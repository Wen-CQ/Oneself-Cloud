package com.cq.wen.oneself.module.system.service.impl;

import com.cq.wen.oneself.module.system.entity.SysLoginInfo;
import com.cq.wen.oneself.module.system.mapper.SysLoginInfoMapper;
import com.cq.wen.oneself.module.system.service.SysLoginInfoService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统访问记录(SysLoginInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 17:40:29
 */
@Service("sysLoginInfoService")
public class SysLoginInfoServiceImpl extends ServiceImpl<SysLoginInfoMapper, SysLoginInfo> implements SysLoginInfoService {
    @Autowired
    private SysLoginInfoMapper sysLoginInfoMapper;

    
}
