package com.dibole.entity.zrrdk;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dibole.codegenerator.entity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 付款记录表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrPay对象", description="付款记录表")
public class ZrrPay extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    private String orderId;

    @ApiModelProperty(value = "需要支付的金额,最小到分")
    private BigDecimal payMoney;

    @ApiModelProperty(value = "微信支付流水号")
    private String tradeId;

    private LocalDateTime payTime;

    private String createTime;

    private String updateTime;


}
