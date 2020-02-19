USE pjt1db;
DESC COURSE;

select * from MEMBERS;

DESC COMMENT;
DESC POST;

CREATE TABLE PARTY (
	party_no			int PRIMARY KEY AUTO_INCREMENT,	# 동반자 찾기 글 관리번호	
    host_no				int NOT NULL,					# 작성자 번호
    host_name			varchar( 50),					# 작성자 이름
	party_title			varchar(200),					# 동반자 찾기 글 제목	
	party_contents		varchar(3000),					# 동반자 찾기 글 내용
	party_regtime		datetime DEFAULT NOW(),			# 동반자 찾기 글 작성시간	
	party_num			int DEFAULT 1,					# 참여자 수
    party_del_check		boolean DEFAULT FALSE			# 삭제 여부
);
SELECT * FROM MEMBERS;
insert into PARTY
(
    host_no,
    host_name,		
	party_title,			
	party_contents
) values 
(
	1, "이주연", "여수 밤바다 보러가실분" , "가서 버스커버스커 여수밤바다 한사발 같이 부르실분 모집. <br> 선착순이요~"
),
(
	2, "김한식", "강남 지금 빨리", "술 ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ"
),
(
	1, "이주연", "청주로 집합해라" , "상당산성가서 막걸리 한사발 해야하니까 집합. 진지함"
),
(
	3, "이준석", "부산 돼지국밥 맛집 탐방 하실분", "1주일 동안 돼지국밥집 10군데 돌아다니면서 맛집 탐방하실뿐"
)
;
SELECT * FROM MEMBERS;
SELECT * FROM PARTY;
INSERT INTO COMMENT
(party_no, mem_no, cmt_content,cmt_writer)
VALUES
	(1, 2, "안녕하세요. 여수가서 간장게장부터 가시져","김한식"),
	(2, 1, "여 2 가능?","이주연"),
	(3, 3, "청주가 어딘데 씹덕아","이준석"),
	(4, 2, "돼지국밥 맛있는곳 제가 좀 알고 있는데 거기말고 다른 곳들도 가보고 비교하시죠.","김한식")
;


SELECT * FROM COMMENT where party_no > 0 ;

SELECT *
FROM PARTY
WHERE party_del_check = FALSE;

SELECT *
FROM PARTY
WHERE party_del_check = FALSE 
AND party_no = 1;
/*
INSERT INTO PARTY
(
    host_no,
    host_name,		
	party_title,			
	party_contents
) VALUES 
(
	#{host_no:INTEGER},
    #{host_name:VARCHAR}, 
    #{party_title:VARCHAR}, 
    #{party_contents:VARCHAR}
);
*/
/*
UPDATE 
PARTY
SET
host_no = #{host_no:INTEGER},
host_name = #{host_name:VARCHAR},
party_title = #{party_title:VARCHAR},
party_contents = #{party_contents:VARCHAR},
party_regtime = CURRENT_TIMESTAMP(),
party_num = #{party_num:INTEGER},
party_del_check = #{party_del_check:BOOLEAN}
WHERE party_no = #{party_no:INTEGER};
*/
/*
UPDATE 
PARTY
SET
party_regtime = CURRENT_TIMESTAMP(),
party_del_check = TRUE
WHERE party_no = #{party_no:INTEGER}
AND party_del_check = FALSE
*/

