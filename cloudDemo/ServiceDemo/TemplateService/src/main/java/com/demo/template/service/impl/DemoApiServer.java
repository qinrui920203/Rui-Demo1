package com.demo.template.service.impl;

import com.demo.template.service.IDemoApiServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DemoApiServer implements IDemoApiServer {

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String putData(Map<String, String> updataDatas) {
        // TODO: 2020/5/14  to be finished
        return "in developing";
    }

    @Override
    public Integer deleteData(List<String> ids) {
        // TODO: 2020/5/14  to be finished
        return -1;
    }

    @Override
    public Integer addData(Map<String, String> datas) {
        // TODO: 2020/5/14  to be finished
        return -1;
    }
}
