
# TODOLIST 

- 2020.02.04


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
 - Blame 테이블 제거
 - Course 테이블 추가

## 3. 데이터 수집 장소 정의 
 - 대도시 테이블
   - 핫플들과 중간규모의 도시들을 모두 포함하는 대형 도시
   - 이름, 주소, 이미지, 컨텐츠 // 한줄평
   - 타입 EX) 서울광역시/경기도/섬/해외

 - 중도시 테이블
   - 핫플들을 포함하는 중간 형태의 도시
   - 이름, 주소, 이미지, 컨텐츠, 타입 EX) 시, 제주도, 서울의 동네 
   - 특징, 별명

 - 소도시 테이블
   - 핫플위주
   - 이름, 주소, 이미지, 컨텐츠
   - 태그 (ex) #가족들과 함께 #짠내투어) - 우리가 직접 입력, 
   - 특징, 별명, 재미요소, 핫플 위치

 - 축제 테이블
   - 이름, 주소, 이미지, 컨텐츠, 태그
   - 시작일, 종료일, 비용, 지도이미지
   - 홈페이지, 주최자

## 4. FAQ / Q&A (구헌)


## 5. LOGIN (지영)