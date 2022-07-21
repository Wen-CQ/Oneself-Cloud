package com.cq.wen.oneself.module.system.controller;




import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.utils.MapUtils;
import com.cq.wen.oneself.common.log.annotation.Log;
import com.cq.wen.oneself.common.log.enums.BusinessType;
import com.cq.wen.oneself.module.system.entity.SysDict;
import com.cq.wen.oneself.module.system.service.SysDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * (SysDict)表控制层
 *
 * @author makejava
 * @since 2022-07-16 19:08:48
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("sysDict")
public class SysDictController{
    /**
     * 服务对象
     */
    @Autowired
    private SysDictService sysDictService;

    @Log(title = "字典类型", businessType = BusinessType.EXPORT)
    @RequestMapping("/list")
    public Result<Map<String,Object>> list(){
        try {
            List<SysDict> list = sysDictService.list();
            return Result.ok(MapUtils.of("size", list.size(), "list", list));
        }catch (Exception e){
            log.info("queryDictList error",e);
        }
        return Result.fail();
    }

}

