package com.common.advice;

import com.common.exception.DemoCommonException;
import com.common.model.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler(value = DemoCommonException.class)
    public CommonResponse<String> handlerCouponException(
            HttpServletRequest req, DemoCommonException ex
    ) {

        CommonResponse<String> response = new CommonResponse<>(
                -1, "business error");
        response.setData(ex.getMessage());
        return response;
    }

}
