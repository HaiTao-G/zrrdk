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
 * 自然人代开海报添加图片水印表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrPosterImage对象", description="自然人代开海报添加图片水印表")
public class ZrrPosterImage extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键标识id")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "海报id")
    private String modelId;

    @ApiModelProperty(value = "海报添加图片水印链接")
    private String imageUrl;

    @ApiModelProperty(value = "修正值。 默认在中间，偏移量相对于中间偏移")
    private Integer x;

    @ApiModelProperty(value = "修正值。 默认在中间，偏移量相对于中间偏移")
    private Integer y;

    @ApiModelProperty(value = "透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字")
    private Float alpha;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creationTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "0---无效，1---有效")
    private Integer status;


}
