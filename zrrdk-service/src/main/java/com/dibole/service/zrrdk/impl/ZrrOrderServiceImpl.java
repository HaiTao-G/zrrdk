package com.dibole.service.zrrdk.impl;

import com.dibole.entity.zrrdk.ZrrOrder;
import com.dibole.dao.mysql.zrrdk.ZrrOrderMapper;
import com.dibole.service.zrrdk.ZrrOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 开票订单表 服务实现类
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Service
public class ZrrOrderServiceImpl extends ServiceImpl<ZrrOrderMapper, ZrrOrder> implements ZrrOrderService {

}
