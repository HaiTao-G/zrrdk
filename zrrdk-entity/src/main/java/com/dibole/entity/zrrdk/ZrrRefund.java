package com.dibole.entity.zrrdk;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dibole.codegenerator.entity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 退款记录表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrRefund对象", description="退款记录表")
public class ZrrRefund extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "付款表ID")
    private String payId;

    @ApiModelProperty(value = "开票订单表ID")
    private String orderId;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundMoney;

    @ApiModelProperty(value = "退款流水号")
    private String refundTransactionId;

    @ApiModelProperty(value = "退款状态： 0-退款中 1-退款成功 2-退款异常 3-退款关闭")
    private String refundStatus;

    private String createTime;

    private String updateTime;


}
