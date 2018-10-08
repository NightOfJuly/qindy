package com.qindy.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qindongyun
 * @Description: 部署测试
 * @date 2018/9/7
 */

@RestController
public class TestController {

    @RequestMapping(value = "/test")
    public String test(){
        //System.out.println("test success!!");
        return "test JRebel success";
    }
}
