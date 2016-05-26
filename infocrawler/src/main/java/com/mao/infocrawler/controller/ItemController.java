package com.mao.infocrawler.controller;

import com.mao.infocrawler.model.Page;
import com.mao.infocrawler.model.entity.Item;
import com.mao.infocrawler.service.ItemService;
import com.mao.infocrawler.utils.CsvUtil;
import com.mao.infocrawler.utils.PageUtil;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mao on 2016/5/2.
 */

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    private static Page initpage = PageUtil.initPage(PageUtil.TWENTY_EVERYPAGE, 1);

    private static final String DB_FIELD_TIME = "time";

    private static final String DB_FIELD_RESOURCE = "resource";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView getUserlist() {
        ModelAndView mv = new ModelAndView();
        List<Item> itemList = itemService.findAll();
        System.out.println("log======table 'item' all records:" + itemList.size());
        mv.addObject("itemList", itemList);
        mv.setViewName("list");
        return mv;
    }

//    @RequestMapping(value="/list",method=RequestMethod.GET)
//    public ModelAndView searchByKeyword(@RequestParam(value ="curPage" , defaultValue = "1")int curPage,
//                                        @RequestParam(value = "keyword", defaultValue = "")String keyword,
//                                        @RequestParam(value = "time", defaultValue = "")String time){
//
//        Page page = PageUtil.validateCurPage(curPage, initpage);
//
//        ModelAndView mv = new ModelAndView();
//        page = itemService.queryByKeyword(keyword, page);
//        List<Item> itemList = (List<Item>)page.getContent();
//        System.out.println("log======queryByKeyword" + itemList.size());
//        //System.out.println("log======queryByKeyword" +time);
////        for (Item i : itemList) {
////            System.out.println("=============="+i.getId()+"--"+ i.getTitle()+"=============");
////        }
//
//        List<String> times = itemService.queryField(DB_FIELD_TIME);
//        mv.addObject("itemList", itemList);
//        mv.addObject("page",page);
//        mv.addObject("keyword", keyword);
//        mv.addObject("times", times);
//        mv.setViewName("list");
//        return mv;
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView searchByKeyword(@RequestParam(value = "curPage", defaultValue = "1") int curPage,
                                        @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                        @RequestParam(value = "time", defaultValue = "") String time,
                                        @RequestParam(value = "resource", defaultValue = "") String resource) {

        Page page = PageUtil.validateCurPage(curPage, initpage);

        ModelAndView mv = new ModelAndView();

        page = itemService.query(keyword, time, resource, page);
        List<Item> itemList = (List<Item>) page.getContent();
        System.out.println("log======queryByKeyword" + itemList.size());
        //System.out.println("log======queryByKeyword" +time);
//        for (Item i : itemList) {
//            System.out.println("=============="+i.getId()+"--"+ i.getTitle()+"=============");
//        }

        List<String> times = itemService.queryField(DB_FIELD_TIME);
        List<String> resources = itemService.queryField(DB_FIELD_RESOURCE);

        mv.addObject("itemList", itemList);
        mv.addObject("page", page);
        mv.addObject("keyword", keyword);
        mv.addObject("times", times);
        mv.addObject("resources", resources);
        mv.addObject("time", time);
        mv.addObject("resource", resource);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String export(@RequestParam(value = "exportKeyword", defaultValue = "") String exportKeyword,
                         @RequestParam(value = "exportTime", defaultValue = "") String exportTime,
                         @RequestParam(value = "exportResource", defaultValue = "") String exportResource) {

        List<Item> items = itemService.queryNoPage(exportKeyword, exportTime, exportResource);
        List<String> itemStrList = CsvUtil.ItemList2StrList(items);
        CsvUtil.writeCsv(CsvUtil.ITEM_CSV_HEADER, itemStrList);
        System.out.println("#############export finished, keyword: " + exportKeyword + ", time: " + exportTime + ", resource: " + exportResource);
        return "redirect:list";
    }

    @RequestMapping(value = "detail/{itemId}")
    public ModelAndView detail(@PathVariable int itemId) {

        ModelAndView mv = new ModelAndView();
        Item item = itemService.findOneById(itemId);
        mv.addObject("item", item);
        mv.setViewName("detail");
        return mv;
    }


}