SELECT * FROM MEMBERS;
USE pjt1db;
SELECT * FROM PARTY;
SELECT * FROM COMMENT;
DESC MEMBERS;
CREATE TABLE PARTYIN (
	partyin_no			int	PRIMARY KEY AUTO_INCREMENT,	# 파티 참가 관리번호
    party_no			int,							# 파티방 번호
    mem_no				int,							# 참가자 번호
    mem_name			varchar( 50),					# 참가자 이름
	mem_email			varchar(150),					# 참가자 이메일
	mem_phone			varchar(50),					# 참가자 번호
	mem_interest		varchar(400),					# 참가자 관심사
    partyin_del_check	boolean DEFAULT FALSE			# 파티 참가 삭제여부
);
DESC CITY;
#파티는 파티인에 들어간 멤버들을 조인해서 가져와서 list에 추가하자.
#파티방가서 참가 클릭하면 해당멤버가 파티인으로 insert하고 party 테이블에서는 upNum + 1 해주고
CREATE TABLE CONQUER_RANK (
	conquer_rank_no			int PRIMARY KEY AUTO_INCREMENT,	# 랭킹 관리번호
    city_no					int,							# 도시 번호
    city_name				varchar(200),					# 도시 이름
    
    conquer_rank_del_check	boolean DEFAULT FALSE	
); 
# 랭킹은 1~10위까지 멤버별로 후기남긴 도시 개수로 추출하자.
# 음 이거 쉽지 않군.
# 내가 쓴 포스트를 가져오는 쿼리를 짜고
# 그 포스트랑해서 도시랑 개수 합치기 
SELECT * FROM POST;
SELECT * FROM CITY;
# post_city에서 #뒤에 추출하고 싶은데 전남이 전라남도 이런식으로도 표기되어있어서 이건 자바에서 처리하는게 편해보이는데

SELECT * FROM PARTY;
SELECT * FROM PARTYIN;
insert into PARTYIN
( 
  party_no,
  mem_no,
  mem_name
) VALUES 
(
  1,
  1,
  '이주연'
),
(
  1,
  2,
  '김한식'
),
(
  1,
  3,
  '이준석'
);

SELECT * FROM PARTY;
SELECT * FROM PARTYIN;
# 이게 리스트용 멤버쓰
SELECT 
p.*,
i.partyin_no,
i.party_no,
i.mem_no,
i.mem_name
FROM PARTY p
LEFT JOIN PARTYIN i
ON p.party_no = i.party_no
WHERE p.party_del_check = FALSE
AND i.partyin_del_check = FALSE
AND p.party_no = 1;


# 그냥 클릭하면 바로 참가가 가능한게 좋은건가?
# 수락/거부 할 수 있는게 맞는거 같은데
		SELECT 
		i.partyin_no,
		i.party_no,
		i.mem_no,
		i.mem_name,
		i.mem_email,
		i.mem_phone,
		i.mem_interest
		FROM PARTY p
		LEFT JOIN PARTYIN i
		ON p.party_no = i.party_no
		WHERE p.party_del_check = FALSE
		AND i.partyin_del_check = FALSE
		AND p.party_no = 1;
        
        
        SELECT  * FROM PARTY;
        
SELECT * FROM MEMBERS;
SELECT p.*
FROM POST p
LEFT JOIN MEMBERS m
ON p.mem_no = m.mem_no
WHERE m.mem_no = 1
ORDER BY p.post_regtime DESC;

SELECT * FROM CITY;

SELECT
	RESULT.rnum,
	RESULT.post_no, 
	RESULT.mem_no,
	RESULT.post_type, 
	RESULT.board_no, 
	RESULT.post_title, 
	RESULT.post_content,
	RESULT.post_category, 
	RESULT.post_regtime, 
	RESULT.post_hits, 
	RESULT.post_city,
	RESULT.post_writer, 
	RESULT.post_plan_date,
	RESULT.files_no,
	RESULT.files_url
FROM (SELECT 
			(CASE 
			WHEN @vpost_no = a.post_no
			THEN @rownum:=@rownum
			ELSE @rownum:=@rownum+1
			END) AS rnum,
			(@vpost_no:=a.post_no) vpost_no,
			a.*
		FROM
			(SELECT 
				p.*,
                f.files_no,
				f.files_url
			FROM POST p 
			LEFT JOIN FILES f  ON p.post_no = f.post_no AND p.mem_no = f.mem_no AND files_del_check = FALSE
			WHERE 
			p.post_del_check = FALSE
			AND p.post_type = 1) as a, 
			(SELECT @vpost_no:='', @rownum:=0 FROM DUAL) as b
		) AS RESULT
