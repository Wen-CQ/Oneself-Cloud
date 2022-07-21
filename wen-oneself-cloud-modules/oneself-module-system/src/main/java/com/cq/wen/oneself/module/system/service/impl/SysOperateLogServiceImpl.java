package com.cq.wen.oneself.module.system.service.impl;

import com.cq.wen.oneself.module.system.entity.SysOperateLog;
import com.cq.wen.oneself.module.system.mapper.SysOperateLogMapper;
import com.cq.wen.oneself.module.system.service.SysOperateLogService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 操作日志记录(SysOperateLog)表服务实现类
 *
 * @author makejava
 * @since 2022-07-19 23:51:43
 */
@Service("sysOperateLogService")
public class SysOperateLogServiceImpl extends ServiceImpl<SysOperateLogMapper, SysOperateLog> implements SysOperateLogService {
    @Autowired
    private SysOperateLogMapper sysOperateLogMapper;

    
}
