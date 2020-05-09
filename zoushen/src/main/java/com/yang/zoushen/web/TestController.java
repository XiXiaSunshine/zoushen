package com.yang.zoushen.web;

import com.yang.zoushen.domain.SimpleMsgVo;
import com.yang.zoushen.domain.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("test")
public class TestController {
    @GetMapping("tagdemo.do")
    public String tagdemo(HttpServletRequest request){
        request.setAttribute("username", "zoushen");
        return "tagdemo";
    }
    @PostMapping("test.do")
    @ResponseBody
    public SimpleMsgVo testdo(@RequestParam() TestDto body){
        System.out.println(body);
        SimpleMsgVo vo = new SimpleMsgVo(true,"hello","http://www.baidu.com");
        return vo;
    }
}
