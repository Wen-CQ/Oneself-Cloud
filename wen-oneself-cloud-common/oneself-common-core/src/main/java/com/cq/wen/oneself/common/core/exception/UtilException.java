package com.cq.wen.oneself.common.core.exception;

/**
 * 工具类异常
 * @author 38169
 */
public class UtilException extends RuntimeException {

    public UtilException(Throwable e)
    {
        super(e.getMessage(), e);
    }

    public UtilException(String message)
    {
        super(message);
    }

    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
