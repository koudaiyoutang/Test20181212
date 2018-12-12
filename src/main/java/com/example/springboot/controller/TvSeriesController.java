package com.example.springboot.controller;


import com.example.springboot.model.TvSeriesVo;
import com.example.springboot.service.TvSeriesService;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/tvSeries")
public class TvSeriesController {

  private static final Log log = LogFactory.getLog(TvSeriesController.class);

  @Autowired
  private TvSeriesService tvSeriesService;

  @GetMapping
  public List<TvSeriesVo> getAll() {
    log.warn("wran级别日志 ：hello()被调用了！！");
    log.trace("trace级别日志 ：hello()被调用了！！");
   /* List<TvSeriesVo> list = new ArrayList<TvSeriesVo>();
    list.add(createPoi());
    list.add(createWestWord());
    return list;*/
    return tvSeriesService.getAll();
  }

  @GetMapping("/{id}")
  public TvSeriesVo getOne(@PathVariable int id) {
    if (log.isTraceEnabled()) {
      log.trace("getOne:id=" + id);
    }
    if (id == 101) {
      return createPoi();
    } else if (id == 102) {
      return createWestWord();
    } else {
      throw new ResourceNotFoundException();
    }

  }

  @PostMapping
  public TvSeriesVo inserOne(@Valid @RequestBody TvSeriesVo tvSeriesVo) {
    if (log.isTraceEnabled()) {
      log.trace("新增TvSeriesVo" + tvSeriesVo);
    }
    tvSeriesVo.setId(9999);
    return tvSeriesVo;
  }


  private TvSeriesVo createPoi() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2018, Calendar.SATURDAY, 12, 0, 0);
    return new TvSeriesVo(101, "Person of Interest", 20, calendar.getTime());
  }

  private TvSeriesVo createWestWord() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2017, Calendar.OCTOBER, 4, 0, 0);
    return new TvSeriesVo(102, "WestWord", 20, calendar.getTime());
  }
}
