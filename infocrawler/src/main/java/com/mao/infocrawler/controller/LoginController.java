package com.mao.infocrawler.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mao.infocrawler.model.entity.User;
import com.mao.infocrawler.service.ExamService;
import com.mao.infocrawler.service.LoginService;
import com.mao.infocrawler.utils.StringUtil;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping("/login")
	public String init(){
		return "login";	
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest  request,
            			HttpServletResponse response,
						@RequestParam(value = "id",defaultValue = "")String id , 
						@RequestParam(value = "password",defaultValue = "")String password){
		
		
		ModelAndView mv = new ModelAndView();
		if(loginService.checkLogin(id, password)){	
			request.getSession().setAttribute(StringUtil.USER_ID, id);
			User u = loginService.findOneUser(id);
			request.getSession().setAttribute(StringUtil.USER_NAME, u.getUsername());
			request.getSession().setAttribute(StringUtil.USER_TYPE, u.getUsertype());
		
			int num = 0; 
			if("T".equals(u.getUsertype())){
				// 如果登录的角色是老师
				String sql = "SELECT * FROM _exam where status=0";
				num = examService.findNoScanCount(sql);
			}else{
				String sql = "SELECT * FROM _exam where studentstatus=1";
				num = examService.findStudentNoScanCount(sql);
			}
			String msgcount = num == 0 ? "":num+"";
			request.getSession().setAttribute(StringUtil.USER_MESSAGE_COUNT, msgcount);
			mv.setViewName("index");
		}
		else{
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public ModelAndView regist(@RequestParam(value = "userid")String userid, 
					 	 @RequestParam(value = "password")String password,
					 	 @RequestParam(value = "username")String username,
					 	 @RequestParam(value = "usertype",defaultValue = "")String usertype){
		
		ModelAndView mv = new ModelAndView();
		// 获取信息添加注册
		String msg = loginService.registUser(userid, username, password, usertype);
		mv.addObject("msg", msg);
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/showeditInfo")
	public ModelAndView showeditInfo(HttpServletRequest request){
		String id = (String) request.getSession().getAttribute(StringUtil.USER_ID);
		User user = loginService.findOneUser(id);
		ModelAndView mv = new ModelAndView();
		// 修改个人信息
		mv.addObject("user", user);
		mv.setViewName("editInfo");
		return mv;
	}
	
	@RequestMapping(value = "/editInfo",method = RequestMethod.POST)
	public ModelAndView editInfo(HttpServletRequest request, 
					 	 @RequestParam(value = "password")String password,
					 	 @RequestParam(value = "username")String username,
					 	 @RequestParam(value = "major",defaultValue = "")String major){
		String id = (String) request.getSession().getAttribute(StringUtil.USER_ID);
		ModelAndView mv = new ModelAndView();
		// 修改个人信息
		mv.addObject("msg", "cc");
		mv.setViewName("editInfo");
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request){
		  Enumeration<String> em = request.getSession().getAttributeNames();
		          while (em.hasMoreElements()) {
		              request.getSession().removeAttribute(em.nextElement().toString());
		          }
		          request.getSession().invalidate();
		         return "login"; 
	}
}
