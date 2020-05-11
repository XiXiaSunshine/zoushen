package com.yang.zoushen.web;

import com.yang.zoushen.domain.SimpleMsgVo;
import com.yang.zoushen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("level.do")
    public String selectByLevelTest(){
        System.out.println(userService.findByLevel("4"));
        return "hello";
    }

    @GetMapping("all.do")
    public String selectAllTest(){
        System.out.println(userService.selectAll());
        return "hello";
    }
    @GetMapping("tagdemo.do")
    public String tagdemo(HttpServletRequest request){
        request.setAttribute("username", "zoushen");
        return "tagdemo";
    }
}
