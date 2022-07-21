package com.cq.wen.oneself.module.system.controller;

import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.utils.MapUtils;
import com.cq.wen.oneself.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @Title: RedisController
 * @Author wen
 * @Date: 2022/7/18 20:11
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    RedisService redisService;


    @RequestMapping("/get")
    public Result<Map<String,Object>> get(String key){
        Object cacheObject = redisService.getCacheObject(key);
        return Result.ok(MapUtils.of("obj",cacheObject));

    }


}
