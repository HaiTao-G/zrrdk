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
 * 自然人代开用户表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrUser对象", description="自然人代开用户表")
public class ZrrUser extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REC_ID", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "登录手机号,同BIND_MOBILE")
    @TableField("LOGIN_NAME")
    private String loginName;

    @ApiModelProperty(value = "登录密码")
    @TableField("LOGIN_PASS")
    private String loginPass;

    @ApiModelProperty(value = "认证证件号码")
    @TableField("CERT_CODE")
    private String certCode;

    @TableField("CERT_PASS")
    private String certPass;

    @ApiModelProperty(value = "认证证件类型")
    @TableField("CERT_TYPE")
    private String certType;

    @ApiModelProperty(value = "认证证件姓名")
    @TableField("CERT_NAME")
    private String certName;

    @ApiModelProperty(value = "认证证件图片")
    @TableField("CERT_IMG")
    private String certImg;

    @ApiModelProperty(value = "微信unionId，同一个开放平台唯一")
    @TableField("UNION_ID")
    private String unionId;

    @ApiModelProperty(value = "微信小程序,openId")
    @TableField("OPEN_ID")
    private String openId;

    @ApiModelProperty(value = "微信appId")
    @TableField("WX_APP_ID")
    private String wxAppId;

    @ApiModelProperty(value = "用户手机号")
    @TableField("BIND_MOBILE")
    private String bindMobile;

    @ApiModelProperty(value = "用户名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "正常（1）、受限（0）、冻结（2）")
    @TableField("ACCT_STATUS")
    private String acctStatus;

    @TableField("USER_IMG")
    private String userImg;

    @ApiModelProperty(value = "微信昵称")
    @TableField("NICK_NAME")
    private String nickName;

    @ApiModelProperty(value = "用户归属于哪个ORGanization组织对应的ID")
    @TableField("GROUP_ID")
    private String groupId;

    @ApiModelProperty(value = "用来关联org或者person")
    @TableField("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "用来控制是否为刚注册的用户，无控制要求统一为0或空，1：导入注册需要强制更新密码操作，2：重置后需要强制重置密码")
    @TableField("REG_FLAG")
    private String regFlag;

    @ApiModelProperty(value = "初始密码必须修改才能进行操作；后续可以考虑超期必须进行密码修改提示")
    @TableField("UPD_PWD_TIME")
    private String updPwdTime;

    @ApiModelProperty(value = "注册时间")
    @TableField("REG_DTTM")
    private String regDttm;

    @ApiModelProperty(value = "角色类型")
    @TableField("REG_ROLETYPE")
    private String regRoletype;

    @ApiModelProperty(value = "包括LBS、终端类型等信息")
    @TableField("LAST_LOGINFO")
    private String lastLoginfo;

    @ApiModelProperty(value = "基于日志判断，库表中不存相关数据信息了")
    @TableField("LAST_LOGIN_TIME")
    private String lastLoginTime;

    @ApiModelProperty(value = "用户角色，子账户还是主账户")
    @TableField("BIZ_ROLES")
    private String bizRoles;

    @ApiModelProperty(value = "城市")
    @TableField("CITY")
    private String city;

    @ApiModelProperty(value = "邀请码图片附件id")
    private String invitecodeImgId;

    @ApiModelProperty(value = "邀请人的标识id")
    private String inviterId;

    @ApiModelProperty(value = "业务员id")
    private String businessId;

    @ApiModelProperty(value = "是否是渠道 0-否 1-是")
    private String isChannel;

    @ApiModelProperty(value = "服务费率")
    private Double serviceRate;

    @ApiModelProperty(value = "渠道下游默认服务费率,不可低于渠道的服务费率,由渠道指定")
    private Double serviceDownstreamRate;

    @ApiModelProperty(value = "上游渠道ID")
    private String channelId;


}
