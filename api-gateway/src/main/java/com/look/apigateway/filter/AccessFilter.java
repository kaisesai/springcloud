package com.look.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessFilter extends ZuulFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

  @Override
  public String filterType() {
    return FilterConstants.POST_TYPE;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    String accessToken = request.getParameter("accessToken");

    LOGGER.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
    // TODO: 2019-04-13 token 处理器
    // redis 或 MySQL ,token 处理器 获取单独的访问一个token鉴权 微服务

    if (StringUtils.isBlank(accessToken)) {
      LOGGER.warn("access token is empty");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      return null;
    }

    LOGGER.info("access token ok");
    return null;
  }
}