WHERE RESULT.rnum > 0 AND RESULT.rnum <= 12;


		SELECT
			RESULT.rnum,
			RESULT.post_no, 
			RESULT.mem_no,
			RESULT.post_type, 
			RESULT.board_no, 
			RESULT.post_title, 
			RESULT.post_content,
			RESULT.post_category, 
			RESULT.post_regtime, 
			RESULT.post_hits, 
			RESULT.post_city,
			RESULT.post_writer, 
			RESULT.post_plan_date,
			RESULT.files_no,
			RESULT.files_url
		FROM (SELECT 
				(CASE 
					WHEN @vpost_no = a.post_no
					THEN @rownum:=@rownum
					ELSE @rownum:=@rownum+1
				END) AS rnum,
				(@vpost_no:=a.post_no) vpost_no,
				a.*
				FROM
					(SELECT 
						p.*,
		                f.files_no,
						f.files_url
					FROM POST p 
					LEFT JOIN FILES f  ON p.post_no = f.post_no AND p.mem_no = f.mem_no AND files_del_check = FALSE
					WHERE 
					p.post_del_check = FALSE
					AND p.post_type = 0) as a, 
					(SELECT @vpost_no:='', @rownum:=0 FROM DUAL) as b
				
                WHERE a.mem_no
					in (SELECT f.following_no
					FROM MEMBERS m1
					LEFT JOIN FOLLOW f
					ON m1.mem_no = f.follower_no
					LEFT JOIN MEMBERS m2
					ON f.following_no = m2.mem_no
					WHERE m1.mem_no = 1
					AND m1.mem_del_check = FALSE 
					AND m2.mem_del_check = FALSE 
					AND f.follow_del_check = FALSE) ) AS RESULT
			WHERE RESULT.rnum > 0 AND RESULT.rnum < 10;
		;
				SELECT f.following_no
				FROM MEMBERS m1
				LEFT JOIN FOLLOW f
				ON m1.mem_no = f.follower_no
				LEFT JOIN MEMBERS m2
				ON f.following_no = m2.mem_no
				WHERE m1.mem_no = 1
				AND m1.mem_del_check = FALSE 
				AND m2.mem_del_check = FALSE 
				AND f.follow_del_check = FALSE;

#p.post_no> #{startPage} and p.post_no<=#{endPage} AND 

SELECT empno, ename, job, sal, rnum
FROM (
   SELECT a.*, 
           (CASE @vjob WHEN a.job THEN @rownum:=@rownum+1 ELSE @rownum:=1 END) rnum,
           (@vjob:=a.job) vjob
   FROM emp a, (SELECT @vjob:='', @rownum:=0 FROM DUAL) b
   ORDER BY a.job, a.sal                 
) c;

SELECT p.*, rnum
FROM (
	SELECT a.*,
            (CASE @vboard_no WHEN a.board_no THEN @rownum:=@rownum+1 ELSE @rownum:=@rownum END) rnum,
			(@vboard_no:=a.board_no) vboard_no
	FROM POST a, (SELECT @vboard_no:='', @rownum:=0 FROM DUAL) b
) p;

SELECT a.*,
		CASE 
        WHEN @vboard_no = a.board_no
        THEN @rownum:=@rownum
        ELSE @rownum:=@rownum+1
        END rnum,
		(@vboard_no:=a.board_no) vboard_no
FROM POST a, (SELECT @vboard_no:='', @rownum:=0 FROM DUAL) b;

(SELECT 
		p.post_no, 
		p.mem_no,
		p.post_type, 
		p.board_no, 
		p.post_title, 
		p.post_content,
		p.post_category, 
		p.post_regtime, 
		p.post_hits, 
		p.post_city,
		p.post_writer, 
		p.post_plan_date,
		f.files_no,
		f.files_url
	FROM POST p 
	LEFT JOIN FILES f  ON p.post_no = f.post_no AND p.mem_no = f.mem_no AND files_del_check = FALSE
	WHERE 
	p.post_del_check = FALSE
	AND p.post_type = 0
	AND p.mem_no = 1);

(SELECT @vjob:='', @rownum:=0 FROM DUAL);

