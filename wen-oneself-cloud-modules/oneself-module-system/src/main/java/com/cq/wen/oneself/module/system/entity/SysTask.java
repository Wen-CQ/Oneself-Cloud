package com.cq.wen.oneself.module.system.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * 系统任务表(SysTask)实体类
 *
 * @author makejava
 * @since 2022-07-16 16:56:26
 */
@Data
public class SysTask implements Serializable {
    private static final long serialVersionUID = -70026944308061667L;
    
    private Integer id;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务启动时间
     */
    private String taskTime;
    /**
     * 备注
     */
    private String desc;
    /**
     * 状态 0 未启用 1 启用
     */
    private Integer status;
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

