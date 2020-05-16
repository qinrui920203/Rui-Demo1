package com.demo.template.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class DemoAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        throwable.printStackTrace();
        log.error("AsyncError: {}, Method: {}, Param: {}",
                throwable.getMessage(), method.getName(),
                JSON.toJSONString(objects));

    }
}
