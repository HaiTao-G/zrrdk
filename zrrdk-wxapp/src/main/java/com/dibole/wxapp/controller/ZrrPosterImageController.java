package com.dibole.wxapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dibole.commons.api.CommonController;
import com.dibole.entity.zrrdk.ZrrPosterImage;

/**
* <p>
* 自然人代开海报添加图片水印表 前端控制器
* </p>
*
* @author haitao
* @since 2020-12-08
*/
@RestController
@RequestMapping("/zrr-poster-image")
public class ZrrPosterImageController extends CommonController<ZrrPosterImage> {

}
