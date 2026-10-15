package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.entity.Dingdan;
import com.example.demo.domain.entity.Fancai;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;


@Mapper
public interface DingdanMapper extends BaseMapper<Dingdan> {

    @Select("SELECT DISTINCT c.id ,c.fanname FROM fancai c LEFT JOIN dingdan s ON c.id = s.id WHERE c.fanname IS NOT NULL")
    List<Map<String,Object>> getFancaiList();


    @Select("SELECT DISTINCT d.id , d.name FROM yonghu d LEFT JOIN dingdan s ON d.id = s.id WHERE d.name IS NOT NULL")
    List<Map<String,Object>> getYonghuList();

    @Select("select * from dingdan")
    public List<Dingdan> DingdanAll();

    @Update("update dingdan set ordername= #{OrderName} , username = #{UserName}  where id= #{id}")
    void update(Dingdan dingdan);

    //删除订单
    @Delete("DELETE FROM dingdan where id = #{id}")
    void dingshan(int id);
}
