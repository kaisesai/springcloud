package com.look.ribbonconsumer.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 熔断器上下文过滤器
 *
 * <p>
 * 用于处理缓存和合并请求功能
 * </p>
 */
@WebFilter(filterName = "hystrixRequestContextServletFilter", urlPatterns = "/*")
public class HystrixRequestContextServletFilter implements Filter {

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HystrixRequestContext context = HystrixRequestContext.initializeContext();
    try {
      chain.doFilter(request, response);
    } finally {
      context.shutdown();
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void destroy() {
  }
}
