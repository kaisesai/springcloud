package com.look.feignconsumer.service;

import com.look.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)
public interface RefactorHelloService extends HelloService {

}
