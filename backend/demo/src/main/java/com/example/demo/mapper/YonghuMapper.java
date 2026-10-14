package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.entity.Yonghu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YonghuMapper extends BaseMapper<Yonghu> {

    @Select("select * from yonghu")
    public List<Yonghu> Yonghuall();

    @Delete("DELETE FROM yonghu where id = #{id}")
    void Yongshan(int id);
}
