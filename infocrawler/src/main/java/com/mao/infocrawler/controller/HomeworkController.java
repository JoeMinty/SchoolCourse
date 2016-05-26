package com.mao.infocrawler.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mao.infocrawler.model.entity.Homework;
import com.mao.infocrawler.service.HomeworkService;
import com.mao.infocrawler.utils.StringUtil;

@Controller
@RequestMapping("/")
public class HomeworkController {

	@Autowired
	private HomeworkService homeworkService;
	

	@RequestMapping("/allHomeworks")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String sql = "select * from _homework order by id desc";
		List<Homework> homeworkList = homeworkService.findAllByTime(sql);
		mv.addObject("homeworkList", homeworkList);
		mv.setViewName("allHomeworks");
		return mv;
	}

	@RequestMapping(value = "/addHomework", method = RequestMethod.POST)
	public ModelAndView addHomework(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "homeworkcontent", defaultValue = "") String homeworkcontent,
			@RequestParam(value = "description", defaultValue = "") String description) {

		ModelAndView mv = new ModelAndView();
		String id = (String) request.getSession().getAttribute(
				StringUtil.USER_ID);
		String username = (String) request.getSession().getAttribute(
				StringUtil.USER_NAME);

		if (homeworkService.addHomework(homeworkcontent, description, id, username)) {
			mv.addObject("msg", "发起作业成功！");
		} else {
			mv.addObject("msg", "发起作业失败！");
		}
		String sql = "select * from _homework order by id desc";
		List<Homework> homeworkList = homeworkService.findAllByTime(sql);
		mv.addObject("homeworkList", homeworkList);
		mv.setViewName("allHomeworks");
		return mv;
	}
	

	@RequestMapping(value = "/uploadHomework", method = RequestMethod.POST)
	public ModelAndView uploadHomework(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "homeworkcontent", defaultValue = "") String homeworkcontent,
			@RequestParam(value = "description", defaultValue = "") String description) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "上传作业成功！");
		String sql = "select * from _homework order by id desc";
		List<Homework> homeworkList = homeworkService.findAllByTime(sql);
		mv.addObject("homeworkList", homeworkList);
		mv.setViewName("allHomeworks");
		return mv;
	}
}
