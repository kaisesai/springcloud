package com.look.rabbitmqhello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RabbitListener(queues = "hello")
@Component
public class Receiver {

  @RabbitHandler
  public void process(String hello) {
    log.info("Reciver: " + hello);
  }
}
