package com.demo.zuul.filter.impl;

import com.demo.zuul.filter.AbstractPostZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试 post 类型过滤器 做个时间记录
 */
@Slf4j
@Component
public class PerformanceFilter extends AbstractPostZuulFilter {
    @Override
    protected Object excRun() {
        System.out.println("PerformanceFilter : "+ Thread.currentThread().getName());
        HttpServletRequest request = requestContext.get().getRequest();

        // 从 PreRequestFilter 中获取设置的请求时间戳
        Long startTime = (Long) requestContext.get().get("startTime");
        String uri = request.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;

        // 从网关通过的请求都会打印日志记录: uri + duration
        log.info("uri: {}, duration: {}", uri, duration);

        return success();
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }
}
