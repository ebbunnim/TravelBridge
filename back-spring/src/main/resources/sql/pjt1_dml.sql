USE PJT1DB;

INSERT INTO member
(mem_no, mem_id, mem_password,mem_phone,mem_name,mem_sex,
mem_birth,mem_address,mem_email,mem_admin,mem_receive_email,mem_following,
mem_followed,mem_lastlogin,mem_regtime,mem_interest,mem_active)
VALUES
(0,'admin1','1234','010-1234-5678','관리자1',0,
'1993-08-23','서울 강남구','admin1@google.com',TRUE,TRUE,0,
0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'맛집',0),
(0,'admin2','1234','010-5678-9101','관리자2',1,
'1987-08-23','서울 성북구','admin2@naver.com',TRUE,TRUE,0,
0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'운동',0),
(0,'admin3','1234','010-4321-5678','관리자3',1,
'1990-11-23','서울 노원구','admin3@daum.net',TRUE,FALSE,0,
0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'해외, 국내',0);

select * from member;

UPDATE member SET
mem_id = 'testMEMBER', 
mem_password = '1111',
mem_phone = '010-4321-5678',
mem_name = '관리자였던 것',
mem_sex = 0,
mem_birth ='1990-11-24',
mem_address = '서울 구로구',
mem_email = 'tester3@daum.net',
mem_admin = FALSE,
mem_receive_email = TRUE,
mem_following = 0,
mem_followed = 0,
mem_lastlogin = NOW(),
mem_interest = 'SOMETHING GOOD',
mem_active = 0 WHERE mem_no = 3;

UPDATE member SET
mem_id = 'testMEMBER', 
mem_password = '11111',
mem_phone = '010-4321-5678',
mem_name = '관리자였던 것',
mem_sex = 0,
mem_birth ='1990-11-24',
mem_address = '서울 구로구',
mem_email = 'tester3@daum.net',
mem_admin = FALSE,
mem_receive_email = TRUE,
mem_following = 0,
mem_followed = 0,
mem_lastlogin = NOW(),
mem_interest = 'SOMETHING GOOD',
mem_active = 0 WHERE mem_id = 'testMEMBER';

select * from member;

# DELETE는 MEMBER가 지워지면
# 관련 내용들 중 무엇들이 바뀌어야 할까?

