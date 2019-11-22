package com.hyz.user.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class UserEmailFilter extends ZuulFilter {

    // pre：可以在请求被路由之前调用
    // route：在路由请求时候被调用
    // post：在route和error过滤器之后被调用
    // error：处理请求时发生错误时被调用

    /**
     * 前置过滤器
     * @return
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
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
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        System.out.println(String.format("%s UserEmailFilter request to %s", request.getMethod(), request.getRequestURL()));

        String email = request.getParameter("email"); // 获取请求的参数
        if (null != email && "517491659@qq.com".equals(email)) {
            context.setSendZuulResponse(true); // 对该请求进行路由
            context.setResponseStatusCode(200);
            context.set("isSucc", true); // 设值，让下一个Filter看到上一个Filter的状态
        } else {
            context.setSendZuulResponse(false); //  过滤该请求，不对其进行路由
            context.setResponseStatusCode(401); // 返回错误码
            context.setResponseBody("{\"result\":\"email is not correct!\"}");// 返回错误内容
            context.set("isSucc", false); // 设值，让下一个Filter看到上一个Filter的状态
        }
        return null;
    }
}
