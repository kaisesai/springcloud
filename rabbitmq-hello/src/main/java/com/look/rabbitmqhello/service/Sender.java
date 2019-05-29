package com.look.rabbitmqhello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.AsyncAmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class Sender {

  private final AmqpTemplate amqpTemplate;

  public Sender(AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  public void send(String msg) {
    String context = msg + new Date();
    log.info("Sender: " + context);
    amqpTemplate.convertAndSend("hello", context);
  }

}
