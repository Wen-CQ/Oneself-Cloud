package com.cq.wen.oneself.client.system.factory;


import com.cq.wen.oneself.client.system.domain.SysLoginInfo;
import com.cq.wen.oneself.client.system.domain.SysOperateLog;
import com.cq.wen.oneself.client.system.model.RemoteLogService;
import com.cq.wen.oneself.common.core.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public Result<Boolean> saveLog(SysOperateLog sysOperateLog, String source){ return null;}
            @Override
            public Result<Boolean> saveLoginInfo(SysLoginInfo sysLoginInfo, String source) {
                return null;
            }
        };

    }
}
