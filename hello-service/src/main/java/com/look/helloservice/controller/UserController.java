package com.look.helloservice.controller;

import com.google.common.collect.Lists;
import com.look.api.dto.User;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  // 静态数据
  private static List<User> users = Lists.newArrayListWithCapacity(100);

  static {
    for (int i = 0; i < 100; i++) {
      User user = new User();
      user.setId(Long.valueOf(i + 1));
      user.setName(RandomStringUtils.randomAlphabetic(10));
      users.add(user);
    }
  }

  @GetMapping(params = {"ids"})
  public List<User> findAllUser(@RequestParam(value = "ids") List<Long> ids) {
    ArrayList<User> result = Lists.newArrayListWithCapacity(ids.size());
    for (Long id : ids) {
      User user = getUser(id);
      if(user != null){
        result.add(user);
      }
    }
    LOGGER.info("[findAllUser]\t[ids:{}]\t[user:{}]", ids, result);
    return result;
  }


  @GetMapping(value = "{id}")
  public User getUserById(@PathVariable(value = "id") Long id) {
    User result = getUser(id);
    LOGGER.info("[getUserById]\t[id:{}]\t[user:{}]", id, result);
    return result;
  }

  private User getUser(Long id) {
    User result = null;
    for (User user : users) {
      if (user.getId().equals(id)) {
        result = user;
      }
    }
    return result;
  }

  @PostMapping
  public User updateUser(@RequestBody User req) {
    User result = null;
    for (User user : users) {
      if (user.getId().equals(req.getId())) {
        user.setName(req.getName());
      }
    }
    LOGGER.info("[updateUser]\t[req:{}]", req);
    return result;
  }

}
