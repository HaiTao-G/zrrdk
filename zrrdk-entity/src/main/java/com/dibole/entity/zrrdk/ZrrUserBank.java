package com.dibole.entity.zrrdk;

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
 * C端用户绑定的商家和银行卡信息表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrUserBank对象", description="C端用户绑定的商家和银行卡信息表")
public class ZrrUserBank extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "银行账号")
    private String bindAccNum;

    @ApiModelProperty(value = "开户银行全称")
    private String bindOpenBankName;

    @ApiModelProperty(value = "开户行名称(用户填写)")
    private String openBankName;

    @ApiModelProperty(value = "开户行所在省")
    private String openBankProvince;

    @ApiModelProperty(value = "开户行所在市")
    private String openBankCity;

    @ApiModelProperty(value = "开户银行行号")
    private String bindOpenOrgNum;

    @ApiModelProperty(value = "用户的微信openid")
    private String openid;

    @ApiModelProperty(value = "银行卡id，网商银行")
    private String bankId;

    @ApiModelProperty(value = "支付宝账号")
    private String alipayAccount;

    @ApiModelProperty(value = "支付宝账号对应的银行卡id，网商银行")
    private String alipayBankId;

    private String createTime;

    private String updateTime;

    @ApiModelProperty(value = "deleted:0;ok:1;")
    private String status;


}
