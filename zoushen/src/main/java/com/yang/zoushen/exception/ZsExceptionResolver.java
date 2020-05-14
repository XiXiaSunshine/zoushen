package com.yang.zoushen.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZsExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof LoginException){
            ex = (LoginException) ex;
        }else{
            ex = new LoginException("验证信息有误！");
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", ((LoginException) ex).getMsg());
        mv.addObject("url", request.getContextPath() + "/index.jsp");
        mv.setViewName("error");
        return mv;
    }
}
