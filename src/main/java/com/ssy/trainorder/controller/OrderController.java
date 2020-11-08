package com.ssy.trainorder.controller;

import com.ssy.trainorder.entity.Order;
import com.ssy.trainorder.entity.CarriageStatus;
import com.ssy.trainorder.entity.SeatStatus;
import com.ssy.trainorder.entity.OrderResult;
import com.ssy.trainorder.entity.Result;
import com.ssy.trainorder.service.OrderService;
import com.ssy.trainorder.service.TicketQueryService;
import com.ssy.trainorder.service.PassengerService;
import com.ssy.trainorder.service.UserPassengerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private TicketQueryService ticketQueryService;

    @Resource
    private PassengerService passengerService;

    @Resource
    private UserPassengerService userPassengerService;

    public String findSeatNoPosition(String seat_type,int seat_no) {
        if(seat_type.equals("特等座")) {
            int row = seat_no / 3 + 1;
            String position = null;
            switch(seat_no % 3) {
                case 1: position = "A";break;
                case 2: position = "C";break;
                case 0: position = "F";break;
                default: break;
            }
            return row + "排" + position + "座";
        }
        else if(seat_type.equals("一等座")) {
            int row = seat_no / 4 + 1;
            String position = null;
            switch(seat_no % 4) {
                case 1: position = "A";break;
                case 2: position = "C";break;
                case 3: position = "D";break;
                case 0: position = "F";break;
                default: break;
            }
            return row + "排" + position + "座";
        }
        else if(seat_type.equals("二等座")) {
            int row = seat_no / 5 + 1;
            String position = null;
            switch(seat_no % 5) {
                case 1: position = "A";break;
                case 2: position = "B";break;
                case 3: position = "C";break;
                case 4: position = "D";break;
                case 0: position = "F";break;
                default: break;
            }
            return row + "排" + position + "座";
        }
        else if(seat_type.equals("软卧")) {
            String position = null;
            if(seat_no % 2 == 0) position = "上铺";
            else position = "下铺";
            return String.format("%02d",seat_no) + "号" + position;
        }
        else if(seat_type.equals("硬卧")) {
            int row = seat_no / 3 + 1;
            String position = null;
            switch(seat_no % 3) {
                case 1: position = "下铺";
                case 2: position = "中铺";
                case 0: position = "上铺";
                default: break;
            }
            return String.format("%02d",row) + "号" + position;
        }
        else return String.format("%03d",seat_no);

    }

    public List<OrderResult> findOrderResult(List<Order> orders) {
        List<OrderResult> orderResults = new ArrayList<>();

        for(Order order:orders) {
            String start_station_name = orderService.findStartStationName(order.getTrain_no(),order.getStart_stop_no());
            String end_station_name = orderService.findEndStationName(order.getTrain_no(),order.getEnd_stop_no());
            String start_date = orderService.findStartDate(order.getTrain_no(),order.getDepart_date(),start_station_name);
            String start_time = orderService.findStartTime(order.getTrain_no(),order.getStart_stop_no());
            String end_time = orderService.findEndTime(order.getTrain_no(),order.getEnd_stop_no());
            int last = ticketQueryService.findLastTime(order.getTrain_no(),start_station_name,end_station_name);
            String last_time = String.format("%02d:%02d",last/60,last%60);
            String seat_type = orderService.findSeatType(order.getTrain_no(),order.getCarriage_no());
            String seat_position = findSeatNoPosition(seat_type,order.getSeat_no());
            String money = "￥" + order.getMoney();
            String real_name = passengerService.findPassengerInfo(order.getPerson_id()).getReal_name();
            String passenger_phone = userPassengerService.findUserPassengerInfo(order.getUser_phone(),order.getPerson_id()).getPassenger_phone();

            OrderResult orderResult  = new OrderResult(order.getOrder_id(),order.getTrain_no(),start_station_name,end_station_name,start_date,start_time,end_time,last_time,order.getCarriage_no(),seat_type,seat_position,money,order.getOrder_status(),real_name,order.getPerson_id(),passenger_phone,order.getCreate_time());
            orderResults.add(orderResult);
        }

        return orderResults;
    }

    @RequestMapping("findPassengerOrder")
    public Result findPassengerOrder(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_date = (String) request.get("start_date");
        String train_no = (String) request.get("train_no");
        String start_station_name = (String) request.get("start_station_name");
        String user_phone = (String) request.get("user_phone");
        String person_id = (String) request.get("person_id");

        String depart_date = ticketQueryService.findDepartDate(train_no,start_station_name,start_date);
        orderService.updateExpiredOrder();
        List<Order> orders = orderService.findPassengerOrder(train_no,depart_date,user_phone,person_id);
        if(!orders.isEmpty()) return Result.fail("同一乘客不能在同一天乘坐同一车次");
        else return Result.succ("允许乘坐");
    }

    @RequestMapping("findCarriageRemaining")
    public Result findCarriageRemaining(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_date = (String) request.get("start_date");
        String train_no = (String) request.get("train_no");
        String start_station_name = (String) request.get("start_station_name");
        String end_station_name = (String) request.get("end_station_name");
        String seat_type = (String) request.get("seat_type");

        int start_carriage_no = orderService.findStartCarriageNo(train_no,seat_type);
        int end_carriage_no = orderService.findEndCarriageNo(train_no,seat_type);
        int carriage_seat_number = orderService.findCarriageSeatNumber(train_no,seat_type);
        String depart_date = ticketQueryService.findDepartDate(train_no,start_station_name,start_date);

        orderService.updateExpiredOrder();
        List<CarriageStatus> carriageStatuses = new ArrayList<>();
        for(int i = start_carriage_no; i <= end_carriage_no; i++) {
            List<Integer> carriage_seats_ordered = new ArrayList<>();
            carriage_seats_ordered = orderService.findCarriageSeatOrdered(train_no,start_station_name,end_station_name,i,depart_date);
            int remaining = carriage_seat_number - carriage_seats_ordered.size();
            CarriageStatus carriageStatus = new CarriageStatus(i,remaining);
            carriageStatuses.add(carriageStatus);
        }
        return Result.succ(carriageStatuses);
    }

    @RequestMapping("findCarriageSeatRemaining")
    public Result findCarriageSeatRemaining(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_date = (String) request.get("start_date");
        String train_no = (String) request.get("train_no");
        String start_station_name = (String) request.get("start_station_name");
        String end_station_name = (String) request.get("end_station_name");
        String seat_type = (String) request.get("seat_type");

        int start_carriage_no = orderService.findStartCarriageNo(train_no,seat_type);
        int end_carriage_no = orderService.findEndCarriageNo(train_no,seat_type);
        int carriage_seat_number = orderService.findCarriageSeatNumber(train_no,seat_type);
        String depart_date = ticketQueryService.findDepartDate(train_no,start_station_name,start_date);

        List<List<SeatStatus>> seatStatusesList = new ArrayList<>();
        for(int i = 0; i < start_carriage_no - 1; i++) {
            List<SeatStatus> seatStatuses = new ArrayList<>();
            seatStatusesList.add(seatStatuses);
        }

        orderService.updateExpiredOrder();
        if(seat_type.equals("特等座")) {
            int row = carriage_seat_number / 3;
            for(int i = start_carriage_no; i <= end_carriage_no; i++) {
                int rowOfA = row;
                int rowOfC = row;
                int rowOfF = row;
                List<Integer> carriage_seats_ordered = new ArrayList<>();
                carriage_seats_ordered = orderService.findCarriageSeatOrdered(train_no,start_station_name,end_station_name,i,depart_date);
                for(int carriage_seat_ordered : carriage_seats_ordered) {
                    if(carriage_seat_ordered % 3 == 1) rowOfA--;
                    else if(carriage_seat_ordered % 3 == 2) rowOfC--;
                    else rowOfF--;
                }
                SeatStatus seatStatusOfA = new SeatStatus("A",rowOfA);
                SeatStatus seatStatusOfC = new SeatStatus("C",rowOfC);
                SeatStatus seatStatusOfF = new SeatStatus("F",rowOfF);
                List<SeatStatus> seatStatuses = new ArrayList<>();
                seatStatuses.add(seatStatusOfA);
                seatStatuses.add(seatStatusOfC);
                seatStatuses.add(seatStatusOfF);
                seatStatusesList.add(seatStatuses);
            }
            return Result.succ(seatStatusesList);
        }
        else if(seat_type.equals("一等座")) {
            int row = carriage_seat_number / 4;
            for(int i = start_carriage_no; i <= end_carriage_no; i++) {
                int rowOfA = row;
                int rowOfC = row;
                int rowOfD = row;
                int rowOfF = row;
                List<Integer> carriage_seats_ordered = new ArrayList<>();
                carriage_seats_ordered = orderService.findCarriageSeatOrdered(train_no,start_station_name,end_station_name,i,depart_date);
                for(int carriage_seat_ordered : carriage_seats_ordered) {
                    if(carriage_seat_ordered % 4 == 1) rowOfA--;
                    else if(carriage_seat_ordered % 4 == 2) rowOfC--;
                    else if(carriage_seat_ordered % 4 == 3) rowOfD--;
                    else rowOfF--;
                }
                SeatStatus seatStatusOfA = new SeatStatus("A",rowOfA);
                SeatStatus seatStatusOfC = new SeatStatus("C",rowOfC);
                SeatStatus seatStatusOfD = new SeatStatus("D",rowOfD);
                SeatStatus seatStatusOfF = new SeatStatus("F",rowOfF);
                List<SeatStatus> seatStatuses = new ArrayList<>();
                seatStatuses.add(seatStatusOfA);
                seatStatuses.add(seatStatusOfC);
                seatStatuses.add(seatStatusOfD);
                seatStatuses.add(seatStatusOfF);
                seatStatusesList.add(seatStatuses);
            }
            return Result.succ(seatStatusesList);
        }
        else if(seat_type.equals("二等座")){
            int row = carriage_seat_number / 5;
            for(int i = start_carriage_no; i <= end_carriage_no; i++) {
                int rowOfA = row;
                int rowOfB = row;
                int rowOfC = row;
                int rowOfD = row;
                int rowOfF = row;
                List<Integer> carriage_seats_ordered = new ArrayList<>();
                carriage_seats_ordered = orderService.findCarriageSeatOrdered(train_no,start_station_name,end_station_name,i,depart_date);
                for(int carriage_seat_ordered : carriage_seats_ordered) {
                    if(carriage_seat_ordered % 5 == 1) rowOfA--;
                    else if(carriage_seat_ordered % 5 == 2) rowOfB--;
                    else if(carriage_seat_ordered % 5 == 3) rowOfC--;
                    else if(carriage_seat_ordered % 5 == 4) rowOfD--;
                    else rowOfF--;
                }
                SeatStatus seatStatusOfA = new SeatStatus("A",rowOfA);
                SeatStatus seatStatusOfB = new SeatStatus("B",rowOfB);
                SeatStatus seatStatusOfC = new SeatStatus("C",rowOfC);
                SeatStatus seatStatusOfD = new SeatStatus("D",rowOfD);
                SeatStatus seatStatusOfF = new SeatStatus("F",rowOfF);
                List<SeatStatus> seatStatuses = new ArrayList<>();
                seatStatuses.add(seatStatusOfA);
                seatStatuses.add(seatStatusOfB);
                seatStatuses.add(seatStatusOfC);
                seatStatuses.add(seatStatusOfD);
                seatStatuses.add(seatStatusOfF);
                seatStatusesList.add(seatStatuses);
            }
            return Result.succ(seatStatusesList);
        }
        else return Result.succ(seatStatusesList);
    }

    @RequestMapping("addOrder")
    public Result addOrder(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_date = (String) request.get("start_date");
        String train_no = (String) request.get("train_no");
        String start_station_name = (String) request.get("start_station_name");
        String end_station_name = (String) request.get("end_station_name");
        String seat_type = (String) request.get("seat_type");
        int carriage_no = (int) request.get("carriage_no");
        String seat_position = (String) request.get("seat_position");
        String user_phone = (String) request.get("user_phone");
        String person_id = (String) request.get("person_id");
        String create_time = (String) request.get("create_time");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/M/d HH:mm:ss");
        Date date = null;
        try {
            date = sdf1.parse(create_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        create_time = sdf2.format(date);

        String depart_date = ticketQueryService.findDepartDate(train_no,start_station_name,start_date);
        int start_stop_no = orderService.findStartStopNo(train_no,start_station_name);
        int end_stop_no = orderService.findEndStopNo(train_no,end_station_name);
        int order_id = orderService.findOrderId();
        double money = Double.parseDouble(ticketQueryService.findSeatPrice(train_no,start_station_name,end_station_name,seat_type).replace("￥",""));
        int carriage_seat_number = orderService.findCarriageSeatNumber(train_no,seat_type);
        List<Integer> carriage_seats_ordered = new ArrayList<>();
        carriage_seats_ordered = orderService.findCarriageSeatOrdered(train_no,start_station_name,end_station_name,carriage_no,depart_date);
        int seat_no = 0;
        System.out.println(start_stop_no);

        if(seat_type.equals("特等座")) {
            int row = carriage_seat_number / 3;
            if(seat_position.equals("A")) {
                for(int i = 1; i < (row - 1) * 3 + 1; i += 3) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("C")) {
                for(int i = 2; i < (row - 1) * 3 + 2; i += 3) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("F")) {
                for(int i = 3; i < (row - 1) * 3 + 3; i += 3) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
        }
        else if(seat_type.equals("一等座")) {
            int row = carriage_seat_number / 4;
            if(seat_position.equals("A")) {
                for(int i = 1; i < (row - 1) * 4 + 1; i += 4) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("C")) {
                for(int i = 2; i < (row - 1) * 4 + 2; i += 4) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("D")) {
                for(int i = 3; i < (row - 1) * 4 + 3; i += 4) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("F")) {
                for(int i = 4; i < (row - 1) * 4 + 4; i += 4) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
        }
        else if(seat_type.equals("二等座")) {
            int row = carriage_seat_number / 5;
            if(seat_position.equals("A")) {
                for(int i = 1; i < (row - 1) * 5 + 1; i += 5) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("B")) {
                for(int i = 2; i < (row - 1) * 5 + 2; i += 5) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("C")) {
                for(int i = 3; i < (row - 1) * 5 + 3; i += 5) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("D")) {
                for(int i = 4; i < (row - 1) * 5 + 4; i += 5) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
            else if(seat_position.equals("F")) {
                for(int i = 5; i < (row - 1) * 5 + 5; i += 5) {
                    if(!carriage_seats_ordered.contains(i)) {
                        seat_no = i;
                        break;
                    }
                }
            }
        }
        else {
            for(int i = 1; i <= carriage_seat_number; i++) {
                if(!carriage_seats_ordered.contains(i)) {
                    seat_no = i;
                    break;
                }
            }
        }

        Order order = new Order(order_id,create_time,"未支付",money,train_no,depart_date,start_stop_no,end_stop_no,carriage_no,seat_no,user_phone,person_id);
        boolean flag = orderService.insertOrder(order);
        if(!flag) return Result.fail("添加失败");
        return Result.succ(order_id);
    }

    @RequestMapping("findAllOrder")
    public Result findAllOrder(@RequestParam String user_phone) {
        orderService.updateExpiredOrder();

        List<Order> orders = orderService.findAllOrder(user_phone);

        List<OrderResult> orderResults = findOrderResult(orders);
        for(OrderResult orderResult:orderResults) {
            String order_status = orderResult.getOrder_status();
            orderResult.setOrder_status(order_status.substring(0,3));
        }

        return Result.succ(orderResults);
    }

    @RequestMapping("findUnpaidOrder")
    public Result findUnpaidOrder(@RequestParam String user_phone) {
        orderService.updateExpiredOrder();

        List<Order> orders = orderService.findUnpaidOrder(user_phone);

        List<OrderResult> orderResults = findOrderResult(orders);

        return Result.succ(orderResults);
    }

    @RequestMapping("findNotTravelOrder")
    public Result findNotTravelOrder(@RequestParam String user_phone) {
        orderService.updateExpiredOrder();

        List<Order> orders = orderService.findNotTravelOrder(user_phone);

        List<OrderResult> orderResults = findOrderResult(orders);

        return Result.succ(orderResults);
    }

    @RequestMapping("findHistoryOrder")
    public Result findHistoryOrder(@RequestParam String user_phone) {
        orderService.updateExpiredOrder();

        List<Order> orders = orderService.findHistoryOrder(user_phone);

        List<OrderResult> orderResults = findOrderResult(orders);

        return Result.succ(orderResults);
    }

    @RequestMapping("findChangeableOrder")
    public Result findChangeableOrder(@RequestParam String user_phone) {
        orderService.updateExpiredOrder();

        List<Order> orders = orderService.findChangeableOrder(user_phone);

        List<OrderResult> orderResults = findOrderResult(orders);

        return Result.succ(orderResults);
    }

    @RequestMapping("findRefundableOrder")
    public Result findRefundableOrder(@RequestParam String user_phone) {
        orderService.updateExpiredOrder();

        List<Order> orders = orderService.findRefundableOrder(user_phone);

        List<OrderResult> orderResults = findOrderResult(orders);

        return Result.succ(orderResults);
    }

    @RequestMapping("updateOrder")
    public Result updateOrder(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        int order_id = (int) request.get("order_id");
        String order_status = (String) request.get("order_status");

        boolean flag = orderService.updateOrder(order_id,order_status);
        if(!flag) return Result.fail("支付失败");
        else return Result.succ(null);
    }

}
