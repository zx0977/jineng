package com.example.demo.service;

import com.example.demo.domain.entity.Canting;

import java.util.List;

public interface CantingService {

    public List<Canting> CantingAll();

    //新增餐厅员工
    public void insert(Canting canting);

    void update(Canting canting);

    void canshan(int id);
}
