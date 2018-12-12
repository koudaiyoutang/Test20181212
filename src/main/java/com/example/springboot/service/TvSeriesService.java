package com.example.springboot.service;

import com.example.springboot.dao.TvSeriesDao;
import com.example.springboot.model.TvSeriesVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvSeriesService {

  @Autowired
  private TvSeriesDao tvSeriesDao;

  public List<TvSeriesVo> getAll(){
    return tvSeriesDao.getAll();
  }

  public  int save(TvSeriesVo tvSeriesVo){
    return tvSeriesDao.save(tvSeriesVo);
  }

  public Page<TvSeriesVo> query(int page, int pageSize ){

    PageHelper.startPage(page, pageSize);
    return tvSeriesDao.query();
  }


}
