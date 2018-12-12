package com.example.springboot.service;

import com.example.springboot.SpringbootApplication;
import com.example.springboot.model.TvSeriesVo;
import com.github.pagehelper.Page;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class TvSeriesServiceTest {

    @Autowired
    private TvSeriesService tvSeriesService;
    @Ignore
    @Test
    public void getALl(){
        List<TvSeriesVo> all = tvSeriesService.getAll();
        System.out.println(all);
    }
    @Ignore
    @Test
    public void save(){
        for (int i = 1 ; i < 50; i++){
            TvSeriesVo tvSeriesVo = new TvSeriesVo();
            tvSeriesVo.setId(201+i);
            tvSeriesVo.setName("测试000_"+i);
            tvSeriesVo.setSeasonCount(20+i);
            tvSeriesService.save(tvSeriesVo);
        }
    }

    @Test
    public void query(){
        Page<TvSeriesVo> all = tvSeriesService.query(2,10);
        System.out.println(all);
    }
}