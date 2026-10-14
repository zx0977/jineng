package com.example.demo.service;

import com.example.demo.domain.entity.Fancai;

import java.util.List;

public interface FancaiService {

    public List<Fancai> fancai();
    //新增饭菜
    public void fancaiadd(Fancai fancai);
    //根据ID查询
    Fancai fanById(int id);
    //修改饭菜
    void update(Fancai fancai);
    //删除饭菜
    void caishan(int id);
}
