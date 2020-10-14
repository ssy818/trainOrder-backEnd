package com.ssy.trainorder.service;

import com.ssy.trainorder.entity.DirectTicketResult;
import com.ssy.trainorder.mapper.TicketQueryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TicketQueryService {

    @Resource
    private TicketQueryMapper ticketQueryMapper;

    public List<DirectTicketResult> findDirectTicket(String start_place,String end_place,String start_date) {
        return ticketQueryMapper.findDirectTicket(start_place,end_place,start_date);
    }

    public String findDepartDate(String train_no,String start_station_name,String start_date) {
        return ticketQueryMapper.findDepartDate(train_no,start_station_name,start_date);
    }

    public String findSeatPrice(String train_no,String start_station_name,String end_station_name,String seat_type) {
        return ticketQueryMapper.findSeatPrice(train_no,start_station_name,end_station_name,seat_type);
    }

    public Integer findSeatRemaining(String train_no,String start_station_name,String end_station_name,String depart_date,String seat_type) {
        return ticketQueryMapper.findSeatRemaining(train_no,start_station_name,end_station_name,depart_date,seat_type);
    }

}
