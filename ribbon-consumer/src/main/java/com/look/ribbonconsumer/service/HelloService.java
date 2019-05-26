package com.look.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class HelloService {

  @Autowired
  private RestTemplate restTemplate;


  @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey",
                  groupKey = "helloGroup", threadPoolKey = "helloThreadGroup")
  public String helloService() throws ExecutionException, InterruptedException {

    System.out.println("[方法开始执行]\t[当前时间" + System.currentTimeMillis() + "]");
    Future<String> future = new AsyncResult<String>() {

      @Override
      public String invoke() {
        try {
          Thread.sleep(RandomUtils.nextInt(0, 3000));
        } catch (InterruptedException ignored) {
        }
        System.out.println("[方法开始结束执行]\t[当前时间" + System.currentTimeMillis() + "]");
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
      }
    };

    System.out.println("[方法开始结束执行]\t[当前时间" + System.currentTimeMillis() + "]");
    return future.get();

  }

  public String helloFallback() {
    return "error";
  }

}
