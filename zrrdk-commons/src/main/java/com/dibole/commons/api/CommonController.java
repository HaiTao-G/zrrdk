package com.dibole.commons.api;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tao
 * @version 1.0.0
 * @className CommonController.java
 * @description 通用controller
 * @createTime 2020年12月07日 13:40:00
 */
@Slf4j
public class CommonController<T> {

    @Autowired
    private BaseMapper<T> mapper;

    @ApiOperation("搜索列表")
    @PostMapping(value = "/listByPage")
    @ResponseBody
    public List<T> listByPage(@RequestBody T map){
        return mapper.selectPage(null,null);
    }

    @ApiOperation("根据主键id获取")
    @GetMapping(value = "/{recId}")
    @ResponseBody
    public T getById(@PathVariable("recId") String recID){
        mapper.selectById(recID);
        return null;
    }

    @ApiOperation("根据主键id删除")
    @DeleteMapping(value = "/{recId}")
    @ResponseBody
    public void deleteById(@PathVariable("recId") String recId){
        mapper.deleteById(recId);
    }


    @ApiOperation("新增")
    @PostMapping(value = "/save")
    @ResponseBody
    public void save(@RequestBody T map){
        mapper.insert(map);
    }

    @ApiOperation("更新")
    @PutMapping(value = "/update")
    @ResponseBody
    public void updateById(@RequestBody T map){
        mapper.updateById(map);
    }
}
