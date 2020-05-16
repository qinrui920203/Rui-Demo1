package com.demo.zuul.filter.impl;

import com.demo.zuul.filter.AbstractPreFilter;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@SuppressWarnings("all")
public class RateLimitFilter extends AbstractPreFilter {
    /** 利用 guava 每秒可以获取到两个令牌 */
    RateLimiter rateLimiter = RateLimiter.create(2.0);

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    protected Object excRun() {
        HttpServletRequest httpRequest = requestContext.get().getRequest();

        if (rateLimiter.tryAcquire()) {
            log.info("get rate token success");
            return success();
        } else {
            log.error("rate limit: {}", httpRequest.getRequestURI());
            return fail(402, "error: rate limit");
        }
    }
}
