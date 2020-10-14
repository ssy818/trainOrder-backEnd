package com.ssy.trainorder.service;

import com.ssy.trainorder.entity.Passenger;
import com.ssy.trainorder.entity.UserPassengerResult;
import com.ssy.trainorder.mapper.PassengerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    public List<Passenger> findAllPassenger() {
        return passengerMapper.findAllPassenger();
    }

    public Passenger findPassengerInfo(String person_id) {
        return passengerMapper.findPassengerInfo(person_id);
    }

    public List<UserPassengerResult> findUserPassengerResult(String user_phone) {
        return passengerMapper.findUserPassengerResult(user_phone);
    }

    public boolean insertPassenger(Passenger passenger) {
        return passengerMapper.insertPassenger(passenger);
    }

    public boolean updatePassenger(Passenger passenger) {
        return passengerMapper.updatePassenger(passenger);
    }

    public boolean deletePassenger(String person_id) {
        return passengerMapper.deletePassenger(person_id);
    }
}
