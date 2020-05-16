package com.rui.demo.advice;

import com.rui.demo.exception.DemoEcxeption;
import com.rui.demo.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = DemoEcxeption.class)
    public CommonResponse<String> handlerCouponException(
            HttpServletRequest req, DemoEcxeption ex
    ) {

        CommonResponse<String> response = new CommonResponse<>(
                -1, "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
