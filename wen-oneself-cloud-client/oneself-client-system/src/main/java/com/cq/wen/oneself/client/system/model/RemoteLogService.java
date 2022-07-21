package com.cq.wen.oneself.client.system.model;

import com.cq.wen.oneself.client.system.domain.SysLoginInfo;
import com.cq.wen.oneself.client.system.domain.SysOperateLog;
import com.cq.wen.oneself.client.system.factory.RemoteLogFallbackFactory;
import com.cq.wen.oneself.common.core.constant.SecurityConstants;
import com.cq.wen.oneself.common.core.constant.ServiceNameConstants;
import com.cq.wen.oneself.common.core.domain.Result;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 日志服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService
{
    /**
     * 保存系统日志
     *
     * @param sysOperateLog 日志实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/sysOperateLog")
     Result<Boolean> saveLog(@RequestBody SysOperateLog sysOperateLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 保存访问记录
     *
     * @param sysLoginInfo 访问实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/sysLoginInfo")
     Result<Boolean> saveLoginInfo(@RequestBody SysLoginInfo sysLoginInfo, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
