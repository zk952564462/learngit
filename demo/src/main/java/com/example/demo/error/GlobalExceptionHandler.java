package com.example.demo.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DAFAULT_ERROR_VIEW ="error";
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DAFAULT_ERROR_VIEW);
		return mav;
	}
	
	@ExceptionHandler(value=TestException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req,TestException e) throws Exception{
		ErrorInfo<String> r=new ErrorInfo<String>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("some data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
}
