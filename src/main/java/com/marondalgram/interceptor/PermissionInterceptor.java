package com.marondalgram.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		// 로그인 된 상태에서 로그인, 회원가입에 온 경우 타임라인으로 리다이렉트
		// 로그아웃 path는 인터셉터 설정에서 제외
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String path = request.getRequestURI();
		
		if (userId != null && path.startsWith("/user")) {
			response.sendRedirect("/timeline/timeline_view");
			return false;
		}
		
		return true;
	}
}
