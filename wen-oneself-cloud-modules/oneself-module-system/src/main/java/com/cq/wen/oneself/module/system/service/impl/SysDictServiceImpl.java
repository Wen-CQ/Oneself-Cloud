package com.cq.wen.oneself.module.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cq.wen.oneself.module.system.entity.SysDict;
import com.cq.wen.oneself.module.system.mapper.SysDictMapper;
import com.cq.wen.oneself.module.system.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 38169
* @description 针对表【sys_dict】的数据库操作Service实现
* @createDate 2022-07-15 16:35:53
*/
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;
}




