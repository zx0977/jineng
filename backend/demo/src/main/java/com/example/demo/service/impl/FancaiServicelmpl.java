package com.example.demo.service.impl;

import com.example.demo.domain.entity.Fancai;
import com.example.demo.mapper.FancaiMapper;
import com.example.demo.service.FancaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FancaiServicelmpl implements FancaiService {

    @Autowired
    FancaiMapper fancaiMapper;

    @Override
    public List<Fancai> fancai() {
        List<Fancai> all= fancaiMapper.FancaiAll();
        return all;
    }
    //新增饭菜
    @Override
    public void fancaiadd(Fancai fancai) {

        fancaiMapper.insert(fancai);
    }
    //根据ID查询
    @Override
    public Fancai fanById(int id) {
        Fancai fancai = fancaiMapper.fanById(id);
        return fancai;
    }

    //修改饭菜
    @Override
    public void update(Fancai fancai) {
        fancaiMapper.update(fancai);
    }

    @Override
    public void caishan(int id) {
        fancaiMapper.caishan(id);
    }
}
