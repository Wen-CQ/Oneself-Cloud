package com.cq.wen.oneself.network.auth.service;

import com.cq.wen.oneself.client.system.domain.SysLoginInfo;
import com.cq.wen.oneself.client.system.model.RemoteLogService;
import com.cq.wen.oneself.client.system.model.RemoteUserService;
import com.cq.wen.oneself.common.core.constant.Constants;
import com.cq.wen.oneself.common.core.constant.SecurityConstants;
import com.cq.wen.oneself.common.core.domain.LoginUser;
import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.domain.SysUser;
import com.cq.wen.oneself.common.core.exception.ServiceException;
import com.cq.wen.oneself.common.core.utils.IpUtils;
import com.cq.wen.oneself.common.core.utils.SecurityUtils;
import com.cq.wen.oneself.common.core.utils.ServletUtils;
import com.cq.wen.oneself.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Title: SysLoginService
 * @Author wen
 * @Date: 2022/7/20 13:37
 */
@Component
public class SysLoginService {

    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    public LoginUser login(String username, String password){
        Result<SysUser> result = remoteUserService.getUserInfo(username, SecurityConstants.INNER);
        SysUser sysUser = result.getData();
        if (!SecurityUtils.matchesPassword(password, sysUser.getPassword()))
        {
            recordLoginInfo(username, Constants.LOGIN_FAIL, "用户密码错误");
            throw new ServiceException("用户不存在/密码错误");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setSysUser(sysUser);
        return loginUser;
    }

    /**
     * 退出
     * @param loginName
     */
    public void logout(String loginName){
        recordLoginInfo(loginName, Constants.LOGOUT, "退出成功");
    }

    /**
     * 注册
     * @param username
     * @param password
     */
    public void register(String username,String password){
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password))
        {
            throw new ServiceException("用户/密码必须填写");
        }
        // 注册用户信息
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setNickName(username);
        sysUser.setPassword(SecurityUtils.encryptPassword(password));
        Result<?> registerResult = remoteUserService.registerUserInfo(sysUser, SecurityConstants.INNER);
        if (Result.FAIL == registerResult.getCode())
        {
            throw new ServiceException(registerResult.getMsg());
        }
        recordLoginInfo(username, Constants.REGISTER, "注册成功");
    }


    /**
     * 记录登陆信息
     * @param username
     * @param status
     * @param message
     */
    public void recordLoginInfo(String username, String status, String message){
        SysLoginInfo loginInfo = new SysLoginInfo();
        loginInfo.setUserName(username);
        loginInfo.setIpaddr(IpUtils.getIpAddress(ServletUtils.getRequest()));
        loginInfo.setMsg(message);
        // 日志状态
        if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER))
        {
            loginInfo.setStatus("0");
        }
        else if (Constants.LOGIN_FAIL.equals(status))
        {
            loginInfo.setStatus("1");
        }
        remoteLogService.saveLoginInfo(loginInfo, SecurityConstants.INNER);
    }


}
