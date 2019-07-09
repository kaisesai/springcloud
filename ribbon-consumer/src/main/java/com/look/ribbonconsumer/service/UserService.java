package com.look.ribbonconsumer.service;

import com.look.api.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand
  public List<User> findAll(List<Long> ids) {
    System.out.println("[开始执行方法]\t[findAll]");
    ParameterizedTypeReference<List<User>> responseType = new ParameterizedTypeReference<List<User>>() {
    };
    String idStr = StringUtils.join(ids, ",");
    ResponseEntity<List<User>> user = restTemplate.exchange("http://HELLO-SERVICE/users?ids={1}", HttpMethod.GET, null, responseType, idStr);
    return user.getBody();
  }

  // 这里的缓存基于每次请求 request 的
  @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")
  // @HystrixCommand
  @HystrixCollapser(batchMethod = "findAll", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
                    collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")})
  public User getUserById(Long id) {
    System.out.println("[开始执行方法]\t[getUserById]");
    return restTemplate.getForObject("http://HELLO-SERVICE/users/{1}", User.class, id);
  }

  @CacheRemove(commandKey = "getUserById", cacheKeyMethod = "getUserByIdCacheKey")
  @HystrixCommand
  // @HystrixProperty(name = "requestCache.enabled", value = "true")
  public void update(User user) {
    User result = restTemplate.postForObject("http://HELLO-SERVICE/users", user, User.class);
    System.out.println(result);
  }

  public String getUserByIdCacheKey(Long id) {
    return String.valueOf(id);
  }

}
