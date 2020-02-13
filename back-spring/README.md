
# **TODOLIST** 

## **INDEX**
[2020.02.04](#2020.02.04)  
[2020.02.05](#2020.02.05)  
[2020.02.06](#2020.02.06)  
[2020.02.07](#2020.02.07)  
[2020.02.10](#2020.02.10)  
[2020.02.11](#2020.02.11)  
[2020.02.12](#2020.02.12)

# 2020.02.04


## 1. 데이터 삭제 관련 정의
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

## 2. 테이블 수정
 - Blame 테이블 제거 o
 - Course 테이블 추가 o
 - CityLayerXXX 테이블들 city + hotplace 테이블로 변환 o
 - Files 테이블 수정 o 
   - post_no 필드 제거 
   - path_type, path_no 필드 추가
 - Q&A 테이블 수정 o
   - qna_reply 필드 추가 // 답변 1개만 달리도록 처리

## 3. 데이터 수집 장소 정의 

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

## 4. FAQ / Q&A (구헌)

 - qna도 카테고리로 범주화 o
 - hits 필드는 둘 다 제거 o
 - faq는 question / answer o 
   qna는 title / content/ answer + category 형태로 데이터 입력 o
 - 1대1 문의 형태라서 secret 필드 제거 o


## 5. LOGIN (지영)
  - 로그인 기능 구현(firebase기반 local login / googlelogin / naverlogin / github login)

## 6. FILES UPLOAD(지영)
  - POST 이미지 파일 업로드 구현

## 7. POST
  - 추가
    - search_by_postno o
    - search_by_category * -> #으로 split처리해서 처리하기
    - search_by_course * -> -으로 같은 로직, 다른 테이블 참조 되는지 확인해봐야
    - insert course 수정 o ('-'기준으로 Split 후 모두 course 각각으로 저장 (post_no 가져가는 것 주의))
    
  - 관련 테이블
    - post, file, comment, course
  
  - 세부사항
  1. 조회수
  2. 작성시간
  3. 비밀여부

  - 마지막 추가 기능
  1. 좋아요
  2. 팔로우
  버튼 만들어서 조작하기

# TestCase 작성 (지영)
  - interest 받을 때 여러개로 받으면 어떻게 string처리?  
  - post에는 후기 게시글밖에 존재 안함
  - course에 대표 지역 설정하는 식으로 해야 (테이블에 추가해야)
  - comment 부분에 대댓글 부분 어떻게 쿼리문으로 가져올 지 생각봐야(일단 데이터만 넣어놓겠음.) & 댓글 title일단 빼고 넣을 것임

# 2020 .02.05

## 1. 데이터 수집
- FAQ, QNA 테스트용 데이터 생성 o
- MEMBERS 테스트용 데이터 생성 o
- CITY, HOTPLACE 데이터 수집 o
- BOARD 데이터 생성
- POST 데이터 생성
  - post는 더보기 형태로 제공
- COMMENT 데이터 생성


## 2. 각 테이블별 기능 구현
- FAQ, Q&A 기능 구현
- FAQ o
  - searchAll
  - search(no)
  - insert
  - delete(no)
  - update

- QNA o
  - searchAll
  - search(no)
  - searchForMember(mem_no)
  - insert
  - delete(no)
  - update
  - answerTheQuestion

- CITY & HOTPLACE
  - json으로 hotplace 정보 insert 시 \n으로 개행처리 해줘야함
  - hotplace img 1개만 사용하기로 함 (hp_img)  
    files는 post_no 하나만 취함+
  - search
    - 도시번호
    - 도시별
    - 태그별
    - 주소별


 # 2020.02.06

## 0. 현재상황
  - back   
    1) 완료
     - 모든 테이블 기본 CRUD
     - faq / qna 
    2) 수정중 
     - member, board, post, city, hotplace, files
    3) 아직
     - course, festival, likes, follow, comment

 
## 1. 페이징 처리
  - board, post, comment 데이터 추가
  - 더보기 && 페이지 (morePage / perPage) 추가
  
## 2. 수정중인 테이블 필수 기능 추가
  - post 상세 검색시 files 및 comment까지 딸려오도록 조인해서 쿼리문 작성  
    resultMap 사용
  - 지영이랑 테이블 변경

## 3. 연관되는 컬럼 삭제 처리
  - 안함

## 4. 미작업 테이블 필수 기능 추출 및 추가
  - 기능 추출중


# 2020.02.07

## 0. 현재상황
  - back   
    1) 완료
     - 모든 테이블 기본 CRUD
     - login
     - faq / qna , 
    2) 수정중 
     - member
     - board, post, files
     - city, hotplace, festival
     - likes, follow, comment
    3) 테이블 변경사항
     - course table 제거. 
     - 세부 필드 변경

## 1. 페이징 처리
  - 더보기 && 페이지 (morePage / perPage) 추가 o
  - Post, Hotplace, Festival 페이징 처리 구현 o
  - 추후 Post 테이블을 plan / report로 분할 시 재수정 필요 o
  - 태그, 도시명, 주소등으로 필터링 가능 o

## 2. 수정중인 테이블 필수 기능 추가
  - like vs member
    - 포스트별로 좋아요 수 추출 구현
    - 마이페이지에서 내가 좋아요 누른 포스트 검색 구현
  - follow vs member

## 3. 연관되는 컬럼 처리
  - 삭제(구현은 역순으로 할 것)
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
    

## 4. 미작업 테이블 필수 기능 추출 및 추가
  - 기능 추출중


# 2020.02.10

## 0. 현재상황
  - back   
    1) 완료
     - 모든 테이블 기본 CRUD
     - login
     - faq / qna  
     - post, hotplace, festival 페이징 처리
     - post(+comment + files)로 상세조회 / member(like + post)로 상세조회
  
    2) 수정중 
     - member
     - board, post, files
     - city, hotplace, festival
     - likes, follow, comment
     
    3) 테이블 변경사항
     - course table 제거. 
     - 세부 필드 변경

