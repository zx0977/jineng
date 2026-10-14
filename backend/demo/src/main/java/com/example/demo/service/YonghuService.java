package com.example.demo.service;

import com.example.demo.domain.entity.Yonghu;
import com.example.demo.domain.result.Result;

import java.util.List;

public interface YonghuService {

    public List<Yonghu> Yonghuall();

    Result Yonghuadd(Yonghu yonghu);

    //根据id查询
    Yonghu yong(int id);

    void Yongxiu(Yonghu yonghu);

    void Yongshan(int id);
}
