
# **TODOLIST** 

## **INDEX**
[2020.02.04](#2020.02.04)  
[2020.02.05](#2020.02.05)  
[2020.02.06](#2020.02.06)


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
