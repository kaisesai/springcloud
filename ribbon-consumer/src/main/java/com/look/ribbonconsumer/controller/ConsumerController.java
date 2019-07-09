package com.look.ribbonconsumer.controller;

import com.look.api.dto.User;
import com.look.ribbonconsumer.service.HelloService;
import com.look.ribbonconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {

  private final HelloService helloService;

  private final UserService userService;

  @Autowired
  public ConsumerController(HelloService helloService, UserService userService) {
    this.helloService = helloService;
    this.userService = userService;
  }

  @GetMapping(value = "/ribbon-consumer")
  public String helloConsumer() throws ExecutionException, InterruptedException {
    return helloService.helloService();
  }


  @GetMapping(value = "/users/{id}")
  public User getUserById(@PathVariable(value = "id") Long id) throws ExecutionException, InterruptedException {
    // User user = null;
    // for (int i = 0; i < 10; i++) {
    //   System.out.println("[开始执行第 " + i + " 次方法]");
    //   user = userService.getUserById(id);
    // }
    User user = userService.getUserById(id);
    return user;
  }

  @PostMapping(value = "/users")
  public User getUserById(@RequestBody User user){
    userService.update(user);
    return user;
  }

}