## 1. 쿼리 작성

  - post+comment+file 쿼리 작성
  - follow + member 쿼리 작성

## 2. 메인 기능 추출 및 구현

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


  # 2020.02.11

  ## 0. 현재상황
  - back   
    1) 완료
     - 모든 테이블 기본 CRUD
     - login
     - faq / qna  
     - post, hotplace, festival 페이징 처리
     - post(+comment + files)로 상세조회 
     - member(like + post)로 상세조회
     - follow + member 쿼리 작성
  
    2) 수정중 
     - member
     - board, post, files
     - city, hotplace, festival
     - likes, follow, comment
     
    3) 테이블 변경사항
     - course table 제거. 
     - 세부 필드 변경
     

## 1. 추출된 메인 기능을 바탕으로 테이블 수정

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
  - like TABLE -> hotplace, festival의 no를 참조 o
  - hotplace, festival TABLE 
    - 좋아요 체크 
    - 테마별 추천 제공을 위해 theme field를 추가한다 o
    - festival 테이블은 종료여부를 알기위해 boolean 타입을 변수로 추가한다. o
    - festival의 종료여부 업데이트는 실제로는 매일 AM 00:00가 되었을 때 일괄처리하는것이 좋아보인다.
  - Board를 개인별로 갖기위해 board에 members의 no를 참조하도록 한다. o
  - comment : writer -> cmt_writer로 정정         o
  - post : writer -> post_writer로 정정           o

 - dto -> lombok annotation 적용                  o
    - 기존 테이블 변경된 쿼리들 수정              o     
    - 필드명변경(comment, post)                   o
    - 필드 추가(festival, board, like, hotplace)  o

## 2. 좋아요 테이블과 연관처리
 - like insert 또는 delete 시 각 관련 테이블은 update 되도록 한다는 것은
 like 눌렀을때 표시가 회원별로 상이하므로 해당 게시물이 like 되었는지는 해당 멤버의 좋아요 리스트를 주고 프론트에서 비교해야 하는 것이 좋아보인다.
 - 따라서 멤버는
    - 좋아요 게시물 리스트 searchMemberLikePost   o
    - 좋아요 핫플 리스트 searchMemberLikeHotPlace o
    - 좋아요 축제 리스트 searchMemberLikeFestival o
 - 상기 메소드를 통해 좋아요 관련 업데이트를 처리한다

## 3. 검색 기능 및 반환리스트 구현
 - 페이징 4개씩으로 변경  o
 - 지역별로 핫플, 축제 리스트 반환 o
 - 제목, 내용, 태그를 if 동적쿼리로 필터링 처리 (핫플, 축제 한정) 
 - 회원 정보의 태그리스트와 비교하여 foreach 동적쿼리로 필터링 처리 o
   - 회원 정보 태그(interest)는 테마와 동일한 값을 가지므로 동일한 로직으로 사용처만 다름 


