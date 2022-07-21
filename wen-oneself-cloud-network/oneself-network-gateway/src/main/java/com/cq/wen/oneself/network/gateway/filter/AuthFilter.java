package com.cq.wen.oneself.network.gateway.filter;

import com.cq.wen.oneself.common.core.constant.CacheConstants;
import com.cq.wen.oneself.common.core.constant.SecurityConstants;
import com.cq.wen.oneself.common.core.constant.TokenConstants;
import com.cq.wen.oneself.common.core.utils.JwtUtils;
import com.cq.wen.oneself.common.core.utils.ServletUtils;
import com.cq.wen.oneself.common.core.utils.StringUtils;
import com.cq.wen.oneself.common.redis.service.RedisService;
import com.cq.wen.oneself.network.gateway.config.properties.IgnoreWhiteProperties;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Title: AuthFilter
 * @Author wen
 * @Date: 2022/7/21 14:23
 */

public class AuthFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

//    @Autowired
//    private IgnoreWhiteProperties ignoreWhite;

    @Autowired
    private RedisService redisService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String path = request.getURI().getPath();
//        if (StringUtils.matches(path,ignoreWhite.getWhites())){
//            return chain.filter(exchange);
//        }
        String token = getToken(request);
        if (StringUtils.isEmpty(token)){
            return unauthorizedResponse(exchange, "令牌不能为空");
        }
        Claims claims = JwtUtils.parseToken(token);
        if (claims == null){
            return unauthorizedResponse(exchange, "令牌已过期或验证不正确！");
        }
        String userKey = JwtUtils.getUserKey(claims);
        boolean isLogin = redisService.hasKey(getTokenKey(userKey));
        if (!isLogin){
            return unauthorizedResponse(exchange, "登录状态已过期");
        }
        String userid = JwtUtils.getUserId(claims);
        String username = JwtUtils.getUserName(claims);
        if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(username)){
            return unauthorizedResponse(exchange, "令牌验证失败");
        }
        addHeader(mutate, SecurityConstants.USER_KEY, userKey);
        addHeader(mutate, SecurityConstants.DETAILS_USER_ID, userid);
        addHeader(mutate, SecurityConstants.DETAILS_USERNAME, username);
        removeHeader(mutate, SecurityConstants.FROM_SOURCE);
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }


    /**
     *  获取请求token
     * @param request
     * @return
     */
    private String getToken(ServerHttpRequest request)
    {
        String token = request.getHeaders().getFirst(TokenConstants.AUTHENTICATION);
        // 如果前端设置了令牌前缀，则裁剪掉前缀
        if (StringUtils.isNotEmpty(token) && token.startsWith(TokenConstants.PREFIX))
        {
            token = token.replaceFirst(TokenConstants.PREFIX, StringUtils.EMPTY);
        }
        return token;
    }

    /**
     * 鉴权异常处理返回
     * @param exchange
     * @param msg
     * @return
     */
    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange, String msg){
        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
        return ServletUtils.webFluxResponseWriter(exchange.getResponse(), msg, HttpStatus.UNAUTHORIZED.value());
    }

    /**
     * 获取token缓存key
     * @param token
     * @return
     */
    private String getTokenKey(String token){
        return CacheConstants.LOGIN_TOKEN_KEY + token;
    }

    /**
     * 添加用户信息到请求Header
     * @param mutate
     * @param name
     * @param value
     */
    private void addHeader(ServerHttpRequest.Builder mutate, String name, Object value) {
        if (value == null){
            return;
        }
        String valueStr = value.toString();
        String valueEncode = ServletUtils.urlEncode(valueStr);
        mutate.header(name, valueEncode);
    }

    /**
     * 内部请求删除请求Header内部信息
     * @param mutate
     * @param name
     */
    private void removeHeader(ServerHttpRequest.Builder mutate, String name) {
        mutate.headers(httpHeaders -> httpHeaders.remove(name)).build();
    }


    @Override
    public int getOrder() {
        return -200;
    }
}
