package com.ssy.trainorder.service;

import com.ssy.trainorder.entity.Order;
import com.ssy.trainorder.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Integer findStartCarriageNo(String train_no,String seat_type) {
        return orderMapper.findStartCarriageNo(train_no,seat_type);
    }

    public Integer findEndCarriageNo(String train_no,String seat_type) {
        return orderMapper.findEndCarriageNo(train_no,seat_type);
    }

    public Integer findCarriageSeatNumber(String train_no,String seat_type) {
        return orderMapper.findCarriageSeatNumber(train_no,seat_type);
    }

    public List<Integer> findCarriageSeatOrdered(String train_no,String start_station_name,String end_station_name,int carriage_no,String depart_date) {
        return orderMapper.findCarriageSeatOrdered(train_no,start_station_name,end_station_name,carriage_no,depart_date);
    }

    public Integer findStartStopNo(String train_no,String start_station_name) {
        return orderMapper.findStartStopNo(train_no,start_station_name);
    }

    public Integer findEndStopNo(String train_no,String end_station_name) {
        return orderMapper.findEndStopNo(train_no,end_station_name);
    }

    public String findStartStationName(String train_no,int start_stop_no) {
        return orderMapper.findStartStationName(train_no,start_stop_no);
    }

    public String findEndStationName(String train_no,int end_stop_no) {
        return orderMapper.findEndStationName(train_no,end_stop_no);
    }

    public String findStartTime(String train_no,int start_stop_no) {
        return orderMapper.findStartTime(train_no,start_stop_no);
    }

    public String findEndTime(String train_no,int end_stop_no) {
        return orderMapper.findEndTime(train_no,end_stop_no);
    }

    public String findStartDate(String train_no,String depart_date,String start_station_name) {
        return orderMapper.findStartDate(train_no,depart_date,start_station_name);
    }

    public String findSeatType(String train_no,int carriage_no) {
        return orderMapper.findSeatType(train_no,carriage_no);
    }

    public Integer findOrderId() {
        return orderMapper.findOrderId();
    }

    public List<Order> findPassengerOrder(String train_no,String depart_date,String user_phone,String person_id) {
        return orderMapper.findPassengerOrder(train_no,depart_date,user_phone,person_id);
    }

    public List<Order> findAllOrder(String user_phone) {
        return orderMapper.findAllOrder(user_phone);
    }

    public List<Order> findUnpaidOrder(String user_phone) {
        return orderMapper.findUnpaidOrder(user_phone);
    }

    public List<Order> findNotTravelOrder(String user_phone) {
        return orderMapper.findNotTravelOrder(user_phone);
    }

    public List<Order> findHistoryOrder(String user_phone) {
        return orderMapper.findHistoryOrder(user_phone);
    }

    public List<Order> findChangeableOrder(String user_phone) {
        return orderMapper.findChangeableOrder(user_phone);
    }

    public List<Order> findRefundableOrder(String user_phone) {
        return orderMapper.findRefundableOrder(user_phone);
    }

    public boolean insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    public boolean updateOrder(int order_id,String order_status) {
        return orderMapper.updateOrder(order_id,order_status);
    }

    public boolean updateExpiredOrder() {
        return orderMapper.updateExpiredOrder();
    }

}
