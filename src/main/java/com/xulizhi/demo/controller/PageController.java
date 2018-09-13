package com.xulizhi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lenovo
 */
@Controller
public class PageController {

    /**
     * 打开首页
     */
    @RequestMapping("index")
    public String showIndex() {
        return "index";
    }

    /**
     * 展示其他页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page) {
        return page;
    }
}
