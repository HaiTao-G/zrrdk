package com.dibole.entity.zrrdk;

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
 * 用户邀请码图片链接存储表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrUserInvitecode对象", description="用户邀请码图片链接存储表")
public class ZrrUserInvitecode extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键标识id")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "邀请码图片附件id")
    private String invitecodeImgId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDatetime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateDatetime;

    @ApiModelProperty(value = "平台id")
    private String oauthId;


}
