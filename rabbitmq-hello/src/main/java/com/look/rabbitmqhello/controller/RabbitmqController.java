package com.look.rabbitmqhello.controller;

import com.look.rabbitmqhello.service.Sender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

  private final Sender sender;

  public RabbitmqController(Sender sender) {
    this.sender = sender;
  }

  @RequestMapping(value = "/send")
  public String sendMsg(@RequestParam(value = "msg") String msg) {
    sender.send(msg);
    return msg;
  }

}
