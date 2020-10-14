package com.ssy.trainorder.mapper;

import com.ssy.trainorder.entity.UserPassenger;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserPassengerMapper {

    List<UserPassenger> findAllUserPassenger();

    List<UserPassenger> findUserPassengerById(String person_id);

    UserPassenger findUserPassengerInfo(@Param("user_phone") String user_phone,@Param("person_id") String person_id);

    boolean insertUserPassenger(UserPassenger userPassenger);

    boolean updateUserPassenger(UserPassenger userPassenger);

    boolean deleteUserPassenger(@Param("user_phone") String user_phone,@Param("person_id") String person_id);

}
