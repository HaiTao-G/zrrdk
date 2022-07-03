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
 * 
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrSystemParameter对象", description="")
public class ZrrSystemParameter extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REC_ID", type = IdType.ASSIGN_ID)
    private String recId;

    @TableField("PARAMETER_TYPE")
    private String parameterType;

    @TableField("PARAMETER_KEY")
    private String parameterKey;

    @TableField("PARAMETER_NAME")
    private String parameterName;

    @TableField("PARAMETER_VALUE")
    private String parameterValue;

    @TableField("WEIGHT")
    private Integer weight;

    @ApiModelProperty(value = "字典logoURL")
    private String logo;

    @TableField("PARENT_PARAMETER_TYPE")
    private String parentParameterType;

    @TableField("PARENT_PARAMETER_KEY")
    private String parentParameterKey;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "字典状态:0无效,1正常")
    private Integer status;

    @TableField("CREATE_TIME")
    private String createTime;

    @TableField("UPDATE_TIME")
    private String updateTime;


}
