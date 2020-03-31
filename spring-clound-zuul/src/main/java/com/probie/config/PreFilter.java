package com.probie.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.probie.basic.ResponseResult;
import com.probie.basic.enums.ResponseTypes;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends ZuulFilter {

  @Override
  public String filterType() {
    //共四种 pre post routing error
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    // 值越小越优先执行
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    // 是否执行run方法
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    // 请求拦截，例如token校验（结合redis）
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    String token = request.getParameter("token");
    if(StringUtils.isEmpty(token)) {
      // 跳转登录页面
      setUnauthorizedResponse(requestContext, "Authentication failed：token is empty，please login ");
    }

    return null;
  }

  /**
   * 设置 400 无权限状态
   */
  private void setUnauthorizedResponse(RequestContext requestContext, String msg) {
    requestContext.setSendZuulResponse(false);
    requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
    requestContext.setResponseBody(msg);
  }
}
