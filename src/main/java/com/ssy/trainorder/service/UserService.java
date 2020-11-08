package com.ssy.trainorder.service;

import com.ssy.trainorder.entity.User;
import com.ssy.trainorder.entity.UserResult;
import com.ssy.trainorder.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    public User findUserInfo(String user_phone){
        return userMapper.findUserInfo(user_phone);
    }

    public UserResult findUserResult(String user_phone) {
        return userMapper.findUserResult(user_phone);
    }

    public String findUserLogin(String user_phone){
        return userMapper.findUserLogin(user_phone);
    }

    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public boolean updateUserInfo(String user_phone,String user_name,String email) {
        return userMapper.updateUserInfo(user_phone,user_name,email);
    }

    public boolean updateUserPwd(String user_phone,String password) {
        return userMapper.updateUserPwd(user_phone,password);
    }

    public boolean deleteUser(String user_phone) {
        return userMapper.deleteUser(user_phone);
    }


}
