# **4반 2조 Violet조**

## **트래블 브릿지 (Travel Bridge)**

## 목차

1. [서비스 소개](#서비스-소개)
1. [주요 기능](#주요-기능)
1. [메타데이터](#TavelBridge-메타데이터)
1. [서비스](#서비스)
1. [테스트](#테스트)
1. [팀 구성](#팀-구성)
1. [사용 툴](#사용-툴)

## **서비스 소개**


여행 관련 서비스들을 묶어 서비스 체류시간을 늘리고  
사용자에게 한곳에서 여러 여행 정보를 제공할 수 있는 서비스.

## **주요 기능**

- 여행지 추천 서비스
- 여행 후기 및 일정표 공유 기능
- SNS 서비스
- 내일로 랜덤 여행 루트 서비스
- 전국 여행 스탬프 서비스
- 동반자 찾기 서비스

---
## **TravelBridge 메타데이터**

### **1. 시스템 구조도**

![시스템구조도](./metadata_description/system_architecture.png)

- FRONT-END는 Vue.js의 모듈로 구성하고 Spring Boot를 통해 개발된 BACK-END와 REST API로 비동기 통신하며 서비스를 제공

### **2. 기술스택**

![기술스택](./metadata_description/skill_stack.png)

 - ## **FRONT-END**
    - HTML5
    - CSS
    - JavaScript
    - Vue.js
    - Quasar

  - ## **BACK-END**
    - Java
    - Spring Boot
    - MySQL

  - ## **BACK-Server**
    - Ubuntu
    - Amazon EC2
    - NGINX

  - ## **Collecting DATA**
    - Python
    - Selenium
    - BeautifulSoup

  - ## **Management**
    - Code
        - git
        - gitlab
    - Issue
        - Jira SoftWare

### [**3. 테이블 설계**](./metadata_description/TABLE.md)

<div style="text-align:center">
    <img src="./metadata_description/pjt1ERD.png" alt = "테이블 설계도"/>
</div>

### [**4. API 문서**](./metadata_description/APIDocumentaion.md)

<div style="text-align:center">
    <img src="metadata_description/PJT1ApiDocument.png">
</div>

---

## **서비스**

### 1. Home

![start](./metadata_description/service/1.png)

### 2. Travel Card

![travel_card](./metadata_description/service/2.png)

### 3. Travel Card Feed

![travel_card](./metadata_description/service/3.png)

### 4. Write Travel Card

![travel_card](./metadata_description/service/4.png)

### 5. Travel Pick 

![travel_card](./metadata_description/service/5.png)

### 6. Travel Pick List

![travel_card](./metadata_description/service/6.png)

### 7. Searched Travel Pick

![travel_card](./metadata_description/service/7.png)

### 8. TravelPlus - Party

![travel_card](./metadata_description/service/8.png)

### 9. TravelPlus - Create Party

![travel_card](./metadata_description/service/9.png)

### 10. TravelPlus - Take part in the party

![travel_card](./metadata_description/service/10.png)

### 11. TravelPlus - Ranking

![travel_card](./metadata_description/service/11.png)

### 12. MyPage - Follow, Information

![travel_card](./metadata_description/service/12.png)

### 13. MyPage - Activity i did

![travel_card](./metadata_description/service/13.png)

## **테스트**

- ### 서비스 도메인 주소 
    - http://i02a402.p.ssafy.io/

- ### 테스트 회원 정보
    ```
    tester id : merung@hanmail.net
    tester pw : qwer1234
    ```

## **팀 구성**

### 1. 프론트엔드

- `팀장` 김수민
    -   필수 기능 프론트엔드 담당
    - 여행지 테마 추천 서비스 프론트엔드 담당
    - 여행지 검색 서비스 프론트엔드 담당

- 김준목
    -   회원관리 기능 프론트엔드 담당
    - 여행 정보 공유 서비스 프론트엔드 담당
    - SNS 피드 서비스 프론트엔드 담당

### 2. 백엔드

- 정구헌
    -   DB 설계 
    -   필수 기능 백엔드 담당
    -   여행 추천 서비스 백엔드 담당

- 신지영
    -   데이터 수집 및 정제
    -   로그인 관련 백엔드 담당
    -   개인 맞춤형 SNS 피드 백엔드 담당
    

## **사용 툴**

- Visual Studio Code
- Spring Tool Suite4
- MySQL Workbench
- git(git bash) / gitlab(lab.ssafy.com) / jira (jira.ssafy.com)


