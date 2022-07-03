package com.dibole.wxapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dibole.commons.api.CommonController;
import com.dibole.entity.zrrdk.ZrrUserInvitecode;

/**
* <p>
* 用户邀请码图片链接存储表 前端控制器
* </p>
*
* @author haitao
* @since 2020-12-08
*/
@RestController
@RequestMapping("/zrr-user-invitecode")
public class ZrrUserInvitecodeController extends CommonController<ZrrUserInvitecode> {

}
