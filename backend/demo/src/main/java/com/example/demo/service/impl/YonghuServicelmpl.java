package com.example.demo.service.impl;

import com.example.demo.domain.entity.Yonghu;
import com.example.demo.domain.result.Result;
import com.example.demo.mapper.YonghuMapper;
import com.example.demo.service.YonghuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YonghuServicelmpl implements YonghuService {

    @Autowired
    YonghuMapper yonghuMapper;

    //查询用户
    @Override
    public List<Yonghu> Yonghuall() {
        List<Yonghu> all = yonghuMapper.Yonghuall();
        // 循环脱敏手机号
        for (Yonghu yonghu : all) {
            String phone = yonghu.getPhone();
            yonghu.setPhone(maskPhone(phone));
        }
        return all;
    }

    //新增用户
    @Override
    public Result Yonghuadd(Yonghu yonghu) {
        yonghuMapper.insert(yonghu);
        return null;
    }

    @Override
    public Yonghu yong(int id) {
        Yonghu yonghu=yonghuMapper.selectById(id);
        return yonghu;
    }

    @Override
    public void Yongxiu(Yonghu yonghu) {
        yonghuMapper.updateById(yonghu);
    }

    @Override
    public void Yongshan(int id) {
        yonghuMapper.Yongshan(id);
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
}
