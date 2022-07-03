package com.dibole.codegenerator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Tao
 * @version 1.0.0
 * @className CommonEntity.java
 * @description 通用entity
 * @createTime 2020年12月05日 09:47:00
 */
public class CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @TableField(exist= false)
    @ApiModelProperty(value = "每页的条数")
    private Integer pageSize;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @TableField(exist= false)
    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
