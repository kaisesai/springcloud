package com.look.feignconsumer;

import com.look.feignconsumer.service.HelloServiceFallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class ConsumerApplication {

  public static void main(String[] args) {
    log.debug("[start application]\t[1]");
    SpringApplication.run(ConsumerApplication.class, args);
    log.debug("[start application]\t[2]");
  }

}
