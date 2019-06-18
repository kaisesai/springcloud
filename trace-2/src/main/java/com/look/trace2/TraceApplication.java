package com.look.trace2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {

  @GetMapping(value = "/trace-2")
  public String trace() {
    log.info("=======call trace2========");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "trace";
  }

  public static void main(String[] args) {
    SpringApplication.run(TraceApplication.class, args);
  }



}
