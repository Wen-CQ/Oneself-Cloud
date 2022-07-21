package com.cq.wen.oneself.client.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统访问记录(SysLoginInfo)实体类
 *
 * @author makejava
 * @since 2022-07-20 17:40:29
 */
@Data
public class SysLoginInfo implements Serializable {
    /**
     * 访问ID
     */
    private Long infoId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 登录IP地址
     */
    private String ipaddr;
    /**
     * 登录状态（0成功 1失败）
     */
    private String status;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 访问时间
     */
    private Date accessTime;

}

