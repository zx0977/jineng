package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.entity.Dingdan;
import com.example.demo.domain.entity.Fancai;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DingdanMapper extends BaseMapper<Dingdan> {

    @Select("select * from dingdan")
    public List<Dingdan> DingdanAll();

    @Update("update dingdan set ordername= #{OrderName} , username = #{UserName}  where id= #{id}")
    void update(Dingdan dingdan);

    //删除订单
    @Delete("DELETE FROM dingdan where id = #{id}")
    void dingshan(int id);
}
