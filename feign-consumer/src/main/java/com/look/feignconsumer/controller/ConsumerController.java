package com.look.feignconsumer.controller;

import com.look.api.dto.User;
import com.look.feignconsumer.service.RefactorHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Slf4j
@RestController
public class ConsumerController {

  private final RefactorHelloService refactorHelloService;

  public ConsumerController(RefactorHelloService refactorHelloService) {
    this.refactorHelloService = refactorHelloService;
  }

  @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
  public String helloConsumer() throws UnsupportedEncodingException {

    String hello4ForParams = refactorHelloService.hello("凯哥");
    User hello5ForHeader = refactorHelloService.hello(URLDecoder.decode("东妹", "UTF-8"), 10);
    User user = new User();
    user.setName("老王");
    user.setAge(15);
    String hello6ForPost = refactorHelloService.hello(user);

    StringBuilder result = new StringBuilder();
    result.append("hello4ForParams: ").append(hello4ForParams).append("\r\n");
    result.append("hello5ForHeader: ").append(hello5ForHeader).append("\r\n");
    result.append("hello6ForPost: ").append(hello6ForPost).append("\r\n");
    log.info("[helloConsumer]\tresult:{}", result.toString());
    return result.toString();
  }

}
