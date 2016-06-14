<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<title>资源显示</title>
		<link rel="stylesheet" href="/infocrawler/static/css/my.css">
		<link rel="stylesheet" href="/infocrawler/static/bootstrap-3.3.6/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="/infocrawler/static/font-awesome/font-awesome.css" />
		<link rel="stylesheet" href="/infocrawler/static/css/personInfo.css">
		<link rel="stylesheet" href="/infocrawler/static/css/tab.css">
		<link rel="stylesheet" href="/infocrawler/static/css/index.css">
		<script type="application/javascript" src="/infocrawler/static/jquery-1.12.3.min.js"></script>
		<script type="application/javascript" src="/infocrawler/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
		<script>
			$(document).ready(function() {
				init();
			});
			function init(){
				var usertype = "<%=session.getAttribute("usertype")%>";
				if(usertype == "T"){
					$("#onlineExam").css("display","none");
					$("#downRes").css("display","none");
					$("#upWork").css("display","none");
				}else{
					$("#upRes").css("display","none");
				}
				var msgcount = "<%=session.getAttribute("msgcount")%>";
				if(msgcount == ""){
					$("#msgcount").css("display","none");
				}
			}
			</script>
</head>
<body>
<div>
		<nav class="navbar navbar-default navbar-fixed-top" id="background-img">
		  <div class="container-fluid col-md-10 col-md-offset-1">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">生物信息学</a>
		    </div>

		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		        <ul class="nav navbar-nav" >
		         <li><a href="/infocrawler/pagehome">主页<span class="sr-only">(current)</span></a></li>
		        <li><a href="/infocrawler/topage?pagename=about">课程简介</a></li>
		        <li><a href="/infocrawler/topage?pagename=catlog">教学大纲</a></li>
		        <li id="onlineExam"><a href="/infocrawler/initExamPage">在线考试</a></li>
		        <li id="upRes"><a href="/infocrawler/oneTeacherShow">上传资源</a>
		        <li id="downRes"><a href="/infocrawler/downAllRources">资源下载</a></li>
		        <li><a href="/infocrawler/allQuestions">在线问答</a></li>
		        <li><a href="/infocrawler/allHomeworks">作业中心</a></li>
		      </ul>
		      
  			  <ul class="nav navbar-nav  navbar-right" style="margin-right:20px;" id="msgcount">
		      		<li  style="padding:20px 5px;"><span class="glyphicon glyphicon-envelope"></span></li>
		      		<li  style="padding:18px 8px;"><span class="badge" style="background-color: red"><a href="/infocrawler/showAllNoScanExams"><%=session.getAttribute("msgcount")%></a></span></li>
		      </ul>
 
		      <ul class="nav navbar-nav navbar-right" id="right-person-info">
		        <li class="dropdown" id="right-person-info-li">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					<img src="/infocrawler/static/img/pic.jpg"/>
					<span id="user-nickname"><%=(String) session.getAttribute("username")%></span>
		          	<span class="caret"></span>	
		          </a>

		          <!-- 这里需要自己计算高度 -->
		          <ul class="dropdown-menu" id="dropdown-info">
		            <li id="not-last-li">
		            	<a href="/infocrawler/topage?pagename=editInfo">
		            		<span class="glyphicon glyphicon-user"></span><span class="badge">5</span>编辑资料
		            	</a>
		            </li>
		         	<li>
		            	<a href="/infocrawler/logout">
		            		<span class="glyphicon glyphicon-off"></span>退出
		            	</a>
		            </li>
		          </ul>
		        </li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>



	<div class="container" style="margin-top:80px;">
				
<h2>一、课程的性质、目的与任务</h2>
生物信息学导论是生物医学工程专业的一门学科基础课。本课程注重学科交叉、融合，以介绍概念、思想和方法为主，启发学生综合运用数学、物理、工程科学和计算机知识的能力，拓宽知识面，了解学科前沿和最新进展，培养跨越生命科学、计算科学、数理科学等不同领域的"大科学"素质和意识，为今后选择新兴交叉学科领域进行深造奠定基础。
<h2>二、课程内容、学时分配及基本要求</h2>
<h3>第一讲 绪论                                          3学时</h3>
第一节  生物信息学的诞生——从人类基因组计划说起
第二节  生物信息学：主要研究内容和方法
基本要求：
了解生物信息学产生的背景和发展，了解生物信息学的主要研究内容和研究方法。

