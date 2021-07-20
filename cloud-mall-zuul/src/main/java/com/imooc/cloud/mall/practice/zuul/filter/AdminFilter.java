package com.imooc.cloud.mall.practice.zuul.filter;

import com.imooc.cloud.mall.practice.common.common.Constant;
import com.imooc.cloud.mall.practice.user.model.pojo.User;
import com.imooc.cloud.mall.practice.zuul.feign.UserFeignClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 管理员鉴权过滤器
 * @Author: Rex
 * @Create: 2021-07-09 19:38
 */
@Component
public class AdminFilter extends ZuulFilter {

  @Autowired
  UserFeignClient userFeignClient;

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    String requestURI = request.getRequestURI();
    if (requestURI.contains("adminLogin")){
      return false;
    }
    if (requestURI.contains("admin")){
      return true;
    }
    return false;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext currentContext = RequestContext.getCurrentContext();
    HttpServletRequest request = currentContext.getRequest();
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute(Constant.IMOOC_MALL_USER);
    if (currentUser == null) {
      currentContext.setSendZuulResponse(false);
      currentContext.setResponseBody("{\n" +
          "    \"status\": 10010,\n" +
          "    \"msg\": \"NEED_LOGIN\",\n" +
          "    \"data\": null\n" +
          "}");
      currentContext.setResponseStatusCode(200);
    }

    // 校验是否是管理员
    Boolean adminRole = userFeignClient.checkAdminRole(currentUser);
    if (!adminRole){
      currentContext.setSendZuulResponse(false);
      currentContext.setResponseBody("{\n" +
          "    \"status\": 10011,\n" +
          "    \"msg\": \"NEED_ADMIN\",\n" +
          "    \"data\": null\n" +
          "}");
      currentContext.setResponseStatusCode(200);
    }
    return null;
  }

}
