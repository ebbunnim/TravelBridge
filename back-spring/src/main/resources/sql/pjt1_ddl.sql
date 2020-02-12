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
	mem_login_type 		varchar(10),					# 소셜로그인 종류 0, 1, 2, 3(기본,구글,네이버,깃허브)
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

# 물어보기
# mem_no을 넣은거임?

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



INSERT INTO MEMBERS 
	(mem_id, mem_email, mem_phone, mem_name, mem_grant, mem_interest, mem_login_type)
VALUES 
	("merung","merung@hanmail.net","010-5434-3422","이주연",0,"#음식#쇼핑#체험","기본"),
	("abcd","abcd@naver.com","010-2323-1441","김한식",1,"#역사#관광지#자연","네이버"),
	("forcetome","forcetome@gmail.com","010-4442-2223","이준석",0,"#실내여행지","깃허브"),
	("babe","babe@gmail.com","010-3422-3444","장준민",0,"#관광지#체험#레포츠","구글"),
	("dksi","dksi@naver.com","010-4532-3333","선민수",1,"#음식#역사","네이버"),
	("여행덕후","crazy@gmail.com","010-5567-3242","한경찰",1,"#역사#쇼핑","기본"),
	("내가짱임","best@hanmail.net","010-2321-2135","인선민",0,"#관광지#체험","기본"),
	("여행마스터","master@gmail.com","010-5632-2222","신민선",0,"#쇼핑#체험#문화시설","깃허브"),
	("용이뿐님","ssss@gmail.com","010-2342-1111","이두나",1,"#쇼핑#자연#관광지","구글"),
	("nullid","nurdy@naver.com","010-3226-6666","육설재",1,"#문화시설","네이버")
;
SELECT * FROM MEMBERS;


INSERT INTO FOLLOW
(follower_no, following_no)
VALUES
	(1, 10),
    (2,4),
    (4,2),
    (3,9),
    (5,7),
    (7,9),
    (2,4),
    (2,8),
    (2,6),
    (6,2)
;
SELECT * FROM FOLLOW;


INSERT INTO BOARD
(board_name)
VALUES
	("함께 쓰는 다이어리"),
    ("플래너")
;
SELECT * FROM BOARD;


