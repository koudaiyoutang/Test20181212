package com.example.springboot.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");


//    @Scheduled(fixedRate = 5000)
//    public void getTime() {
//        System.out.println(
//                "定时输出现在时间：" +
//                        dateFormat.format(new Date())
//        );
//    }
//    @Scheduled(cron = "*/5 * * * * ? ")
//    public void getTime2(){
//        System.out.println(
//                "cron表达式 定时任务 "
//                + dateFormat.format(new Date())
//        );
//    }

}
