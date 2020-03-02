
# **백엔드 특이 사항** 

## **INDEX**
1. [데이터 삭제 관련](#데이터-삭제-관련)
1. [데이터 수집 장소](#데이터-수집-장소)
1. [페이징 처리](#페이징-처리)
1. [메인 기능](#메인-기능)

# **데이터 삭제 관련** 

### **정의**
 - MEMBER 삭제 시   
   - FOLLOW, Q&A, COURSE, FILES, LIKES, COMMENT, POST 제거  
   - 각각 join해서 쿼리 7개 적용
 - BOARD 삭제 시
   - COURSE, FILES, LIKES, COMMENT, POST 제거
 - POST 삭제 시
   - COURSE, FILES, LIKES, COMMENT 제거
 - CITYLAYERTOP 삭제 시
   - CITYLAYERMID, CITYLAYERBOTTOM, FESTIVAL 제거
 - CITYLAYERMID 삭제 시
   - CITYLAYERBOTTOM, FESTIVAL 제거
- 나머지는 각각 삭제

### **연관되는 컬럼 처리 순서**
  - 삭제(구현은 역순)
    >**1) board 삭제**  
    > - post 삭제  
    > comment 삭제  
    > files 삭제  
    > likes 삭제    

    >**2) members 삭제**
    > - post 삭제  
    > files 삭제  
    > comment 삭제  
    > likes 삭제  
    > - follow 삭제

### **연관 삭제 연산**
 - POST 삭제시 
    - COMMENT 삭제 FILES 삭제 LIKE 삭제
 - CITY 삭제시 
    - HOTPLACE 삭제 FESTIVAL 삭제 LIKE 삭제
 - HOTPLACE 삭제 
    - LIKE 삭제
 - FESTIVAL 삭제 
    - LIKE 삭제
 - MEMBER 삭제 
    - FOLLOW 삭제 LIKE 삭제 POST 삭제 COMMENT 삭제 QNA 삭제
 - 단위가 달라지므로 DEFAULT 및 MULTIPLE DELETE QUERY가 있는게 나을듯
 - DEFAULT DELETE o
 - multiple update가 직접 값들을 번호만 매칭해서 지정해주는 것들이랑 WHERE 절에서 in으로 받는 것도 번호가 쭉 있는 상태가 되어야함
   - SELECT 한 결과를 배열로 만들어서 FOREACH문으로 뿌려줘야함

 ### **delete 연산 구현**
  - default만으로는 안되고, 연관지어 삭제해야했고, 연속으로 update처리를 위해서 관련 있는 row를 찾기 위해 find를 우선적으로 진행함
  - likes 삭제(취소) 시는 like만 삭제 
  - post 삭제 시 likes, comment, files 삭제 
  - hotplace 삭제 시 likes 삭제 
  - festival 삭제 시 likes 삭제 
  - member 삭제 시 board, qna, follow, likes, post, comment, files 삭제 
  - city는 실제로 삭제할 이유가 없으므로 남김

# **데이터 수집 장소**

### **정의**

 - 도시테이블 + 여행지테이블 이렇게 2개로 만들고  
    여행지 테이블은 다양한 태그로 구성 (스트링으로 분할해서 처리할 예정)  
    태그에 해당하는 보드 생성  
    
 - 도시의 이미지 활용하기  
    Carousel 로 메인에서 도시를 태그해서 보여줄 때 클릭시 지역에서 볼 수 있는 여행지(핫플)들 리스트를 보여준다.  
    도시들 이름만으로 된 태그리스트를 클릭해도 동일한 페이지로 이동한다.

    도시테이블  
    이름, 국내/국외여부, 주소(서울 강남구), 이미지 

    핫플테이블  
    이름, 도시번호, 주소, 상세주소, List<이미지>, 컨텐츠, 태그 + api(지도, 리뷰 등), 상세정보(홈페이지, 휴일, 요금, 운영시간)

    - 파일 테이블을 외래키를 제거하고 TYPE을 추가해서 POST, HOTPLACE 구분하고 해당 번호를 가지고 SELECT
    
 - 축제 테이블 
   - 이름, 주소, 이미지, 컨텐츠, 태그
   - 시작일, 종료일, 비용, 지도이미지
   - 홈페이지, 주최자

   구한 자료 내용  
   이름, 주소, 개최기간, 주요내용, 축제소재, 축제, 계절 o  
   지도 , 홈페이지 , 이미지 , 요금 x

- 카테고리 정하기 

  1. #미식
  2. #레저 취미
  3. #인문 교양
  4. #반려견
  5. #축제

- 대한민국 구석구석 https://korean.visitkorea.or.kr/main/main.do 여기서 데이터 수집
 - 카테고리는 주관적으로 5개 어디에 포함되는지 (중복 포함 가능)

### **수집**
 - 파이썬 (selenium + bs4)을 통한 웹 크롤링
 - 대한민국 구석구석 홈페이지 이용
 - 그외 테스트용 데이터는 직접 생성
 
# **페이징 처리**
  - 더보기 && 페이지 넘기기 (morePage / perPage) 
  - 태그, 도시명, 주소 등으로 필터링 가능

  - 페이징 개수 변경(hp or fval - 4개씩, post - 16개씩)

  - Join된 경우 limit를 활용하기 어려움
  - 따라서 다음과 같이 행번호를 매겨서 startPage ~ endPage 번호 사이를 가져오도록 페이징 처리
  
  - ex) 검색 Option에 따라 Post를 Paging해서 가져오는 함수
  ```xml
  <select id="searchPagePostByOption" parameterType="hashmap" resultMap="pcfMap">
		<![CDATA[SELECT
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
			RESULT.files_url,
			RESULT.cmt_no,
			RESULT.cmt_regtime, 
			RESULT.cmt_content, 
			RESULT.cmt_writer, 
			RESULT.course_no,
			RESULT.course_title,
			RESULT.course_description
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
						f.files_url,
						c.cmt_no,
						c.cmt_regtime, 
						c.cmt_content, 
						c.cmt_writer, 
						cs.course_no,
						cs.course_title,
						cs.course_description
					FROM POST p
					LEFT JOIN COMMENT c ON p.post_no = c.post_no AND c.cmt_del_check = FALSE
					LEFT JOIN FILES f   ON p.post_no = f.post_no AND p.mem_no = f.mem_no AND f.files_del_check = FALSE
					LEFT JOIN COURSE cs ON p.post_no = cs.post_no AND cs.course_del_check=FALSE
					WHERE p.post_del_check = FALSE
					ORDER BY p.post_regtime DESC)
					as a,
					(SELECT @vpost_no:='', @rownum:=0 FROM DUAL) as b
				) AS RESULT
		WHERE RESULT.rnum >#{startPage} AND  RESULT.rnum <= #{endPage}]]>
		<choose>
			<when test="searchOption == 'all'">
				<if test="word != null">
				AND
				(post_title like concat('%','${word}','%')
				OR post_content like concat('%','${word}','%')
				OR post_category like concat('%','${word}','%')
				OR post_city like concat('%','${word}','%'))
				</if>
			</when>
			<when test="searchOption == 'title'">
				AND	post_title like concat('%','${word}','%')
			</when>
			<when test="searchOption == 'content'">
				AND post_content like concat('%','${word}','%')
			</when>
			<when test="searchOption == 'tag'">
				AND post_category like concat('%','${word}','%')
			</when>
			<when test="searchOption == 'city'">
				AND post_city like concat('%','${word}','%')
			</when>
		</choose>
		<!-- ORDER BY p.post_regtime DESC -->
	</select>
  ```

# **메인 기능**

## 기능 추출 및 구현
1. 검색 기능  

    1.1 통합검색  
      - 제목 + 태그 + 내용 검색 (DropDown으로 조건주고 데이터 가져옴)  
      - 사용되는 조건식 태그는 크롤링한 데이터에 대한 태그 ( ex)슬로시티)  
      - 로그인 옆에  
    1.2 메인기능2 서브 추천받기 검색  
      - 톺아보기에서는 검색 X  
      - 지역별로 각 지역에서 핫플, 축제를 동시에 보여줄 것  
      - 태그로만 검색
  
