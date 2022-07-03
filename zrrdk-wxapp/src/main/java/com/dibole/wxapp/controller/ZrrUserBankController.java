package com.dibole.wxapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dibole.commons.api.CommonController;
import com.dibole.entity.zrrdk.ZrrUserBank;

/**
* <p>
* C端用户绑定的商家和银行卡信息表 前端控制器
* </p>
*
* @author haitao
* @since 2020-12-08
*/
@RestController
@RequestMapping("/zrr-user-bank")
public class ZrrUserBankController extends CommonController<ZrrUserBank> {

}
