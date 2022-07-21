package com.cq.wen.oneself.module.system.controller;




import com.cq.wen.oneself.module.system.service.SysDictItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * (SysDictItem)表控制层
 *
 * @author makejava
 * @since 2022-07-16 16:55:51
 */
@RestController
@RequestMapping("sysDictItem")
public class SysDictItemController{
    /**
     * 服务对象
     */
    @Autowired
    private SysDictItemService sysDictItemService;

}

