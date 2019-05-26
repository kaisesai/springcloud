package com.look.api.service;

import com.look.api.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/refactor")
public interface HelloService {

  @GetMapping(value = "/hello4")
  String hello(@RequestParam(value = "name") String name);

  @GetMapping(value = "/hello5")
  User hello(@RequestHeader(value = "name") String name, @RequestHeader(value = "age") Integer age);

  @PostMapping(value = "hello6")
  String hello(@RequestBody User user);

}