INSERT INTO POST
(post_type, board_no, mem_no, post_title, post_content, post_category, post_city, post_hits, post_regtime)
VALUES
(0, 1,10,"2020 얼음나라 화천산천어축제 제대로 즐기는 TIP","
겨울 축제는 아이들의 방학 문제로 보통 1월에 집중적으로 열립니다. 
축제에 참여하는 사람들이 가족단위인 경우가 많다보니 주로 1월에 개최하는 것입니다. 
1월에 열리는 축제의 주요 테마는 '물고기'입니다. 지방축제가 본격적으로 시작된 1990년대에는 
겨울축제의 테마로 주로 눈(snow)과 등산을 선택했다면 2000년대 이후에는 단연 어류가 돋보이고 있습니다. 
얼음나라 화천산천어축제는 세계 4대 겨울 축제의 하나로 이름을 올릴 정도로 큰 성공을 올리고 있는 겨울축제입니다. 
토종물고기인 산천어 자체에 차별성이 있기도 하고 축제 내부적으로 주민들의 
참여 및 협조가 잘 되고 있다는 점이 축제가 크게 성공할 수 있었던 길인 것 같습니다. ",
"#취미#레저","#강원도",432,"2020-01-10 10:40:33"),
( 0, 1, 1, "인천 여행코스 송월동 동화마을 역대 최고 규모의 벽화마을",
"수십 년 전로 담벼락에 색칠을 하여 동화마을로 변화하였다.가끔 형을 따라서 이곳저곳 몇몇 벽화마을 찾아가 봤지만 인천 송월동 동화마을 만큼 큰 규모를 보지 못했습니다.
아니 그 반도 안되는 곳들이 대부분인데요 많은 사람들이 이곳을 인천 여행코스 라고 이야기하는 이유를 느낄 수 있었고
애인이 있었다면 꼭 한 번 데리고 갔을 것 같은 장소로 연인들의 기념사진 촬영하기 딱 적당한 장소였답니다",
"#인문#교양","#인천", 100, "2019-01-02 8:12:22"),
(0, 1, 3,"그렇게 가보고 싶던 담양, 죽녹원 & 메타세콰이어길에 가다!",
"게스트하우스에서 나와 311번 버스를 타고 도착한 죽녹원. 
네이버 지도가 알려준 시간보다 훨씬 빨리 도착했다. 
어제 먹은 술 해장도 할겸 밥을 먹으려 돌아다니는데 담양하면 하도 
떡갈비라고 들어서 주변 떡갈비집을 찾아봤다. 
1인분만 되는 떡갈비집을 다행히도 찾았고 먹었다! 
죽통밥을 다 먹고 나니 사장님께서 기념으로 가져갈 수 있다며 봉지 드릴까요? 
하시기에 얼떨결에 받아왔다는 이야기ㅎㅎ 담양국수거리도 바로 앞이라 국수도 먹고 싶었지만 
혼자 여행의 최대 단점. 여러 가지 다양하게 먹을 수가 없다. 다음에 날 따뜻해지면 다시 갈거니까 그 땐 국수 먹어야징!",
"#미식#교양","#전라남도",87, "2019-12-24 12:00:11"),
(0, 1, 4,"춘천 애니메이션박물관 + 토이로봇관",
"춘천갈까 말까 했었는데 춘천시는 미세먼지가 양호하다는 뉴스를 보고
몇일 지겨웠던 미세먼지 심각에서 잠시나마 벗어나고자 피할려고 강원도로 방향을 틀었다.
일단 강원도로 오니 공기부터가 일단 다르다. 너무 늦게 출발해서 너무 늦게 도착했더니
여러군데 들릴 수가 없을 것 같았다.  
1군데만 들린다면 ...이왕 아이들 때문에 나왔으니 아이 중심으로 가자고 했던 곳이 여기 애니메이션박물관이다.
생각보다 넓은 규모에 시설이 잘 되어 있어서 좋았다. 
무엇보다도 봄날씨에 파란하늘이 마음을 더 들 뜨게 한다.
춘천...사실 그리 먼거리는 아니지만 2시간 정도 ...이래저래 쉬엄쉬엄 오면
왕복 4~5시간....자주 오기에는 조금 부담스럽긴 하다.
늦게 도착해서 그냥 애니메이션박물관만 구경만 하는게 더 좋을 법도 했는데 이왕 왔으니 토이로봇관이랑 애니메이션박물관
두군데 볼 수 있는 티켓을 구매했다. 춘천시민은 절반 가격이니....
춘천으로 이사와야 겠다. ㅋㅋ",
"#인문#교양#미식","#강원도",2,"2019-01-19 9:10:01"),
(0, 1, 2,"광주 패밀리랜드 눈썰매장 ! 광주 놀거리",
"2주전에 남친과 초등학교 이후로 안가본 눈썰매장을 갔어요!
근데 정말 상당히 재밌더라구요! 사람 많은거 빼구.. 표는 티몬에서 구매했어요!
놀이기구 5종 , 열차 , 눈썰매장! 까지 해서 한 사람당 16,000원이였던거같아요!
놀이기구도 많이타고 썰매도 타고싶으신분들은
그냥 매표소 가서 자유이용권,눈썰매장 이렇게 끊으셔도 될거같아요
자유이용권,눈썰매장 이렇게 21,000원이세요!
근데 자유이용권은 반드시 할인카드가 있어야해요!
저도 자세한 할인카드는 잘 몰라서..ㅎㅎ
추워서 놀이기구 별로 안탈줄알았는데 재밌더라구요~
남친님과 후회했어요!
한번 패밀리랜드 눈썰매장 가보세요~ 괜찮아요! 주차장도 넓구!
물론 주차비가 별도로 나갑니다. 저희는 1,000원 들었어요! ㅎㅎ
앞으로 가실 분들은 참고하세요!!! ㅎㅎ 끄읕~",
"#레저","#광주",30,"2020-01-11 01:33:21" ),
(0, 1, 6 ,"부산 먹거리 여행 명소, 부평깡통시장 야시장",
"이곳이 깡통시장인 이유는 6.25 때 미군부대에서 나온 캔 같은 깡통 제품을 많이 팔았기 때문이라고 한다. 이곳은 밤에 운영하는 야시장이 유명하다. 
야시장 운영 시간은 19:30 ~ 23:00이다. 
시장 골목의 한 곳에 갖가지 먹거리 부스들이 한 줄로 늘어서 있다. 
약 110m 거리에 30개 정도의 노점이 운영되고 있다고 한다. 음식들은 맛이 있다.
비주얼도 좋아서 눈으로 보면 다 먹고 싶을 정도이다. 
인기가 있는 몇 군데는 줄도 길게 서 있다. 구매하면 거의 서서 먹어야 한다. 
군데군데 서서 먹을 수 있는 스탠딩 테이블이 놓여 있긴 한데 사람 수가 더 많다. 
쓰레기통도 많이 비치되어 있기 때문에 다 먹고 쓰레기를 어떻게 해야 할지 걱정할 필요는 없다.
아, 현지인에게 물어보니 유부주머니를 꼭 먹어보라고 하던데 경황이 없어서 먹어보지 못했다.",
"#미식#취미","#부산",101,"2019-09-01 01:33:21"),
(0, 1, 7,"강화석모도 미네랄 온천 ;족욕",
"족욕하는 다른 곳이 공사중으로 문을 닫아 미네랄 온천 무료 족욕.
오전 시간이었는데도 대기 번호 100번이 넘는... 오픈 했을때 배타고 들어 올때는 이렇게 밀리지 않았는데
석모대교 개통이후에는 사람이 많아 입장하기가 쉽지 않다. 새벽에 와야 할 듯 하다^^~",
"#레저#취미#교양","#인천",2,"2020-01-27 21:08:01" ),
(0, 1,4,"울산 자수정동굴나라 및 보트체험 후기!",
"울산 여행의 마지막을 장식하는 곳으로 울산에 유명한 자수정동굴나라를 다녀왔습니다.
마침 대구 가는길에 있는곳이기도 하지만 큰 기대는 하지 않았습니다. 전날 숙박업소에서 워낙 기분이 안좋은것도 있었지만...
다만 울산 자수정동굴나라에서 공연한다는건 한번 보고 싶었죠.
얼핏 다른 블로그에서 울산 자수정동굴나라 공연하는 모습을 잠시봤는데 재미있는것 같더라고요.
그래서 공연은 꼭 한번 보고 싶었죠.
울산 자수정동굴나라만 관람하는것은 7천원이고 보트까지 같이 체험하는것은 합쳐서 12000원이라
동굴+보트 둘이 같이 해서 관람료를 냈습니다.
전날 네이버에서 표를 예약하면 천원정도 할인되니 참고 하시길 바랍니다
(당일은 안됩니다.) 자수정동굴나라 보기전에 먼저 보트를 타시면됩니다.
보트를 타는 입구에 가면 구명조끼를 입고 보트를 타고 출발하게되는데
안에 날씨가 밖에보다 훨씬 낮긴합니다.
물은 진한 회색에 가까운편이고 보트를 타고 볼수 있는건 그냥 불빛에 비춰지는 동굴정도라고
생각하시면될겁니다. 크게 확 와~ 하고 그러는건 없습니다.
보트 관람자체는 솔직히 금방 끝나는편입니다.
한 5분? 조금 넘는시간이였던것 같네요 보트로 슝슝~ 가다보니 금방 끝납니다.
자수정 동굴나라 입구쪽에 원래 매표소가 있는데 보트를 타는곳에 나중에 보니 
자수정동굴나라 공연시간과 결제하는기계가 있더군요.
자수정동굴나라 공연은 오복학춤 정종수(그냥 장기자랑같은;;)
필리핀판타스틱 아크로바트 공연단(이게 볼만합니다 ^^) 두가지의 공연을 같이 하는데
1회부터 6회까지 합니다. 10시30분,12시,1시30분,3시,4시30분,6시 이렇게 하루에 6번의 공연을 합니다.
공연은 정말 필수로 보시길 바랍니다.
집에 돌아오니 정말 이 공연 다시 생각납니다. 여행이 짱이구너,,,,",
"#교양#레저","#울산",11," 2019-11-11 18:45:22" ),
(0, 1, 8,"가평 아침고요수목원 오색별빌정원전",
"크리스마스를 기념하여 여자친구와 떠난 가평의 오색별빛정원전. 
사실 이런 곳이 있는지도 모르고 있었던 찰나에 강원도 여행을 취소하고
서울 인근인 가평여행을 선택하게 되었다. 우연찮게 아침고요수목원의 
오색별빛정원전의 빛축제 기간이 딱 맞아 떨어져서 이곳에 갈 수 있께 되었다. 
주말인 토요일이라서 그런지 정말 많은 인파가 몰려 차에서 꽤나 오랫동안 기다리며 들어갈 수 있었다. 
주차공간들이 꽤나 많이 준비되어 있어서 주차 문제는 크게 신경쓰지 않았던 것 같다. 
이외에도 버스로 이곳에 갈 수 있다고 하니 위의 시간표를 참고하여
차를 가지고 오지 않으신 분들은 버스를 이용하시면 좋을 것 같다.",
"#인문#취미#레저","#경기도",301,"2018-12-24 07:10:02"),
(0, 1,4,"5","서천 판교마을, -시간이 멈춘 마을","
대학후배와 어찌어찌하다가 주말 여행을 가기로 했는데, 어디로 갈까 검색하다가 좀 색다른 곳으로 가보고 싶다는 생각을 하다가 찾은 서천 판교마을
검색에는 영 재능이 없는 내가 찾은 레트로 감성이 가득한 레트로 마을, 시간이 멈춘 듯한 공간이라는 소개가 마음에 들었다.
북적한 도시보다는 뭔가 여유롭게 옛스런 느낌이 더 반가울거같았기에 둘다 여기로 마음을 먹었다. 
숙소 정보가 별로 없어서 서천 판교마을에서 놀고, 대천으로 넘어가는 일정으로 계획한 주말 여행이었다.","#충청남도",109,"2019-11-30 11:26:23")
;
SELECT * FROM POST;





INSERT INTO COMMENT
(post_no, mem_no, cmt_regtime,cmt_content,writer)
VALUES
	(1, 10, "2020-01-10 13:40:21","화천 산천어 축제 세계 축제인지는 몰랐어요ㅎㅎ 좋은 정보 감사합니다!","merung"),
	(1, 10, "2020-01-11 08:12:33","ㅋㅋㅋㅋ얼음나라라니 너무 귀여워요","abcd"),
	(2, 1, "2019-01-03 01:24:44","송월동 동화마을에 해바라기 그려져 있는 벽화 보셨나요? 거기 인생 스팟이에요","forcetome"),
	(2, 1, "2019-01-03 18:22:23","남자친구랑 가봐야겠어요 ㅎㅎ","abcd"),
	(2, 1, "2019-01-06 11:53:22","오 사진으로 봤을땐 작아보이던데 규모가 크군요!","babe"),
	(3, 3, "2019-12-24 12:34:44","죽녹원 앞에 '어머니 손맛' 칼국수 맛집 가보셨나요? 존맛입니다","여행마스터"),
	(3, 3, "2019-12-26 14:43:33","떡갈비집 주소좀 알려주세요","내가짱임"),
	(3, 3, "2019-12-26 14:55:11","저도 취미가 혼자 여행하는건데 항상 먹을때 외롭긴 해요,,","nullid"),
	(3, 3, "2019-12-28 12:22:44","메타세콰이어길 진짜 예뻐요","dksi"),
	(4, 4, "2019-01-20 11:35:33","아이들이랑 애니메이션 박물관 갔는데 너무 재밌어했어요 ㅋㅋㅋ","dksi"),
	(4, 4, "2019-01-21 01:35:33","티켓 값은 얼마인가요?","여행덕후"),
	(4, 4, "2019-01-25 22:10:11","crazy님! 춘천 시민은 7000원 일반 시민은 14000원이에요!","여행마스터"),
	(5, 2, "2020-01-11 12:35:25","할인카드 혹시 어떤건가요?","merung"),
	(6, 6, "2019-09-02 11:44:23","할매곱창의 곱창 떡볶이 존맛...","내가짱임"),
	(7, 7, "2020-01-27 22:10:44","대기번호 100번은 양호합니다.. 저 저번에 227번이었어요","babe"),
	(8, 4, "2019-11-14 10:44:22","공연 특별할게 있어요? 전 재미없던데요","여행덕후"),
	(9, 8, "2018-12-25 12:26:31","솔직히 저는 여기 홍보빨이라고 생각","merung"),
	(9, 8, "2018-12-26 11:23:52","남친이랑 작년에도 가보고 이번에도 갔는데 진짜 좋더라구요. 데이트코스로 추천","abcd"),
	(9, 8, "2018-12-30 17:34:54","오 자동차 끌고 가야겠네요 ㅎㅎ 좋은 정보 감사횽ㅋㅋ","babe"),
	(10, 4, "2019-11-30 18:23:55","letroo.......","merung")
;
SELECT * FROM COMMENT;


INSERT INTO LIKES
(post_no, liker_mem_no)
VALUES
	(1, 2),
    (1, 3),
    (1, 5),
    (1, 7),
    (1, 9),
    (1, 8),
    (2, 3),
    (2, 2),
    (2, 5),
    (2, 6),
    (3, 1),
    (3, 2),
    (3, 10),
    (4, 1),
    (4, 10),
    (5, 1),
    (5, 10),
    (5, 3),
    (5, 4),
    (6, 1),
    (6, 2),
    (6, 3),
    (6, 4),
    (6, 5),
    (7, 1),
    (7, 8),
    (8, 1),
    (8, 2),
    (8, 9),
    (8, 10),
    (9, 1),
    (10, 2),
    (10, 3)
;

select * from post;
select * from members;

SELECT * FROM LIKES;






INSERT INTO LIKES
(post_no, liker_mem_no)
VALUES
	(1, 2),
    (1, 3),
    (2, 3),
    (2, 2),
    (3, 1),
    (3, 2),
    (4, 1),
    (5, 1),
    (6, 1),
    (6, 2),
    (6, 3),
    (7, 1)
;

select post_no from post order by post_no desc limit 0, 1;


select * from likes;

 
select *
from post
where post_no in (select post_no from likes l
					right join members m
					on m.mem_no = l.liker_mem_no
					where m.mem_no = 1);
select * from likes l
					right join members m
					on m.mem_no = l.liker_mem_no
					where m.mem_no = 1;
                   
# 좋아하는 포스트들 체크하기     - members 에서 필요한 것 같은데      
select mem_id, like_no, l.post_no, post_title, post_category, post_regtime, post_hits, post_city
from members m
left join likes l on m.mem_no = l.liker_mem_no
left join post p on l.post_no = p.post_no
where m.mem_no = 1;

select *
		from members m
		left join likes l on m.mem_no = l.liker_mem_no
		where m.mem_no = 1;
DESC post;
# post 별 likes 개수
SELECT COUNT(*) 
FROM likes
WHERE post_no = 1;
DESC likes;
select * from post;
UPDATE post SET post_hits = post_hits + 1 WHERE post_no = 4;




















SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PJT1DB';
SHOW DATABASES;
SHOW TABLES FROM PJT1DB;
SHOW TABLE STATUS FROM PJT1DB LIKE 'MEMBER'; 

use pjt1db;

show table status;

show tables;


