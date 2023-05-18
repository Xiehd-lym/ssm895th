package com.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 权限(Token)验证 拦截器
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    public static final String LOGIN_TOKEN_KEY = "Token";

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //支持跨域请求
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,request-source,Token, Origin,imgType, Content-Type, cache-control,postman-token,Cookie, Accept,authorization");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        /**
         * HandlerMethod封装了很多属性，在访问请求方法的时候可以方便的访问到方法、方法参数、方法上的注解、所属类等并且对方法参数封装处理，也可以方便的访问到方法参数的注解等信息
         */
        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            /**
             * 获取注解。判断接口注解是否是忽略检验：忽略Token验证
             */
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            /**
             * 通过方法
             */
//            Method method = handlerMethod.getMethod();
//            if (method.isAnnotationPresent(IgnoreAuth.class)) {
//                IgnoreAuth jwtIgnore = method.getAnnotation(IgnoreAuth.class);
//            }
            annotation = handlerMethod.getMethodAnnotation(IgnoreAuth.class);
        } else {
            /**
             * 如果不是映射到方法，直接通过
             */
            return true;
        }

        //从header中获取token
        String token = request.getHeader(LOGIN_TOKEN_KEY);

        /**
         * 不需要验证权限的方法直接放过
         */
        if(annotation!=null) {
            return true;
        }
        
        TokenEntity tokenEntity = null;
        if(StringUtils.isNotBlank(token)) {
            tokenEntity = tokenService.getTokenEntity(token);
        }

        /**
         * 注入session
         */
        if(tokenEntity != null) {
            request.getSession().setAttribute("userId", tokenEntity.getUserid());
            request.getSession().setAttribute("role", tokenEntity.getRole());
            request.getSession().setAttribute("tableName", tokenEntity.getTablename());
            request.getSession().setAttribute("username", tokenEntity.getUsername());
            return true;
        }

        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSONObject.toJSONString(R.error(401, "请先登录")));
        } finally {
            if(writer != null){
                writer.close();
            }
        }
//		throw new EIException("请先登录", 401);
        return false;
    }

}
