package com.cq.wen.oneself.module.system.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (SysDictItem)实体类
 *
 * @author makejava
 * @since 2022-07-16 16:55:49
 */
@Data
public class SysDictItem implements Serializable {
    private static final long serialVersionUID = -11567917842232167L;
    
    private Integer id;
    /**
     * 父表ID
     */
    private String dictId;
    /**
     * 字典项文本
     */
    private String itemText;
    /**
     * 字典项编码
     */
    private String itemCode;
    /**
     * 字典项描述
     */
    private String description;
    /**
     * 字典项排序分数
     */
    private Integer scores;
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

