package com.ssy.trainorder.controller;

import com.ssy.trainorder.entity.DirectTicketResult;
import com.ssy.trainorder.entity.IndirectTicketResult;
import com.ssy.trainorder.entity.TicketInfo;
import com.ssy.trainorder.entity.DirectTicketDetail;
import com.ssy.trainorder.entity.TrainStationResult;
import com.ssy.trainorder.entity.Result;
import com.ssy.trainorder.service.TicketQueryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Resource;

@RestController
@RequestMapping
public class TicketQueryController {

    @Resource
    private TicketQueryService ticketQueryService;

    public DirectTicketResult findDirectTicketResult(TicketInfo ticketInfo,String start_date,String query) {
        String train_no = ticketInfo.getTrain_no();
        String start_station_name = ticketInfo.getStart_station_name();
        String end_station_name = ticketInfo.getEnd_station_name();
        String start_time = ticketInfo.getStart_time();
        String end_time = ticketInfo.getEnd_time();
        DirectTicketResult directTicketResult = new DirectTicketResult(train_no,start_station_name,end_station_name,start_time,end_time);
        int last = ticketQueryService.findLastTime(train_no,start_station_name,end_station_name);
        directTicketResult.setLast_time(String.format("%02d:%02d",last/60,last%60));
        String depart_date = ticketQueryService.findDepartDate(train_no,start_station_name,start_date);
        String seat_types[] = {"特等座","一等座","二等座","软卧","硬卧","硬座"};
        if (query.equals("remaining")) {
            for (String seat_type : seat_types) {
                if (ticketQueryService.findSeatRemaining(train_no, start_station_name, end_station_name, depart_date, seat_type) != null) {
                    int remaining = ticketQueryService.findSeatRemaining(train_no, start_station_name, end_station_name, depart_date, seat_type);
                    if (remaining > 20) {
                        switch (seat_type) {
                            case "特等座":
                                directTicketResult.setPremier_seat("有");
                                break;
                            case "一等座":
                                directTicketResult.setFirst_seat("有");
                                break;
                            case "二等座":
                                directTicketResult.setSecond_seat("有");
                                break;
                            case "软卧":
                                directTicketResult.setSoft_sleeper("有");
                                break;
                            case "硬卧":
                                directTicketResult.setHard_sleeper("有");
                                break;
                            case "硬座":
                                directTicketResult.setHard_seat("有");
                                break;
                            default:
                                break;
                        }
                    } else if (remaining >= 0) {
                        switch (seat_type) {
                            case "特等座":
                                directTicketResult.setPremier_seat(String.valueOf(remaining));
                                break;
                            case "一等座":
                                directTicketResult.setFirst_seat(String.valueOf(remaining));
                                break;
                            case "二等座":
                                directTicketResult.setSecond_seat(String.valueOf(remaining));
                                break;
                            case "软卧":
                                directTicketResult.setSoft_sleeper(String.valueOf(remaining));
                                break;
                            case "硬卧":
                                directTicketResult.setHard_sleeper(String.valueOf(remaining));
                                break;
                            case "硬座":
                                directTicketResult.setHard_seat(String.valueOf(remaining));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        else {
            for (String seat_type : seat_types) {
                if (ticketQueryService.findSeatPrice(train_no,start_station_name,end_station_name,seat_type) != null) {
                    String price = ticketQueryService.findSeatPrice(train_no,start_station_name,end_station_name,seat_type);
                    switch (seat_type) {
                        case "特等座":
                            directTicketResult.setPremier_seat(price);
                            break;
                        case "一等座":
                            directTicketResult.setFirst_seat(price);
                            break;
                        case "二等座":
                            directTicketResult.setSecond_seat(price);
                            break;
                        case "软卧":
                            directTicketResult.setSoft_sleeper(price);
                            break;
                        case "硬卧":
                            directTicketResult.setHard_sleeper(price);
                            break;
                        case "硬座":
                            directTicketResult.setHard_seat(price);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return directTicketResult;
    }

    @RequestMapping("findDirectTicket")
    public Result findDirectTicket(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_place = (String) request.get("start_place");
        String end_place = (String) request.get("end_place");
        String start_date = (String) request.get("start_date");
        String min_time = (String) request.get("min_time");
        String max_time = (String) request.get("max_time");
        String query = (String) request.get("query");

        List<TicketInfo> ticketInfos = new ArrayList<TicketInfo>();
        ticketInfos = ticketQueryService.findDirectTicketInfo(start_place,end_place,start_date);

        if (ticketInfos.isEmpty()) {
            return Result.fail("结果为空");
        }

        if (min_time != null && !min_time.equals("")) {
            for(int i = 0; i < ticketInfos.size(); i++) {
                if(ticketInfos.get(i).getStart_time().compareTo(min_time) < 0) {
                    ticketInfos.remove(i);
                    i--;
                }
            }
        }
        if (max_time != null && !max_time.equals("")) {
            for(int i = 0; i < ticketInfos.size(); i++) {
                if(ticketInfos.get(i).getStart_time().compareTo(max_time) > 0) {
                    ticketInfos.remove(i);
                    i--;
                }
            }
        }

        if (ticketInfos.isEmpty()) {
            return Result.fail("结果为空");
        }

        List<DirectTicketResult> directTicketResults = new ArrayList<DirectTicketResult>();
        for (TicketInfo ticketInfo : ticketInfos) {
            DirectTicketResult directTicketResult = findDirectTicketResult(ticketInfo,start_date,query);
            directTicketResults.add(directTicketResult);
        }
        return Result.succ(directTicketResults);
    }

    @RequestMapping("findDirectTicketDetail")
    public Result findDirectTicketDetail(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_date = (String) request.get("start_date");
        String train_no = (String) request.get("train_no");
        String start_station_name = (String) request.get("start_station_name");
        String end_staion_name = (String) request.get("end_station_name");
        String start_time = (String) request.get("start_time");
        String end_time = (String) request.get("end_time");

        TicketInfo ticketInfo = new TicketInfo(train_no,start_station_name,end_staion_name,start_time,end_time);
        DirectTicketResult directTicketResult1 = findDirectTicketResult(ticketInfo,start_date,"remaining");
        DirectTicketResult directTicketResult2 = findDirectTicketResult(ticketInfo,start_date,"price");

        String last_time = directTicketResult1.getLast_time();
        String premier_seat_remaining = directTicketResult1.getPremier_seat();
        String first_seat_remaining = directTicketResult1.getFirst_seat();
        String second_seat_remaining = directTicketResult1.getSecond_seat();
        String soft_sleeper_remaining = directTicketResult1.getSoft_sleeper();
        String hard_sleeper_remaining = directTicketResult1.getHard_sleeper();
        String hard_seat_remaining = directTicketResult1.getHard_seat();
        String premier_seat_price = directTicketResult2.getPremier_seat();
        String first_seat_price = directTicketResult2.getFirst_seat();
        String second_seat_price = directTicketResult2.getSecond_seat();
        String soft_sleeper_price = directTicketResult2.getSoft_sleeper();
        String hard_sleeper_price = directTicketResult2.getHard_sleeper();
        String hard_seat_price = directTicketResult2.getHard_seat();

        DirectTicketDetail directTicketDetail = new DirectTicketDetail(start_date,train_no,start_station_name,end_staion_name,start_time,end_time,last_time,premier_seat_remaining,first_seat_remaining,second_seat_remaining,soft_sleeper_remaining,hard_sleeper_remaining,hard_seat_remaining,premier_seat_price,first_seat_price,second_seat_price,soft_sleeper_price,hard_sleeper_price,hard_seat_price);
        return Result.succ(directTicketDetail);
    }

    @RequestMapping("findIndirectTicket")
    public Result findIndirectTicket(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_place = (String) request.get("start_place");
        String end_place = (String) request.get("end_place");
        String start_date = (String) request.get("start_date");
        String mid_station_name = (String) request.get("mid_station_name");

        List<IndirectTicketResult> indirectTicketResults = new ArrayList<IndirectTicketResult>();
        indirectTicketResults = ticketQueryService.findIndirectTicketResult(start_place,end_place,start_date);

        if (indirectTicketResults.isEmpty()) {
            return Result.fail("结果为空");
        }

        if (mid_station_name != null && !mid_station_name.equals("")) {
            for (int i = 0; i < indirectTicketResults.size(); i++) {
                if (!indirectTicketResults.get(i).getMid_station_name().equals(mid_station_name)) {
                    indirectTicketResults.remove(i);
                    i--;
                }
            }
        }

        if (indirectTicketResults.isEmpty()) {
            return Result.fail("结果为空");
        }

        for (IndirectTicketResult indirectTicketResult : indirectTicketResults) {
            int mid = Integer.parseInt(indirectTicketResult.getMid_time());
            if (mid < 0) mid = mid + 24*60;
            String mid_time = String.format("%02d:%02d",mid/60,mid%60);
            indirectTicketResult.setMid_time(mid_time);
            int last = Integer.parseInt(indirectTicketResult.getLast_time());
            String last_time = String.format("%02d:%02d",last/60,last%60);
            indirectTicketResult.setLast_time(last_time);
        }

        return Result.succ(indirectTicketResults);
    }

    @RequestMapping("findIndirectTicketDetail")
    public Result findIndirectTicketDetail(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String train_no_1 = (String) request.get("train_no_1");
        String train_no_2 = (String) request.get("train_no_2");
        String start_station_name = (String) request.get("start_station_name");
        String mid_station_name = (String) request.get("mid_station_name");
        String end_station_name = (String) request.get("end_station_name");
        String start_time_1 = (String) request.get("start_time_1");
        String end_time_1 = (String) request.get("end_time_1");
        String start_time_2 = (String) request.get("start_time_2");
        String end_time_2 = (String) request.get("end_time_2");
        String start_date = (String) request.get("start_date");
        String query = (String) request.get("query");

        TicketInfo ticketInfo1 = new TicketInfo(train_no_1,start_station_name,mid_station_name,start_time_1,end_time_1);
        TicketInfo ticketInfo2 = new TicketInfo(train_no_2,mid_station_name,end_station_name,start_time_2,end_time_2);

        DirectTicketResult directTicketResult1 = findDirectTicketResult(ticketInfo1,start_date,query);
        DirectTicketResult directTicketResult2 = findDirectTicketResult(ticketInfo2,start_date,query);

        List<DirectTicketResult> directTicketResults = Arrays.asList(directTicketResult1,directTicketResult2);

        if(directTicketResults.isEmpty()) {
            return Result.fail("查询失败");
        }

        return Result.succ(directTicketResults);
    }

    @RequestMapping("findTrainStation")
    public Result findTrainStation(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String train_no = (String) request.get("train_no");
        String depart_date = (String) request.get("depart_date");

        List<TrainStationResult> trainStationResults = new ArrayList<>();
        trainStationResults = ticketQueryService.findTrainStationResult(train_no,depart_date);

        if(trainStationResults.isEmpty()) {
            if(ticketQueryService.findTrain(train_no) == null) {
                return Result.fail("列车不存在");
            }
            else return Result.fail("当日已停运");
        }

        for(TrainStationResult trainStationResult : trainStationResults) {
            int last = Integer.parseInt(trainStationResult.getLast_time());
            String last_time = String.format("%02d:%02d",last/60,last%60);
            trainStationResult.setLast_time(last_time);
        }
        return Result.succ(trainStationResults);
    }

    @RequestMapping("findChangeTicket")
    public Result findChangeTicket(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String train_no = (String) request.get("train_no");
        String start_station_name = (String) request.get("start_station_name");
        String end_station_name = (String) request.get("end_station_name");
        String start_date_1 = (String) request.get("start_date_1");
        String start_date_2 = (String) request.get("start_date_2");
        String query = (String) request.get("query");

        String start_place = ticketQueryService.findCity(start_station_name);
        String end_place = ticketQueryService.findCity(end_station_name);

        List<TicketInfo> ticketInfos = ticketQueryService.findDirectTicketInfo(start_place,end_place,start_date_2);

        if (ticketInfos.isEmpty()) {
            return Result.fail("结果为空");
        }

        List<DirectTicketResult> directTicketResults = new ArrayList<>();
        for (TicketInfo ticketInfo : ticketInfos) {
            if (start_date_1.equals(start_date_2) && ticketInfo.getTrain_no().equals(train_no)) break;
            DirectTicketResult directTicketResult = findDirectTicketResult(ticketInfo,start_date_2,query);
            directTicketResults.add(directTicketResult);
        }
        return Result.succ(directTicketResults);
    }

}
