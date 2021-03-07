package org.bmj.ims.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bmj.ims.vo.Member;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheck implements HandlerInterceptor{
	
	//컨트롤러의 메서드 작동후(후처리)
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("LoginCheck postHandle");
//	}
	
	//컨트롤러 메서드 가기전(전처리) 
	//리턴값이 true면 컨트롤러 메서드로 이동
	//리턴값이 false면 컨트롤러 메서드로 가지 않음
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember==null) {
			//로그인이 되어있지 않으니까 그냥 /로 이동
			response.sendRedirect("/");
			return false;
		}else {
			//로그인 되어있으니까 컨트롤러로 이동
			return true;
		}//if~else end
		
	}//postHandle end

}//LoginCheck end
