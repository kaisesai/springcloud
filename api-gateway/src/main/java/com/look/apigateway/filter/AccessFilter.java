package com.look.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

  @Override
  public String filterType() {
    return "pre";
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
    // redis 或 MySQL ,token 处理器

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