SELECT 
(CASE 
	WHEN @vpost_no = a.post_no
	THEN @rownum:=@rownum
	ELSE @rownum:=@rownum+1
END) AS rnum,
(@vpost_no:=a.post_no) vpost_no,
a.*
FROM
	(SELECT 
		p.*,
		f.files_no,
		f.files_url
	FROM POST p 
	LEFT JOIN FILES f  ON p.post_no = f.post_no AND p.mem_no = f.mem_no AND files_del_check = FALSE
	WHERE 
	p.post_del_check = FALSE
	AND p.post_type = 0) as a, 
	(SELECT @vpost_no:='', @rownum:=0 FROM DUAL) as b
WHERE a.mem_no
	in (SELECT f.following_no
	FROM MEMBERS m1
	LEFT JOIN FOLLOW f
	ON m1.mem_no = f.follower_no
	LEFT JOIN MEMBERS m2
	ON f.following_no = m2.mem_no
	WHERE m1.mem_no = 1
	AND m1.mem_del_check = FALSE 
	AND m2.mem_del_check = FALSE 
	AND f.follow_del_check = FALSE)
		;
        
        
SELECT * FROM POST;
SELECT country , sum(mon1) , sum(mon2)  FROM COUNTRY
GROUP BY  ROLLUP ( country );

## 지역별 후기 개수
SELECT city_no,city_name, COUNT(a.post_city) AS city_visited
FROM CITY
LEFT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no
			ORDER BY m.mem_no) AS a
ON a.post_city LIKE concat('%',city_name,'%')
GROUP BY city_no;



SELECT *
FROM 
(SELECT m.mem_no,
m.mem_id,
m.mem_name,
m.mem_interest,
p.post_no,
p.post_type,
p.post_city
FROM MEMBERS m
LEFT JOIN POST p
ON m.mem_no = p.mem_no) as mem
, 
CITY ct;

SELECT mem_no, mem_name, city_no, city_name
FROM MEMBERS, CITY;

# 제공할때는 MEMBER 한명당 17개의 도시를 제공해야하고
# MEMBER의 포스트에서 주소를 비교해서 개수를 추출해야하고

# 멤버 개인에게 제공되는 도시 방문 후기 회수
SELECT 
a.mem_no, 
a.mem_name, 
c.city_no, 
c.city_name, 
COUNT(a.post_city) AS city_visited,
(CASE 
		WHEN @vcity_visited >= COUNT(a.post_City)
		THEN @curRank := @curRank
		ELSE @curRank := @curRank + 1
	END) 
 AS ranking,
 (@vcity_visited:=COUNT(a.post_City)) vcity_visited
FROM 
(SELECT @curRank := 0, @vcity_visited :=0) r, 
(SELECT 
* 
FROM
CITY c
RIGHT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no
            WHERE m.mem_no = 4) AS a
ON a.post_city LIKE concat('%',c.city_name,'%') 
GROUP BY c.city_no
ORDER BY city_visited DESC);

# 그러면 이런 city_visited 개수들을 지역별로 모아서 랭킹을 매겨야하잖아.
/*
SELECT    first_name,
          age,
          gender,
          @curRank := @curRank + 1 AS rank
FROM      person p, (SELECT @curRank := 0) r
ORDER BY  age;
*/
-- p.post_city LIKE concat('%','강원','%') AND 
select * FROM CITY;
SELECT 
p.post_no, p.mem_no, p.post_city, m.mem_name
FROM POST p
LEFT JOIN MEMBERS m  
ON p.mem_no = m.mem_no
ORDER BY m.mem_no;
SELECT * FROM POST;
(SELECT 
p.post_no, p.mem_no, p.post_city, m.mem_name
FROM POST p
LEFT JOIN MEMBERS m  
ON p.mem_no = m.mem_no
WHERE post_city like concat('%','서울','%')
ORDER BY m.mem_no);
## 개인별로 갔던 지역 후기 회수랑 랭킹
SELECT
d.mem_no,
d.mem_name,
d.city_no,
d.city_name,
(CASE 
		WHEN @vcity_visited <= d.city_visited
		THEN @curRank := @curRank
		ELSE @curRank := @curRank + 1
	END) 
 AS ranking,
 (@vcity_visited:=d.city_visited) city_visited 
