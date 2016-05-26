package com.mao.infocrawler.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mao.infocrawler.service.ResoinfoService;

@Controller
public class DownloadController {
	
	@Autowired
	private ResoinfoService resoinfoService;
	
	@RequestMapping(value = "/download")
	public String download(@RequestParam String filename,@RequestParam int downloadnum,@RequestParam int resoid,
			HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String downloadPath = ctxPath + filename;
		
		try {
			long fileLength = new File(downloadPath).length();
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Length",String.valueOf(fileLength));
			response.setHeader("Content-disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"),"ISO-8859-1"));
			bis = new BufferedInputStream(new FileInputStream(downloadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte [] buff = new byte [2048];
			int bytesRead;
			while((bytesRead = bis.read(buff,0,buff.length))!=-1){
				bos.write(buff,0,bytesRead);
			}
		
		} catch (Exception e) {
		}finally{
			if(bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		// 每下载一次，下载次数+1
		String sql = "update _resoinfo set downloadnum=" + (++downloadnum) + " where id='" +resoid+"'";
		resoinfoService.update(sql);
		return null;
	}

}
