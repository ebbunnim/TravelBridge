use pjt1db;

DROP TABLE FESTIVAL;
DROP TABLE CITY_LAYER_BOTTOM;
DROP TABLE CITY_LAYER_MID;
DROP TABLE CITY_LAYER_TOP;
DROP TABLE FILES;
DROP TABLE BLAME;
DROP TABLE QNA;
DROP TABLE FAQ;
DROP TABLE LIKES;
DROP TABLE COMMENT;
DROP TABLE COURSE;
DROP TABLE POST;
DROP TABLE BOARD;
DROP TABLE FOLLOW;
DROP TABLE MEMBER;

# MEMBER 테이블
CREATE TABLE MEMBER (
	mem_no				int	PRIMARY KEY AUTO_INCREMENT,	# 회원 관리번호
	mem_id				varchar( 50) NOT NULL UNIQUE,	# 아이디
	mem_email			varchar(150) NOT NULL UNIQUE,	# 이메일
	mem_password		varchar(500) NOT NULL ,			# 패스워드
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
    FOREIGN KEY(follower_no) REFERENCES MEMBER(mem_no),
    FOREIGN KEY(following_no) REFERENCES MEMBER(mem_no)
);


CREATE TABLE BOARD (
	board_no			int PRIMARY KEY AUTO_INCREMENT,	# 게시판 관리 번호 기본키, 자동증가	
	board_name			varchar(200) NOT NULL ,			# 게시판 이름
    board_del_check		boolean DEFAULT FALSE
);
# 후기와 일정에 대한 게시물 테이블
# 후기는 다양한 이미지와 긴 글을 작성할 수 있고, 코스를 추가할 수 있다.
# 일정은 시작일과 종료일을 정해서 간단한 메모 형태로 작성할 수 있다.
CREATE TABLE POST (
	post_no				int PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호	기본키, 자동증가
    post_type			int NOT NULL DEFAULT 0,			# 후기(사진등 추가) : 0, 일정(양식) : 1 
	board_no			int NOT NULL,					# 게시판 번호	외래키
	mem_no				int NOT NULL,					# 작성자 번호	외래키
	post_title			varchar(200),					# 게시글 제목	
	post_content		varchar(3000) NOT NULL,			# 게시글 내용	
	post_category		varchar(300),					# 게시글 카테고리, 태그
	post_regtime		datetime DEFAULT NOW(),			# 게시글 작성시간	
	post_hits			int DEFAULT 0,					# 게시글 조회수	
	post_secret			boolean DEFAULT FALSE,			# 비밀 게시글 여부	
	post_notice			boolean DEFAULT FALSE,			# 공지사항 여부	
    post_start_day		date,							# 일정 시작날짜
    post_end_day		date,							# 일정 끝 날짜
    post_plan			varchar(300),					# 일정 간단한 메모내용
    post_del_check		boolean DEFAULT FALSE,			# 삭제 여부
	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
);
 
 # 코스 테이블
 # 후기 게시물에 추가되는 코스로 장소명과 간단한 설명에 대해서 작성 할 수 있고, 한 게시물에 여러개가 추가될 수 있다.
CREATE TABLE COURSE (
	course_no			int PRIMARY KEY AUTO_INCREMENT,	# 후기에 갔던 장소들 번호 기본키, 자동증가
    post_no				int NOT NULL,					# 참조하는 게시물 번호
    course_spot			varchar(1000),					# 장소명들을 직접 받아서 스트링 형태로 저장 ,로 구분하자. 
    course_del_check	boolean DEFAULT FALSE,			# 삭제 여부
    FOREIGN KEY(post_no) REFERENCES POST(post_no) 
);

 # 댓글 테이블
CREATE TABLE COMMENT (
	cmt_no			int PRIMARY KEY AUTO_INCREMENT,	# 댓글 관리번호	기본키, 자동증가
	board_no		int NOT NULL,					# 게시판 번호 외래키
	post_no			int	NOT NULL, 					# 게시물 번호 외래키
	mem_no			int NOT NULL,					# 게시글 작성자 번호 외래키
	cmt_regtime		datetime,						# 댓글 작성 일시	
	cmt_parent		int DEFAULT NULL,				# 기본 댓글은 부모가 없고, 대댓글들은 부모 번호 존재 //댓글에 댓글을 다는 버튼이면 해당 댓글번호 넣기
	cmt_secret		boolean DEFAULT FALSE,			# 비밀 댓글 여부		
	cmt_title		varchar(200),					# 댓글 제목	
	cmt_content		varchar(3000),					# 댓글 내용	
    cmt_del_check	boolean DEFAULT FALSE,
	FOREIGN KEY(post_no) REFERENCES POST(post_no),
	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
);

