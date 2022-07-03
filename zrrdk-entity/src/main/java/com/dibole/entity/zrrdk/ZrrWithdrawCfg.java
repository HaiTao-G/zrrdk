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
 * 提现配置表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrWithdrawCfg对象", description="提现配置表")
public class ZrrWithdrawCfg extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REC_ID", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "提现的类型：渠道:1")
    @TableField("TYPE")
    private String type;

    @ApiModelProperty(value = "税率（整数，<=100，>==0）")
    @TableField("RATE")
    private String rate;

    @ApiModelProperty(value = "最低提现金额：元")
    @TableField("LOW_AMT")
    private String lowAmt;

    @ApiModelProperty(value = "状态0：删除，1：正常")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private String updateTime;

    @ApiModelProperty(value = "每月的最大限额:元")
    @TableField("MONTH_MAX_AMT")
    private String monthMaxAmt;


}
