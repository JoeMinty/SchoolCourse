<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<title>登录</title>
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

		      <ul class="nav navbar-nav navbar-right" id="right-person-info" >
		        <li class="dropdown" id="right-person-info-li">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					<img src="/infocrawler/static/img/pic.jpg"/>
					<span id="user-nickname"><%=(String) session.getAttribute("username")%></span>
		          	<span class="caret"></span>	
		          </a>

		          <!-- 这里需要自己计算高度 -->
		          <ul class="dropdown-menu" id="dropdown-info">
		            <li id="not-last-li">
		            	<a href="/infocrawler/showeditInfo">
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



	<div class="container" style="margin-top:100px;">

		<div class="col-md-8">
			<!--旋转轮播-->
			<div data-ride="carousel" class="carousel slide" id="carousel-container">
				<!--图片容器-->
				<div class="carousel-inner">
					<div class="item">
						<img alt="first"  class="carousel-inner img-responsive img-rounded" src="/infocrawler/static/img/pic02.jpg" style="height:150px;width:100%;"/>
						<div class="carousel-caption">
							<p>我翻过千山万水，蓦然回首，原来你也在这里。</p>
						</div>
					</div>
					<div class="item active">
						<img alt="second"  class="carousel-inner img-responsive img-rounded" src="/infocrawler/static/img/pic03.jpg" style="height:150px;width:100%;">
						<div class="carousel-caption">
							<p>你留一个潇洒的背影，却流泪满面。</p>
						</div>
					</div>
					<div class="item">
						<img alt="third"  class="carousel-inner img-responsive img-rounded" src="/infocrawler/static/img/pic04.jpg" style="height:150px;width:100%;"/>
						<div class="carousel-caption">
							<p>香榭丽舍大道旁的繁华，依然抵不过夜深后，流水的孤寂。</p>
						</div>
					</div>

				</div>
				<!--圆圈指示符-->
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-container"></li>
					<li data-slide-to="1" data-target="#carousel-container" class="active"></li>
					<li data-slide-to="2" data-target="#carousel-container"></li>
				</ol>
				<!--左右控制按钮-->
				<a data-slide="prev" href="#carousel-container" class="left carousel-control">
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a>
				<a data-slide="next" href="#carousel-container" class="right carousel-control">
					<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>

			<div class="col-md-12" id="recommend-article">
				<h4>每日动态</h4>
			</div>
			
			<div class="col-md-12" id="recommend-article-main">
				<div id="article-title">
					<h3>
						<strong><a href="#">并不是有了青楼和镖局，就是江湖。</a></strong>
					</h3>
				</div>
				<div id="article-content">
					<p>并不是有了青楼和镖局，就是江湖。并不是有了青楼和镖局，就是江湖。	并不是有了青楼和镖局，就是江湖。并不是有了青楼和镖局，就是江湖。	并不是有了青楼和镖局，就是江湖。并不是有了青楼和镖局，就是江湖。	并不是有了青楼和镖局，就是江湖。并不是有了青楼和镖局，就是江湖.</p>
				</div>
				<div class="col-md-12" id="article-footer">
					<small>BY：<strong><a href="">Joe</a></strong>
					<span>共有<strong>666</strong>人阅读</span>
					<a id="focus" href="javascript:focusArticle();"><span class="glyphicon glyphicon-heart-empty"></span></a></small>
				</div>
			</div>

			<div class="col-md-12" id="hot-recommend" > 
				<div class="col-md-10" id="day-recommend"><h4>数据库中心</h4></div>
			</div>
			<div class="col-md-12" id="hot-content">
				<div class="col-md-12" id="content-suipian">
					<!--动态的拼写6个div-->
					<!--第一行-->
					<div class="col-md-12">
						<!--左侧-->
						<div class="col-md-4" id="content-suipian-detail">
							<div class="col-md-12">
								<p id="suipian-content">欧洲分子生物学实验室的DNA和RNA序列库</p>
							</div>
							<div class="col-md-12" id="content-suipian-comment"><p><a href="http://www.ebi.ac.uk/embl.html" title="欧洲分子生物学实验室的DNA和RNA序列库"><strong>EMBL</strong></a></p></div>	
						</div>
						<!--中间-->
						<div class="col-md-4" id="content-suipian-detail-middleAndRight">
							
							<div class="col-md-12">
								<p id="suipian-content">美国国家生物技术信息中心（NCBI）所维护的供公众自由读取的、带注释的DNA序列的总数据库</p>
							</div>
							<div class="col-md-12" id="content-suipian-comment"><p><a href="http://www.ncbi.nlm.nih.gov/Web/Genbank/" title="美国国家生物技术信息中心（NCBI）所维护的供公众自由读取的、带注释的DNA序列的总数据库"><strong>GenBank</strong></a></p></div>	
						</div>
						<!--右侧-->
						<div class="col-md-4" id="content-suipian-detail-middleAndRight">
							
							<div class="col-md-12">
								<p id="suipian-content">DNA Databank of Japan(DDBJ)，日本核酸数据库</p>
							</div>
							<div class="col-md-12" id="content-suipian-comment"><p><a href="http://www.ddbj.nig.ac.jp/" title="DNA Databank of Japan(DDBJ)，日本核酸数据库"><strong>DDBJ</strong></a></p></div>	
						</div>
					</div>
					
					<!--第二行-->
					<div class="col-md-12" id="row-2">
						<!--左侧-->
						<div class="col-md-4" id="content-suipian-detail">
							
							<div class="col-md-12">
								<p id="suipian-content">GSDB是由美国国家基因组资源中心（NCGR）维护的DNA序列关系数据库（Genome Sequence DataBase）</p>
							</div>
						<div class="col-md-12" id="content-suipian-comment"><p><a href="http://www.ncgr.org/gsdb/" title="GSDB是由美国国家基因组资源中心（NCGR）维护的DNA序列关系数据库（Genome Sequence DataBase）"><strong>GSDB</strong></a></p></div>
						</div>
						<!--中间-->
						<div class="col-md-4" id="content-suipian-detail-middleAndRight">
							
							<div class="col-md-12">
								<p id="suipian-content">世界上最大的cDNA数据库，还有大量的EST序列和人类基因索引（HGI）</p>
							</div>
							<div class="col-md-12" id="content-suipian-comment"><p><a href="http://www.tigr.org/tdb/hcd/overview.html" title="世界上最大的cDNA数据库，还有大量的EST序列和人类基因索引（HGI）"><strong>TIGR</strong></a></p></div>	
						</div>
						<!--右侧-->
						<div class="col-md-4" id="content-suipian-detail-middleAndRight" >
							
						<div class="col-md-12">
								<p id="suipian-content">DNA Databank of Japan(DDBJ)，日本核酸数据库</p>
							</div>
							<div class="col-md-12" id="content-suipian-comment"><p><a href="#" title="DNA Databank of Japan(DDBJ)，日本核酸数据库"><strong>DDBJ</strong></a></p></div>	
						</div>
					</div>

				</div>
				
			</div>
			
			<div class="col-md-12" id="hot-recommend" > 
				<div class="col-md-10" id="day-recommend"><h4>分析工具</h4></div>
			</div>
			<div class="col-md-12" id="hot-content">
		
				<div class="col-md-12" id="about-article">
					
					<div  class="col-md-12" id="article-title">
						<a href="http://www.ncbi.nlm.nih.gov/dbEST/index.html" class="col-md-8">
							基因组序列信息的提取和分析
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://www.ncbi.nlm.nih.gov/" class="col-md-8">
							功能基因组相关信息分析
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://us.expasy.org/ch2d/" class="col-md-8">
							蛋白质组学相关信息分析
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://www.rcsb.org/pdb/" class="col-md-8">
							大分子结构模拟和药物设计生物信息分析
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://www.girinst.org/" class="col-md-8">
							核酸序列的预测分析--重复序列分析
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://www.ncbi.nlm.nih.gov/BLAST/" class="col-md-8">
							数据库搜索
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://genes.mit.edu/GENSCAN.html" class="col-md-8">
							编码区统计特性分析
						</a>
					</div>
					<div  class="col-md-12" id="article-title">
						<a href="http://www.expasy.ch/tools/" class="col-md-8">
							预测蛋白质的物理性质
						</a>
					</div>
						<div  class="col-md-12" id="article-title">
						<a href="http://www.cmpharm.ucsf.edu/~nomi/nnpredict.html" class="col-md-8">
							蛋白质二级结构预测
						</a>
					</div>
						<div  class="col-md-12" id="article-title">
						<a href="http://www.expasy.ch/swissmod/SWISS-MODEL.html" class="col-md-8">
							蛋白质三维结构预测
						</a>
					</div>
				</div>
			<br/>
			</div>

		</div>


		<!-- 右侧tab -->
		<div class="col-md-4">
			<!--问题广场-->
			<div class="col-md-12" id="right-tips-personal-second">
				<div class="col-md-12" id="right-tips-personal-title">
					<div class="col-md-6"><h4><strong>热门问题</strong></h4></div>
				</div>
				
					<c:forEach var="question" items="${questionInfoList }">
						<div class="col-md-12" id="huati-detail">
						
							<!--标题-->
							<div class="col-md-8" id="huati-title"><a href="/infocrawler/showQuestionDetail?questionid=${question.id}">${question.questionname}</a></div>
							<!--子模块-->
							<div class="col-md-2" id="huati-nums"><span class="badge">${question.answernum}</span></div>
						</div>
					
					</c:forEach>
				
				
		
				
			</div>
			
			<div class="col-md-12" id="right-tips-personal-second">
				<div class="col-md-12" id="right-tips-personal-title">
					<div class="col-md-6"><h4><strong>最新作业</strong></h4></div>
					<div class="col-md-3 col-md-offset-3"><h4><small><a href="/infocrawler/allHomeworks">更多</a></small></h4></div>
				</div>
				
				<c:forEach var="item" items="${homeworklist }">
					<div class="col-md-12" id="huati-detail">
						<!--标题-->
						<div class="col-md-8" id="huati-title">${item.homeworkcontent}</div>
						
					</div>
				</c:forEach>	
			</div>
		</div>

	</div>



		<div id="footer-container" >
				<div class="copy">
					&copy 弓一伦- 2016
				</div>
		</div>

</body>
</html> 
