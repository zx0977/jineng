package com.example.demo.mapper;

import com.example.demo.domain.entity.Canting;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CantingMapper {

    @Select("select * from canting")
    public List<Canting> CantingAll();

    @Insert("insert into canting values(DEFAULT,#{name},#{gender},#{address},#{phone},#{notes})")
    public void insert(Canting canting);

    //修改
    @Update("update canting set  name= #{name} , gender = #{gender} ,address= #{address} ,phone= #{phone} ,notes= #{notes} where id= #{id}")
    void update(Canting canting);

    @Delete("DELETE FROM canting where id = #{id}")
    void canshan(int id);
}
