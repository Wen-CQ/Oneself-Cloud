package com.cq.wen.oneself.module.system.controller;




import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.utils.MapUtils;
import com.cq.wen.oneself.module.system.entity.SysOperateLog;
import com.cq.wen.oneself.module.system.service.SysOperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * 操作日志记录(SysOperateLog)表控制层
 *
 * @author makejava
 * @since 2022-07-19 23:51:43
 */
@Slf4j
@RestController
@RequestMapping("sysOperateLog")
public class SysOperateLogController{
    /**
     * 服务对象
     */
    @Autowired
    private SysOperateLogService sysOperateLogService;

    @PostMapping("")
    public Result savaLog(@RequestBody SysOperateLog sysOperateLog){
        try {
            sysOperateLogService.save(sysOperateLog);
            return Result.ok();
        }catch (Exception e){
            log.error("savaLog error",e);
        }
        return Result.fail();
    }

    @GetMapping("list")
    public Result<Map<String,Object>> list(){
        try {
            List<SysOperateLog> list = sysOperateLogService.list();
            return Result.ok(MapUtils.of("list",list));
        }catch (Exception e){
            log.error("list error",e);
        }
        return Result.fail();
    }

}

