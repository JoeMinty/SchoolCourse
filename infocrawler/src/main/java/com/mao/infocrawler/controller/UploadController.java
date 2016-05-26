package com.mao.infocrawler.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mao.infocrawler.model.entity.Resoinfo;
import com.mao.infocrawler.model.entity.User;
import com.mao.infocrawler.service.LoginService;
import com.mao.infocrawler.service.ResoinfoService;
import com.mao.infocrawler.utils.StringUtil;

@Controller
public class UploadController {
	
	@Autowired
	private ResoinfoService resoinfoService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/oneTeacherShow")
	public ModelAndView init(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String id = (String) request.getSession().getAttribute(StringUtil.USER_ID);
		List<Resoinfo> reso = resoinfoService.findOneTeacherAllResources(id);
		String uploadUrl = request.getSession().getServletContext()
				.getRealPath("/") + "upload/";
		mv.addObject("reso", reso);
		mv.addObject("resosrc",uploadUrl);
		mv.setViewName("oneUpload");
		return mv;
	}
	
	 @RequestMapping("/downAllRources")
		public ModelAndView initAllResources(HttpServletRequest request){
			ModelAndView mv = new ModelAndView();
			List<Resoinfo> allreso = resoinfoService.findAll();
			String uploadUrl = request.getSession().getServletContext()
					.getRealPath("/") + "upload/";
			mv.addObject("allreso", allreso);
			mv.addObject("resosrc",uploadUrl);
			mv.setViewName("uploadResult");
			return mv;
		}
	
	
	@RequestMapping(value = "/oneUpload")
	public ModelAndView oneUpload(@RequestParam("filename") MultipartFile filename,
			HttpServletRequest request,@RequestParam(value = "description")String descripton) {
		
		String uploadUrl = request.getSession().getServletContext()
				.getRealPath("/") + "upload/";

		
		String id = (String)request.getSession().getAttribute(StringUtil.USER_ID);
		String name = filename.getOriginalFilename();

		File dir = new File(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		System.out.println("文件上传到" + uploadUrl + name);
		File targetFile = new File(uploadUrl + id + name);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			filename.transferTo(targetFile);
			
			User user = loginService.findOneUser(id);
			
			// 将资源名，上传老师的工号和姓名，以及下载次数显示到界面
			Resoinfo resoinfo = new Resoinfo();
			String realname = id + name;
			resoinfo.setUrlname(realname);
			resoinfo.setDownloadnum(0);
			resoinfo.setDescription(descripton);
			resoinfo.setTeacherid(id);
			resoinfo.setTeachername(user.getUsername());
			resoinfoService.create(resoinfo);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		List<Resoinfo> reso = resoinfoService.findOneTeacherAllResources(id);
		mv.addObject("reso", reso);
		mv.addObject("resosrc",uploadUrl);
		mv.setViewName("oneUpload");
		return mv;
	}
	
	

	@RequestMapping(value = "/moreUpload")
	public String moreUpload(HttpServletRequest request) {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartHttpServletRequest
				.getFileMap();
		String uploadUrl = request.getSession().getServletContext()
				.getRealPath("/")
				+ "upload/";

		File dir = new File(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		List<String> fileList = new ArrayList<String>();
		for (MultipartFile file : files.values()) {
			File targetFile = new File(uploadUrl + file.getOriginalFilename());
			if (!targetFile.exists()) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					file.transferTo(targetFile);
					fileList.add("http://localhost:8080/infocrawler/upload/"
							+ file.getOriginalFilename());
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		request.setAttribute("files", fileList);
		return "uploadResult";
	}
}
