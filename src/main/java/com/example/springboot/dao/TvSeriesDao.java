package com.example.springboot.dao;

import com.example.springboot.model.TvSeriesVo;
import com.github.pagehelper.Page;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface TvSeriesDao {
  @Select("select * from tv_series")
  public List<TvSeriesVo> getAll();

  @Insert("insert into tv_series  (id, name, season_count, origin_release, status) "
          + "values (#{id}, #{name}, #{seasonCount}, now(), 0) ") // 添加
  public int save(TvSeriesVo tvSeriesVo);

  @Select("select * from tv_series order by id desc")
  Page<TvSeriesVo> query();

}
