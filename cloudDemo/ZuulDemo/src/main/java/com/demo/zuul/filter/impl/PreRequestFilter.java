package com.demo.zuul.filter.impl;

import com.demo.zuul.filter.AbstractPreFilter;
import com.demo.zuul.filter.AbstractZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PreRequestFilter extends AbstractPreFilter {
    /**
     * 做个简单的接口时间记录测试
     * @return
     */
    @Override
    protected Object excRun() {
        System.out.println("PreRequestFilter : "+ Thread.currentThread().getName());
        requestContext.get().set("startTime", System.currentTimeMillis());

        return success();
    }

    @Override
    public int filterOrder() {
        return 2;
    }
}
