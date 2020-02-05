
# **TODOLIST** 

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
  - selenium을 활용한 크롤링 예정 - 대한민국 구석구석
  
- 


# 2020 .02.05

## 1. 데이터 수집

## 2. 각 테이블별 기능 구현

## 3. 연관되는 컬럼 삭제 처리
