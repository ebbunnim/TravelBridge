use pjt1db;

SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'pjt1db';
SHOW DATABASES;
SHOW TABLES FROM PJT1DB;

show table status;

show tables;



DROP TABLE FESTIVAL;
DROP TABLE HOTPLACE;
DROP TABLE CITY;
DROP TABLE FILES;
DROP TABLE QNA;
DROP TABLE FAQ;
DROP TABLE LIKES;
DROP TABLE COMMENT;
DROP TABLE POST;
DROP TABLE BOARD;
DROP TABLE FOLLOW;
DROP TABLE MEMBERS;


SELECT * FROM FESTIVAL;
SELECT * FROM HOTPLACE;
SELECT * FROM CITY;
SELECT * FROM FILES;
SELECT * FROM QNA;
SELECT * FROM FAQ;
SELECT * FROM LIKES;
SELECT * FROM COMMENT;
SELECT * FROM POST;
SELECT * FROM BOARD;
SELECT * FROM FOLLOW;
SELECT * FROM MEMBERS;

# MEMBER 테이블
CREATE TABLE MEMBERS (
	mem_no				int	PRIMARY KEY AUTO_INCREMENT,	# 회원 관리번호
	mem_id				varchar( 50) NOT NULL UNIQUE,	# 아이디
	mem_email			varchar(150) NOT NULL UNIQUE,	# 이메일
	mem_phone			varchar( 50) NOT NULL UNIQUE,	# 핸드폰번호
	mem_name			varchar( 50),					# 이름
	mem_sex				int,							# 성별 0: 남 1:여
	mem_birth			date,							# 생년월일
	mem_address			varchar(300),					# 주소
	mem_grant			int default 0,					# 멤버 권한(0:방문자, 1:관리자, 2:팀원)
	mem_receive_email	boolean DEFAULT TRUE,			# 이메일 수신여부
	mem_following		int DEFAULT 0, 					# 팔로잉 수		
	mem_followed		int DEFAULT 0,					# 팔로우 수		
	mem_lastlogin		datetime DEFAULT NOW(),			# 마지막 로그인 시간		
	mem_regtime			datetime DEFAULT NOW(),			# 가입 시간
	mem_interest		varchar(400),					# 관심 카테고리들
	mem_token 			varchar(500), 					# 짧은 로그인처리 토큰 (front에서 자바스크립트 접근제한하는 secure 등 필요)
	mem_login_type 		varchar(10),					# 소셜로그인 종류 0, 1, 2, 3(기본,구글,네이버,깃허브)
	mem_del_check		boolean DEFAULT FALSE			# 삭제여부
);

# 팔로우 테이블
CREATE TABLE FOLLOW (
	follow_no			int PRIMARY KEY AUTO_INCREMENT,	# 팔로우 관리번호	
	follower_no			int	NOT NULL,					# 팔로우 하는 회원	외래키
	following_no		int	NOT NULL, 					# 팔로우 당하는 회원	외래키
    follow_del_check	boolean DEFAULT FALSE,			# 삭제 여부
    FOREIGN KEY(follower_no) REFERENCES MEMBERS(mem_no),
    FOREIGN KEY(following_no) REFERENCES MEMBERS(mem_no)
);

# 게시판 테이블
CREATE TABLE BOARD (
	board_no			int PRIMARY KEY AUTO_INCREMENT,	# 게시판 관리 번호 기본키, 자동증가	
    mem_no				int, 							# 해당 회원의 피드
	board_name			varchar(200) NOT NULL ,			# 게시판 이름(회원아이디로)
    board_del_check		boolean DEFAULT FALSE 			# 게시판 삭제여부
);

