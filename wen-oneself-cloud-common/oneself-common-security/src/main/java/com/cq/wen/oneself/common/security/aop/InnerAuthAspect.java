package com.cq.wen.oneself.common.security.aop;

import com.cq.wen.oneself.common.core.constant.SecurityConstants;
import com.cq.wen.oneself.common.core.exception.InnerAuthException;
import com.cq.wen.oneself.common.core.utils.ServletUtils;
import com.cq.wen.oneself.common.core.utils.StringUtils;
import com.cq.wen.oneself.common.security.annotation.InnerAuth;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InnerAuthAspect implements Ordered {


    @Around("@annotation(innerAuth)")
    public Object innerAround(ProceedingJoinPoint point, InnerAuth innerAuth) throws Throwable
    {
        String source = ServletUtils.getRequest().getHeader(SecurityConstants.FROM_SOURCE);
        // 内部请求验证
        if (!StringUtils.equals(SecurityConstants.INNER, source))
        {
            throw new InnerAuthException("没有内部访问权限，不允许访问");
        }

        String userid = ServletUtils.getRequest().getHeader(SecurityConstants.DETAILS_USER_ID);
        String username = ServletUtils.getRequest().getHeader(SecurityConstants.DETAILS_USERNAME);
        // 用户信息验证
        if (innerAuth.isUser() && (StringUtils.isEmpty(userid) || StringUtils.isEmpty(username)))
        {
            throw new InnerAuthException("没有设置用户信息，不允许访问 ");
        }
        return point.proceed();
    }


    @Override
    public int getOrder() {
       return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
