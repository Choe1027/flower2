package com.lazyfish.back.interceptors;


import com.lazyfish.back.handler.ExcptionHandler;
import com.lazyfish.core.utils.RequestPool;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author cyk
 * @date 2018/9/7/007 15:54
 * @email choe0227@163.com
 * @desc 权限认证拦截器
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Aspect
@Component
public class AuthInterceptors {

    @Autowired
    private ExcptionHandler excptionHandler;


    @Around("execution(* com.lazyfish.back.ctrl..*.*(..))")
    public Object action(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 获取request 对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        // 将请求加到RequestPool 中
        RequestPool.set(request);
        // 验证当前用户是否有token
        // 过滤不需要登录权限验证的接口 TODO: 2018/9/7/007
        String token = RequestPool.getToken();

//        if ()

        // 验证当前登录用户角色是否有调用接口的权限

        Object proceed = null;
        proceed = proceedingJoinPoint.proceed();
//        Result result = null;
//        if (!(proceed instanceof Void) && proceed != null){
//            result = new Result.ResultBuilder().ok().data(proceed).build();
//        }else {
//            result = new Result.ResultBuilder().ok().build();
//        }
        return result;
    }
}
