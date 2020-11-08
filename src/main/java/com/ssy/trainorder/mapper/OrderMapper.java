package com.ssy.trainorder.mapper;

import com.ssy.trainorder.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    Integer findStartCarriageNo(@Param("train_no") String train_no,@Param("seat_type") String seat_type);

    Integer findEndCarriageNo(@Param("train_no") String train_no,@Param("seat_type") String seat_type);

    Integer findCarriageSeatNumber(@Param("train_no") String train_no,@Param("seat_type") String seat_type);

    List<Integer> findCarriageSeatOrdered(@Param("train_no") String train_no, @Param("start_station_name") String start_station_name, @Param("end_station_name") String end_station_name, @Param("carriage_no") int carriage_no, @Param("depart_date") String depart_date);

    Integer findStartStopNo(@Param("train_no") String train_no,@Param("start_station_name") String start_station_name);

    Integer findEndStopNo(@Param("train_no") String train_no,@Param("end_station_name") String end_station_name);

    String findStartStationName(@Param("train_no") String train_no,@Param("start_stop_no") int start_stop_no);

    String findEndStationName(@Param("train_no") String train_no,@Param("end_stop_no") int end_stop_no);

    String findStartTime(@Param("train_no") String train_no,@Param("start_stop_no") int start_stop_no);

    String findEndTime(@Param("train_no") String train_no,@Param("end_stop_no") int end_stop_no);

    String findStartDate(@Param("train_no") String train_no,@Param("depart_date") String depart_date,@Param("start_station_name") String start_station_name);

    String findSeatType(@Param("train_no") String train_no,@Param("carriage_no") int carriage_no);

    Integer findOrderId();

    List<Order> findPassengerOrder(@Param("train_no") String train_no,@Param("depart_date") String depart_date,@Param("user_phone") String user_phone,@Param("person_id") String person_id);

    List<Order> findAllOrder(String user_phone);

    List<Order> findUnpaidOrder(String user_phone);

    List<Order> findNotTravelOrder(String user_phone);

    List<Order> findHistoryOrder(String user_phone);

    List<Order> findChangeableOrder(String user_phone);

    List<Order> findRefundableOrder(String user_phone);

    boolean insertOrder(Order order);

    boolean updateOrder(@Param("order_id") int order_id,@Param("order_status") String order_status);

    boolean updateExpiredOrder();

}


