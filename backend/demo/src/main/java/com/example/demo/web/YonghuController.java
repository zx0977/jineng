package com.example.demo.web;

import com.example.demo.domain.entity.Yonghu;
import com.example.demo.domain.result.Result;
import com.example.demo.service.YonghuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // 在Controller类上加这个注解
@RestController
public class YonghuController {

    @Autowired
    YonghuService yonghuService;

    @GetMapping("/yonghuall")
    public Result Yonghuall(){
        List<Yonghu> all= yonghuService.Yonghuall();
        return Result.success(all);
    }

    @PostMapping("/yonghuadd")
    public Result Yonghuadd(@RequestBody Yonghu yonghu){
        yonghuService.Yonghuadd(yonghu);
        return Result.success();
    }

    @GetMapping("/yong/{id}")
    public Result Yong(@PathVariable int id){
       Yonghu yonghu= yonghuService.yong(id);
        return Result.success(yonghu);
    }

    @PutMapping("/yongxiu")
    public Result Yongxiu(@RequestBody Yonghu yonghu){
       yonghuService.Yongxiu(yonghu);
        return Result.success();
    }

    @DeleteMapping("/yongshan")
    public Result Yongshan(int id){
        yonghuService.Yongshan(id);
        return Result.success();
    }
}
