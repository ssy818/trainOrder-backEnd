package com.ssy.trainorder.controller;

import com.ssy.trainorder.entity.Passenger;
import com.ssy.trainorder.entity.UserPassenger;
import com.ssy.trainorder.entity.UserPassengerResult;
import com.ssy.trainorder.entity.Result;
import com.ssy.trainorder.service.PassengerService;
import com.ssy.trainorder.service.UserPassengerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.List;
import javax.annotation.Resource;

@RestController
@RequestMapping
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @Resource
    private UserPassengerService userPassengerService;

    @RequestMapping("findPassenger")
    public Result findPassenger(@RequestParam String user_phone) {

        List<UserPassengerResult> userPassengerResults = passengerService.findUserPassengerResult(user_phone);

        if(userPassengerResults.isEmpty()) {
            return Result.fail("结果为空");
        }

        return Result.succ(userPassengerResults);
    }

    @RequestMapping("deletePassenger")
    public Result deletePassenger(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String user_phone = (String) request.get("user_phone");
        String person_id = (String) request.get("person_id");

        boolean flag = userPassengerService.deleteUserPassenger(user_phone,person_id);
        if(!flag) return Result.fail("删除失败");
        else {
            if(userPassengerService.findUserPassengerById(person_id).isEmpty()) {
                passengerService.deletePassenger(person_id);
            }
            return Result.succ(null);
        }
    }

    @RequestMapping("addPassenger")
    public Result addPassenger(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String user_phone = (String) request.get("user_phone");
        String person_id = (String) request.get("person_id");
        String real_name = (String) request.get("real_name");
        String passenger_phone = (String) request.get("passenger_phone");

        Passenger passenger = new Passenger(person_id,real_name);
        UserPassenger userPassenger = new UserPassenger(user_phone,person_id,passenger_phone);

        if(passengerService.findPassengerInfo(person_id) == null) {
            boolean flag1 = passengerService.insertPassenger(passenger);
            if(!flag1) return Result.fail("添加失败");
            else {
                boolean flag2 = userPassengerService.insertUserPassenger(userPassenger);
                if(flag2) return Result.succ(null);
                else return Result.fail("添加失败");
            }
        }
        else {
            if(userPassengerService.findUserPassengerInfo(user_phone,person_id) != null) {
                return Result.fail("乘客已存在");
            }
            else {
                boolean flag3 = userPassengerService.insertUserPassenger(userPassenger);
                if(flag3) return Result.succ(null);
                else return Result.fail("添加失败");
            }
        }
    }
}
