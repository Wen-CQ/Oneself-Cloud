package com.cq.wen.oneself.common.core.domain;

import com.cq.wen.oneself.common.core.constant.Constants;

import java.io.Serializable;

/**
 * 响应信息主体
 * @author 38169
 */
public class Result<T> implements Serializable {

    /** 成功 */
    public static final int SUCCESS = Constants.SUCCESS;

    /** 失败 */
    public static final int FAIL = Constants.FAIL;

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> ok()
    {
        return restResult(null, SUCCESS, null);
    }

    public static <T> Result<T> ok(T data)
    {
        return restResult(data, SUCCESS, null);
    }

    public static <T> Result<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> Result<T> fail()
    {
        return restResult(null, FAIL, null);
    }

    public static <T> Result<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> Result<T> fail(T data)
    {
        return restResult(data, FAIL, null);
    }

    public static <T> Result<T> fail(T data, String msg)
    {
        return restResult(data, FAIL, msg);
    }

    public static <T> Result<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> Result<T> restResult(T data, int code, String msg)
    {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

}
