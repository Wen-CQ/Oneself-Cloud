package com.cq.wen.oneself.common.core.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Title: SysUser
 * @Author wen
 * @Date: 2022/7/19 17:18
 */
@Data
public class SysUser {

    /** 用户ID */
    private Long userId;

    /** 部门ID */
    private Long deptId;

    /** 用户账号 */
    private String userName;

    /** 用户昵称 */
    private String nickName;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phoneNumber;

    /** 用户性别 */
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 删除标志（ 0 存在  2 删除） */
    private String delFlag;

    /** 最后登录IP */
    private String loginIp;

    /** 最后登录时间 */
    private Date loginDate;


}
