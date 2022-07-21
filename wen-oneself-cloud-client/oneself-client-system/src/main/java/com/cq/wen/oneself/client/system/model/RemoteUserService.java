package com.cq.wen.oneself.client.system.model;

import com.cq.wen.oneself.client.system.factory.RemoteUserFallbackFactory;
import com.cq.wen.oneself.common.core.constant.SecurityConstants;
import com.cq.wen.oneself.common.core.constant.ServiceNameConstants;

import com.cq.wen.oneself.common.core.domain.LoginUser;
import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/sysUser/info/{username}")
     Result<SysUser> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/sysUser/register")
     Result<Boolean> registerUserInfo(@RequestBody SysUser sysUser, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
