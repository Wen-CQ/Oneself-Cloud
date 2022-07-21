package com.cq.wen.oneself.common.log.service;

import com.cq.wen.oneself.client.system.domain.SysOperateLog;
import com.cq.wen.oneself.client.system.model.RemoteLogService;
import com.cq.wen.oneself.common.core.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步调用日志服务
 * @author 38169
 */
@Service
public class AsyncLogService {

    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveLog(SysOperateLog sysOperateLog)
    {
        remoteLogService.saveLog(sysOperateLog, SecurityConstants.INNER);
    }

}
