package com.example.springboot.controller;

import com.example.springboot.model.TvSeriesVo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tv")
public class TvController {

    @RequestMapping(value = "/getTvHtml")
    public ModelAndView getTvHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tvSeries");
        return mv;
    }

    @RequestMapping(value = "/saveResult")
    public ModelAndView saveResult(HttpServletRequest request, HttpServletResponse response,
            TvSeriesVo tvSeriesVo) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", tvSeriesVo.getName() + "添加成功！");
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping(value = "/saveTv")
    public ModelAndView saveTv(HttpServletRequest request, HttpServletResponse response,
            @Valid TvSeriesVo tvSeriesVo) {
        System.out.println("------------------------" + tvSeriesVo);
        ModelAndView mv = new ModelAndView();
        mv.addObject(tvSeriesVo);
        mv.addObject("result", tvSeriesVo.getName() + "添加成功！");
       // mv.setViewName("redirect:saveResult");
        mv.setViewName("result");

        return mv;

    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


}
