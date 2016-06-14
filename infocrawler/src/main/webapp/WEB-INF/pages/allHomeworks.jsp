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
				showMsg();
			});
			function init(){
				var usertype = "<%=session.getAttribute("usertype")%>";
				if(usertype == "T"){
					$("#onlineExam").css("display","none");
					$("#downRes").css("display","none");
					$("#upWork").css("display","none");
					$("#uploadWork").css("display","none");
				}else{
					$("#postWork").css("display","none");
					$("#upRes").css("display","none");
				}
				var msgcount = "<%=session.getAttribute("msgcount")%>";
				if(msgcount == ""){
					$("#msgcount").css("display","none");
				}
			}
	
			function showMsg(){
				if("${msg}"!=''){
					$('#msgModal').modal('show');
					}
			}
	</script>
</head>
<body>

<div id="msgModal" class="modal fade" tabindex="-1" role="dialog"
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
	
	
	<div class="modal fade" id="myModal" tabindex="-1"  role="dialog" aria-labelledby="gridSystemModalLabel">
	 <form action="/infocrawler/addHomework" method="post" role="form"  accept-charset="utf-8">
      <div class="modal-dialog" role="document">
    	<div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">发起作业</h4>
	      </div>
	      <div class="modal-body">
	        <div class="container-fluid">
	        
	         	 <div class="form-group col-md-12">
					<input type="text" class="form-control" name="homeworkcontent"  placeholder="作业">
				 </div>
	         
		         <div class="form-group col-md-12" style="padding-left:0;margin-left:0;">
					<textarea class="form-control" name="description" rows="3" placeholder="详细描述"></textarea>								
				 </div>
	     	
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="submit" class="btn btn-primary">保存</button>
	      </div>
    	</div><!-- /.modal-content -->
     	 </div><!-- /.modal-dialog -->
     	  </form>
    </div><!-- /.modal -->
    
    	<div class="modal fade" id="myModal1" tabindex="-1"  role="dialog" aria-labelledby="gridSystemModalLabel">
	 <form action="/infocrawler/uploadHomework" method="post" role="form"  accept-charset="utf-8">
      <div class="modal-dialog" role="document">
    	<div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">上传作业</h4>
	      </div>
	      <div class="modal-body">
	        <div class="container-fluid">
	        
					<input type="file" class="form-control" name="homeworkcontent"  placeholder="作业">
	         
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="submit" class="btn btn-primary">保存</button>
	      </div>
    	</div><!-- /.modal-content -->
     	 </div><!-- /.modal-dialog -->
     	  </form>
    </div><!-- /.modal -->
	
	

<div class="container" style="margin-top:80px;">
				<div id="fm-main">
					<form class="col-md-12"> 
						<div class="col-md-12" id="pianke-content-detail" style=
						"padding: 0;border-bottom:1px solid #ddd;margin-top:10px;">
							<div class="col-md-12" style="font-size:24px;">
								<p class="col-md-10">
									 <i class="fa fa-quote-left"></i>
										<strong>作业中心</strong>
								</p>
								<p class="col-md-2" id="postWork">
									 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  												发起作业
									</button>
								</p>
								<p class="col-md-2" id="uploadWork">
									 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">
  												上传作业
									</button>
								</p>
							</div>
						</div>


					<div>
						<table class="table table-condensed">
						   <thead>
						      <tr>
						         <th>作业</th>
						         <th>详细说明</th>
						         <th style="text-align: center">时间</th>
						         <th>发起老师</th>
						      </tr>
						   </thead>
						   <tbody>
						   		<c:forEach var="item" items="${homeworkList }">
									 <tr>
								         <td><a href="#">${item.homeworkcontent}</a></td>
								         <td>${item.description}</td>
								         <td style="text-align: center">${item.time}</td>
								         <td>${item.teachername}</td>
						     		 </tr>
						  	 	 </c:forEach>	
						   </tbody>
						</table>
					</div>
					

					</form>
				</div>
			</div>

	
</body>
</html>
