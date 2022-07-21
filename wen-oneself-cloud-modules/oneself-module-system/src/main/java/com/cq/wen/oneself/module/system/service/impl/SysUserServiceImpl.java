package com.cq.wen.oneself.module.system.service.impl;

import com.cq.wen.oneself.module.system.entity.SysUser;
import com.cq.wen.oneself.module.system.mapper.SysUserMapper;
import com.cq.wen.oneself.module.system.service.SysUserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 18:07:58
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser queryUserName(String username) {
        return sysUserMapper.selectUsername(username);
    }
}
