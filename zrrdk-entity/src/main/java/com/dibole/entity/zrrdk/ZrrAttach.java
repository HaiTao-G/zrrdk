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
 * 附件表
 * </p>
 *
 * @author haitao
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ZrrAttach对象", description="附件表")
public class ZrrAttach extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "rec_id", type = IdType.ASSIGN_ID)
    private String recId;

    @ApiModelProperty(value = "文件后缀名")
    private String fileType;

    @ApiModelProperty(value = "文件所处的OSS的URL")
    private String fileOssUrl;

    @ApiModelProperty(value = "文件所处相对路径")
    private String fileRelativePath;

    @ApiModelProperty(value = "文件保存后服务器上名称,带后缀")
    private String fileSaveName;

    @ApiModelProperty(value = "文件上传原始名称带后缀名")
    private String fileSourceName;

    @ApiModelProperty(value = "关联的上传人的uid")
    private String attachUid;


}
