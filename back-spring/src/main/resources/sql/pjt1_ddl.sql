use pjt1db;

DROP TABLE FESTIVAL;
DROP TABLE HOTPLACE;
DROP TABLE CITY;
DROP TABLE FILES;
DROP TABLE QNA;
DROP TABLE FAQ;
DROP TABLE LIKES;
DROP TABLE COMMENT;
DROP TABLE COURSE;
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
SELECT * FROM COURSE;
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
	mem_login_type 		varchar(10) default 0,			# 소셜로그인 종류 0, 1, 2, 3(기본,구글,네이버,카카오)
	mem_del_check		boolean DEFAULT FALSE			# 삭제여부
);

CREATE TABLE FOLLOW (
	follow_no			int PRIMARY KEY AUTO_INCREMENT,	# 팔로우 관리번호	
	follower_no			int	NOT NULL,					# 팔로우 하는 회원	외래키
	following_no		int	NOT NULL, 					# 팔로우 당하는 회원	외래키
    follow_del_check	boolean DEFAULT FALSE,			# 삭제 여부
    FOREIGN KEY(follower_no) REFERENCES MEMBERS(mem_no),
    FOREIGN KEY(following_no) REFERENCES MEMBERS(mem_no)
);
CREATE TABLE BOARD (
	board_no			int PRIMARY KEY AUTO_INCREMENT,	# 게시판 관리 번호 기본키, 자동증가	
	board_name			varchar(200) NOT NULL ,			# 게시판 이름
    board_del_check		boolean DEFAULT FALSE 
);
select following_no from 
members
left join follow on members.mem_no = follow.follower_no
where members.mem_no = 1;
#member가 List로 followerList 있으면 되냐 되겠군a

select * from members 
	where mem_no in (select following_no 
					from members m
					left join follow f on m.mem_no = f.follower_no
					where m.mem_no = 1);

insert into follow(follower_no, following_no) values(1,3);
select * from follow;
# 후기와 일정에 대한 게시물 테이블
# 후기는 다양한 이미지와 긴 글을 작성할 수 있고, 코스를 추가할 수 있다.
# 일정은 시작일과 종료일을 정해서 간단한 메모 형태로 작성할 수 있다.
CREATE TABLE POST (
	post_no				int PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호	기본키, 자동증가
    post_type			int NOT NULL,			# 후기(사진등 추가) : 0, 일정(양식) : 1 
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
    post_del_check		boolean DEFAULT FALSE,			# 삭제 여부
    writer				varchar( 50),					# 작성자
	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no),
    foreign key(writer) references MEMBERS(mem_id)
);

DROP TABLE POST;
DROP TABLE COMMENT;
DROP TABLE FILES;
DROP TABLE COURSE;
DROP TABLE LIKES;
 # 댓글 테이블
CREATE TABLE COMMENT (
	cmt_no			int PRIMARY KEY AUTO_INCREMENT,	# 댓글 관리번호	기본키, 자동증가
	post_no			int	NOT NULL, 					# 게시물 번호 외래키
	mem_no			int NOT NULL,					# 게시글 작성자 번호 외래키
	cmt_regtime		datetime DEFAULT NOW(),			# 댓글 작성 일시	
	cmt_content		varchar(3000),					# 댓글 내용	
    cmt_del_check	boolean DEFAULT FALSE,
    writer			varchar( 50),
	FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no),
    foreign key(writer) references members(mem_id)
);

# 좋아요 테이블
# 게시판의 게시물 또는 댓글에 좋아요를 클릭할 수 있다.
# 좋아요 개수는 각각 조회


drop table likes;
CREATE TABLE LIKES (
	like_no				int PRIMARY KEY AUTO_INCREMENT,	# 좋아요 관리번호	기본키, 자동증가
    post_no				int NOT NUll,					# 게시물 번호
	liker_mem_no		int NOT NULL,					# 좋아요 한 회원 외래키
    like_del_check		boolean DEFAULT FALSE,			# 삭제 여부
	FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(liker_mem_no) REFERENCES MEMBERS(mem_no)
);
select count(*) from likes where post_no = 1;
select * from likes where liker_mem_no = 2;
select * from likes;
insert into likes(post_no, liker_mem_no) values (1,1);

# FAQ 테이블
# 관리자가 만들어둔 게시글들
DROP TABLE FAQ;
CREATE TABLE FAQ (
	faq_no		int PRIMARY KEY AUTO_INCREMENT,		# 자주하는 질문 관리번호	기본키, 자동증가
    faq_category varchar(200),						# 질문 카테고리
	faq_question varchar(200),						# 질문 제목
	faq_answer	varchar(3000),						# 답변 내용	
	faq_regtime	datetime DEFAULT NOW(),				# 등록 시간	
    faq_del_check boolean DEFAULT FALSE				# FAQ 삭제 여부
);
# Q&A 테이블
# 회원들은 질문사항을 남길 수 있다.
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

create table FILES(
	files_no int NOT NULL KEY AUTO_INCREMENT,
    post_no int NOT NULL,				# 게시물 번호
    mem_no int NOT NULL,
    files_url varchar(500) NOT NULL,
    files_del_check boolean DEFAULT FALSE,
    FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
);

# 국내/국외여부, 주소(서울 강남구), 이미지 
create table city(
	city_no int NOT NULL KEY AUTO_INCREMENT, # 도시 관리번호
    city_name varchar(200) NOT NULL,		 # 도시 이름
    city_is_overseas boolean NOT NULL,	 	 # 국내/해외 여부
    city_address varchar(500) NOT NULL, 	 # 도시 주소 //ex) 대한민국 서울시
    city_img varchar(500),					 # 도시 이미지
    city_del_check boolean DEFAULT FALSE	 # 도시 삭제 여부
);
select * from city;
# 이름, 도시번호, 주소, 상세주소, List<이미지>, 
# 컨텐츠, 태그 + api(지도, 리뷰 등), 상세정보(홈페이지, 휴일, 요금, 기타) //운영시간은 거의 없어서 제외하고 기타로 대체
select * from hotplace;

create table hotplace(
	hp_no int NOT NULL KEY AUTO_INCREMENT,	# 핫플 관리번호
    city_no int NOT NULL,					# 도시 번호
    hp_name varchar(200) NOT NULL,			# 핫플 이름
    hp_address varchar(200) NOT NULL,		# 핫플 주소 //ex) 서울 강남구
    hp_detail_adr varchar(500) NOT NULL,	# 핫플 상세주소
    hp_content varchar(3000) NOT NULL,		# 핫플 컨텐츠
    hp_tag varchar(1000) NOT NULL,			# 핫플 태그 (" "로 구분)
    hp_homepage varchar(500),				# 핫플 홈페이지
    hp_holiday varchar(200),				# 핫플 휴일
    hp_fee varchar(2000),					# 핫플 요금
    hp_img varchar(500),					# 핫플 관련 기타사항
    hp_del_check boolean DEFAULT FALSE,		# 핫플 삭제 여부
	FOREIGN KEY(city_no) REFERENCES CITY(city_no)
);


# 축제테이블
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
    fval_fee int DEFAULT 0,							# 축제 비용
	fval_img varchar(500),							# 축제 이미지
	fval_host varchar(200),							# 축제 주최자
    fval_del_check boolean DEFAULT FALSE,			# 축제 삭제 여부
    FOREIGN KEY(city_no) REFERENCES CITY(city_no)
); 

SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PJT1DB';
SHOW DATABASES;
SHOW TABLES FROM PJT1DB;
SHOW TABLE STATUS FROM PJT1DB LIKE 'MEMBER'; 

use pjt1db;

show table status;

show tables;


