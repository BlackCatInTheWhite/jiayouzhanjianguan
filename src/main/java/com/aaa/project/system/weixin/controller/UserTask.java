package com.aaa.project.system.weixin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张益达
 * @create 2019-04-23 11:04
 * @desprint 这个代码好
 */
@RestController("/wxtask")
public class UserTask {
    @RequestMapping("/task")
    public List task(){
        return null;
    }
}
