package com.ssy.trainorder.mapper;

import com.ssy.trainorder.entity.User;
import com.ssy.trainorder.entity.UserResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAllUser();

    User findUserInfo(String user_phone);

    UserResult findUserResult(String user_phone);

    String findUserLogin(String user_phone);

    boolean insertUser(User user);

    boolean updateUserInfo(@Param("user_phone") String user_phone,@Param("user_name") String user_name,@Param("email") String email);

    boolean updateUserPwd(@Param("user_phone") String user_phone,@Param("password") String password);

    boolean deleteUser(String user_phone);
}
