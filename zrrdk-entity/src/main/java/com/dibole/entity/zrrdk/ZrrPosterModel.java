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
 * 自然人代开海报表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrPosterModel对象", description="自然人代开海报表")
public class ZrrPosterModel extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键标识id")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "海报图片链接地址")
    private String bizUrl;

    @ApiModelProperty(value = "海报宽度")
    private Integer width;

    @ApiModelProperty(value = "海报高度")
    private Integer height;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creationTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "0---无效，1---有效")
    private Integer status;


}
