package com.hyz.user.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

    // 返回过滤器的类型
    // 可选项：pre, route, post, error
    @Override
    public String filterType() {
        return "post";
    }

    // 返回一个int值来指定过滤器的执行顺序
    // 不同的过滤器允许返回相同的数字
    @Override
    public int filterOrder() {
        return 0;
    }

    // 返回一个boolean值来判断该过滤器是否要执行
    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getBoolean("isSucc");
    }

    // 过滤器具体逻辑
    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        // 默认敏感头信息（Authorization,Cookie,Set-Cookie）不允许转发，也就是获取不到，
        // 如果想获取，则需要再配置中添加zuul.sensitiveHeaders为空
        context.addZuulRequestHeader("Cookie", "abc");
        HttpServletRequest request = context.getRequest();

        System.out.println(String.format("%s TokenFilter request to %s", request.getMethod(), request.getRequestURL()));

        String token = request.getParameter("token");
        if (token == null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("unAuthrized");
            return null;
        }
        return null;
    }

}
