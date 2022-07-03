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
 * 开票人表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrDrawer对象", description="开票人表")
public class ZrrDrawer extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "证件人姓名")
    private String drawerName;

    @ApiModelProperty(value = "手机号")
    private String phoneNum;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "身份证正面关联的attach_id")
    private String idcardObverseId;

    @ApiModelProperty(value = "身份证反面关联的attach_id")
    private String idcardOtherId;

    private String status;

    private String createTime;

    private String updateTime;

    @ApiModelProperty(value = "证件人身份证号码")
    private String drawerNumber;

    @ApiModelProperty(value = "证件地址")
    private String drawerAddress;


}
