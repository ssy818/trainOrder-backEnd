package com.ssy.trainorder.mapper;

import com.ssy.trainorder.entity.DirectTicketResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TicketQueryMapper {

    List<DirectTicketResult> findDirectTicket(@Param("start_place") String start_place,@Param("end_place") String end_place,@Param("start_date") String start_date);

    String findDepartDate(@Param("train_no") String train_no,@Param("start_station_name") String start_station_name,@Param("start_date") String start_date);

    String findSeatPrice(@Param("train_no") String train_no,@Param("start_station_name") String start_station_name,@Param("end_station_name") String end_station_name,@Param("seat_type") String seat_type);

    Integer findSeatRemaining(@Param("train_no") String train_no,@Param("start_station_name") String start_station_name,@Param("end_station_name") String end_station_name,@Param("depart_date") String depart_date,@Param("seat_type") String seat_type);

}
