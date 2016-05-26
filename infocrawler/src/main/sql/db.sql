##########Joe#########

##安装navicate 8.0 for mysql
##NAVJ-W56S-3YUU-MVHV

CREATE DATABASE teacher_stu,


USE teacher_stu,

CREATE TABLE _teacher (
	id    INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL
)

CREATE TABLE _student (
	id    INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	passwd VARCHAR(100) NOT NULL
)


CREATE TABLE _user (
	id 	     VARCHAR(100) NOT NULL PRIMARY KEY,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	usertype VARCHAR(5) NOT NULL,
)




CREATE TABLE _resoinfo(
	id            INT PRIMARY KEY AUTO_INCREMENT,
	urlname       VARCHAR(100) NOT NULL,
	teachername   VARCHAR(100) NOT NULL,
	teacherid     VARCHAR(100) NOT NULL,
	downloadnum   INT NOT NULL,
	description   NVARCHAR(2000)

)


CREATE TABLE _question(
	id            INT PRIMARY KEY AUTO_INCREMENT,
	questionname  VARCHAR(100) NOT NULL,
	askusername   VARCHAR(100) NOT NULL,
	askuserid     VARCHAR(100) NOT NULL,
	description   NVARCHAR(2000),
	time          VARCHAR(20) NOT NULL
)


CREATE TABLE _homework(
	id            	  	INT PRIMARY KEY AUTO_INCREMENT,
	homeworkcontent   	VARCHAR(500) NOT NULL,
	teacherid     		VARCHAR(100) NOT NULL,
	description   		NVARCHAR(2000),
	time          		VARCHAR(20) NOT NULL
)


CREATE TABLE _answers(
	id            INT PRIMARY KEY AUTO_INCREMENT,
	questionid    VARCHAR(100) NOT NULL,
	answerusername   VARCHAR(100) NOT NULL,
	answers       NVARCHAR(2000),
	time          VARCHAR(20) NOT NULL
)



##############下面的表先不要执行##############

CREATE TABLE _choose(
	id    		INT PRIMARY KEY AUTO_INCREMENT,
	content     VARCHAR(200) NOT NULL,
	result1 	VARCHAR(100) NOT NULL,
	result2 	VARCHAR(100) NOT NULL,
	result3 	VARCHAR(100) NOT NULL,
	result4 	VARCHAR(100) NOT NULL,
	result		VARCHAR(100) NOT NULL,
	tempresult	VARCHAR(100) NOT NULL
)

CREATE TABLE _positive(
	id    		INT PRIMARY KEY AUTO_INCREMENT,
	content     VARCHAR(500) NOT NULL,
	tempresult  VARCHAR(500) NOT NULL
)

CREATE TABLE _exam(
	id    				INT PRIMARY KEY AUTO_INCREMENT,
	studentid			VARCHAR(100) NOT NULL,
	studentname			VARCHAR(100) NOT NULL,
	status				INT NOT NULL,
	choosescore			INT NOT NULL,
	tempresult			VARCHAR(100),
	
	choose1id			INT NOT NULL,
	choose1result 	  	VARCHAR(5),
	choose1realresult   VARCHAR(5),
	
	choose2id			INT NOT NULL,
	choose2result 	  	VARCHAR(5),
	choose2realresult   VARCHAR(5),
	
	choose3id			INT NOT NULL,
	choose3result 	  	VARCHAR(5),
	choose3realresult   VARCHAR(5),
	
	
	choose4id			INT NOT NULL,
	choose4result 	  	VARCHAR(5),
	choose4realresult   VARCHAR(5),
	
	choose5id			INT NOT NULL,
	choose5result 	  	VARCHAR(5),
	choose5realresult   VARCHAR(5),
	
	choose6id			INT NOT NULL,
	choose6result 	  	VARCHAR(5),
	choose6realresult   VARCHAR(5),
	
	choose7id			INT NOT NULL,
	choose7result 	  	VARCHAR(5),
	choose7realresult   VARCHAR(5),
	
	choose8id			INT NOT NULL,
	choose8result 	  	VARCHAR(5),
	choose8realresult   VARCHAR(5),
	
	positive1id			INT NOT NULL,
	positive1result		VARCHAR(2000),
	positive1score		INT NOT NULL,
	
	positive2id			INT NOT NULL,
	positive2result		VARCHAR(2000),
	positive2score		INT NOT NULL
	
)

