package com.dibole.wxapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dibole.commons.api.CommonController;
import com.dibole.entity.zrrdk.ZrrUser;

/**
* <p>
* 自然人代开用户表 前端控制器
* </p>
*
* @author haitao
* @since 2020-12-08
*/
@RestController
@RequestMapping("/zrr-user")
public class ZrrUserController extends CommonController<ZrrUser> {

}
