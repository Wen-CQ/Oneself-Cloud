package com.cq.wen.oneself.network.auth.form;

import lombok.Data;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */
@Data
public class RegisterBody extends LoginBody
{

    private String modelPhone;

    private String email;

}
