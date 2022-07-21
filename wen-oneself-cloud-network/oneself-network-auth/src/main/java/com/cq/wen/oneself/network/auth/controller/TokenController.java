package com.cq.wen.oneself.network.auth.controller;


import com.cq.wen.oneself.common.core.domain.LoginUser;
import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.utils.JwtUtils;
import com.cq.wen.oneself.common.core.utils.SecurityUtils;
import com.cq.wen.oneself.common.core.utils.StringUtils;
import com.cq.wen.oneself.common.security.anth.AuthUtil;
import com.cq.wen.oneself.common.security.service.TokenService;
import com.cq.wen.oneself.network.auth.form.LoginBody;
import com.cq.wen.oneself.network.auth.form.RegisterBody;
import com.cq.wen.oneself.network.auth.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * token 控制
 * 
 * @author ruoyi
 */
@RestController
public class TokenController
{
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("login")
    public Result<?> login(@RequestBody LoginBody form)
    {
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form.getUsername(), form.getPassword());
        // 获取登录token
        return Result.ok(tokenService.createToken(userInfo));
    }

    @DeleteMapping("logout")
    public Result<?> logout(HttpServletRequest request)
    {
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token))
        {
            String username = JwtUtils.getUserName(token);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            // 记录用户退出日志
            sysLoginService.logout(username);
        }
        return Result.ok();
    }

    @PostMapping("refresh")
    public Result<?> refresh(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return Result.ok();
        }
        return Result.ok();
    }

    @PostMapping("register")
    public Result<?> register(@RequestBody RegisterBody registerBody)
    {
        // 用户注册
        sysLoginService.register(registerBody.getUsername(), registerBody.getPassword());
        return Result.ok();
    }
}
