package com.demo.template.controller;

import com.demo.template.dao.MybatisTest;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {
    @Autowired
    MybatisTest mybatisTest;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health(){
        redisTemplate.opsForValue().set("test","demo");
        return "service is okay!";
    }

}
