package com.cq.wen.oneself.module.system.service.impl;

import com.cq.wen.oneself.module.system.entity.SysDictItem;
import com.cq.wen.oneself.module.system.mapper.SysDictItemMapper;
import com.cq.wen.oneself.module.system.service.SysDictItemService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (SysDictItem)表服务实现类
 *
 * @author makejava
 * @since 2022-07-16 16:55:53
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements SysDictItemService {
    @Autowired
    private SysDictItemMapper sysDictItemMapper;

    
}
