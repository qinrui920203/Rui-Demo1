package com.demo.template.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MybatisTest {
    List<String> demoDao();
}