# 좋아요 테이블
# 게시판의 게시물 또는 댓글에 좋아요를 클릭할 수 있다.
# 좋아요 개수는 각각 조회

CREATE TABLE LIKES (
	like_no				int PRIMARY KEY AUTO_INCREMENT,	# 좋아요 관리번호	기본키, 자동증가
    board_no			int NOT NULL,					# 게시판 위치 
    post_no				int NOT NUll,					# 게시물 번호
    cmt_check			boolean not null,				# 댓글 여부 (게시물이면 false, 댓글이면 true)
	cmt_no				int	default 0,					# 댓글 번호 (댓글이면 해당 번호 삽입)
	liker_mem_no		int NOT NULL,					# 좋아요 한 회원	외래키
	liking_mem_no		int NOT NULL,					# 좋아요 당한 회원	외래키
    like_del_check		boolean DEFAULT FALSE,			# 삭제 여부			
    FOREIGN KEY(board_no) REFERENCES BOARD(board_no), 
	FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(liker_mem_no) REFERENCES MEMBER(mem_no),
    FOREIGN KEY(liking_mem_no) REFERENCES MEMBER(mem_no)
);


# FAQ 테이블
# 관리자가 만들어둔 게시글들
CREATE TABLE FAQ (
	faq_no		int PRIMARY KEY AUTO_INCREMENT,		# 자주하는 질문 관리번호	기본키, 자동증가
	faq_title	varchar(200),						# 질문 제목	
	faq_content	varchar(3000),						# 질문 내용	
	faq_answer	varchar(3000),						# 답변 내용	
	faq_hits	int DEFAULT 0,						# 조회 수	
	faq_regtime	datetime DEFAULT NOW(),				# 등록 시간	
    faq_del_check boolean DEFAULT FALSE				# FAQ 삭제 여부
);

# Q&A 테이블
# 회원들은 질문사항을 남길 수 있다.
CREATE TABLE QNA (
	qna_no			int PRIMARY KEY AUTO_INCREMENT,	# Q&A 관리번호	기본키, 자동증가
	mem_no			int NOT NULL,					# 질문한 회원 번호	외래키
	qna_title		varchar(200),					# Q&A 질문 제목	
	qna_content		varchar(3000),					# Q&A 질문 내용	
	qna_hits		int DEFAULT 0,					# 조회수	
	qna_regtime		datetime DEFAULT NOW(),			# 등록 시간	
	qna_secret		boolean DEFAULT FALSE,			# 비밀 게시글 여부
	qna_del_check	boolean DEFAULT FALSE,			# Q&A 삭제 여부
    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
);
# 신고테이블
# 이건 게시물이랑 같이 봐야할 것 같은데 미사용 형태로 두고 쓸 때 개선
CREATE TABLE BLAME (
	blame_no		int PRIMARY KEY AUTO_INCREMENT,	#신고 관리번호	기본키,자동증가
	mem_no			int NOT NULL,					#신고한 회원번호	외래키
	target_mem_no	int NOT NULL,					#신고당한 회원번호	외래키
	blame_time		datetime DEFAULT NOW(),			#신고 일시	
    blame_del_check	boolean DEFAULT FALSE,			#신고 삭제 여부
	FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no),
	FOREIGN KEY(target_mem_no) REFERENCES MEMBER(mem_no)
);
#post_no or cmt_no
create table FILES(
	files_no int NOT NULL KEY AUTO_INCREMENT,		# 파일 관리번호 기본키, 자동증가
	post_no int NOT NULL,							# 게시물 번호
	files_name varchar(200) NOT NULL,				# 파일 이름
	files_thumbnail boolean,						# 파일 썸네일 여부
	files_url varchar(500) NOT NULL, 				# 파일 경로
    files_del_check boolean DEFAULT FAlSE, 			# 파일 삭제 여부
	FOREIGN KEY(post_no) REFERENCES POST(post_no)
);


