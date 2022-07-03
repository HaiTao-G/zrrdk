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
 * 用户第三方账号信息表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrUserThirdOauth对象", description="用户第三方账号信息表")
public class ZrrUserThirdOauth extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键标识id")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "本地用户唯一标识")
    private String userId;

    @ApiModelProperty(value = "第三方平台唯一标识id（例如微信的UNION_ID）")
    private String oauthId;

    @ApiModelProperty(value = "第三方平台标识名称（1---微信小程序，2---微信公众号,.....）")
    private String loginType;

    @ApiModelProperty(value = "第三方平台用户的标识id")
    private String uuid;

    @ApiModelProperty(value = "辅助字段：例如在微信开放平台下小程序，公众号，微信扫码每个都有单独的标识id")
    private String sourceId;


}
