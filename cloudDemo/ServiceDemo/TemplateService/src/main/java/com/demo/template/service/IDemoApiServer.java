package com.demo.template.service;

import java.util.List;
import java.util.Map;

public interface IDemoApiServer {
    /**
     * 获取数据测试服务
     * 简单的做一个数据查询，验证服务状态，当健康检查用了
     * redis弄完了记得加上redis逻辑
     * @return 数据Json
     */
    public String getData();

    /**
     * 修改数据服务
     * 做一个批量修改
     * @param updataDatas 修改的数据集合，因数据库我就做了2列测试，这里简单的搞一下
     * @return success/fail/erro
     */
    public String putData(Map<String, String> updataDatas);

    /**
     * 删除数据接口服务
     * 同时删除数据库和缓存
     * @param ids 需要删除的id集合
     * @return 受影响行数
     */
    public Integer deleteData(List<String> ids);

    /**
     * 新增数据接口
     * 先放缓存，然后kafka异步入库
     * @param datas 新增数据集合
     * @return 插入成功行数
     */
    public Integer addData(Map<String, String> datas);
}