#대도시 테이블
#핫플들과 중간규모의 도시들을 모두 포함하는 대형 도시
create table CITY_LAYER_TOP(
	clt_no int NOT NULL KEY AUTO_INCREMENT,			# 대도시 관리번호
    clt_name varchar(200) NOT NULL,					# 대도시 명
    clt_address varchar(500) NOT NULL,				# 대도시 주소
    clt_img varchar(500),							# 대도시 이미지
    clt_content varchar(3000) NOT NULL,				# 대도시 컨텐츠
    clt_type int NOT NULL,							# 대도시 타입 EX) 서울광역시/경기도/섬/해외
    clt_del_check boolean DEFAULT FALSE				# 대도시 삭제여부
);
# 중도시 테이블
# 핫플들을 포함하는 중간 형태의 도시
create table CITY_LAYER_MID(
	clm_no int NOT NULL KEY AUTO_INCREMENT,			# 중도시 관리번호
    clt_no int NOT NULL,							# 대도시 번호
    clm_name varchar(200) NOT NULL,					# 중도시 명
    clm_address varchar(500) NOT NULL,				# 중도시 주소
    clm_img varchar(500),							# 중도시 이미지
    clm_content varchar(3000) NOT NULL,				# 중도시 컨텐츠
    clm_type int NOT NULL,							# 중도시 타입 EX) 시, 제주도, 서울의 동네 
    clm_character varchar(500),						# 중도시 특징
    clm_subtitle varchar(200),						# 중도시 별명
    clm_del_check boolean DEFAULT FALSE,			# 중도시 삭제여부
    FOREIGN KEY(clt_no) REFERENCES CITY_LAYER_TOP(clt_no)
);
# 소도시 테이블
# 핫플위주
create table CITY_LAYER_BOTTOM( 
	clb_no int NOT NULL KEY AUTO_INCREMENT,			# 소도시 관리번호
    clm_no int NOT NULL,							# 중도시 번호
    clb_name varchar(200) NOT NULL,					# 소도시 명
    clb_address varchar(500) NOT NULL,				# 소도시 주소
	clb_img varchar(500),							# 소도시 이미지
    clb_content varchar(3000) NOT NULL,				# 소도시 컨텐츠
    clb_tag varchar(500),							# 소도시 태그
    clb_character varchar(500),						# 소도시 특징
    clb_subtitle varchar(200),						# 소도시 별명
    clb_fun varchar(200),							# 소도시 재미요소
    clb_spot varchar(500),							# 소도시 핫플 위치
    clb_del_check boolean DEFAULT FALSE,			# 소도시 삭제 여부
	FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)
);

# 축제테이블
create table FESTIVAL(
    fval_no int NOT NULL KEY AUTO_INCREMENT,		# 축제 관리번호
    clm_no int NOT NULL,							# 중도시 번호
    fval_name varchar(200) NOT NULL,				# 축제 명
    fval_address varchar(500) NOT NULL,				# 축제 주소
    fval_img varchar(500),							# 축제 이미지
    fval_content varchar(3000) NOT NULL,			# 축제 컨텐츠
    fval_tag varchar(500),							# 축제 태그
    fval_start_day date,							# 축제 시작일
    fval_end_day date,								# 축제 종료일
    fval_fee int DEFAULT 0,							# 축제 비용
    fval_map_img varchar(500),						# 축제 지도이미지
    fval_homepage varchar(300),						# 축제 홈페이지
    fval_host varchar(200),							# 축제 주최자
    fval_del_check boolean DEFAULT FALSE,			# 축제 삭제 여부
    FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)
); 


SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PJT1DB';
SHOW DATABASES;
SHOW TABLES FROM PJT1DB;
SHOW TABLE STATUS FROM PJT1DB LIKE 'MEMBER'; 

use pjt1db;

show table status;

show tables;

DESC blame;
DESC board;
DESC city_layer_bottom;
DESC city_layer_mid;
DESC city_layer_top;
DESC comment;
DESC course;
DESC faq;
DESC festival;
DESC files;
DESC follow;
DESC likes;
DESC member;
DESC post;
DESC qna;

