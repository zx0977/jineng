package com.example.demo.service.impl;

import com.example.demo.domain.entity.Canting;
import com.example.demo.mapper.CantingMapper;
import com.example.demo.service.CantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantingServicelmpl implements CantingService {

    @Autowired
    CantingMapper cantingMapper;

    //查询餐厅人员
    @Override
    public List<Canting> CantingAll() {
        List<Canting> all = cantingMapper.CantingAll();
        // 循环脱敏手机号
        for (Canting canting : all) {
            String phone = canting.getPhone();
            canting.setPhone(maskPhone(phone));
        }
        return all;
    }
    /**
     * 手机号脱敏：13512345678 → 135****5678
     */
    private String maskPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
    //新增餐厅人员
    @Override
    public void insert(Canting canting) {
        cantingMapper.insert(canting);
    }

    //修改餐厅人员
    @Override
    public void update(Canting canting) {
        cantingMapper.update(canting);
    }

    @Override
    public void canshan(int id) {
        cantingMapper.canshan(id);
    }


}