<h3>第二讲 分子生物学基础                                6学时</h3>
第一节  “What is life？”——从薛定锷的思考到“双螺旋”的发现
第二节  生命的演化和分类
第三节  生命的分子组成
第四节遗传的分子基础
第五节基因组与基因结构
基本要求：
了解生命的演化和分类，掌握生命的分子组成，遗传的分子基础，基因组与基因结构。


<h3>第三讲 生物信息数据库和生物信息学主要问题            6学时</h3>
第一节  生物信息学概述与历史回顾
第二节  基因组序列数据的获取
第三节生物信息数据库简介（一级数据库、二级数据库简介）
第四节生物信息学主要问题（序列比对、核酸和蛋白质结构与功能预测、基因组序列分析与蛋白质序列分析、功能基因组相关信息分析）
基本要求：
了解生物信息学的概念与发展历史，了解基因组序列数据的获取，掌握生物信息数据库的获取与使用，了解生物信息学的主要研究问题。

<h3>第四讲 生物信息学研究方法简介                        6学时</h3>
第一节 统计分析方法（统计学基础、回归分析方法及其应用、判别分析方法及其应用、聚类分析方法及其应用）
第二节 机器学习方法（概率论基础、Markov过程的基本概念、隐Markov模型（HMM）的基本原理、人工神经网络（ANN）方法简介）
基本要求：
了解生物信息学的主要研究方法，会使用统计分析方法与机器学习方法解决简单生物学问题。

<h3>第五讲 生物序列比对                                  6学时</h3>
第一节  序列比对的定义和意义
第二节  序列比对方法概述
第二节 序列比对的动态规划方法
基本要求：
掌握序列比对的概念，掌握序列比对的方法。


<h3>第六讲 基因预测                                      6学时</h3>
第一节  基因预测的概念及其在基因组研究中的应用
第二节  微生物基因预测方法简介
第三节  真核生物基因预测方法简介
第三节 基因预测方法的评价
基本要求：
了解基因预测的概念及其在基因组研究中的应用，了解微生物和真核生物的基因预测方法及其评价。

<h3>第七讲 基因组进化及分子进化研究简介                  3学时</h3>
第一节  引言（基因组进化的复杂性与系统发育分析、分子进化与进化树）
第二节  构建系统发育树方法简介（距离法、最大简约法、最大似然法）
基本要求：
了解基因组进化，系统发育分析，分子进化，进化树的概念，了解构建系统发育树的方法。

<h3>第八讲 蛋白质序列分析与结构预测                      6学时</h3>
第一节  蛋白质序列与结构的基本知识
第二节  蛋白质序列分析与信号预测
第三节蛋白质结构与蛋白质结构预测
第四节蛋白质结构预测方法简介（基于蛋白质序列的结构预测方法、蛋白质二级结构预测、三级结构预测）
基本要求：
了解蛋白质序列与结构的基本知识，了解蛋白质序列分析与信号预测，蛋白质结构与蛋白质结构预测的概念、方法。

注：课堂讨论2次，共6学时。三、各教学环节学时分配
      项目
学时数	讲课	习题课	实验	上机	其他	合计
第一讲	3					3
第二讲	6					6
第三讲	6					6
第四讲	6				3	9
第五讲	6					6
第六讲	6					6
第七讲	3					3
第八讲	6				3	9
合计	42				6	48

<h2>四、教材及参考</h2>
教材：  孙啸，《生物信息学》，科学出版社，2003年
参考书：Westhead et al., <Bioinformatics>（英文原版），科学出版社，2003年
Pevzner，<Computational Molecular Biology>，MIT Press，2000
Salzberg, et al., <Computational Methods in Molecular Biology>, Elsevier Science, 1998
Waterman, <Introduction to Computational Biology>, Chapman & Hall, 1995
Durbin等, <Biological sequence analysis>（英文原版）, 清华大学出版社，2002
Brown著，袁建刚等译，《基因组》，科学出版社，2002年
Campbell等著，孙之荣等译，《探索基因组学、蛋白质组学和生物信息学》，科学出版社，2004年
郝柏林、张淑誉，《生物信息学手册》（第二版），上海科学技术出版社，2002年
Attwood等著，罗静初等译，《生物信息学概论》，北京大学出版社，2002年
Mount，<Bioinformatics-Sequence and Genome Analysis>，科学出版社，2002年（中文版由钟杨等译、高等教育出版社2003年出版） 
执笔人：汤丽华	
				
				
				
	</div>
	
	
</body>
</html>
