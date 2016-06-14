<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="/infocrawler/static/bootstrap-3.3.6/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="/infocrawler/static/font-awesome/font-awesome.css" />
			<link rel="stylesheet" href="/infocrawler/static/css/tab.css">
				<link rel="stylesheet" href="/infocrawler/static/css/editInfo.css">
		<script type="application/javascript" src="/infocrawler/static/jquery-1.12.3.min.js"></script>
		<script type="application/javascript" src="/infocrawler/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
		<script>
		$(document).ready(function(){
			  init();
			  resize();
			  showMsg();
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
			if("${msgcount}" == ""){
				$("#msgcount").css("display","none");
			}
			var msgcount = "<%=session.getAttribute("msgcount")%>";
			if(msgcount == ""){
				$("#msgcount").css("display","none");
			}
		}
		
		function showMsg(){
			if("${msg}"!=''){
				$('#myModal').modal('show');
			}
		}
		
		function resize(){
			$("#username").height($("#nickname").height());
			$(".progress-bar").css({"width":"60%"});
			$("#introduction").html("明日天寒地冻，路遥马荒");
			$(".progress-bar").html("60%");
		}
	</script>
</head>
<body>
	<!-- js弹出框 -->
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body">
					<p>${msg}</p>
				</div>
			</div>
		</div>
	</div>


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
		            		<span class="glyphicon glyphicon-user"></span>编辑资料
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



	<div class="container" id="info-detail">
		<form action="/infocrawler/editInfo" method="post" class="form-inline">
		<div class="col-md-10 col-md-offset-1">
			

			<!-- 具体信息-->
			<div class="col-md-12" id="person-info">
				<div id="pad-left">
						<div class="form-group">
				    		<h4><%=(String) session.getAttribute("username")%> ›› 编辑个人资料</h4>
				    	</div>
				</div>
			</div>
			<div class="col-md-12" id="content-detail">
				<!--工号-->
				<div class="col-md-12" id="pad-left-b">
						<div class="form-group">
						    <label>工号：</label>
						    <span class="text-info">${user.id}</span>
						</div>
				</div>
				
				<!--姓名-->
				<div class="col-md-12" id="pad-left-b">
						<div class="form-group">
						    <label>姓名：</label>
						    <span class="text-info">${user.username}</span>
						</div>
				</div>
				
			
				<!--密码-->
				<div class="col-md-12" id="pad-left-b">
							<div class="form-group">
							    <label>密码：</label>
				   				<input type="password" class="form-control" id="password" name="password" value="${user.password}">
				   			</div>
				</div>

				<!--性别-->
				<div class="col-md-12" id="pad-left">
				   		<div class="form-group">
				   			<label>性别：</label>
					   	    <span class="checkbox-inline">
						        <input type="radio" id="male"  
						         value="male" name="sex" checked> 男
						    </span>
						    <span class="checkbox-inline">
						        <input type="radio" id="female" 
						         value="female"> 女
						    </span>
					    </div>
				</div>

				
				<!--行业-->
				<div class="col-md-12" id="pad-left-b">
						<div class="form-group">
						    <label>专业：</label>
						     <input type="text" class="form-control" id="job" name="major" value="">
						</div>
				</div>

				<!--位置-->
				<div class="col-md-12" id="pad-left-b">
						<div class="form-group">
						    <label>省份：</label>
						    <select id="province" class="form-control">
							  <option>江苏</option>
							  <option>北京</option>
							  <option>上海</option>
							  <option>四川</option>
							  <option>西安</option>
							</select>
							<label>城市：</label>
							<select id="city" class="form-control">
							  <option>南京</option>
							  <option>无锡</option>
							  <option>苏州</option>
							  <option>常州</option>
							  <option>泰州</option>
							</select>
						</div>
				</div>

			</div>

			<!--保存修改-->
			<div class="col-md-12" id="btn-edit">
				<div class="col-md-4 col-md-offset-3">
				<button type="submit" class="btn btn-primary btn-lg btn-block">保存修改</button></div>
				<div class="col-md-4" style="margin-top:20px;text-align:right;"><a style="" href="index.html">返回主页</a></div>
			</div>
		
		</div>
	</form>
	</div>

</body>
</html> 
