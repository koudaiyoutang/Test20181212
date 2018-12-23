package com.example.springboot.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.model.HttpClientResult;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class HttpsClientUtilsTest {

    @Test
    public void getWXACodeUnlimit() {
        try {
            HttpClientResult httpClientResult = HttpsClientUtils
                    .doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx808d2fa91acb3761&secret=198cc46c72baf605f0ebdbe2a623e01e");
            System.out.println(httpClientResult);
            String content = httpClientResult.getContent();
            JSONObject jsonObject = JSON.parseObject(content);
            String access_token = (String)jsonObject.get("access_token");

            System.out.println( "access_token= "+access_token);
            Map<String, String> map = new HashMap<String, String>();
            map.put("scene", "33");
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=";
//            url.concat("16_vP-St6Y0uAFL95JoWrlVBEfnENObpedMdX5LG39x16TyZxAPJr7DjqUZAU9SLB4sxr5nmZmKkYrd60IziJiPgWfccQA-uotf5rtUlRNyDtldLPXIWLowrTJGnedAiny0GxQbZLZif-wgjjirRVPdAIAIMG");
            url = url.concat(access_token);
            System.out.println("-----------------开始获取二维码------------------");
            HttpClientResult httpClientResult1 = HttpsClientUtils.doPostJson(url,null, map);
            System.out.println("-----------------开始获取二维码------------------");
           // System.out.println(httpClientResult1);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}