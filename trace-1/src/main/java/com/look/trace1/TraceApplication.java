package com.look.trace1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @GetMapping(value = "/trace-1")
  public String trace() {
    log.info("=======call trace1========");
    return restTemplate().getForEntity("http://trace-2/trace-2", String.class).getBody();
  }

  public static void main(String[] args) {
    SpringApplication.run(TraceApplication.class, args);
  }
}
