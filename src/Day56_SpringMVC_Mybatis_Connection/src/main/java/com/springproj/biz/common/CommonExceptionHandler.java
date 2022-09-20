package com.springproj.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//객체를 생성하는데 공통의 관심 부분을 AOP에서 advice로 함.
//위치 패키지를 지정
//@ControllerAdvice("com.springproj.controller")
public class CommonExceptionHandler {
   
   @ExceptionHandler(ArithmeticException.class)//예외와 그에대한 인폼(.class)을 추가적으로 작성해야한다.
   public ModelAndView handleArithmeticException(Exception e) {
      
      ModelAndView mav = new ModelAndView();
      
      mav.addObject("exception", e);
      mav.setViewName("/common/arithmeticError");
      
      return mav;
   }
   
      
      @ExceptionHandler(NullPointerException.class)
      public ModelAndView handleNullPointerException(Exception e) {
         
         ModelAndView mav = new ModelAndView();
         
         mav.addObject("exception", e);
         mav.setViewName("/common/nullPointerError");
         
         return mav;
      }
      
      @ExceptionHandler(Exception.class)
      public ModelAndView handleException(Exception e) {
    	  
    	  ModelAndView mav = new ModelAndView();
    	  
    	  mav.addObject("exception", e);
    	  mav.setViewName("/common/error");
    	  
    	  return mav;
      }
   

}