# 후기와 일정에 대한 게시물 테이블
CREATE TABLE POST (
	post_no				int PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호	기본키, 자동증가
    post_type			int NOT NULL,					# 후기(사진등 추가) : 0, 일정(양식) : 1 
	board_no			int NOT NULL,					# 게시판 번호	외래키
	mem_no				int NOT NULL,					# 작성자 번호	외래키
	post_title			varchar(200),					# 게시글 제목	
	post_content		varchar(3000),					# 게시글 내용
	post_category		varchar(300),					# 게시글 카테고리, 태그
	post_regtime		datetime DEFAULT NOW(),			# 게시글 작성시간	
	post_hits			int DEFAULT 0,					# 게시글 조회수
    post_city			varchar(500),					# 지역(해시태그) 달기
    post_plan_start		date,							# 일정 시작날짜
    post_plan_end		date,							# 일정 끝 날짜
    post_plan_title		varchar(200),					# 일정 제목
    post_writer			varchar( 50),					# 작성자
    post_del_check		boolean DEFAULT FALSE,			# 삭제 여부
	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
);

# 댓글 테이블
CREATE TABLE COMMENT (
	cmt_no			int PRIMARY KEY AUTO_INCREMENT,	# 댓글 관리번호	기본키, 자동증가
	post_no			int	NOT NULL, 					# 게시물 번호 외래키
	mem_no			int NOT NULL,					# 게시글 작성자 번호 외래키
	cmt_regtime		datetime DEFAULT NOW(),			# 댓글 작성 일시	
	cmt_content		varchar(3000),					# 댓글 내용	
    cmt_writer		varchar( 50),					# 댓글 작성자
    cmt_del_check	boolean DEFAULT FALSE,			# 댓글 삭제 여부
	FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
);

# 좋아요 테이블 
CREATE TABLE LIKES (
	like_no				int PRIMARY KEY AUTO_INCREMENT,	# 좋아요 관리번호	기본키, 자동증가
    like_type			int NOT NULL,					# 좋아요 위치(1:게시물,2:핫플,3:축제)
    post_no				int DEFAULT 0,					# 게시물 번호
    hotplace_no			int DEFAULT 0,					# 핫플 번호
    festival_no			int DEFAULT 0,					# 축제번호
	liker_mem_no		int NOT NULL,					# 좋아요 한 회원 외래키
    like_del_check		boolean DEFAULT FALSE,			# 삭제 여부
    FOREIGN KEY(liker_mem_no) REFERENCES MEMBERS(mem_no)
);

# FAQ 테이블
CREATE TABLE FAQ (
	faq_no		int PRIMARY KEY AUTO_INCREMENT,		# 자주하는 질문 관리번호	기본키, 자동증가
    faq_category varchar(200),						# 질문 카테고리
	faq_question varchar(200),						# 질문 제목
	faq_answer	varchar(3000),						# 답변 내용	
	faq_regtime	datetime DEFAULT NOW(),				# 등록 시간	
    faq_del_check boolean DEFAULT FALSE				# FAQ 삭제 여부
);

# Q&A 테이블
CREATE TABLE QNA (
	qna_no			int PRIMARY KEY AUTO_INCREMENT,	# Q&A 관리번호	기본키, 자동증가
	mem_no			int NOT NULL,					# 질문한 회원 번호	외래키
    qna_category	varchar(200),					# Q&A 카테고리
	qna_title		varchar(200),					# Q&A 질문 제목	
	qna_content		varchar(3000),					# Q&A 질문 내용	
    qna_answer		varchar(3000),					# Q&A 답변 내용
	qna_regtime		datetime DEFAULT NOW(),			# 등록 시간	
	qna_del_check	boolean DEFAULT FALSE,			# Q&A 삭제 여부
    FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
); 

# 파일 테이블
create table FILES(
		files_no int NOT NULL KEY AUTO_INCREMENT,	# 파일 관리 번호
		post_no int NOT NULL,						# 게시물 번호
		mem_no int NOT NULL,						# 게시물 등록 회원 번호 
		files_url varchar(500),			# 파일 경로
		files_del_check boolean DEFAULT FALSE,		# 파일 삭제 여부
    FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
);