2. 화면 기능

    2.1 메인기능2 홈화면  
      - 세부기능으로 연결하도록 각 서비스 관련해서 배치  
      - 회원정보에 있는 태그 기반으로도 제공  
      - 화면에 노출되는 카드의 개수는 4개 (세부기능은 더보기로 더 늘림)    

   2.2 마이페이지  
      - 2.2.1 내가 팔로우한 유저들 보여주기  
      - 2.2.2 좋아요한 게시글 보여주기  
      - 2.2.3 좋아요한 핫플/축제 보여주기  
        - 좋아요가 핫플이랑 페스티벌 필드로 삽입  
        - Toggle 식으로 핫플/페스티벌 카드들이 체크되었는지 확인할 수 있어야함  

3. 추천 기능  

    - 3.3.1 회원정보기반 태그  
    - 3.3.2 테마별 추천
      - 테마자체 정의할 것(바닷가에 다 넣고 이런거)
      - 데이터 가공 or DB 가공 or 가져온거 가공해서 반환
    - 3.3.3 지역추천
       - 내 정보기반

4. 기타
    - 태그들(사용자 태그)는 or 로 여러개 필터링해서 검색할 수 있다.
    - 날씨 / 도장깨기는 일단 보류
    - 페스티벌에 종료태그를 두어, 축제가 종료되면 종료되었음을 파악할 수 있다.(삭제하는 것이 아님)

## 추출된 메인 기능을 바탕으로 테이블 수정

- 통합검색시 
  - Hotplace와 festival을 구분해서 반환할 것
  - 제목, 내용, 태그 조건을 if 동적쿼리를 활용해 like를 통해 검색되도록 할 것

- 추천페이지 검색
  - 회원정보에 있는 태그 기반으로 필터링 검색할 것(동적으로 쿼리 생성)
  - 회원정보의 태그 별로 리스트 반환할 것
 
- 여행지 페이지 
  - 여행지 페이지는 지역별로 핫플, 축제 리스트를 보여줄 것이므로, 지역별 리스트 반환

- 마이 페이지
  - 좋아요 누른 핫플, 축제 리스트 반환
  - 이를 위해 테이블 수정

- 테이블 수정
  - like TABLE -> hotplace, festival의 no를 참조 
  - hotplace, festival TABLE 
    - 좋아요 체크 
    - 테마별 추천 제공을 위해 theme field를 추가한다 
    - festival 테이블은 종료여부를 알기위해 boolean 타입을 변수로 추가한다. 
    - festival의 종료여부 업데이트는 실제로는 매일 AM 00:00가 되었을 때 일괄처리하는것이 좋아보인다.
  - Board를 개인별로 갖기위해 board에 members의 no를 참조하도록 한다. 
  - comment : writer -> cmt_writer로 정정         
  - post : writer -> post_writer로 정정           

 - dto -> lombok annotation 적용                  
    - 기존 테이블 변경된 쿼리들 수정              o    
    - 필드명변경(comment, post)                   
    - 필드 추가(festival, board, like, hotplace)  


