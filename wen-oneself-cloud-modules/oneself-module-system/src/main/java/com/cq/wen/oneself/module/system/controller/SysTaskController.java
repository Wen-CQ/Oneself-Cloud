package com.cq.wen.oneself.module.system.controller;




import com.cq.wen.oneself.module.system.service.SysTaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * 系统任务表(SysTask)表控制层
 *
 * @author makejava
 * @since 2022-07-16 19:08:09
 */
@RestController
@RequestMapping("sysTask")
public class SysTaskController{
    /**
     * 服务对象
     */
    @Autowired
    private SysTaskService sysTaskService;

}

