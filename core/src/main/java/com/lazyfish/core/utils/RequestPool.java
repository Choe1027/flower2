package com.lazyfish.core.utils;


import com.lazyfish.core.constant.Context;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/** 请求临时对象缓存池 根据当前线程获取当前的request对象，获取session中的内容，避免request对象的传递*/
@Component
public class RequestPool {
	/** request临时对象池 */
	private static ThreadLocal<HttpServletRequest> pool = new ThreadLocal<HttpServletRequest>();

	/** 移除缓存 */
	public static void remove() {
		pool.remove();
	}

	/** 添加缓存 */
	public static void set(HttpServletRequest request) {
		pool.set(request);

	}

	/** 获取缓存 */
	public static HttpServletRequest get() {
		return pool.get();
	}

	/** 获取缓存session */
	public static HttpSession getSession() {
		return get().getSession();
	}

	/**
	 * 获取用户id
	 * @return	返回用户id
	 */
	public static Long getUserId() {
		Long userId = (Long) getSession().getAttribute(Context.session_userId);
		return userId;
	}

	public static String getUserName(){
		String userName = (String) getSession().getAttribute(Context.session_userName);
		return userName;
	}

	public static String getToken(){
		String token = (String) getSession().getAttribute(Context.session_token);
		return token;
	}

//	/**
//	 * 获取用户类型
//	 * @return	返回用户id
//	 * @see UserType
//	 */
//	public static UserType getUserType() {
//		Integer userType = (Integer) getSession().getAttribute(Context.session_userType);
//		UserType ut = UserType.forType(userType);
//		if (ut == UserType.notKnow) {
//			throw new CommonException("用户类型未知");
//		}
//		return ut;
//	}
}
