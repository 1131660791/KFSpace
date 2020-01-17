package com.boot.demo.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.boot.demo.common.enums.ResponseCodeEnum;
import com.boot.demo.common.enums.StatusEnum;
import com.boot.demo.common.redis.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotResubmitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            NotResubmit accessLimit = hm.getMethodAnnotation(NotResubmit.class);
            if (accessLimit == null) {
                return true;
            }
            //判断Token,不取redis判断是否已经登录判断
            String token = request.getHeader("Token");
            if (StringUtils.isEmpty(token)) {
                render(response, ResponseCodeEnum.NO_RIGHT);
                return false;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            String key = request.getRequestURI();
            key += "access:" + token;
            Object count = redisUtils.get(key);
            if (count == null) {
                redisUtils.set(key, maxCount, seconds);
            } else {
                int keyCount = Integer.parseInt(count.toString());
                if (keyCount < maxCount) {
                    redisUtils.incr(key, seconds);
                } else {
                    render(response, ResponseCodeEnum.REQUEST_FREQUENT);
                    return false;
                }
            }
        }
        return true;
    }

    private void render(HttpServletResponse response, ResponseCodeEnum statusEnum) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        Map<String,Object> xtyunResponse = new HashMap();
        xtyunResponse.put("code",statusEnum.getCode());
        xtyunResponse.put("message",statusEnum.getDesc());
        String str  = JSON.toJSONString(xtyunResponse);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

}