package com.cq.wen.oneself.module.system.controller;




import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.module.system.entity.SysLoginInfo;
import com.cq.wen.oneself.module.system.service.SysLoginInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * 系统访问记录(SysLoginInfo)表控制层
 *
 * @author makejava
 * @since 2022-07-20 17:40:29
 */
@Slf4j
@RestController
@RequestMapping("sysLoginInfo")
public class SysLoginInfoController{
    /**
     * 服务对象
     */
    @Autowired
    private SysLoginInfoService sysLoginInfoService;


    @PostMapping("")
    public Result saveLoginInfo(SysLoginInfo sysLoginInfo){
        log.info("savaLoginInfo.sysLoginInfo{}",sysLoginInfo);
        sysLoginInfoService.save(sysLoginInfo);
        return Result.ok();

    }

}

