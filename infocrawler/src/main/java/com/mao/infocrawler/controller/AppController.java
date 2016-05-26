package com.mao.infocrawler.controller;

import com.mao.infocrawler.service.AppService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mao on 2016/4/21.
 */


@Controller
public class AppController {

    @Autowired
    private AppService service;

    
    /**
     * test
     * @param model
     * @return
     */
    @RequestMapping(value = "/redis2DB", method = RequestMethod.GET)
    public String listItems(ModelMap model) throws MySQLIntegrityConstraintViolationException {

        service.redis2DB();
        model.addAttribute("saved", "记录已存入数据库");
        return "hello";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/startCrawler", method = RequestMethod.GET)
    public String startCrawler(ModelMap model) {

//        service.startCrawler();
//        model.addAttribute("finished", true);
//        model.addAttribute("total", "共爬取"+service.total()+"条记录");
        return "hello";
    }

}
