package com.mao.infocrawler.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mao.infocrawler.model.entity.Choose;
import com.mao.infocrawler.model.entity.Exam;
import com.mao.infocrawler.model.entity.Positive;
import com.mao.infocrawler.service.ExamChooseService;
import com.mao.infocrawler.service.ExamService;
import com.mao.infocrawler.service.PositiveService;
import com.mao.infocrawler.utils.StringUtil;

@Controller
@RequestMapping("/")
public class ExamController {

	@Autowired
	private ExamChooseService examChooseService;
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private PositiveService positiveService;


	@RequestMapping("/initExamPage")
	public String initExamPage(HttpServletRequest request) {
		return "examinit";
	}
	
	protected static List<Choose> chooseList = null;
	protected static Positive positiveQ1 = null;
	protected static Positive positiveQ2 = null;
	protected static Map<Object,String> idAndResult = null;
	
	@RequestMapping(value = "/enterExamPage")
	public ModelAndView enterExamPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String sql = "SELECT * FROM _choose ORDER BY rand() LIMIT 8";
		String sqlPositite = "SELECT * FROM _positive ORDER BY rand() LIMIT 2"; 
		chooseList = examChooseService.findRandomEightChoose(sql);
		List<Positive> positiveList = positiveService.findRandomTwoPositive(sqlPositite);
		positiveQ1 = positiveList.get(0);
		positiveQ2 = positiveList.get(1);
		Map<Object,String> temp = new HashMap<Object,String>();
		for(Choose choose : chooseList){
			temp.put(choose.getId(), choose.getResult());
		}
		idAndResult = temp;
		mv.addObject("chooseList",chooseList);
		mv.addObject("positive1",positiveQ1);
		mv.addObject("positive2",positiveQ2);
		mv.addObject("positivescore", "0");
		mv.setViewName("exam");
		return mv;
	}

	
	@RequestMapping(value = "/calScores", method = RequestMethod.POST)
	public ModelAndView calScores(HttpServletRequest request,
			@RequestParam(value = "options1") String options1,@RequestParam(value = "options2") String options2,
			@RequestParam(value = "options3") String options3,@RequestParam(value = "options4") String options4,
			@RequestParam(value = "options5") String options5,@RequestParam(value = "options6") String options6,
			@RequestParam(value = "options7") String options7,@RequestParam(value = "options8") String options8,
			@RequestParam(value = "positive1") String positive1,@RequestParam(value = "positive2") String positive2) {
		String id = (String) request.getSession().getAttribute(
				StringUtil.USER_ID);
		String username = (String) request.getSession().getAttribute(
				StringUtil.USER_NAME);

		int choosescore = 0;
		if(idAndResult.values().contains(options1)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options2)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options3)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options4)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options5)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options6)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options7)){
			choosescore+=8;
		}
		if(idAndResult.values().contains(options8)){
			choosescore+=8;
		}
		
	
		
		ModelAndView mv = new ModelAndView(); 
		Exam exam = new Exam();
		exam.setStatus(0);
		exam.setStudentstatus(0);
		exam.setStudentid(id);
		exam.setStudentname(username);
		exam.setChoosescore(choosescore);
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date time = new Date();
		exam.setTime(myFmt.format(time));
		
		// [start]  这里是折叠的效果
		int index = 0;
		for(int i = 0 ; i < chooseList.size() ; i++){
			Choose choose = chooseList.get(i);
			index = i+1;
			if(index==1){
				exam.setChoose1id(choose.getId()+"");
				exam.setChoose1realresult(choose.getResult());
				exam.setChoose1result(options1);
				choose.setTempresult(options1);
			}
			if(index==2){
				exam.setChoose2id(choose.getId()+"");
				exam.setChoose2realresult(choose.getResult());
				exam.setChoose2result(options2);
				choose.setTempresult(options2);
			}
			if(index==3){
				exam.setChoose3id(choose.getId()+"");
				exam.setChoose3realresult(choose.getResult());
				exam.setChoose3result(options3);
				choose.setTempresult(options3);
			}
			if(index==4){
				exam.setChoose4id(choose.getId()+"");
				exam.setChoose4realresult(choose.getResult());
				exam.setChoose4result(options4);
				choose.setTempresult(options4);
			}
			if(index==5){
				exam.setChoose5id(choose.getId()+"");
				exam.setChoose5realresult(choose.getResult());
				exam.setChoose5result(options5);
				choose.setTempresult(options5);
			}
			if(index==6){
				exam.setChoose6id(choose.getId()+"");
				exam.setChoose6realresult(choose.getResult());
				exam.setChoose6result(options6);
				choose.setTempresult(options6);
			}
			if(index==7){
				exam.setChoose7id(choose.getId()+"");
				exam.setChoose7realresult(choose.getResult());
				exam.setChoose7result(options7);
				choose.setTempresult(options7);
			}
			if(index==8){
				exam.setChoose8id(choose.getId()+"");
				exam.setChoose8realresult(choose.getResult());
				exam.setChoose8result(options8);
				choose.setTempresult(options8);
			}
		}
		// [end]
		
		// 保存主观题
		exam.setPositive1id(positiveQ1.getId()+"");
		exam.setPositive1result(positive1);
		exam.setPositive1score(0);
		exam.setPositive2id(positiveQ2.getId()+"");
		exam.setPositive2result(positive2);
		exam.setPositive2score(0);
		// 最后需要放出来
		//examService.create(exam);
		
		mv.addObject("chooseList", chooseList);
		mv.addObject("choosescore", choosescore);
		mv.addObject("positive1",positiveQ1);
		mv.addObject("positive2",positiveQ2);
		mv.addObject("positivescore", "0");
		mv.addObject("msg","您此次考试的客观题得分为：" + choosescore + "分,主观题得分请等老师批阅后查看。");
		// 答案入库，便于以前查看
		mv.setViewName("examResult");
		return mv;

	}
	
	@RequestMapping(value = "/showAllNoScanExams")
	public ModelAndView showAllNoScanExams(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String uesrtype = (String) request.getSession().getAttribute(
				StringUtil.USER_TYPE);
		String id = (String) request.getSession().getAttribute(
				StringUtil.USER_ID);
		if("S".equals(uesrtype)){
			String sql = "SELECT * FROM _exam where studentstatus=1 and studentid="+id;
			List<Exam> temp = examService.findNoScanExams(sql);
			mv.addObject("personalExamList", temp);
			mv.setViewName("studentAllNoScanExams");
		}else{
			String sql = "SELECT * FROM _exam where status=0";
			List<Exam> temp = examService.findNoScanExams(sql);
			mv.addObject("personalExamList", temp);
			mv.setViewName("allNoScanExams");
		}
		return mv;
	}
	
	

	@RequestMapping(value = "/showOneStudentAllExams")
	public ModelAndView showOneStudentAllExams(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		String id = (String) request.getSession().getAttribute(
				StringUtil.USER_ID);
		List<Exam> temp = examService.findAllByOneStudentId(id);
		List<Exam> personalExamList = new ArrayList<Exam>();
		for(Exam exam : temp){
			if(exam.getStatus()==0){
				exam.setTempresult("老师尚未披阅主观题");
			}else{
				exam.setTempresult(exam.getPositive1score()+exam.getPositive2score()+"" + "分");
			}
			personalExamList.add(exam);
		}
		mv.addObject("personalExamList", personalExamList);
		mv.setViewName("allExams");
		return mv;

	}
	
	
	@RequestMapping(value = "/initOneEverExam", method = RequestMethod.GET)
	public ModelAndView initOneEverExam(HttpServletRequest request,@RequestParam int examid) {
		
		Exam exam = examService.findOneById(Integer.parseInt((examid+"")));
		ModelAndView mv = new ModelAndView();
		exam.setStudentstatus(0);
		
		String tempp = (String) request.getSession().getAttribute(
				StringUtil.USER_MESSAGE_COUNT);
		int re = (Integer.parseInt(tempp) - 1);
		String msgcount = re > 1 ? re+"":"";
		
		request.getSession().setAttribute(StringUtil.USER_MESSAGE_COUNT, msgcount);
		List<Integer> chooseIdList = new ArrayList<Integer>();
		chooseIdList.add(Integer.parseInt(exam.getChoose1id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose2id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose3id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose4id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose5id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose6id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose7id()));
		chooseIdList.add(Integer.parseInt(exam.getChoose8id()));
		
		Positive temp1 = positiveService.findOneById(Integer.parseInt(exam.getPositive1id()));
		Positive temp2 = positiveService.findOneById(Integer.parseInt(exam.getPositive2id()));
		temp1.setTempresult(exam.getPositive1result());
		temp2.setTempresult(exam.getPositive2result());
		
		List<Choose> chooseList1 = new ArrayList<Choose>();
		for(int i = 0 ; i < chooseIdList.size() ; i++){
			Choose temp = examChooseService.findOneById(chooseIdList.get(i));
			int index = i + 1;
			if(index==1)
				temp.setTempresult(exam.getChoose1result());
			if(index==2)
				temp.setTempresult(exam.getChoose2result());
			if(index==3)
				temp.setTempresult(exam.getChoose3result());
			if(index==4)
				temp.setTempresult(exam.getChoose4result());
			if(index==5)
				temp.setTempresult(exam.getChoose5result());
			if(index==6)
				temp.setTempresult(exam.getChoose6result());
			if(index==7)
				temp.setTempresult(exam.getChoose7result());
			if(index==8)
				temp.setTempresult(exam.getChoose8result());
			chooseList1.add(temp);
		}
		
		mv.addObject("chooseList", chooseList1);
		if(exam.getStatus()==1){
			mv.addObject("msg","您该次考试的成绩总分为"+ (exam.getChoosescore()+exam.getPositive1score()+exam.getPositive2score())+"分（客观题为"+exam.getChoosescore()+"分，主观题为"+(
					exam.getPositive1score()+exam.getPositive2score())+"）");
			mv.addObject("positivescore", "1");
		}else{
			mv.addObject("msg", "您该次考试主观题部分老师尚未批阅，您的客观题得分为"+exam.getChoosescore()+"分");
			mv.addObject("positivescore", "0");
		}
		mv.addObject("positive1",temp1);
		mv.addObject("positive2",temp2);
		mv.setViewName("examResult");
		mv.addObject("exam", exam);
		return mv;

	}
	
	
	@RequestMapping(value = "/initOneEverExamOnlyPositive", method = RequestMethod.GET)
	public ModelAndView initOneEverExamOnlyPositive(HttpServletRequest request,@RequestParam int examid) {
		
		Exam exam = examService.findOneById(Integer.parseInt((examid+"")));
		ModelAndView mv = new ModelAndView();
		
		Positive temp1 = positiveService.findOneById(Integer.parseInt(exam.getPositive1id()));
		Positive temp2 = positiveService.findOneById(Integer.parseInt(exam.getPositive2id()));
		temp1.setTempresult(exam.getPositive1result());
		temp2.setTempresult(exam.getPositive2result());
		
		mv.addObject("positive1",temp1);
		mv.addObject("positive2",temp2);
		mv.addObject("item",exam);
		mv.setViewName("dealPositive");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/calPositive", method = RequestMethod.POST)
	public ModelAndView calPositive(HttpServletRequest request,@RequestParam int positiveid,
			@RequestParam(value = "positive1score") int positive1score,@RequestParam(value = "positive1score") int positive2score
		) {
		Exam exam = examService.findOneById(Integer.parseInt((positiveid+"")));
		exam.setPositive1score(positive1score);
		exam.setPositive2score(positive2score);
		exam.setStatus(1);
		exam.setStudentstatus(1);
		examService.update(exam);
		String tempp = (String) request.getSession().getAttribute(
				StringUtil.USER_MESSAGE_COUNT);
		int re = (Integer.parseInt(tempp) - 1);
		String msgcount = re >= 1 ? re+"":"";
		
		request.getSession().setAttribute(StringUtil.USER_MESSAGE_COUNT, msgcount);
		ModelAndView mv = new ModelAndView();
		String sql = "SELECT * FROM _exam where status=0";
		List<Exam> temp = examService.findNoScanExams(sql);
		mv.addObject("personalExamList", temp);
		mv.setViewName("allNoScanExams");
		return mv;
	}
	
	
	@RequestMapping("/backToCenter")
	public String backToCenter(){
		return "examinit";
	}
	 
}
