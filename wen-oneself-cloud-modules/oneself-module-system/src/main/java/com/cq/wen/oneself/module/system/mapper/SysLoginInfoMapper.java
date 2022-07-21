package com.cq.wen.oneself.module.system.mapper;

import com.cq.wen.oneself.module.system.entity.SysLoginInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统访问记录(SysLoginInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 17:40:29
 */
@Mapper
public interface SysLoginInfoMapper extends BaseMapper<SysLoginInfo> {

}

