package com.example.sky.controller;

import com.example.sky.DTO.AlarmMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * @author chengbb
 * @date 2019.12.26
 */
@RequestMapping("/alarm1")
@RestController
@Slf4j
public class AlarmController {

//    //sign
//    private String secret = "SEC70fd39665db75c8f208fa57d99d6a018d1ce6479561b3fa3cd7398878ea094bf";
//    //wehook-api地址
//    private String webhook = "https://oapi.dingtalk.com/robot/send?access_token=3254be9ce79ca3d3db303c1df75436df952809b6aac149cc2f4074141bdf8b90";
//测试
//    //sign
//    private String secret = "SEC7e6f6db7865c367b6278c122767b5f678315a7771058cf8eb067af424cc4aaf4";
//    //wehook-api地址
//    private String webhook = "https://oapi.dingtalk.com/robot/send?access_token=5f5db66807c1e69f5d328d5916e7c6549add4342d088775d0e02abe441c7a999";

    private String webhook = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=6933878f-5e4b-4fd6-ad35-5386dfd64d07";

    @RequestMapping(value = "/pushData1", method = RequestMethod.POST)
    public void alarm(@RequestBody List<AlarmMessageDto> alarmMessageList) throws IOException {

        log.info("alarmMessage:{}", alarmMessageList.toString());

        for (int i = 0; i < alarmMessageList.size(); i++) {
            AlarmMessageDto s = (AlarmMessageDto) alarmMessageList.get(i);
            System.out.println(s.getName() + "  " + s.getAlarmMessage());
            //调用企业微信webhook中的shell命令返回告警信息
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(webhook);
            httppost.addHeader("Content-Type", "application/json; charset=utf-8");
            //构建一个json格式字符串textMsg，其内容是接收方需要的参数和消息内容
            String textMsg = "{\n" +
                    "  \"msgtype\": \"markdown\",\n" +
                    "  \"markdown\": {\n" +
                    "    \"content\": \"<font color=\\\"**bold**\\\">==========Skywalking告警信息反馈==========</font>，请相关同事注意。\\n> 告警服务:<font color=\\\"comment\\\">"+ s.getName() +"</font>\\n> 告警信息内容:<font color=\\\"comment\\\">" + s.getAlarmMessage() + "</font>\\n> \"\n" +
                    "  }\n" +
                    "}";
            StringEntity se = new StringEntity(textMsg, "utf-8");
            httppost.setEntity(se);
            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(result);
            }
        }
    }

}
