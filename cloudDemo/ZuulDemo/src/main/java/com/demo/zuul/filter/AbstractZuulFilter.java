package com.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;

public abstract class AbstractZuulFilter extends ZuulFilter {

    // 为了保障线程安全，这里设计成在Threadlocal中放置
    protected ThreadLocal<RequestContext> requestContext = new ThreadLocal<RequestContext>();

    // 标识是否继续执行过滤
    private final static String NEXT = "next";

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        boolean stepFlag = (boolean)ctx.getOrDefault(NEXT, true);
        return stepFlag;
    }

    @Override
    public Object run() throws ZuulException {
        requestContext.set(RequestContext.getCurrentContext());
        return excRun();
    }

    protected Object fail(int code, String msg){
        RequestContext ctx = requestContext.get();

        ctx.set(NEXT, false);
        ctx.setSendZuulResponse(false);
        ctx.getResponse().setContentType("text/html;charset=UTF-8");
        ctx.setResponseStatusCode(code);
        ctx.setResponseBody(String.format("{\"result\": \"%s!\"}", msg));

        return null;
    }

    protected Object success() {
        RequestContext ctx = requestContext.get();
        ctx.set(NEXT, true);

        return null;
    }

    protected abstract Object excRun();
}
