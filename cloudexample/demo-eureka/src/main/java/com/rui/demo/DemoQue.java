package com.rui.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class DemoQue {
        @Autowired
        private SqlDao dao;

        @RequestMapping(value = 'xxxxxxxx')
        public String getAreaData(String AreaaCode){

            List<vo> vos = dao.selectArea(AreaaCode);
            return new Gson.toJson(buildNode(vos));
        }

        private List<Vo> buildNode(List<vo> vos){
            根据父id做个聚集，时间有限，不写了
        }
    }
