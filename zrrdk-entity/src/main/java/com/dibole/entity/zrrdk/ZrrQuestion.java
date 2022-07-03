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
 * 常见问题表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrQuestion对象", description="常见问题表")
public class ZrrQuestion extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "标题")
    private String title;

    private String content;

    @ApiModelProperty(value = "创建人ID")
    private String createId;

    private String createTime;

    private String updateTime;


}
