package com.ssy.trainorder.mapper;

import com.ssy.trainorder.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAllUser();

    User findUserInfo(String user_phone);

    String findUserLogin(String user_phone);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(String user_phone);
}
