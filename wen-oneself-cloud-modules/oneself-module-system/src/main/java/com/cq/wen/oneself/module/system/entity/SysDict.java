package com.cq.wen.oneself.module.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sys_dict
 */
@Data
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  主键ID
     */
    private Integer id;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 字典所属类别
     */
    private String dictClass;

    /**
     * 描述
     */
    private String description;

    /**
     * 删除状态 0 正常 1 删除
     */
    private Integer delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;



}