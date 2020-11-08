package com.ssy.trainorder.controller;

import com.ssy.trainorder.entity.User;
import com.ssy.trainorder.entity.Result;
import com.ssy.trainorder.entity.UserResult;
import com.ssy.trainorder.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import javax.annotation.Resource;

@RestController
@RequestMapping
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("login")
    public Result login(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String user_phone = (String) request.get("user_phone");
        String password = (String) request.get("password");

        if(user_phone == null || password == null)
            return Result.fail("不能为空");

        if(userService.findUserLogin(user_phone) == null)
            return Result.fail("用户不存在");
        else if(password.equals(userService.findUserLogin(user_phone))) {
            UserResult userResult = userService.findUserResult(user_phone);
            return Result.succ(userResult);
        }
        else
            return Result.fail("密码不正确");
    }

    @RequestMapping("register")
    public Result register(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String user_phone = (String) request.get("user_phone");
        String password = (String) request.get("password");
        String user_name = (String) request.get("user_name");
        String real_name = (String) request.get("real_name");
        String person_id = (String) request.get("person_id");
        String email = (String) request.get("email");

        if(userService.findUserInfo(user_phone) != null) {
            return Result.fail("用户已注册");
        }
        else {
            User user = new User(user_phone,user_name,password,person_id,real_name,email);
            boolean flag = userService.insertUser(user);
            if(flag) return Result.succ(user);
            else return Result.fail("注册失败");
        }
    }

    @RequestMapping("updateUserInfo")
    public Result updateUserInfo(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String user_phone = (String) request.get("user_phone");
        String user_name = (String) request.get("user_name");
        String email = (String) request.get("email");

        boolean flag = userService.updateUserInfo(user_phone,user_name,email);
        if(flag) {
            UserResult userResult = userService.findUserResult(user_phone);
            return Result.succ(userResult);
        }
        else return Result.fail("修改失败");
    }

    @RequestMapping("updateUserPwd")
    public Result updateUserPwd(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String user_phone = (String) request.get("user_phone");
        String password = (String) request.get("password");

        boolean flag = userService.updateUserPwd(user_phone,password);
        if(flag) {
            UserResult userResult = userService.findUserResult(user_phone);
            return Result.succ(userResult);
        }
        else return Result.fail("修改失败");
    }
}
