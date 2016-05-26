<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<title>登录</title>
		<link rel="stylesheet" href="/infocrawler/static/bootstrap-3.3.6/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="/infocrawler/static/font-awesome/font-awesome.css" />
		<link rel="stylesheet" href="/infocrawler/static/css/login.css">
		<script type="application/javascript" src="/infocrawler/static/jquery-1.12.3.min.js"></script>
		<script type="application/javascript" src="/infocrawler/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
		<script>
			$(document).ready(function() {
				resize();
				hideDangerInfo();
				init();

				$("#regist button").click(function(event) {//创建事件对象
					var flag = showDangerInfo("regist");
					if (!flag) {
						event.preventDefault();//阻止默认事件
					}
				});
				
				$("#login button").click(function(event) {
					var flag = showDangerInfo("login");
					if (!flag) {
						event.preventDefault();
					}
				});

				showMsg();
			});

			function showMsg(){
				if("${msg}"!=''){
					$('#myModal').modal('show');
					}
			}
		
			// 后续屏幕大小切换通过方法计算页面布局
			function resize() {
				// TODO
			}
		
			// 页面刚加载时隐藏错误信息提示
			function hideDangerInfo() {
				$("#userInfo").css('display', 'none');
				$("#emailInfo").css('display', 'none');
				$("#passwordInfo").css('display', 'none');
				$("#login-emailInfo").css('display', 'none');
				$("#login-passwordInfo").css('display', 'none');
			}
		
			// 秋哥处理下，提示信息可以自己修改，前面我写死了。
			function showDangerInfo(type) {
				//判断是否通过验证标志，默认通过验证
				var flag = true;
				if (type == 'regist') {
					var username = $("#username").val();
					if (username == '') {
						$("#userInfo").html("姓名不能为空哦！").css('display', 'block');
						flag = false;
					}
					var email = $("#email").val();
					if (email == '') {
						$("#emailInfo").html("工号不能为空哦！").css('display', 'block');
						flag = false;
					}
					var password = $("#password").val();
					if (password == '') {
						$("#passwordInfo").html("密码不能为空哦！").css('display', 'block');
						flag = false;
					}
					return flag;
				} else {
					var email = $("#login-email").val();
					if (email == '') {
						$("#login-emailInfo").html("邮箱不能为空哦！").css('display', 'block');
						flag = false;
					}
					var password = $("#login-password").val();
					if (password == '') {
						$("#login-passwordInfo").html("密码不能为空哦！").css('display',
								'block');
						flag = false;
					} 
					return flag;
				}
			}
			
			
		</script>
	</head>
	<body>
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
	<div class="container">
			<div class="content">

			<!-- 左侧图片,这边最好能做随机生成一张图片展示 -->
			<div class="col-md-6">
				<img src="/infocrawler/static/img/pic01.jpg" class="img-responsive" alt="我不愿让你一个人" id="img-change">
			</div>

			<!-- 右侧登录栏-->
			<div class="col-md-6" id="right-content">
				<div class="col-md-8 col-md-offset-2" id="right-content-tab">
					<ul class="nav nav-tabs center text-center">
						<li class="col-md-6"><a href="#regist" data-toggle="tab"><b>注册</b></a></li>
						<li class="col-md-6 active"><a href="#login" data-toggle="tab"><b>登录</b></a></li>
					</ul>
				</div>
					
					<div class="tab-content">
						<!-- 注册 -->
						<div class="tab-pane" id="regist">
							<form class="col-md-6 col-md-offset-3" action="/infocrawler/regist" method="post">
								<div class="form-group has-feedback">
								 	<span class="glyphicon glyphicon-user form-control-feedback"></span>
								 	<input type="text" class="form-control" name="username" id="username" placeholder="用户名">
								 	<p class="text-danger" id="userInfo">用户名不能为空！</p>
								</div>

								<div class="form-group has-feedback">
								 	<span class="glyphicon glyphicon-heart form-control-feedback"></span>
								 	<input type="text" class="form-control" name="userid" id="userid" placeholder="工号">
								 	<p class="text-danger" id="emailInfo">工号不能为空！</p>
								</div>

								<div class="form-group has-feedback">
								  	<input type="password" class="form-control" name="password" id="password" placeholder="密码">
								  	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								  	<p class="text-danger" id="passwordInfo">密码不能为空！</p>
								</div>
								
								<div class="form-group has-feedback">
								  	<label class="radio-inline">
									   <input type="radio" name="usertype" id="inlineRadio1" value="S"> 学生
									</label>
									<label class="radio-inline">
									   <input type="radio" name="usertype" id="inlineRadio2" value="T"> 教师
									</label>
								</div>
								
								<div class="center-block">
								 	<button type="submit" class="btn btn-primary btn-block">注册</button>
								</div>
							</form>
						</div>
					    
						<!-- 登录 -->
					    <div class="tab-pane in active" id="login">
					    	<form  class="col-md-6 col-md-offset-3" action="/infocrawler/login" method="post">
								<div class="form-group has-feedback">
								 	<span class="glyphicon glyphicon-user form-control-feedback"></span>
								 	<input type="text" name="id" class="form-control" id="login-email" placeholder="工号">
								 	<p class="text-danger" id="login-emailInfo">工号不能为空！</p>
								</div>
								<div class="form-group has-feedback">
								  	<input type="password" name="password" class="form-control" id="login-password" placeholder="密码">
								  	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								  	<p class="text-danger" id="login-passwordInfo">密码不能为空！</p>
								</div>
								<div class="center-block">
								 	<button type="submit" class="btn btn-primary">登录</button>
								 	<a id="forget" href="">忘记密码</a>
								</div>
							</form>
					    </div>
					</div>
			</div>
		</div>
		</div>
	</body>
</html>