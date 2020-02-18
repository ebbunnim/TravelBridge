# **API Documentation**

## **Controller INDEX**
- [BOARD](#BOARD)
- [CALENDAR](#CALENDAR)
- [CITY](#CITY)
- [COMMENT](#COMMENT)
- [COURSE](#COURSE)
- [FAQ](#FAQ)
- [FESTIVAL](#FESTIVAL)
- [FILES](#FILES)
- [FOLLOW](#FOLLOW)
- [HOTPLACE](#HOTPLACE)
- [LIKES](#LIKES)
- [MEMBERS](#MEMBERS)
- [POST](#POST)
- [QNA](#QNA)


## **BOARD**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET     |LIST<BOARD>   |searchAll              | /Board              |                   |전체 Board 목록 조회               |
|GET     |BOARD         |search                 | /Board/{board_no}   |int board_no       |no에 따른 Board 정보 조회          |
|POST    |VOID          |insert                 | /Board              | BOARD board       |Board 정보 등록                    |
|PUT     |VOID          |update                 |/Board               |Board board        |Board정보 수정                     |
|DELETE  |VOID          |delete                 |/Board/{board_no}    | int board_no      |Board 정보 삭제                    |

## **CALENDAR**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET     |List<CALENDAR>|searchAll              |/Calendar            |                   |전체 Calendar 목록 조회            |
|GET     |CALENDAR      |searchCalendarByMem_no |/Calendar/{mem_no}   |int mem_no         |mem_no으로 해당 유저가 가진 모든 일정 조회|
|POST    |VOID          |insert                 |/Calendar            |CALENDAR calendar  |Calendar 정보 등록     |
|PUT     |VOID          |update                 |/Calendar            |CALENDAR calendar  |Calendar 정보 수정|

## **CITY**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET     |LIST<CITY>    |searchAll              |/City                |                   |전체 City 목록을 조회하는 기능|
|GET     |CITY          |search                 |/City/{no}           |int no             |no에 따른 City 정보 조회하는 기능 |
|POST    |VOID          |insert                 |/City                |CITY city          |City 정보 등록|
|PUT     |VOID          |update                 |/City                |CITY city          |City 정보 수정|
|DELETE  |VOID          |delete                 |/City/{no}            |int no             |City 정보 삭제|

## **COMMENT**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET     |List<COMMENT> |searchAll              |/Comment             |                   |전체 Comment 목록을 조회하는 기능|
|GET     |COMMENT       |search                 |/Comment/{no}        |int no             |no에 따른 Comment 정보 조회하는 기능|
|POST    |VOID          |insert                 |/Comment             |COMMENT comment    |Comment 정보 등록|
|PUT     |VOID          |update                 |/Comment             |COMMENT comment    |Comment 정보 수정|
|DELETE  |VOID          |delete                 |/Comment/{no}        |int no             |Comment 정보 삭제|

## **COURSE**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
GET     |List<COURSE>  |searchAll              |/Course              |                   |전체 Course 목록을 조회하는 기능|
GET     |COURSE        |search                 |/Course/{no}         |int no             |no에 따른 Course 정보 조회하는 기능|
POST    |VOID          |insert                 |/Course              |COURSE course      |Course 정보 등록|
PUT     |VOID          |update                 |/Course              |COURSE course      |Course 정보 수정|
DELETE  |VOID          |delete                 |/Course/{no}         |int no             |Course 정보 삭제|

## **FAQ**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET    |List<FAQ>      |searchAll          |/Faq/search/all          |                   |전체 Faq 목록을 조회하는 기능      |
|GET    |FAQ            |search             |/Faq/search/{faq_no}     |int no             |no에 따른 Faq 정보 조회하는 기능   |
|POST   |VOID           |insert             |/Faq/insert              |FAQ faq            |Faq 정보 등록                      |
|PUT    |VOID           |update             |/Faq/update              |FAQ faq            |Faq 정보 수정                      |
|DELETE |VOID           |delete             |/Faq/delete/{faq_no}     |int no             |Faq 정보 삭제                      |

## **FESTIVAL**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET     |List<Festival>            |searchAll                   |/Festival/searchAll                                  ||전체 Festival 목록을 조회하는 기능|
|GET     |Festival                  |search                      |/Festival/search/{fval_no}                           |int fval_no|no에 따른 Festival 정보 조회하는 기능|
|GET     |List<Map<String, Object>> |searchMoreFestivalAll       |/Festival/search/more/{btnCnt}                       |int btnCnt|더보기로 Festival 전체 목록 조회|
|GET     |List<Map<String, Object>> |searchMoreFestival          |/Festival/search/more/{btnCnt}/{searchOption}/{word} |int btnCnt, String searchOption, String word |더보기로 Festival 검색하기 조회 - searchOption은 all/ title / content/ tag / city중 전달|
|GET     |List<Map<String, Object>> |searchMoreFestivalByCityName|/Festival/search/more/cityname/{btnCnt}/{word}       |int btnCnt, String word|더보기로 Festival 도시이름으로 목록 조회|
|GET     |List<Map<String, Object>> |searchMoreFestivalByTag     |/Festival/search/more/tag/{btnCnt}/{word}            |int btnCnt, String word|더보기로 Festival 태그로 목록 조회|
|GET     |List<Map<String, Object>> |searchMoreHotPlaceByTheme   |/Festival/search/more/theme/{btnCnt}/{word}          |int btnCnt, String word|더보기로 Festival 테마로 목록 조회|
|POST    |VOID                      |insert                      |/Festival/insert                                     |Festival festival|Festival 정보 등록|
|PUT     |VOID                      |update                      |/Festival/update                                     |Festival festival|Festival 정보 수정|
|DELETE  |VOID                      |delete                      |/Festival/delete/{fval_no}                           |int fval_no|Festival 정보 삭제|

## **FILES**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET    |List<Files>|searchAll |/Files/searchAll       | |전체 Files 목록을 조회하는 기능|
|GET    |Files      |search|/Files/search/{files_no}  |int files_no|no에 따른 Files 정보 조회하는 기능|
|POST   |VOID       |insert|/Files/insert             |Files files|Files 정보 등록|
|POST   |VOID       |getImgurContent|/Files/Post      |Files files|Imgur 형식 이미지 파일 받아오기|
|PUT    |VOID       |update|/Files/update             |Files files|Files 정보 수정|
|DELETE |VOID       |delete|/Files/delete/{files_no}  |int files_no|Files 정보 삭제|

## **FOLLOW**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET   |List<Follow>|searchAll|/Follow/searchAll                            ||전체 Follow 목록을 조회하는 기능|
|GET   |Follow|search|/Follow/search/{follow_no}                            |int follow_no|no에 따른 Follow 정보 조회하는 기능|
|GET   |List<Follow>|followMembers|/Follow/search/members/{follow_no}       |int follow_no|no에 따른 Follow 정보 조회하는 기능|
|POST  |VOID|insert|/Follow/insert                                          |Follow follow|Follow 정보 등록|
|PUT   |VOID|update|/Follow/update                                          |Follow follow|Follow 정보 수정|
|DELETE|VOID|delete|/Follow/delete/{follow_no}                              |int follow_no|Follow 정보 삭제|

## **HOTPLACE**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET   |List<HotPlace>|searchAll|/HotPlace                                                                  | |전체 HotPlace 목록을 조회하는 기능|                           
|GET   |HotPlace|search|/HotPlace/{no}                                                                      |int no|no에 따른 HotPlace 정보 조회하는 기능|
|GET   |List<Map<String, Object>>|searchMoreHotPlaceAll|/HotPlace/search/more/{btnCnt}                      |int btnCnt|더보기로 Hotplace 전체 목록 조회|
|GET   |List<Map<String, Object>>|searchMoreFestival|/HotPlace/search/more/{btnCnt}/{searchOption}/{word}   |int btnCnt, String searchOption, String word|더보기로 HotPlace 검색하기 조회 - searchOption은 all/ title / content/ tag /city 중 전달|
|GET   |List<Map<String, Object>>|searchMoreHotPlaceByAddress|/HotPlace/search/more/address/{btnCnt}/{word} |int btnCnt, String word|더보기로 Hotplace 주소로 목록 조회|
|GET   |List<Map<String, Object>>|searchMoreHotPlaceByCityName|/HotPlace/search/more/cityname/{btnCnt}/{word}|int btnCnt, String word|더보기로 Hotplace 도시이름으로 목록 조회|
|GET   |List<Map<String, Object>>|searchMoreHotPlaceByTag|/HotPlace/search/more/tag/{btnCnt}/{word}          |int btnCnt, String word|더보기로 Hotplace 태그로 목록 조회|
|GET   |List<Map<String, Object>>|searchMoreHotPlaceByTheme|/HotPlace/search/more/theme/{btnCnt}/{word}      |int btnCnt, String word|더보기로 Hotplace 테마로 목록 조회|
|POST  |VOID|insert|/HotPlace                                           |HOTPLACE hotplace|HotPlace 정보 등록                |       
|PUT   |VOID|update|/HotPlace                                           |HOTPLACE hotplace|HotPlace 정보 수정|
|DELETE|VOID|delete|/HotPlace/{no}                                      |int no|HotPlace 정보 삭제|

## **LIKES**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET   |List<Likes>|searchAll|/Likes/searchAll       ||전체 Likes 목록을 조회하는 기능|
|GET   |Likes|search|/Likes/search/{like_no}|int like_no|no에 따른 Likes 정보 조회하는 기능|
|POST  |VOID|insert|/Likes/insert          |Likes likes|Likes 정보 등록|
|PUT   |VOID|update|/Likes/update          |Likes likes|Likes 정보 수정|
|DELETE|VOID|delete|/Likes/delete/{like_no}|int like_no|Likes 정보 삭제|

## **MEMBERS**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET   |List<Members>|searchAll|/Members/searchAll                                       |    | 전체 Member 목록을 조회하는 기능|
|GET   |Members|search|/Members/search/{mem_no}\                                         |int mem_no| no에 따른 Member 정보 조회하는 기능|
|GET   |Members|searchMemberByEmail|/Members/search/email/{mem_email}                    |String mem_email| Member 조회(email에 따른)|
|GET   |List<Post>|searchFollowingPeoplePost|/Members/searchFollowingPeoplePost/{mem_no} |int mem_no| no에 따른 Member의 Following List의 Post를 조회하는 기능|
|GET   |Members|searchFollowMePeople|/Members/searchFollowMePeople/{mem_no}              |int mem_no| no에 따른 Member의 FollowMeList를 조회하는 기능|
|GET   |Members|searchMyFollowPeople|/Members/searchMyFollowPeople/{mem_no}              |int mem_no| no에 따른 Member의 FollowList를 조회하는 기능|
|GET   |Members|searchMemberLikeFestival|/Members/searchMemberLikeFestival/{mem_no}      |int mem_no| no에 따른 Member가 좋아하는 축제 List를 조회하는 기능|
|GET   |Members|searchMemberLikeHotPlace|/Members/searchMemberLikeHotPlace/{mem_no}      |int mem_no| no에 따른 Member가 좋아하는 핫플레이스 List를 조회하는 기능|
|GET   |Members|searchMemberLikePost|/Members/searchMemberLikePost/{mem_no}              |int mem_no| no에 따른 Member가 좋아하는 포스트 List를 조회하는 기능|
|POST  |VOID|getInfo|/api/jwtinfo                                                        |HttpServletRequest request, Members members| jwtinfo 전달하는 api|
|POST  |VOID|insert|/Members/insert                                                      |Members members| Member 정보 등록|
|POST  |VOID|loginMembers|/Members/login                                                 |Members members, HttpServletRequest request| 로그인|
|PUT   |VOID|update|/Members/update                                                      |Members members| Member 정보 수정|
|DELETE|VOID|delete|/Members/delete/{mem_no}                                             |int mem_no| Member 삭제|

## **POST**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET   |List<Post>|searchAll|/Post/searchAll                                        | |전체 Post 목록을 조회하는 기능                  |
|GET   |Post|search|/Post/search/{post_no}                                          |int post_no|no에 따른 Post 정보 조회하는 기능     |
|GET   |List<Map<String, Object>>|searchPagePostAll|/Post/search/pageAll/{btnCnt}   |int btnCnt|페이징된 Post 전체 목록 조회           |
|GET   |List<Map<String, Object>>|searchPagePost|/Post/search/pagePost/{btnCnt}     |int btnCnt|페이징된 Post 중 후기(Post) 목록 조회  |
|GET   |List<Map<String, Object>>|searchPagePlan|/Post/search/pagePlan/{btnCnt}     |int btnCnt|페이징된 Post 중 일정(Plan) 목록 조회  |
|POST  |VOID|insert|/Post/insert                                                    |Post post|Post 정보 등록                          |
|PUT   |VOID|update|/Post/update                                                    |Post post|Post 정보 수정                          |
|DELETE|VOID|delete|/Post/delete/{post_no}                                          |int post_no|Post 정보 삭제                        |

## **QNA**

| 호출 타입 | 반환 타입 | 메소드 명 |URL | 파라미터 | 설명 |
|-|-|-|-|-|-|
|GET   |List<Qna>|searchAll|/Qna/searchAll                      | | 전체 Qna 목록을 조회하는 기능|
|GET   |Qna|search|/Qna/search/{qna_no}                         |int qna_no| no에 따른 Qna 정보 조회하는 기능|
|GET   |List<Qna>|searchForMember|/Qna/searchForMember/{mem_no} |int mem_no| member no에 따른 Qna 정보 조회하는 기능|
|POST  |VOID|insert|/Qna/insert                                 |Qna qna| Qna 정보 등록|
|PUT   |VOID|update|/Qna/update                                 |Qna qna| Qna 정보 수정|
|PUT   |VOID|answerTheQuestion|/Qna/answerTheQuestion           |Qna qna| Qna 답글 달기|
|DELETE|VOID|delete|/Qna/delete/{qna_no}                        |int qna_no| Qna 정보 삭제|




