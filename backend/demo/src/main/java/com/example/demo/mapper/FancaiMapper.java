package com.example.demo.mapper;

import com.example.demo.domain.entity.Fancai;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FancaiMapper {

    //查询所有饭菜
    @Select("select * from fancai")
    public List<Fancai> FancaiAll();

    //新增饭菜
    @Insert("insert into fancai values(DEFAULT,#{fanname},#{cainame})")
    public void insert(Fancai fancai);

    //根据ID查询
    @Select("select * from fancai where id= #{id}")
    Fancai fanById(int id);

    //修改饭菜
    @Update("update fancai set  fanname= #{fanname} , cainame = #{cainame}  where id= #{id}")
    void update(Fancai fancai);

    //删除饭菜
    @Delete("DELETE FROM fancai where id = #{id}")
    void caishan(int id);
}
