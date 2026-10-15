package com.example.demo.web;

import com.example.demo.domain.entity.Dingdan;
import com.example.demo.domain.result.Result;
import com.example.demo.service.DingdanService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin // 在Controller类上加这个注解
@RestController
public class DingdanController {

    @Autowired
    DingdanService dingdanService;

    @GetMapping("/dingdanall")
    public Result Dingdanall(){
        List<Dingdan> all = dingdanService.DingdanAll();
        return Result.success(all);
    }
    @GetMapping("/fanlist")
    public Result FanList(){
        List<Map<String,Object>> fan=dingdanService.FanList();
        return Result.success(fan);
    }
    @GetMapping("/yonglist")
    public Result YongList(){
        List<Map<String,Object>> yong=dingdanService.YongList();
        return Result.success(yong);
    }
    @PostMapping("/dingdanadd")
    public Result Dingdanadd(@RequestBody Dingdan dingdan) {

        return dingdanService.Dingdanadd(dingdan);
    }

    @GetMapping("/dingdan/{id}")
    public Result Dingdan(@PathVariable int id){
        Dingdan dingdan = dingdanService.Dingdan(id);
        return Result.success(dingdan);
    }

    @PutMapping("/dingdanxiua")
    public Result Dingdanxiu(@RequestBody Dingdan dingdan){
        dingdanService.Dingdanxiu(dingdan);
        return Result.success("123123");
    }

    @DeleteMapping("/dingshan")
    public Result Dingshan(int id){
        dingdanService.dingshan(id);
        return Result.success();
    }
}
