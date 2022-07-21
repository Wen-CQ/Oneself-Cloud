package com.cq.wen.oneself.module.system.service;

import com.cq.wen.oneself.module.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 18:07:58
 */
public interface SysUserService extends IService<SysUser> {

    SysUser queryUserName(String username);
}
