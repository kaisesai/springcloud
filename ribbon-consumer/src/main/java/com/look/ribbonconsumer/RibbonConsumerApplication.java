package com.look.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@ServletComponentScan
@SpringCloudApplication
@SpringBootApplication(scanBasePackages = "com.look.ribbonconsumer")
public class RibbonConsumerApplication {

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {

    SpringApplication.run(RibbonConsumerApplication.class, args);
  }

}

