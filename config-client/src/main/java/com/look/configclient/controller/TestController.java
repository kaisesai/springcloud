package com.look.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

  @Value("${from}")
  private String from;

  @RequestMapping(value = "/from")
  public String from() {

    String s = new String();

    return from;

  }

}
