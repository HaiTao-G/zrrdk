package com.dibole.entity.zrrdk;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.dibole.codegenerator.entity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 提现返佣记录表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrAccountRecord对象", description="提现返佣记录表")
public class ZrrAccountRecord extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "目前只有返佣和提现,后续增加")
    private String type;

    @ApiModelProperty(value = "操作之前账户余额")
    private Double oldFinance;

    @ApiModelProperty(value = "操作变更金额")
    private Double changeFinance;

    @ApiModelProperty(value = "结果金额")
    private Double destFinance;

    private String createTime;

    private String updateTime;

    @ApiModelProperty(value = "提现成功或者失败的说明")
    private String markInfo;

    @ApiModelProperty(value = "提现状态：0：提现失败，1：提现中，2:提现成功")
    @TableField("STATUS")
    private String status;


}
