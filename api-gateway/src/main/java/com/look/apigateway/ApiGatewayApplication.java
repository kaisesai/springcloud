package com.look.apigateway;

import com.look.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

// 使用 zuul 反向代理服务器
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }

  /**
   * 自定义的请求过滤器
   *
   * @return
   */
  @Bean
  public AccessFilter accessFilter() {
    return new AccessFilter();
  }

  /**
   * 自定义的路由规则
   * <p>
   *   例如服务 helloservice-v1
   *   映射的 URL 是  v1/helloservice/**
   * </p>
   * @return
   */
  // @Bean
  // public PatternServiceRouteMapper patternServiceRouteMapper() {
  //   return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+^)", "${version}/${name}");
  // }

}
