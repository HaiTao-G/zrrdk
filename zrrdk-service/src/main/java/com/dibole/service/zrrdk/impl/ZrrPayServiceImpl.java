package com.dibole.service.zrrdk.impl;

import com.dibole.entity.zrrdk.ZrrPay;
import com.dibole.dao.mysql.zrrdk.ZrrPayMapper;
import com.dibole.service.zrrdk.ZrrPayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 付款记录表 服务实现类
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Service
public class ZrrPayServiceImpl extends ServiceImpl<ZrrPayMapper, ZrrPay> implements ZrrPayService {

}
