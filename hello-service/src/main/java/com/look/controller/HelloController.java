package com.look.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Autowired
  private DiscoveryClient client;

  @RequestMapping(value = "/hello")
  public String hello() throws InterruptedException {
    List<ServiceInstance> instances = client.getInstances("hello-service");
    // List<String> services = client.getServices();
    // logger.info("[hello]\tinstances:{}\tservices:{}", instances, services);
    // Thread.sleep(new Random().nextInt(3000));
    return "hello world";
  }
}
