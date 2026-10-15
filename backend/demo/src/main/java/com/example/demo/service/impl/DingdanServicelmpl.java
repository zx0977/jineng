package com.example.demo.service.impl;

import com.example.demo.domain.entity.Dingdan;
import com.example.demo.domain.result.Result;
import com.example.demo.mapper.DingdanMapper;
import com.example.demo.service.DingdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class DingdanServicelmpl implements DingdanService {

    @Autowired
    DingdanMapper dingdanMapper;
    // 在这里定义random成员变量！
    private static final Random random = new Random();
    //查询订单
    @Override
    public List<Dingdan> DingdanAll() {
        List<Dingdan> all = dingdanMapper.DingdanAll();
        return all;
    }

    @Override
    public List<Map<String,Object>> FanList() {
        List<Map<String,Object>> fan=dingdanMapper.getFancaiList();
        return fan;
    }

    @Override
    public List<Map<String,Object>> YongList() {
        List<Map<String,Object>> yong=dingdanMapper.getYonghuList();
        return yong;
    }

    //新增订单
    @Override
    public Result Dingdanadd(Dingdan dingdan) {
        // ===== 自动生成订单号 =====
        String orderNo = generateOrderNo();
        dingdan.setOrder(orderNo);

        try {
            dingdan.setTime(new Date());
            // 插入数据库，变量名统一用 dingdan
            int insert = dingdanMapper.insert(dingdan);
            if (insert > 0) {
                return Result.success("新增订单成功");
            }
            return Result.error("新增失败");
        } catch (DuplicateKeyException e) {
            // 极端情况：生成的订单号重复，重试一次
            String newOrderNo = generateOrderNo();
            dingdan.setOrder(newOrderNo);
            try {
                dingdan.setTime(new Date());
                dingdanMapper.insert(dingdan);
                return Result.success("新增订单成功");
            }catch (DuplicateKeyException ex){
                // 重试依旧冲突，直接返回错误
                return Result.error("订单号生成失败，请重试");
            }
        }
    }

    //修改订单
    @Override
    public void Dingdanxiu(Dingdan dingdan) {
        dingdan.setTime(new Date());
        dingdanMapper.updateById(dingdan);
    }

    @Override
    public Dingdan Dingdan(int id) {
        Dingdan dingdan=dingdanMapper.selectById(id);
        return dingdan;
    }

    //删除订单
    @Override
    public void dingshan(int id) {
        dingdanMapper.dingshan(id);
    }

    // 生成订单号方法
    private String generateOrderNo() {
        // 毫秒时间戳 + 3位随机数(000~999)
        long timestamp = System.currentTimeMillis();
        int num = random.nextInt(1000);
        // 格式化，不足三位前面补0，保证固定3位
        return timestamp + String.format("%03d", num);
    }

}
