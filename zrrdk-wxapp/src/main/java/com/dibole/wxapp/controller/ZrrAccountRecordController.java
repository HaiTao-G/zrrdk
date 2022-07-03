package com.dibole.wxapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dibole.commons.api.CommonController;
import com.dibole.entity.zrrdk.ZrrAccountRecord;

/**
* <p>
* 提现返佣记录表 前端控制器
* </p>
*
* @author haitao
* @since 2020-12-08
*/
@RestController
@RequestMapping("/zrr-account-record")
public class ZrrAccountRecordController extends CommonController<ZrrAccountRecord> {

}