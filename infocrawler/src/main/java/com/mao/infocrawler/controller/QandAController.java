package com.mao.infocrawler.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mao.infocrawler.model.entity.Answers;
import com.mao.infocrawler.model.entity.Question;
import com.mao.infocrawler.model.entity.QuestionInfo;
import com.mao.infocrawler.service.AnswersService;
import com.mao.infocrawler.service.QAndAService;
import com.mao.infocrawler.utils.StringUtil;

@Controller
@RequestMapping("/")
public class QandAController {

	@Autowired
	private QAndAService qAndAService;
	
	@Autowired
	private AnswersService answersService;

	@RequestMapping("/allQuestions")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String sql = "select * from _question order by id desc";
		List<Question> questionList = qAndAService.findAllByTime(sql);
		List<QuestionInfo> questionInfoList = new ArrayList<QuestionInfo>();
		for (Question record : questionList) {
			QuestionInfo questionInfo = new QuestionInfo();
			questionInfo.setId(record.getId());
			questionInfo.setAskusername(record.getAskusername());
			questionInfo.setDescription(record.getDescription());
			questionInfo.setQuestionname(record.getQuestionname());
			questionInfo.setTime(record.getTime());
			String sqlQueryCount = "select count(*) from _answers where questionid="
					+ record.getId();
			int count = qAndAService.findAnswerCount(sqlQueryCount);
			questionInfo.setAnswernum(count);
			questionInfoList.add(questionInfo);
		}
		mv.addObject("questionInfoList", questionInfoList);
		mv.setViewName("allQuestions");
		return mv;
	}

	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public ModelAndView addQuestion(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "questionname", defaultValue = "") String questionname,
			@RequestParam(value = "description", defaultValue = "") String description) {

		ModelAndView mv = new ModelAndView();
		String id = (String) request.getSession().getAttribute(
				StringUtil.USER_ID);
		String username = (String) request.getSession().getAttribute(
				StringUtil.USER_NAME);

		if (qAndAService.addQuestion(questionname, description, id, username)) {
			mv.addObject("msg", "添加问题成功！");
		} else {
			mv.addObject("msg", "添加问题失败！");
		}
		String sql = "select * from _question order by id desc";
		List<Question> questionList = qAndAService.findAllByTime(sql);
		List<QuestionInfo> questionInfoList = new ArrayList<QuestionInfo>();
		for (Question record : questionList) {
			QuestionInfo questionInfo = new QuestionInfo();
			questionInfo.setId(record.getId());
			questionInfo.setAskusername(record.getAskusername());
			questionInfo.setDescription(record.getDescription());
			questionInfo.setQuestionname(record.getQuestionname());
			questionInfo.setTime(record.getTime());
			String sqlQueryCount = "select count(*) from _answers where questionid="
					+ record.getId();
			int count = qAndAService.findAnswerCount(sqlQueryCount);
			questionInfo.setAnswernum(count);
			questionInfoList.add(questionInfo);
		}
		mv.addObject("questionInfoList", questionInfoList);
		mv.setViewName("allQuestions");
		return mv;
	}

	

	@RequestMapping(value = "/showQuestionDetail")
	public ModelAndView showQuestionDetail(
			HttpServletRequest request,@RequestParam(value = "questionid")int id
			) {
		
		ModelAndView mv = new ModelAndView();
		Question question = qAndAService.findOneById(id);
		mv.addObject("question", question);
		// 通过问题找出所有回答
		
		String sql = "select * from _answers where questionid=" + id;
		List<Answers> answerlist =  answersService.findAllByTime(sql);
		mv.addObject("answerlist", answerlist);
		mv.setViewName("oneQuestionDetail");
		return mv;
	}
	
	
	@RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
	public ModelAndView addAnswer(
			HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value = "questionid") String questionid,
			@RequestParam(value = "answercontent", defaultValue = "") String answercontent) {

		ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute(
				StringUtil.USER_NAME);

		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date time = new Date();

		
		if (answersService.addAnswer(questionid, answercontent, myFmt.format(time), username)) {
			mv.addObject("msg", "发表评论成功！");
		} else {
			mv.addObject("msg", "发表评论失败！");
		}
		
		Question question = qAndAService.findOneById(Integer.parseInt(questionid));
		mv.addObject("question", question);
		
		String sql = "select * from _answers where questionid=" + questionid;
		List<Answers> answerlist =  answersService.findAllByTime(sql);
		mv.addObject("answerlist", answerlist);
		mv.setViewName("oneQuestionDetail");
		return mv;
	}
}