FROM 
(SELECT @curRank := 1, @vcity_visited :=0) r, 
(SELECT 
a.mem_no, 
a.mem_name, 
c.city_no, 
c.city_name, 
COUNT(a.post_city) AS city_visited
FROM
CITY c
RIGHT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no
            WHERE m.mem_no = 4) AS a
ON a.post_city LIKE concat('%',c.city_name,'%') 
GROUP BY c.city_no
ORDER BY city_visited DESC) d;

DESC LIKES;

(SELECT 
a.mem_no, 
a.mem_name, 
c.city_no, 
c.city_name, 
COUNT(a.post_city) AS city_visited
FROM
CITY c
RIGHT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no
            WHERE m.mem_no = 4) AS a
ON a.post_city LIKE concat('%',c.city_name,'%') 
GROUP BY c.city_no
ORDER BY city_visited DESC);


SELECT
d.mem_no,
d.mem_name,
d.city_no,
d.city_name,
d.city_visited 
FROM  
(SELECT 
a.mem_no, 
a.mem_name, 
c.city_no, 
c.city_name, 
COUNT(a.post_city) AS city_visited
FROM
CITY c
RIGHT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no) AS a
ON a.post_city LIKE concat('%',c.city_name,'%') 
GROUP BY c.city_no
ORDER BY city_visited DESC) d;



SELECT 
p.post_no, p.mem_no, p.post_city, m.mem_name
FROM POST p
LEFT JOIN MEMBERS m  
ON p.mem_no = m.mem_no;


SELECT *
FROM
(SELECT 
CI.city_no,
CI.city_name,
POMEM.*
FROM 
CITY CI
RIGHT JOIN
(SELECT 
p.post_no, p.mem_no, p.post_city, m.mem_name
FROM POST p
LEFT JOIN MEMBERS m  
ON p.mem_no = m.mem_no
WHERE p.post_city like concat('%','부산','%')) AS POMEM
ON city_name ='부산') AS AAA
LEFT JOIN
(SELECT 
a.mem_no, 
c.city_name, 
COUNT(a.post_city) AS city_visited
FROM
CITY c
RIGHT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no) AS a
ON a.post_city LIKE concat('%',c.city_name,'%') 
GROUP BY c.city_no
HAVING city_name = '부산') AS BBB
ON BBB.mem_no = AAA.mem_no;


SELECT 
a.mem_no, 
c.city_name, 
COUNT(a.post_city) AS city_visited
FROM
CITY c
RIGHT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no) AS a
ON a.post_city LIKE concat('%',c.city_name,'%') 
GROUP BY c.city_no
HAVING city_name = '부산' ;

SELECT city_no,city_name, COUNT(a.post_city) AS city_visited
FROM CITY
LEFT JOIN (SELECT 
			p.post_no, p.mem_no, p.post_city, m.mem_name
			FROM POST p
			LEFT JOIN MEMBERS m  
			ON p.mem_no = m.mem_no) AS a
ON a.post_city LIKE concat('%',city_name,'%')
GROUP BY city_no;

SELECT c.city_no,c.city_name, p.post_no,p.post_type,p.mem_no,p.post_city, m.mem_no,m.mem_name
FROM CITY c
LEFT JOIN POST p
ON p.post_city like concat('%',c.city_name,'%')
LEFT JOIN MEMBERS m
ON p.mem_no = m.mem_no
ORDER BY c.city_no;

SELECT 
p.post_no, p.mem_no, p.post_city, m.mem_name, c.city_name
FROM POST p
LEFT JOIN MEMBERS m  
ON p.mem_no = m.mem_no
LEFT JOIN CITY c
ON p.post_city like CONCAT('%',c.city_name,'%')
ORDER BY mem_no;

# 이거 멤버를 기준으로 묶어야하는데;
# 오른쪽에는 멤버를 기준으로 도시 이름, 도시 방문 횟수가 있어야지?
# 왼쪽에는 

SELECT *
FROM CITY c
LEFT JOIN POST p
ON p.post_city LIKE CONCAT('%', c.city_name, '%')
ORDER BY c.city_no;