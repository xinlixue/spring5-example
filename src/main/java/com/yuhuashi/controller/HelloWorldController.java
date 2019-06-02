package com.yuhuashi.controller;

import com.yuhuashi.domain.User;
import com.yuhuashi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 00:11
 **/
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

  @Autowired
  private UserService userService;

  @RequestMapping("/list")
  @ResponseBody
  public void userList() {
    User user = new User();
    user.setId(UUID.randomUUID().toString().replace("-", "").substring(20));
    user.setName("123");
    user.setSex("123");
    user.setAge(123);
    userService.insertUser(user);
  }


  @RequestMapping("/pay")
  @ResponseBody
  public String requestPay(String name) {
    return userService.pay(name);
  }


}
