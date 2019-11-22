package com.hyz.user.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class UserPwdFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getBoolean("isSucc");
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        System.out.println(String.format("%s UserPwdFilter request to %s", request.getMethod(), request.getRequestURL()));

        String pwd = request.getParameter("pwd");
        if (null != pwd && "123456".equals(pwd)) {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("isSucc", true);
        } else {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("{\"result\":\"pwd is not correct!\"}");// 返回错误内容
            context.set("isSucc", false);
        }
        return null;
    }
}
