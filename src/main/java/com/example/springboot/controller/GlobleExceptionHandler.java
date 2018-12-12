package com.example.springboot.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
//所谓加强Controller就是@ControllerAdvice注解，有这个注解的类中的方法的某些注解会应用到所有的Controller里，其中就包括@ExceptionHandler注解。
public class GlobleExceptionHandler {

    private static final Log log = LogFactory.getLog(TvSeriesController.class);

    @ExceptionHandler(value = Exception.class)//异常处理(@ControllerAdvice注解注释的controller层和此注解注释的方法,会对所有controller层抛出的异常进行统一处理)
    public ModelAndView ExceptionHandler(HttpServletRequest request, Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("msg","");

        if (e instanceof BindException){
            BindException ex = (BindException)e;
            List<ObjectError> allErrors = ex.getAllErrors();//捕获的所有错误对象
            ObjectError error = allErrors.get(0);
            String defaultMessage = error.getDefaultMessage();//异常内容
            log.info(defaultMessage);//打印日志
            return mv.addObject("msg",defaultMessage);
        }else {
            return mv.addObject("msg","其他异常！");
        }
    }
}