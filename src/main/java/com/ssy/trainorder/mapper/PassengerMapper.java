package com.ssy.trainorder.mapper;

import com.ssy.trainorder.entity.Passenger;
import com.ssy.trainorder.entity.UserPassengerResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PassengerMapper {

    List<Passenger> findAllPassenger();

    Passenger findPassengerInfo(String person_id);

    List<UserPassengerResult> findUserPassengerResult(String user_phone);

    boolean insertPassenger(Passenger passenger);

    boolean updatePassenger(Passenger passenger);

    boolean deletePassenger(String person_id);
}
