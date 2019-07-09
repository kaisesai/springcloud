package com.look.apigateway;

import com.look.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
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
   * 例如服务 helloservice-v1
   * 映射的 URL 是  v1/helloservice/**
   * </p>
   *
   * @return
   */
  // @Bean
  // public PatternServiceRouteMapper patternServiceRouteMapper() {
  //   // 这里使用了正则表达式分组和反向引用
  //   // 小括号 () 可以达到对正则表达式进行分组的效果。
  //   // 模式分组后会在正则表达式中创建反向引用。
  //   // 反向引用会保存匹配模式分组的字符串片断，这使得我们可以获取并使用这个字符串片断。
  //   // 在以正则表达式替换字符串的语法中，是通过 $ 来引用分组的反向引用，
  //   // $0 是匹配完整模式的字符串（注意在 JavaScript 中是用 $& 表示）；
  //   // $1 是第一个分组的反向引用；$2 是第二个分组的反向引用，以此类推。
  //
  //   // 分组的反向引用副本
  //   // Java 中可以在小括号中使用 ?<name> 将小括号中匹配的内容保存为一个名字为 name 的副本。
  //   // 表达式 (?<name>^.+) 意思是模式为将以任何字符开头并且出现一次或多次的字符保存在一个名字叫做 name 的group 中.
  //   return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+^)", "${version}/${name}");
  // }

}
