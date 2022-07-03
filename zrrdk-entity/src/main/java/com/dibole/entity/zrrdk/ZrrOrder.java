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
 * 开票订单表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrOrder对象", description="开票订单表")
public class ZrrOrder extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "用户")
    private String userId;

    @ApiModelProperty(value = "园区")
    private String parkId;

    @ApiModelProperty(value = "抬头")
    private String companyId;

    @ApiModelProperty(value = "开票类目")
    private String categoryId;

    @ApiModelProperty(value = "开票人")
    private String drawerId;

    @ApiModelProperty(value = "开票金额")
    private BigDecimal price;

    @ApiModelProperty(value = "需要付款金额")
    private BigDecimal needPay;

    @ApiModelProperty(value = "收票地址")
    private String addressId;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "凭证, attach_id逗号分隔")
    private String voucher;

    @ApiModelProperty(value = "合同,attach_id逗号分隔")
    private String contract;

    @ApiModelProperty(value = "订单状态: 1-待开票 2-已开票(返佣) 3-已取消")
    private String orderStatus;

    @ApiModelProperty(value = "支付状态: 0-未支付 1-已支付 2-已退款")
    private String payStatus;

    @ApiModelProperty(value = "当前费率,固定在订单中")
    private Double serviceRate;

    @ApiModelProperty(value = "当前渠道费率,固定在订单中")
    private Double channelRate;

    private String createTime;

    private String updateTime;

    private String deliveryName;

    private String deliveryNo;

    private String orderUrl;

    @ApiModelProperty(value = "付款ID")
    private String payId;

    @ApiModelProperty(value = "开票上家userId，分成的上家")
    private String channelId;

    @ApiModelProperty(value = "是否参与了分成，1：是（分成），0：否（不分成）")
    private String channelType;

    @ApiModelProperty(value = "支付平台标识id")
    private String sourceId;


}