# 도시 테이블
create table CITY(
	city_no int NOT NULL KEY AUTO_INCREMENT, 		# 도시 관리번호
    city_name varchar(200) NOT NULL,		 		# 도시 이름
    city_is_overseas boolean NOT NULL,	 	 		# 국내/해외 여부
    city_address varchar(500) NOT NULL, 	 		# 도시 주소 //ex) 대한민국 서울시
    city_img varchar(500),					 		# 도시 이미지
    city_del_check boolean DEFAULT FALSE	 		# 도시 삭제 여부
);
# 여행지 핫플레이스 테이블
create table HOTPLACE(
	hp_no int NOT NULL KEY AUTO_INCREMENT,	# 핫플 관리번호
    city_no int NOT NULL,					# 도시 번호
    hp_name varchar(200) NOT NULL,			# 핫플 이름
    hp_address varchar(200) NOT NULL,		# 핫플 주소 //ex) 서울 강남구
    hp_detail_adr varchar(500) NOT NULL,	# 핫플 상세주소
    hp_content varchar(3000) NOT NULL,		# 핫플 컨텐츠
    hp_tag varchar(1000) 		,			# 핫플 태그
    hp_homepage varchar(500),				# 핫플 홈페이지
    hp_holiday varchar(200),				# 핫플 휴일
    hp_fee varchar(1000),					# 핫플 요금
    hp_img varchar(500),					# 핫플 이미지
    hp_theme varchar(500),					# 핫플 테마
    hp_del_check boolean DEFAULT FALSE,		# 핫플 삭제 여부
	FOREIGN KEY(city_no) REFERENCES CITY(city_no)
);
# 축제 테이블
create table FESTIVAL(
    fval_no int NOT NULL KEY AUTO_INCREMENT,		# 축제 관리번호
    city_no int NOT NULL,							# 도시 번호
    fval_name varchar(200) NOT NULL,				# 축제 명
    fval_address varchar(500) NOT NULL,				# 축제 주소
    fval_detail_adr varchar(500) NOT NULL,			# 축제 상세주소
    fval_content varchar(3000) NOT NULL,			# 축제 컨텐츠
    fval_tag varchar(500),							# 축제 태그
    fval_start_day date,							# 축제 시작일
    fval_end_day date,								# 축제 종료일
    fval_homepage varchar(300),						# 축제 홈페이지
    fval_fee varchar(1000),							# 축제 비용
	fval_img varchar(500),							# 축제 이미지
	fval_host varchar(200),							# 축제 주최자
    fval_theme varchar(500),						# 축제 테마
    fval_ended boolean DEFAULT FALSE,				# 축제 종료여부
    fval_del_check boolean DEFAULT FALSE,			# 축제 삭제 여부
    FOREIGN KEY(city_no) REFERENCES CITY(city_no)
); 

CREATE TABLE CALENDAR (
    _id int NOT NULL KEY AUTO_INCREMENT,		# 캘린더 관리 번호
	title varchar(200) NOT NULL,				# 일정 제목
	description varchar(500) ,					# 일정 메모
	start varchar(100),							# 일정 시작일
	end varchar(100),							# 일정 마감일
	type varchar(100), 							# 일정 카테고리
	mem_no int , 								# 유저번호
    backgroundColor varchar(100),				# 일정 배경색
    textColor varchar(100),						# 폰트 색
    allDay boolean,								# 선택사항
    foreign key(mem_no) REFERENCES MEMBERS(mem_no)
);
SELECT * FROM CALENDAR;

use pjt1db;
SELECT * FROM POST;
DESC MEMBERS;

#(용도) hp, festival 테마, 회원이 가진 태그들, 포스토나 여행정보 보여줄 정형화된 기준 
#맛집 #가족 #데이트 #쇼핑 #문화 #실내 #힐링 #전통      split할것임 

DROP TABLE FOLLOW;
DROP TABLE COMMENT;
DROP TABLE FILES;
DROP TABLE POST;
DROP TABLE LIKES;
DROP TABLE QNA;
DROP TABLE MEMBERS;




