package com.example.demo.service;

import com.example.demo.domain.entity.Dingdan;
import com.example.demo.domain.result.Result;

import java.util.List;
import java.util.Map;

public interface DingdanService {

    //查询订单
    public List<Dingdan> DingdanAll();

    public List<Map<String,Object>> FanList();

    public List<Map<String,Object>> YongList();
    //新增订单
    Result Dingdanadd(Dingdan dingdan);

    //修改订单
    void Dingdanxiu(Dingdan dingdan);

    //根据id查询
    Dingdan Dingdan(int id);

    //删除订单
    void dingshan(int id);
}
