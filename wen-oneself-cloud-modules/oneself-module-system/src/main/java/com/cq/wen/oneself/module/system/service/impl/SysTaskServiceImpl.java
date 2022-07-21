package com.cq.wen.oneself.module.system.service.impl;

import com.cq.wen.oneself.module.system.entity.SysTask;
import com.cq.wen.oneself.module.system.mapper.SysTaskMapper;
import com.cq.wen.oneself.module.system.service.SysTaskService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统任务表(SysTask)表服务实现类
 *
 * @author makejava
 * @since 2022-07-16 16:56:29
 */
@Service
public class SysTaskServiceImpl extends ServiceImpl<SysTaskMapper, SysTask> implements SysTaskService {
    @Autowired
    private SysTaskMapper sysTaskMapper;

    
}
