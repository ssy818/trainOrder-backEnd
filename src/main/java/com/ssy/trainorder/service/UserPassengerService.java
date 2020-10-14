package com.ssy.trainorder.service;

import com.ssy.trainorder.entity.UserPassenger;
import com.ssy.trainorder.mapper.UserPassengerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserPassengerService {

    @Resource
    UserPassengerMapper userPassengerMapper;

    public List<UserPassenger> findAllUserPassenger() {
        return userPassengerMapper.findAllUserPassenger();
    }

    public List<UserPassenger> findUserPassengerById(String person_id) {
        return userPassengerMapper.findUserPassengerById(person_id);
    }

    public UserPassenger findUserPassengerInfo(String user_phone,String person_id) {
        return userPassengerMapper.findUserPassengerInfo(user_phone,person_id);
    }

    public boolean insertUserPassenger(UserPassenger userPassenger) {
        return userPassengerMapper.insertUserPassenger(userPassenger);
    }

    public boolean updateUserPassenger(UserPassenger userPassenger) {
        return userPassengerMapper.updateUserPassenger(userPassenger);
    }

    public boolean deleteUserPassenger(String user_phone,String person_id) {
        return userPassengerMapper.deleteUserPassenger(user_phone,person_id);
    }
}
