package com.look.feignconsumer.service;

import com.look.api.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *   这里加入 @RequestMapping("/will-never-access-this-endpoint")
 *   目的是的映射需要修改为不和父类相同,避免出现 Caused by: java.lang.IllegalStateException: Ambiguous mapping.
 * </p>
 */
@RequestMapping("/will-never-access-this-endpoint")
@Component
public class HelloServiceFallback implements RefactorHelloService {

  private static final User USER = new User();

  static {
    USER.setName("未知");
    USER.setId(0L);
  }

  @Override
  public String hello(String name) {
    return "error";
  }

  @Override
  public User hello(String name, Integer age) {
    return USER;
  }

  @Override
  public String hello(User user) {
    return "error";
  }

}
