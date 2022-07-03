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
@ApiModel(value="ZrrUserAccount对象", description="")
public class ZrrUserAccount extends CommonEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REC_ID", type = IdType.ASSIGN_ID)
    private String recId;

    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty(value = "现金账户->60冻结现金账户->61")
    @TableField("ACC_TYPE")
    private String accType;

    @TableField("ACC_AMT")
    private String accAmt;

    @TableField("UPDATE_DTTM")
    private String updateDttm;

    @TableField("ACC_STATUS")
    private String accStatus;


}
