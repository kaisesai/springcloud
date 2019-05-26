package com.look.feignconsumer.service;

import com.look.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hello-service")
public interface RefactorHelloService extends HelloService {

}