## 4. 오늘남은기능
 - 제목, 내용, 태그를 if 동적쿼리로 필터링 처리 (핫플, 축제 한정) 
   - 이것도 각각 주는 것이니까 핫플, 축제 각각 처리해주면 됨
 - 회원 정보의 태그리스트와 비교하여 foreach 동적쿼리로 필터링 처리
   - 이거 2개는 양쪽 다 받아서 하나에 담아서 줄지,
   - 각각 요청하도록 할지 결정하고 시작
   - 따로 주는 것으로 합의 o
   - 그리고 그냥 바로 프론트에서 회원정보 받아서 태그리스트에 렌더링한뒤 created 시 요청하는 걸로 처리니까 끝 o

   내일 할일
   검색 마무리 + paging 없애기 (더보기로) 

 # 2020.02.12

  ## 0. 현재상황
  - back   
    1) 완료
     - 모든 테이블 기본 CRUD
     - login
     - faq / qna  
     - post / comment / files / comment
     - follow
  
    2) 수정중 
     - member
     - board, 
     - city, hotplace, festival
     - likes
     
    3) 테이블 변경사항
     - course table 제거. 
     - 세부 필드 변경

    4) 기타
     - dto -> lombok
     - Content per Page num = 4로 고정
     

## 1. 검색 기능 및 반환리스트 구현
 - 페이징 제거 o
 - 검색 마무리 o
    - 제목 / 내용 / 태그를 if 동적쿼리로 필터링 처리 (핫플 / 축제) 

## 2. 연관 삭제 연산
 - POST 삭제시 COMMENT 삭제 FILES 삭제 LIKE 삭제
 - CITY 삭제시 HOTPLACE 삭제 FESTIVAL 삭제 LIKE 삭제
 - HOTPLACE 삭제 LIKE 삭제
 - FESTIVAL 삭제 LIKE 삭제
 - MEMBER 삭제 FOLLOW 삭제 LIKE 삭제 POST 삭제 COMMENT 삭제 QNA 삭제
 - 단위가 달라지므로 DEFAULT 및 MULTIPLE DELETE QUERY가 있는게 나을듯
 - DEFAULT DELETE o
 - multiple update가 직접 값들을 번호만 매칭해서 지정해주는 것들이랑 WHERE 절에서 in으로 받는 것도 번호가 쭉 있는 상태가 되어야함
   - SELECT 한 결과를 배열로 만들어서 FOREACH문으로 뿌려줘야함

## 3. DB 테스트
 - 각 기능을 DB에 있는 데이터로 확인
 - 필요한 작업 수행
 
## 4. 추가기능
 1) SPRING Batch
 - 해당 모듈을 적용할 방법 학습 예정
 - 적용범위는   
    ex) 관리자페이지  
    - 전 날의 데이터를 집계하여 통계자료로써 사용  
    - members, post, comment, hotplace, festival 등 개수  
    - 현재 이용가능 festival 개수

 2) ALARM
 - 자신의 게시물에 댓글이 달린경우 알림을 보낼 수 있다
 - 좋아요를 누른경우 알림을 보낼 수 있다

 3) 권한
  - faq, qna 등

  ## 5. 내일 할 일
  - 연관 DELETE 쿼리문 마무리
  - DB 테스팅
  - SPRING Batch 학습

  # 2020.02.13

 ## 0. 현재상황
  - back   
    1) 완료
     - 모든 테이블 기본 CRUD
     - login
     - faq / qna  
     - comment / files / comment / board
     - city, hotplace, festival
     - likes
  
    2) 수정중 
     - member
     - follow
     - post

  ## delete 연산
  - default만으로는 안되고, 연관지어 삭제해야했고, 연속으로 update처리를 위해서 관련 있는 row를 찾기 위해 find를 우선적으로 진행함
  - likes 삭제(취소) 시는 like만 삭제 o
  - post 삭제 시 likes, comment, files 삭제 o
  - hotplace 삭제 시 likes 삭제 o
  - festival 삭제 시 likes 삭제 o
  - member 삭제 시 board, qna, follow, likes, post, comment, files 삭제 o
  - city는 실제로 삭제할 이유가 없으므로 남김o

 ## 기타 기능
  - 회원가입시 본인 board 생성 (추후 필요시 사용) o
  - MyPage에서 board 하나 호출시 다 담아서 주려했으나 현재 필요한 기능인 팔로우한 사람들의 포스트 20개씩 반환만 수행
  - 내가 팔로우한 사람, 나를 팔로우한 사람 목록 반환
 
  - 쿼리는 다 짰음 o
  - 내가 팔로우한 사람 목록 o
