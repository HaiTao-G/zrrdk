package com.dibole.wxapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dibole.commons.api.CommonController;
import com.dibole.entity.zrrdk.ZrrUserThirdOauth;

/**
* <p>
* 用户第三方账号信息表 前端控制器
* </p>
*
* @author haitao
* @since 2020-12-08
*/
@RestController
@RequestMapping("/zrr-user-third-oauth")
public class ZrrUserThirdOauthController extends CommonController<ZrrUserThirdOauth> {

}
