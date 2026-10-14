package com.example.demo.web;

import com.example.demo.domain.entity.Fancai;
import com.example.demo.domain.result.Result;
import com.example.demo.service.FancaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin // 在Controller类上加这个注解
@RestController
public class FancaiController {

    @Autowired
    FancaiService fancaiService;

    //查询饭菜
    @GetMapping ("/fancai")
    public Result fancai(){
        List<Fancai> all = fancaiService.fancai();
        return Result.success(all);
    }

    //新增饭菜
    @PostMapping("/fancaiadd")
    public Result fancaiad(@RequestBody Fancai fancai){
        fancaiService.fancaiadd(fancai);
        return Result.success();
    }
     //根据id查询
    @GetMapping("/fanxiu/{id}")
    public Result fanxiu(@PathVariable int id){
        Fancai fancai = fancaiService.fanById(id);
        return Result.success(fancai);
    }

    //修改饭菜
    @PutMapping("/caixiu")
    public Result caixiu(@RequestBody Fancai fancai){
        fancaiService.update(fancai);
        return Result.success();
    }

    //删除
    @DeleteMapping("/caishan")
    public Result caishan(int id){
        fancaiService.caishan(id);
        return Result.success();
    }

}
