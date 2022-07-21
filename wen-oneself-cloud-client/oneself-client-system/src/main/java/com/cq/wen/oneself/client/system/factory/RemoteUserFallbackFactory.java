package com.cq.wen.oneself.client.system.factory;

import com.cq.wen.oneself.client.system.model.RemoteUserService;
import com.cq.wen.oneself.common.core.domain.LoginUser;
import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.common.core.domain.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Title: RemoteUserFallbackFactory
 * @Author wen
 * @Date: 2022/7/19 20:32
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable cause) {
        log.error("Throwable error",cause.getMessage());
        return new RemoteUserService() {

            @Override
            public Result<SysUser> getUserInfo(String username, String source) {
                return Result.fail("获取用户失败");
            }

            @Override
            public Result<Boolean> registerUserInfo(SysUser sysUser, String source) {
                return Result.fail("注册用户失败");
            }
        };
    }
}
