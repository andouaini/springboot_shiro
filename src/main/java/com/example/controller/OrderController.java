package com.example.controller;

import com.example.entity.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author zhaoluowei
 * @Date 2019/7/6  19:27
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/authc")
public class OrderController {

    /**
     * token的参数 要放在请求头中
     * @return
     */
    @PostMapping(value = "/video/play_record")
    public JsonData findMyPlayRecord(){
        //从数据库中查询出来
        Map<String ,String> recordMap = new HashMap<>();

        recordMap.put("SpringBoot入门到高级实战","第8章第1集");
        recordMap.put("Cloud微服务入门到高级实战","第4章第10集");
        recordMap.put("分布式缓存Redis","第10章第3集");

        return JsonData.buildSuccess(recordMap);

    }

}
