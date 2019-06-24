package com.look.helloservice.controller;

import com.look.api.dto.User;
import com.look.api.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class RefactorController implements HelloService {

  @Override
  public String hello(@RequestParam("name") String name) {
    System.out.println("hello4");
    return "hello " + name;
  }

  @Override
  public User hello(@RequestHeader("name") String name, @RequestHeader Integer age) {
    System.out.println("hello5");
    User user = new User();
    try {
      user.setName(URLDecoder.decode(name, "UTF-8"));
    } catch (UnsupportedEncodingException ignored) {
    }
    user.setAge(age);
    return user;
  }

  @Override
  public String hello(@RequestBody User user) {
    System.out.println("hello6");
    return "hello " + user.getName() + ", " + user.getAge();
  }
}
