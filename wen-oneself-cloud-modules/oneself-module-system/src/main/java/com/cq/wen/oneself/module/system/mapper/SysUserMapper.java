package com.cq.wen.oneself.module.system.mapper;

import com.cq.wen.oneself.module.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 18:07:58
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectUsername(String username);
}

