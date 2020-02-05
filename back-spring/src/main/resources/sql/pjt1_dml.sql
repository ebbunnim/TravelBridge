##################################################
# FAQ DML 

INSERT INTO faq
(faq_category, faq_question, faq_answer)
VALUES (
'Login', 
'회원가입은 어떻게 합니까?', 
'TravelBridge는 우측 상단의 로그인 버튼을 통해 회원가입을 신청할 수 있으며, 네이버와 구글 아이디를 통해서도 로그인 할 수 있는 소셜로그인 서비스를 지원하고 있습니다.'
),
('Login', 
'사용자 아이디 또는 이메일 주소가 일시 정지된 계정과 연결되어 있는 경우 어떻게 합니까?'
,'일시 정지된 계정에 연결된 사용자 아이디와 이메일 주소는 어떤 경우에도 사용할 수 없습니다.'
),(
'Login',
'회원정보 수정은  어떻게 합니까?',
'로그인한 상태에서 My Page로 들어가 회원정보 수정을 할 수 있습니다.'
),(
'Login',
'회원탈퇴는 어떻게 합니까?',
'로그인한 상태에서 My Page로 들어가 회원 탈퇴를 신청할 수 있습니다. 이후에 동일한 아이디로 재가입은 불가능합니다.'
);

SELECT * FROM FAQ;
##################################################
# MEMBERS DML 
DESC MEMBERS;

INSERT INTO members
(mem_id, mem_email, 
mem_phone, 
mem_name, mem_sex,
mem_birth, mem_address, 
mem_receive_email, mem_interest, 
mem_token, mem_login_type) 
VALUES (
'admin', 'admin@gmail.com', 
'010-1234-5432', 
'관리인',0, 
'2000-08-20', '서울시 강남구', 
true, '맛집,혼술', '', 0
),(
'tester', 'tester@naver.com',
'010-7777-6555',
'테스터',1,
'1999-01-02', '서울시 용산구',
false, '없음','',1
),(
'vistior', 'visiter@daum.net',
'010-3333-4444',
'방문자테스터',0,
'1958-05-07','경기도 수원시',
true, '치킨', '',0
);

UPDATE MEMBERS SET mem_grant = 2 WHERE mem_no = 1;
UPDATE MEMBERS SET mem_grant = 1 WHERE mem_no = 2;
SELECT * FROM MEMBERS;

##################################################
# QNA DML 
INSERT INTO qna
(mem_no, qna_category, qna_title, qna_content, qna_answer) 
VALUES (
	2, 
	'운영', 
	'사이트 운영 관련된 질문이 있습니다.', 
	'사이트의 수익구조가 어떻게 됩니까?',
	''
),(
3, 
'기타', 
'가장 인기가 많은 나라는 어디인가요??', 
'유럽여행 가고싶은데 나라가 너무 많아서 고르기 어려워요',
''
),
(3,
'기타',
'당일치기 여행 추천해주세요',
'당일치기 국내 여행지 추천해주세요. 여행지마다 갈만한 곳이랑 맛집도 알려주세요.',
'');


UPDATE qna SET
qna_answer = '저희 사이트는 수익창출이 목적이 아닙니다.'
WHERE qna_no = 1;

UPDATE qna SET
qna_answer = ' 당일치기 국내여행으로는 남이섬을 추천드리겠습니다. 볼거리로는 겨울연가 촬영지가 있고 맛집은 ...'
WHERE qna_no = 3;

SELECT * FROM qna;