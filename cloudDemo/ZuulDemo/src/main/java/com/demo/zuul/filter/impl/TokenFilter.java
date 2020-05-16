package com.demo.zuul.filter.impl;

import com.demo.zuul.filter.AbstractPreFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class TokenFilter extends AbstractPreFilter {
    @Override
    protected Object excRun() {
        /*RequestContext context = requestContext.get();
        HttpServletRequest request = context.getRequest();
        log.info(String.format("%s request to %s",
                request.getMethod(), request.getRequestURL().toString()));

        Object token = request.getParameter("token");
        if (null == token) {
            log.error("error: token is empty");
            return fail(401, "error: token is empty");
        }*/

        return success();
    }

    @Override
    public int filterOrder() {
        // 身份校验级别高，不通过的话后面都没必要执行
        return 1;
    }
}
