package com.cq.wen.oneself.client.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志记录(SysOperateLog)实体类
 *
 * @author makejava
 * @since 2022-07-19 23:51:42
 */
@Data
public class SysOperateLog implements Serializable {

    /**
     * 日志主键
     */
    private Integer id;
    /**
     * 模块标题
     */
    private String title;
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer businessType;
    /**
     * 请求方式
     */
    private String requestMethod;
    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    private Integer operatorType;
    /**
     * 操作人员
     */
    private String operateName;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 请求URL
     */
    private String operateUrl;
    /**
     * 主机地址
     */
    private String operateIp;
    /**
     * 请求参数
     */
    private String operateParam;
    /**
     * 返回参数
     */
    private String jsonResult;
    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;
    /**
     * 错误消息
     */
    private String errorMsg;
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 方法名称
     */
    private String operateMethod;

}

