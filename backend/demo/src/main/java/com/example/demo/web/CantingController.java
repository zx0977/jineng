package com.example.demo.web;

import com.example.demo.domain.entity.Canting;
import com.example.demo.domain.result.Result;
import com.example.demo.service.CantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // 在Controller类上加这个注解
@RestController
public class CantingController {

    @Autowired
    CantingService cantingService;

    //查询餐厅人员
    @GetMapping("/cantingall")
    public Result Cantingall(){
        List<Canting> all = cantingService.CantingAll();
        return Result.success(all);
    }

    //新增餐厅人员
    @PostMapping("/cantingadd")
    public Result Cantingadd(@RequestBody Canting canting){
        cantingService.insert(canting);
        return Result.success();
    }
    //修改
    @PutMapping("/cantingxiu")
    public Result Cantingxiu(@RequestBody Canting canting){
        cantingService.update(canting);
        return Result.success();
    }
    //删除
    @DeleteMapping("/cantingshan")
    public Result Cantingshan(int id){
        cantingService.canshan(id);
        return Result.success();
    }
}
