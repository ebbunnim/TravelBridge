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

###########################
#CITY DML
INSERT INTO 
city
(city_name, city_is_overseas,
city_address, city_img) 
VALUES (
"서울",
false,
"대한민국 서울시",
"/img/domestic/seoul.PNG"
),
("전주",
false,
"대한민국 전라북도",
"/img/domestic/jeonbuk.jpg"
);
#맛집 #가족 #데이트 #쇼핑 #문화 #실내 #힐링 #전통
#맛집 #실내 #
###########################
#HOTPLACE DML
INSERT INTO 
hotplace
(city_no, hp_name, hp_address,
hp_detail_adr,hp_content,
hp_tag , hp_homepage,
hp_holiday, hp_fee,
hp_img, hp_theme) 
VALUES (
1,
"남산서울타워", 
"서울 용산구",
"서울특별시 용산구 남산공원길 105", 
"※ 19_20 한국관광 100선 ※ \n 남산서울타워는 한국 최초의 타워형태의 관광명소다. 높이 236.7m를 헤아리는 타워는 해발 243m인 남산의 높이까지 계산하면 실제 높이는 480m에 이르러 가히 동양최고의 타워라고 자랑할 만하다. 남산서울타워는 40년 만에 일반인에게 공개되는 서울타워플라자'와 2005년부터 CJ푸드빌이 임대하여 운영 중인 N서울타워로 구성되어 있다. 남산서울타워는 1969년 TV와 라디오 방송을 수도권에 송출하기 위해 한국 최초의 종합 전파탑으로 세워졌으며, 현재는 서울의 대표적인 복합문화공간이자 랜드마크로 자리잡았다.",
"#15_16한국관광100선 #17_18한국관광100선 #19_20한국관광100선 #가족여행 #경복궁 #고궁 #관광지 #교과서속여행 #당일치기여행 #서울 #서울근교여행 #수도권 #아이와함께 #역사 #역사유적지 #연인과함께 #전통역사문화체험 #친구와함께 #한국관광100선",
"http://www.seoultower.co.kr",
"연중무휴",
"* 전망대 - 대인 11,000원 / 소인 9,000원 \n* 헬로키티아일랜드 - 대인 8,000원 / 소인 7,000원 \n* 2종 패키지(전망대+헬로키티) - 대인 13,500원 / 소인 11,500원 \n※ 경로 요금의 경우, 전망대 및 전시관 요금에만 적용 \n※ 36개월 미만의 유아는 무료(보호자 1명당 1명에 한함, 유치원 단체의 경우 어린이 요금 적용) ※ 장애인 할인 : 1~3급의 경우 본인+동반자 1인 30% 할인, 4~6급의 경우 본인 30%할인 (패키지 및 단체 제외)\n※ 국가 유공상이자 1~3급의 경우 장애우 할인 혜택과 동일하게 적용(국가유공자 본인 경우 30% 할인)\n※ 엔그릴 이용고객은 사전 예약시 전망대를 무료로 관람하실 수 있습니다.\n * 남산 케이블카 \n운행시간 : 10:00 ~ 23:00 (단, 금~토 / 휴일 전날은 상황에 따라 연장 운행)\n운행요금 : 대인왕복 9,500원 / 대인편도 7,000원 / 소인왕복 6,500원 / 소인편도 4,000원\n※ 30명 이상 단체의 경우 단체 할인 적용\n※ 소인 (36개월 ~ 초등학생) / 65세 이상은 소인요금 적용", 
"",
"#힐링 #데이트"
),(
1,
"낙산공원",
"서울 종로구",
"서울특별시 종로구 낙산길 41",
"낙산은 서울의 형국을 구성하던 내사산(남산, 인왕산, 북악산, 낙산)의 하나로 풍수지리상 주산인 북악산의 좌청룡에 해당하는 산이다. \n이렇게 소중한 자연환경과 문화유산을 지니고 있는 낙산은 일제의 강점기를 거쳐 현재에 이르기까지 상당부분 파괴·소실되었고 \n특히 60년대 이후의 근대화 과정에서 무분별한 도시계획으로 인해 아파트와 주택이 낙산을 잠식한 채 오랜 시간 방치되어 역사적 유물로써의 제 기능을 상실하게 되었다.\n이에 서울시에서는 공원녹지확충 5개년 계획의 일환으로 낙산을 근린공원으로 지정하고 주변의 녹지축과의 연결을 도모하면서 낙산의 모습과 역사성을 복원하는 사업을 추진하게 되었다.\n * 총 면적 152,443㎡ (약 46,114평) \n* 녹지대 131,615㎡ / 광장 4,018㎡ / 기타시설 16,810㎡\n* 수목관리\n1) 수목식재 - 소나무 등 47종 107,603주\n2) 지피식물 - 구절초 등 11종 43,075본",
"#가족여행 #관광지 #나들이 #낙산공원 #데이트코스 #드라이브여행 #수도권 #아이와함께 #연인과함께 #체험학습 #친구와함께 #힐링",
"http://parks.seoul.go.kr",
"연중무휴",
"무료", 
"",
"#힐링 #데이트"
),
(
1,
"북촌한옥마을",
"서울 종로구",
"서울특별시 종로구 계동길 37",
"※ 북촌마을 방문 시 지켜야할 에티켓 \n - 단체관광객 방문시 반드시 가이드 동행- 관광버스 불법주차 금지 - 무단 침입, 무단 촬영, 무단 투기, 노상방뇨, 소음 금지 - 마을 방문시간 준수  예로부터 북촌이라 하여 양반 동네로 알려진 이곳 주택은 모두 조선 시대의 기와집으로서 상류층의 구조 형태를 간직하며 지금까지 보존되어 오고 있다. 원래 이 동네에는 솟을대문이 있는 큰 집 몇 채와 30여 호의 한옥밖에 없었으나, 일제 말기와 6.25 수복 직후 지금의 상태로 늘어났다. 북촌한옥마을은 경복궁과 창덕궁, 종묘의 사이에 위치한 지역으로 서울 600년 역사와 함께해온 우리의 전통 거주 지역이다. 거대한 두 궁궐 사이에 밀접하여 전통한옥군이 위치하고 있으며, 수많은 가지 모양의 골목길을 그대로 보존하고 있어 6백 년 역사도시의 풍경을 극적으로 보여주고 있다. 지금은 전통문화체험관이나 한옥음식점 등으로 활용이 되어 간접적으로나마 조선시대의 분위기를 느낄 수 있는 곳이다.  예로부터 원서동, 재동, 계동, 가회동, 인사동으로 구성된 이 지역은 청계천과 종로의 윗 동네라는 이름에서 ‘북촌''이라는 이름으로 불리었으며, 당시로써는 왕실의 고위관직에 있거나 왕족이 거주하는 고급 주거지구로 유명하였다. 곳곳에 아직까지 남아있는 몇 채의 한옥들은 이때의 명성을 그대로 간직하고 있다. 여러 채의 한옥이 지붕처마를 잇대고 벽과 벽을 이웃과 함께 사용하고 있는 풍경은 우리가 잊고 살았던 따뜻한 정과 살아갈 맛을 느끼게 해준다. 북촌 지역을 걷다보면 이어진 처마선의 아름다운만큼이나 골목길의 정겨움을 느낄 수 있다.북촌한옥마을이 지속가능한 관광지가 될 수 있도록 침묵관광을 하도록 주의를 요한다.* 허용시간 : 10:00 ~17:00(주중,토) / 일 : 골목길 쉬는 날 * 대상지역 : 북촌로 11길 일대 약 100m 구간 ※ 침묵관광이란 외부 관광객들의 관광지 방문으로 인해 주민들의 생활권과 환경권이 침해받지 않도록 큰 소리로 떠들지 않고 조용히 여행하는 관광형태를 말",
"#가족여행 #관광지 #나홀로여행 #당일치기여행 #데이트코스 #도심여행 #북촌한옥마을 #사계절 #서울근교여행 #아이와함께 #역사 #연인과함께 #전통가옥 #친구와함께 #한옥",
"http://hanok.seoul.go.kr/front/index.do",
"연중무휴",
"* 전망대 - 대인 11,000원 / 소인 9,000원  * 헬로키티아일랜드 - 대인 8,000원 / 소인 7,000원 * 2종 패키지(전망대+헬로키티) - 대인 13,500원 / 소인 11,500원  ※ 경로 요금의 경우, 전망대 및 전시관 요금에만 적용  ※ 36개월 미만의 유아는 무료(보호자 1명당 1명에 한함, 유치원 단체의 경우 어린이 요금 적용) ※ 장애인 할인 : 1~3급의 경우 본인+동반자 1인 30% 할인, 4~6급의 경우 본인 30%할인 (패키지 및 단체 제외) ※ 국가 유공상이자 1~3급의 경우 장애우 할인 혜택과 동일하게 적용(국가유공자 본인 경우 30% 할인) ※ 엔그릴 이용고객은 사전 예약시 전망대를 무료로 관람하실 수 있습니다. * 남산 케이블카 운행시간 : 10:00 ~ 23:00 (단, 금~토 / 휴일 전날은 상황에 따라 연장 운행) 운행요금 : 대인왕복 9,500원 / 대인편도 7,000원 / 소인왕복 6,500원 / 소인편도 4,000원  30명 이상 단체의 경우 단체 할인 적용 ※ 소인 (36개월 ~ 초등학생) / 65세 이상은 소인요금 적용", 
"",
"#전통 #가족"
),
(
1,
"청계천",
"서울 중구",
"서울특별시 종로구 창신동",
"청계천이 시작되는 세종로에 조성된 청계광장.청계천 복원 시작지점인 동아일보사 앞에서부터 신답철교 사이로 연장160m, 폭50m, 총 면적 2천 106평의 규모로 조성되었다. 분수와 폭포, 청계천 미니어처, 산책로와 탐방로 등으로 꾸며져있고, 청계천 복원의 의미와 함께 만남과 화합, 평화와 통일을 염원하는 장소로 만들어져 있다. 이 중 광장은 청계천 복원 시작지점중심에 741평 규모로 조성되었고, 우리나라 전통적보자기형태의 디자인을 가져와 다양한 색상의 석재포장으로 우아한 전통미를 살린다. 이 곳에는 청계천 축소모형인 청계 미니어처가 설치되어 복원된 청계천의 모습을 한눈에 볼 수 있다. 청계천을 가로지르는 22개 다리에 대한 해설판도 설치되어 있고, 이외에도 다양한 형상의 분수가 만들어져 아름다운 경관을 연출한다.한편, 광장에서 청계천으로 진입하기 위한 시설로는 왼편에 계단형 진입로, 오른편에 청계탐방로가 들어 서 있다. 청계 탐방로 중 18m 구간에는 터널이 설치돼 광장에서 청계천으로 들어 오는 시민들에게 색다른 경험을 선사한다. 서울시는 청계천광장 조성 후 공휴일에는 이 곳을 차 없는 거리로 만들어 광장, 수변공간, 도로가 시민들의 휴식과 문화공간으로 이용되도록 마련해놓았다. 삼색 조명이 어우러진 캔들 분수와 4m 아래로 떨어지는 2단 폭포가 장관을 연출한다. 폭포 양 옆에는 전국에서 돌을 가져온 8도석으로 제작된 ''팔석담''을 깔았다. 밤이면 빛과 물이 어우러지는 환상적인 모습을 연출한다. 또, 청계천 전구간을 1/100로 축소한 미니어쳐 역시 멋진 볼거리를 제공한다. * 청계천복원구간 1/100의 미니어쳐캔들(촛불)분수, 4m 2단 폭포, 팔도석",
"#가족여행 #관광지 #나들이 #데이트코스 #드라이브여행 #산책길 #산책하기 #산책하기좋은곳 #수도권 #아이와함께 #연인과함께 #청계천 #체험학습 #친구와함께 #힐링",
"http://www.sisul.or.kr/open_content/cheonggye/",
"연중무휴",
"무료", 
"",
"#자연 #데이트"
),
(
1,
"홍대",
"서울 마포구",
"서울특별시 마포구 홍익로 20",
"※ 19_20 한국관광 100선 ※\n 홍대거리에는 이색카페들, 소규모 갤러리와 화랑, 소품점과 패션숍, 라이브카페와 클럽, 예술시장, 각종 맛집 등은 홍대거리를 더욱 자유스럽게 만든다. 다양한 행사와 거리공연, 축제 등의 문화요소를 간직하고 있어 홍대주변은 항상 많은 사람들로 북적거린다. 또한, 홍대주변을 구성하는 미술학원거리, 피카소거리, 클럽거리, 걷고 싶은거리 등 이색거리가 홍대거리로의 발걸음을 즐겁게 한다.\n [홍대앞 주요 관광지]\n* 홍대 걷고싶은거리 : 홍대 걷고싶은거리는 홍대를 대표하는 곳으로 야외 무대 공연장을 설치해 인디밴드의 거리공연과 젊은이들의 역동적인 모습을 느낄 수 있는 곳이다.\n * 홍대 벽화거리 : 홍대 벽화거리는 홍익대학교 후문에 위치한 카네마야 제면소부터 포시즌하우스까지 이어지는 와우산로 22길에 펼쳐져 있다.낙서 같은 그림도 많으나 디자인 예술에 가까운 벽화도 많아 피카소 거리라고 불리며, 연인들의 데이트 코스로 널리 알려져있다.\n * 홍대앞 예술시장 프리마켓 / 홍대앞 희망시장 : 홍익대 정문 앞 홍익어린이 공원에서는 매년 3월부터 11월까지 매주 토요일은 홍대앞 예술시장 프리마켓이, 매주 일요일은 홍대앞 희망시장이 열린다.각각의 예술시장에서는 일반 시민작가들의 참여와 손으로 직접 만든 수공예품 판매,생활창작 아티스트들의 작품전시 및 판매가 이루어진다.",
"#17_18한국관광100선 #19_20한국관광100선 #관광지 #서울 #수도권 #연인과함께 #젊음의거리 #친구와함께 #한국관광100선 #홍대 #홍대거리 #홍대걷고싶은거리 #홍대프리마켓 #홍대희망시장",
"http://www.mapo.go.kr/CmsWeb/culture/main.req",
"",
"", 
"",
"#문화 #데이트"
),
(
1,
"서울숲",
"서울 성동구",
"서울특별시 성동구 뚝섬로 273",
"2005년 6월 18일 \"서울숲\" 개원 이전까지는 뚝섬은 생성과 변천을 거듭해 오면서 임금의 사냥터, 군검열장 등으로, 최초의 상수원수원지로, 골프장으로, 경마장, 체육공원 등으로 활용되어 왔다.현재 \"서울숲\"은 18만 평 규모의 5개 테마공원으로서, 동북부 주민은 물론, 1,100만 서울시민에게 환경친화적인 대규모식 공간으로 탈바꿈하였는 바, 영국의 하이드파크(Hyde Park), 뉴욕의 센트럴파크(Central Park)와 같이 서울의 \"서울숲\"이 자리메김 될 것이다. \n * 서울숲 광장 \n 1) 서울숲 중앙에 위치 \n 2) 서울숲광장, 뚝섬 가족마당, 장식화단, 방문자센터, 스케이트파크, 야외무대, 수변휴게실(레스토랑), 숲속의 빈터, 숲속놀이터, 물놀이터 등으로 구성 \n * 뚝섬생태숲  \n 1) 과거 한강물이 흘렀던 곳 \n2) 한강과 중랑천을 연계하는 자연생태숲으로 재현 (야생동물의 서식 공간) \n 3) 야생동물 방사 - 8종 114수(꽃사슴 40, 고라니 10, 다람쥐 30, 다마사슴 8마리) 등 \n 4) 연못 - 원앙 6, 청둥오리 8, 흰뺨검둥오리 8, 쇠물닭 4마리 \n 5) 야생동물을 관찰할 수 있도록 보행가교 설치 \n * 자연체험학습장 \n 1) 구 뚝섬정수장 구조물을 재활용 \n 2) 곤충 식물원, 야생초화원, 테마초화원과 이벤트마당, 지킴이숲 등으로 조성 \n * 습지생태원 \n 1) 유수지의 기존 자연환경을 활용 \n 2) 습지생태관리소, 환경놀이터, 야외자연교실, 조류관찰대, 습지초화원, 정수식물원 등 \n * 한강공원 \n 1) 공원의 남서측 한강변에 위치 \n 2) 한강·중랑천 합류부의 자연호안, 수변공원, 선착장, 휴게공간 등",
"#가족여행 #걷기길 #관광지 #데이트코스 #생태관광지 #서울숲 #수도권 #아이와함께 #연인과함께 #연중무휴 #피크닉 #휴식공간 #휴식여행 #휴식하기 #휴식하기좋은곳",
"http://seoulforest.or.kr",
"연중무휴(일부시설 월요일휴관)",
"무료", 
"",
"#힐링 #가족"
),
(
2,
"전주한옥마을 [슬로시티]",
"전북 전주시",
"전라북도 전주시 완산구 어진길 29",
"전주한옥마을은 전주시 풍남동과 교동에 위치해 있다. 이곳에는 한국의 전통 건물인 한옥(韓屋)이 735여 채나 밀집되어 있다. \n빠르게 변화는 도시 속에 옛 것을 그대로 간직한 전주한옥마을은 한국의 옛 전통을 맛볼 수 있는 곳으로 유명하다. \n전주한옥마을의 멋은 무엇보다도 한옥의 아름다운 지붕선에 있다. 지붕자락이 살짝 하늘로 향해 있는 것이 한옥의 특징이고 멋이다. \n한옥의 구조는 크게 안채와 사랑채로 나누어져 있다. \n안채는 여인들이 머무는 곳으로 규수방이 있고, 사랑채는 남자들이 사용하던 곳으로 선비방으로 되어 있다. \n한옥은 남녀의 활동이 구분되어 있어 각각의 특징들을 가지고 있다. \n그 중 안채의 경우는 여인들이 생활하는 곳이기 때문에 가장 은밀하고 깊숙한 곳에 위치해 있다. \n한옥의 또 하나의 특징은 온돌방이다. \n한국은 주로 앉아서 생활하기 때문에 바닥에 온돌을 깐다. 온돌의 구조는 방 밖에 아궁이(함실)을 만들고 구들(아궁이 안쪽)밑으로 불을 때면 온돌이 따뜻하게 데워지는 것이다. \n여름에는 시원하고 겨울에는 따뜻하다는 것이 온돌의 가장 큰 특징이다. 이곳에 가면 한옥생활체험관이 따로 마련되어 있다. \n한옥생활체험관안에 있는 선비방과 규수방에서 직접 온돌방 체험을 할 수도 있다.\n 한옥생활체험 중 이곳에서 제공되는 전통한식은 납청유기(納淸鍮器)에 담아 맛과 멋을 더한다. \n전주한옥마을에서 직접생활도 해보고 맛있기로 유명한 전주비빔밥도 맛보는 두가지 체험을 할 수 있는 곳이다.\n",
"#19_20한국관광100선 #2010 #가족여행 #관광시설 부문 #관광지 #미식여행 #수상내역 #슬로시티 #역사 #역사유적지 #인생샷 #전라권 #전주한옥마을 #전통가옥 #한국관광의별 #한옥",
"http://tour.jeonju.go.kr",
"",
"무료", 
"",
"#전통 #가족 #데이트"
);
select * from city;
select * from hotplace;
select * from board;
# 도시번호 찾기
SELECT city_no 
FROM city 
WHERE city_name = "서울" 
AND city_del_check = FALSE;

# 도시별로 가져오기
SELECT * 
FROM hotplace 
WHERE city_no = 1 
AND hp_del_check = FALSE
ORDER BY hp_name
LIMIT 0, 3;

select Count(*) from hotplace;
# 도시별로 가져오기 sub query
SELECT * 
FROM hotplace 
WHERE city_no = (SELECT city_no 
				 FROM city 
				 WHERE city_name = "전주" 
				 AND city_del_check = FALSE) 
AND hp_del_check = FALSE
ORDER BY hp_name;


# 태그별로 가져오기 (태그안에 해당 단어가 있으면 다가져옴)
SELECT * 
FROM hotplace
WHERE hp_tag 
LIKE concat('%','데이트','%') 
AND hp_del_check = FALSE;
# 주소별로 가져오기
SELECT * 
FROM hotplace
WHERE hp_address = TRIM("서울 용산구") 
AND hp_del_check = FALSE;
select * from hotplace;
DESC hotplace;
##############################
# BOARD

INSERT INTO 
board (board_name) 
VALUES ('공지사항'); 
INSERT INTO 
board (board_name) 
VALUES ('일정 게시판');
INSERT INTO 
board (board_name) 
VALUES ('후기 게시판');

SELECT * FROM BOARD;
## 유저별로 피드 식으로 제공할 거면 유저 번호가 게시판마다 필요한가

SELECT * FROM MEMBERS;
SELECT * FROM POST;
/*
post_no				int PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호	기본키, 자동증가
    post_type			int NOT NULL,			# 후기(사진등 추가) : 0, 일정(양식) : 1 
	board_no			int NOT NULL,					# 게시판 번호	외래키
	mem_no				int NOT NULL,					# 작성자 번호	외래키
	post_title			varchar(200),					# 게시글 제목	
	post_content		varchar(3000) NOT NULL,			# 게시글 내용	
	post_category		varchar(300),					# 게시글 카테고리, 태그
	post_regtime		datetime DEFAULT NOW(),			# 게시글 작성시간	
	post_hits			int DEFAULT 0,					# 게시글 조회수
    post_city			varchar(500),					# 지역(해시태그) 달기
    post_plan_start		date,							# 일정 시작날짜
    post_plan_end		date,							# 일정 끝 날짜
    post_plan_title		varchar(200),					# 일정 제목
    post_del_check		boolean DEFAULT FALSE,			# 삭제 여부
    writer	
    */
    DROP tABLE post;
    select * from post;
    select * from members;
    INSERT INTO post
		(post_type, 
		board_no, 
		mem_no, 
		post_plan_start,
		post_plan_end,
		post_plan_title)
VALUES( 1, 
		2,
		2, 
        '2020-02-05',
        '2020-02-07',
		'나의 청춘예찬 첫 일정'
);
INSERT INTO post
		(post_type, 
		board_no, 
		mem_no, 
		post_title, 
		post_content, 
		post_category, 
        post_city)
VALUES( 0, 
		1,
		2, 
		'청춘예찬 첫 후기', 
		'따뜻한 봄날의 품으며, 같은 싸인 든 있는 유소년에게서 봄바람이다. 이는 청춘의 없으면 커다란 시들어 피에 인간은 그들의 것이다. 하는 이상 고동을 때까지 이상의 할지니, 피다. 눈이 열락의 몸이 끝에 인간에 봄바람이다. 그들에게 어디 얼마나 끝에 실현에 눈이 것이다. 군영과 것은 풍부하게 하는 그들의 같이, 그것은 뿐이다. 그들의 꾸며 없으면 굳세게 실현에 얼마나 군영과 반짝이는 관현악이며, 봄바람이다. 든 영락과 타오르고 관현악이며, 인류의 사랑의 사막이다. 생의 내는 것은 길지 그들은 쓸쓸하랴? 
         물방아 역사를 튼튼하며, 별과 과실이 불러 장식하는 많이 것이다. 불어 힘차게 거친 이상이 영락과 그들의 가치를 찾아다녀도, 산야에 때문이다. 소금이라 무엇을 인생에 사막이다. 방지하는 따뜻한 청춘의 고동을 생명을 바이며, 전인 이것이다. 청춘의 보내는 소금이라 하는 뜨거운지라, 있으며, 만천하의 약동하다. 이상은 황금시대를 천하를 우리의 것이다. 보배를 맺어, 하여도 동력은 돋고, 무엇을 그들의 것이다. 있음으로써 생명을 앞이 없으면 할지니, 곧 꽃 열매를 운다. 무한한 구하지 소담스러운 위하여 이성은 그들의 인도하겠다는 약동하다. 피가 생의 보이는 아니다. 
		때까지 그들의 맺어, 그들에게 인생을 온갖 들어 그리하였는가? 불러 피는 그들의 피가 피고, 지혜는 것이다. 너의 붙잡아 하는 피가 열락의 있음으로써 구하지 가슴이 것이다. 청춘이 그들에게 같이, 안고, 불어 위하여서. 광야에서 품으며, 위하여서, 피다. 꽃이 만천하의 주며, 대중을 찾아다녀도, 별과 부패뿐이다. 그들에게 얼마나 보내는 싶이 있다. 피부가 인간이 곳으로 얼마나 듣기만 긴지라 아름다우냐? 찾아 커다란 평화스러운 사막이다. 방황하였으며, 그들의 되는 품에 구할 노래하며 속에 앞이 듣는다. 돋고, 평화스러운 꾸며 무엇을 바이며, 힘차게 안고, 같은 것이다.', 
		'#문화','#부산'
);

# 권한 1의 tester가 board
select * from post;

DESC festival;
DESC course;
DESC board;
DESC post;
DESC comment;
DESC qna;
# follow 기능을 고려하면, board가 member_no별로 생성되어야함
# 자신이 follow한 사람들의 post(0) 가져오고, 
# follow한 사람이 없어도 컨텐츠랑 추천 아이디가 보이도록해야겠지
select * from comment;

select 
board_no 
from board
where 
board_name = '여행지 추천 게시판';

select * 
from post p
where p.board_no = (select 
				b.board_no 
				from board b
				where 
				b.board_name = '후기 게시판');

# post member 조인
select board_no, post_no, post_title, mem_id, post_content, post_category                     
		, date_format(post_regtime, '%Y-%m-%d') as post_regtime
        , post_hits, ((post_end_day)-(post_start_day)) as days
		 			 from   post, members                                        
		 			 where  post_no = 1 and post.mem_no = members.mem_no;
                    
DESC comment;
INSERT INTO 
comment
(board_no, post_no, mem_no, cmt_title, cmt_content) 
VALUES (3,1,2,'댓글1', 'ㅈㄱㄴ'),(3,1,2,'댓글2','냉무'),( 3,1,3, '댓글3', 'ㅋㅋ루ㅋㅋ'),(3,1,3,'댓글4', '오? 심상치 않은데?');

# 하나의 post에 달려있는 댓글들 까지 전부 가져오기 (작성자 아이디, 댓글작성자 아이디까지 조인)
select p.* , m.mem_id as cmt_person, c.cmt_no, c.mem_no, cmt_title, cmt_content             
from   comment c                                              
right join  (select post_no, post_title, mem_id, post_content, post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, post_hits, ((post_end_day)-(post_start_day)) as days
			 from   post, members                                        
			 where  post_no = 1 and post.mem_no = members.mem_no) p                                   
on   p.post_no = c.post_no
left join members m
on c.mem_no = m.mem_no;
  
/* 요만큼이 association 관계고*/
select post_no, post_title, mem_id, post_content, post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, post_hits, post_start_day, post_end_day
from   post, members                                        
where  post_no = 1 and post.mem_no = members.mem_no; 
             
             
select p.post_no, p.post_title, m.mem_id, p.post_content, p.post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, p.post_hits, p.post_start_day, p.post_end_day,
                    m.mem_id as cmt_person, c.cmt_no, c.mem_no, c.cmt_title, c.cmt_content   
from  post p
left join members m on p.mem_no = m.mem_no           
right join comment c on p.post_no = c.post_no                            
where  p.post_no = 1;

select p.post_no, p.post_title, m.mem_id, p.post_content, p.post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, p.post_hits, p.post_start_day, p.post_end_day,
                    m.mem_id as cmt_person, c.cmt_no, c.mem_no, c.cmt_title, c.cmt_content   
from  members m
right join post p on m.mem_no = p.mem_no           
right join comment c on c.mem_no = m.mem_no                          
where  p.post_no = 1;




UPDATE comment set cmt_del_check = true where cmt_no = 4;
select * from comment;
#vistir
insert into comment(post_no,mem_no,cmt_content,writer) values (2,3,'앙아가악ㅇㄴ막미나굽데수ㅐㅂㄷ','visitor');
select * from post;  
select * from members;
select * from files;
insert into files(post_no,mem_no,files_url) 
values
(2,2,'url1'),
(2,2,'url2');

select p.* , m.mem_id as cmt_person, c.cmt_no, cmt_title, cmt_content             
from   comment c    
left join members m
on c.mem_no = m.mem_no                                          
right join  (select post_no, post_title, mem_id, post_content, post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, post_hits, ((post_plan_end)-(post_plan_start)) as days
			 from   post, members                                        
			 where  post_no = 1 and post.mem_no = members.mem_no) p                                   
on   p.post_no = c.post_no;

select p.* , m.mem_id as cmt_person, c.cmt_no, cmt_title, cmt_content             
from   comment c                                             
right join  (select post_no, post_title, mem_id, post_content, post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, post_hits, ((post_end_day)-(post_start_day)) as days
			 from   post                                      
			 where  post_no = 1) p                                   
on   p.post_no = c.post_no;
DESC BOARD;
DESC CITY;
DESC hotplace;
DESC POST;
select *
from post p
left join comment c
on p.post_no = c.post_no
left join files f
on p.post_no = f.post_no;



SELECT * fROM post;
SELECT * FROM COMMENT;
SELECT * FROM FILES;

SELECT * FROM members;
INSERT INTO POST
(post_type, board_no, mem_no, post_title, post_content, post_category, post_city, post_hits, post_regtime)
VALUES
(0, 1,2,"2020 얼음나라 화천산천어축제 제대로 즐기는 TIP","
겨울 축제는 아이들의 방학 문제로 보통 1월에 집중적으로 열립니다. 
축제에 참여하는 사람들이 가족단위인 경우가 많다보니 주로 1월에 개최하는 것입니다. 
1월에 열리는 축제의 주요 테마는 '물고기'입니다. 지방축제가 본격적으로 시작된 1990년대에는 
겨울축제의 테마로 주로 눈(snow)과 등산을 선택했다면 2000년대 이후에는 단연 어류가 돋보이고 있습니다. 
얼음나라 화천산천어축제는 세계 4대 겨울 축제의 하나로 이름을 올릴 정도로 큰 성공을 올리고 있는 겨울축제입니다. 
토종물고기인 산천어 자체에 차별성이 있기도 하고 축제 내부적으로 주민들의 
참여 및 협조가 잘 되고 있다는 점이 축제가 크게 성공할 수 있었던 길인 것 같습니다. ",
"#취미#레저","강원도",432,"2020-01-10 10:40:33"),
( 0, 1, 1, "인천 여행코스 송월동 동화마을 역대 최고 규모의 벽화마을",
"수십 년 전로 담벼락에 색칠을 하여 동화마을로 변화하였다.가끔 형을 따라서 이곳저곳 몇몇 벽화마을 찾아가 봤지만 인천 송월동 동화마을 만큼 큰 규모를 보지 못했습니다.
아니 그 반도 안되는 곳들이 대부분인데요 많은 사람들이 이곳을 인천 여행코스 라고 이야기하는 이유를 느낄 수 있었고
애인이 있었다면 꼭 한 번 데리고 갔을 것 같은 장소로 연인들의 기념사진 촬영하기 딱 적당한 장소였답니다",
"#인문#교양","인천", 100, "2019-01-02 8:12:22"),
(0, 1, 2,"그렇게 가보고 싶던 담양, 죽녹원 & 메타세콰이어길에 가다!",
"게스트하우스에서 나와 311번 버스를 타고 도착한 죽녹원. 
네이버 지도가 알려준 시간보다 훨씬 빨리 도착했다. 
어제 먹은 술 해장도 할겸 밥을 먹으려 돌아다니는데 담양하면 하도 
떡갈비라고 들어서 주변 떡갈비집을 찾아봤다. 
1인분만 되는 떡갈비집을 다행히도 찾았고 먹었다! 
죽통밥을 다 먹고 나니 사장님께서 기념으로 가져갈 수 있다며 봉지 드릴까요? 
하시기에 얼떨결에 받아왔다는 이야기ㅎㅎ 담양국수거리도 바로 앞이라 국수도 먹고 싶었지만 
혼자 여행의 최대 단점. 여러 가지 다양하게 먹을 수가 없다. 다음에 날 따뜻해지면 다시 갈거니까 그 땐 국수 먹어야징!",
"#미식#교양","전라남도",87, "2019-12-24 12:00:11"),
(0, 1, 1,"춘천 애니메이션박물관 + 토이로봇관",
"춘천갈까 말까 했었는데 춘천시는 미세먼지가 양호하다는 뉴스를 보고
몇일 지겨웠던 미세먼지 심각에서 잠시나마 벗어나고자 피할려고 강원도로 방향을 틀었다.
일단 강원도로 오니 공기부터가 일단 다르다. 너무 늦게 출발해서 너무 늦게 도착했더니
여러군데 들릴 수가 없을 것 같았다.  
1군데만 들린다면 ...이왕 아이들 때문에 나왔으니 아이 중심으로 가자고 했던 곳이 여기 애니메이션박물관이다.
생각보다 넓은 규모에 시설이 잘 되어 있어서 좋았다. 
무엇보다도 봄날씨에 파란하늘이 마음을 더 들 뜨게 한다.
춘천...사실 그리 먼거리는 아니지만 2시간 정도 ...이래저래 쉬엄쉬엄 오면
왕복 4~5시간....자주 오기에는 조금 부담스럽긴 하다.
늦게 도착해서 그냥 애니메이션박물관만 구경만 하는게 더 좋을 법도 했는데 이왕 왔으니 토이로봇관이랑 애니메이션박물관
두군데 볼 수 있는 티켓을 구매했다. 춘천시민은 절반 가격이니....
춘천으로 이사와야 겠다. ㅋㅋ",
"#인문#교양#미식","강원도",2,"2019-01-19 9:10:01"),
(0, 1, 2,"광주 패밀리랜드 눈썰매장 ! 광주 놀거리",
"2주전에 남친과 초등학교 이후로 안가본 눈썰매장을 갔어요!
근데 정말 상당히 재밌더라구요! 사람 많은거 빼구.. 표는 티몬에서 구매했어요!
놀이기구 5종 , 열차 , 눈썰매장! 까지 해서 한 사람당 16,000원이였던거같아요!
놀이기구도 많이타고 썰매도 타고싶으신분들은
그냥 매표소 가서 자유이용권,눈썰매장 이렇게 끊으셔도 될거같아요
자유이용권,눈썰매장 이렇게 21,000원이세요!
근데 자유이용권은 반드시 할인카드가 있어야해요!
저도 자세한 할인카드는 잘 몰라서..ㅎㅎ
추워서 놀이기구 별로 안탈줄알았는데 재밌더라구요~
남친님과 후회했어요!
한번 패밀리랜드 눈썰매장 가보세요~ 괜찮아요! 주차장도 넓구!
물론 주차비가 별도로 나갑니다. 저희는 1,000원 들었어요! ㅎㅎ
앞으로 가실 분들은 참고하세요!!! ㅎㅎ 끄읕~",
"#레저","광주",30,"2020-01-11 01:33:21" );

select * from post;
select * from city;
select * from hotplace;
select * from festival;
desc festival;
SELECT COUNT(*) 
		FROM festival 
		WHERE city_no = (SELECT city_no 
						 FROM city 
						 WHERE city_name = "서울" 
						 AND city_del_check = FALSE) 
		AND fval_del_check = FALSE;

insert into festival(city_no, fval_name,fval_address,fval_detail_adr,fval_content,fval_tag)
values
(1,"이름1","서울 강남구","서울 강남구 역삼동", "내용","#꿀"), 
(1,"이름2","서울 강남구","서울 강남구 역삼동", "내용","#꿀"), 
(1,"이름3","서울 강남구","서울 강남구 역삼동", "내용","#꿀"), 
(1,"이름4","서울 강남구","서울 강남구 역삼동", "내용","#꿀"), 
(1,"이름5","서울 강남구","서울 강남구 역삼동", "내용","#꿀"), 
(1,"이름6","서울 강남구","서울 강남구 역삼동", "내용","#휴"), 
(1,"이름7","서울 강남구","서울 강남구 역삼동", "내용","#휴"), 
(1,"이름8","서울 강남구","서울 강남구 역삼동", "내용","#휴"), 
(1,"이름9","서울 종로구","서울 종로구 명동", "내용","#중"), 
(1,"이름10","서울 종로구","서울 종로구 명동", "내용","#중"), 
(1,"이름11","서울 종로구","서울 종로구 명동", "내용","#중"), 
(1,"이름12","서울 종로구","서울 종로구 명동", "내용","#중");


(SELECT p.post_no, p.mem_no,
			post_type, board_no, post_title, post_content,
			post_category, post_regtime, post_hits, post_city,
			post_plan_start, post_plan_end, post_plan_title,
			p.writer, post_del_check, c.mem_no as cmt_mem_no, cmt_regtime, cmt_content, c.writer as cmt_writer
			FROM post p 
			LEFT JOIN comment c 
			ON p.post_no = c.post_no AND cmt_del_check = FALSE 
			GROUP BY c.cmt_no );
# post + comment + files
SELECT 
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
	p.post_plan_start, 
	p.post_plan_end, 
	p.post_plan_title,
	p.writer, 
	c.mem_no,
	c.cmt_regtime, 
	c.cmt_content, 
	c.writer, 
	f.files_url
	FROM post p 
	LEFT JOIN comment c ON p.post_no = c.post_no AND c.cmt_del_check = FALSE
	LEFT JOIN files f   ON p.post_no = f.post_no AND p.mem_no = f.mem_no AND f.files_del_check = FALSE
	WHERE p.post_no =2 AND p.post_del_check = FALSE;

SELECT DISTINCT
p.post_no,
post_type, board_no, post_title, post_content,
post_category, post_regtime, post_hits, post_city,
post_plan_start, post_plan_end, post_plan_title,
p.writer, cmt_regtime, cmt_content, c.writer, files_url
FROM post p, comment c, files f
WHERE p.post_no = c.post_no AND cmt_del_check = FALSE
AND p.post_no = f.post_no AND p.mem_no = f.mem_no AND files_del_check = FALSE
AND p.post_no = 2 AND p.post_del_check = FALSE;

SELECT 
	post_type, board_no, post_title, post_content,
	post_category, post_regtime, post_hits, post_city,
	post_plan_start, post_plan_end, post_plan_title,
	p.writer, cmt_regtime, cmt_content, c.writer
	FROM post p 
	LEFT JOIN comment c 
	ON p.post_no = c.post_no AND cmt_del_check = FALSE
	WHERE p.post_no = 2 AND p.post_del_check = FALSE;
    
    
    
select * from follow;
select * from post;
select * from board;

SELECT
f.follow_no,
f.follower_no,
f.following_no,
m.mem_id,
m.mem_email,
m.mem_name
FROM follow f 
LEFT JOIN members m ON f.following_no = m.mem_no AND m.mem_del_check = FALSE
WHERE f.follower_no = 1
AND f.follow_del_check = FALSE;
select * from likes;

SELECT 
		a.mem_no, 
		a.mem_id,
		a.mem_email, 
		a.mem_name,
		b.following_no,
		b.mem_id,
		b.mem_email,
		b.mem_name
		FROM members a, (SELECT
						f.follow_no,
						f.follower_no,
						f.following_no,
						m.mem_id,
						m.mem_email,
						m.mem_name
						FROM follow f 
						LEFT JOIN members m ON f.following_no = m.mem_no AND m.mem_del_check = FALSE
						WHERE f.follower_no = 1
						AND f.follow_del_check = FALSE) b
		WHERE a.mem_no = b.follower_no
		AND a.mem_del_check = FALSE;
        
        
SELECT
		f.follow_no,
		f.follower_no,
		f.following_no,
		m.mem_id,
		m.mem_email,   
		m.mem_name
		FROM follow f
		LEFT JOIN members m ON f.following_no = m.mem_no AND m.mem_del_check = FALSE
		WHERE f.follower_no = 1
		AND f.follow_del_check = FALSE;	
        
        
        
        select * from hotplace;
        
        select * from likes;
        select * from festival;
        
		
        select * from city;
        # 테마에 대한 고려가 없어서 
        select * from members;
        
        
        select * from hotplace;
        


INSERT INTO MEMBERS 
	(mem_id, mem_email, mem_phone, mem_name, mem_grant, mem_interest, mem_login_type)
VALUES 
	("merung","merung@hanmail.net","010-5434-3422","이주연",0,"#음식#쇼핑#체험","기본"),
	("abcd","abcd@naver.com","010-2323-1441","김한식",1,"#역사#관광지#자연","네이버"),
	("forcetome","forcetome@gmail.com","010-4442-2223","이준석",0,"#실내여행지","깃허브"),
	("babe","babe@gmail.com","010-3422-3444","장준민",0,"#관광지#체험#레포츠","구글"),
	("dksi","dksi@naver.com","010-4532-3333","선민수",1,"#음식#역사","네이버"),
	("여행덕후","crazy@gmail.com","010-5567-3242","한경찰",1,"#역사#쇼핑","기본"),
	("내가짱임","best@hanmail.net","010-2321-2135","인선민",0,"#관광지#체험","기본"),
	("여행마스터","master@gmail.com","010-5632-2222","신민선",0,"#쇼핑#체험#문화시설","깃허브"),
	("용이뿐님","ssss@gmail.com","010-2342-1111","이두나",1,"#쇼핑#자연#관광지","구글"),
	("nullid","nurdy@naver.com","010-3226-6666","육설재",1,"#문화시설","네이버")
;
SELECT * FROM MEMBERS;

select count(*) from likes where post_no = 1;
select * from likes where liker_mem_no = 2;
select * from likes;
insert into likes(post_no, liker_mem_no) values (1,1);
INSERT INTO FOLLOW
(follower_no, following_no)
VALUES
	(1, 10),
    (2,4),
    (4,2),
    (3,9),
    (5,7),
    (7,9),
    (2,4),
    (2,8),
    (2,6),
    (6,2)
;
SELECT * FROM FOLLOW;


INSERT INTO BOARD
(board_name)
VALUES
	("함께 쓰는 다이어리"),
    ("플래너")
;
DESC board;

SELECT * FROM BOARD;
INSERT INTO BOARD
(mem_no, board_name)
VALUES
(4,"merung"),
(5,"abcd"),
(6,"forcetoem"),
(7,"babe"),
(8,"dksi"),
(9,"여행덕후"),
(10,"내가짱임"),
(11,"여행마스터"),
(12,"용이뿐님"),
(13,"nullid")
;
DESC POST;
INSERT INTO POST
(post_type, 
 board_no, 
 mem_no, 
 post_title, 
 post_content, 
 post_category, 
 post_city, 
 post_hits, 
 post_regtime,
 post_writer)
VALUES
(0, 9,10,"2020 얼음나라 화천산천어축제 제대로 즐기는 TIP","
겨울 축제는 아이들의 방학 문제로 보통 1월에 집중적으로 열립니다. 
축제에 참여하는 사람들이 가족단위인 경우가 많다보니 주로 1월에 개최하는 것입니다. 
1월에 열리는 축제의 주요 테마는 '물고기'입니다. 지방축제가 본격적으로 시작된 1990년대에는 
겨울축제의 테마로 주로 눈(snow)과 등산을 선택했다면 2000년대 이후에는 단연 어류가 돋보이고 있습니다. 
얼음나라 화천산천어축제는 세계 4대 겨울 축제의 하나로 이름을 올릴 정도로 큰 성공을 올리고 있는 겨울축제입니다. 
토종물고기인 산천어 자체에 차별성이 있기도 하고 축제 내부적으로 주민들의 
참여 및 협조가 잘 되고 있다는 점이 축제가 크게 성공할 수 있었던 길인 것 같습니다. ",
"#취미#레저","#강원도",432,"2020-01-10 10:40:33", "내가짱임"),
( 0, 9, 10, "인천 여행코스 송월동 동화마을 역대 최고 규모의 벽화마을",
"수십 년 전로 담벼락에 색칠을 하여 동화마을로 변화하였다.가끔 형을 따라서 이곳저곳 몇몇 벽화마을 찾아가 봤지만 인천 송월동 동화마을 만큼 큰 규모를 보지 못했습니다.
아니 그 반도 안되는 곳들이 대부분인데요 많은 사람들이 이곳을 인천 여행코스 라고 이야기하는 이유를 느낄 수 있었고
애인이 있었다면 꼭 한 번 데리고 갔을 것 같은 장소로 연인들의 기념사진 촬영하기 딱 적당한 장소였답니다",
"#인문#교양","#인천", 100, "2019-01-02 8:12:22", "내가짱임"),
(0, 3, 4,"그렇게 가보고 싶던 담양, 죽녹원 & 메타세콰이어길에 가다!",
"게스트하우스에서 나와 311번 버스를 타고 도착한 죽녹원. 
네이버 지도가 알려준 시간보다 훨씬 빨리 도착했다. 
어제 먹은 술 해장도 할겸 밥을 먹으려 돌아다니는데 담양하면 하도 
떡갈비라고 들어서 주변 떡갈비집을 찾아봤다. 
1인분만 되는 떡갈비집을 다행히도 찾았고 먹었다! 
죽통밥을 다 먹고 나니 사장님께서 기념으로 가져갈 수 있다며 봉지 드릴까요? 
하시기에 얼떨결에 받아왔다는 이야기ㅎㅎ 담양국수거리도 바로 앞이라 국수도 먹고 싶었지만 
혼자 여행의 최대 단점. 여러 가지 다양하게 먹을 수가 없다. 다음에 날 따뜻해지면 다시 갈거니까 그 땐 국수 먹어야징!",
"#미식#교양","#전라남도",87, "2019-12-24 12:00:11","merung"),
(0, 3, 4,"춘천 애니메이션박물관 + 토이로봇관",
"춘천갈까 말까 했었는데 춘천시는 미세먼지가 양호하다는 뉴스를 보고
몇일 지겨웠던 미세먼지 심각에서 잠시나마 벗어나고자 피할려고 강원도로 방향을 틀었다.
일단 강원도로 오니 공기부터가 일단 다르다. 너무 늦게 출발해서 너무 늦게 도착했더니
여러군데 들릴 수가 없을 것 같았다.  
1군데만 들린다면 ...이왕 아이들 때문에 나왔으니 아이 중심으로 가자고 했던 곳이 여기 애니메이션박물관이다.
생각보다 넓은 규모에 시설이 잘 되어 있어서 좋았다. 
무엇보다도 봄날씨에 파란하늘이 마음을 더 들 뜨게 한다.
춘천...사실 그리 먼거리는 아니지만 2시간 정도 ...이래저래 쉬엄쉬엄 오면
왕복 4~5시간....자주 오기에는 조금 부담스럽긴 하다.
늦게 도착해서 그냥 애니메이션박물관만 구경만 하는게 더 좋을 법도 했는데 이왕 왔으니 토이로봇관이랑 애니메이션박물관
두군데 볼 수 있는 티켓을 구매했다. 춘천시민은 절반 가격이니....
춘천으로 이사와야 겠다. ㅋㅋ",
"#인문#교양#미식","#강원도",2,"2019-01-19 9:10:01","merung"),
(0, 3, 4,"광주 패밀리랜드 눈썰매장 ! 광주 놀거리",
"2주전에 남친과 초등학교 이후로 안가본 눈썰매장을 갔어요!
근데 정말 상당히 재밌더라구요! 사람 많은거 빼구.. 표는 티몬에서 구매했어요!
놀이기구 5종 , 열차 , 눈썰매장! 까지 해서 한 사람당 16,000원이였던거같아요!
놀이기구도 많이타고 썰매도 타고싶으신분들은
그냥 매표소 가서 자유이용권,눈썰매장 이렇게 끊으셔도 될거같아요
자유이용권,눈썰매장 이렇게 21,000원이세요!
근데 자유이용권은 반드시 할인카드가 있어야해요!
저도 자세한 할인카드는 잘 몰라서..ㅎㅎ
추워서 놀이기구 별로 안탈줄알았는데 재밌더라구요~
남친님과 후회했어요!
한번 패밀리랜드 눈썰매장 가보세요~ 괜찮아요! 주차장도 넓구!
물론 주차비가 별도로 나갑니다. 저희는 1,000원 들었어요! ㅎㅎ
앞으로 가실 분들은 참고하세요!!! ㅎㅎ 끄읕~",
"#레저","#광주",30,"2020-01-11 01:33:21","merung"),
(0, 5, 6 ,"부산 먹거리 여행 명소, 부평깡통시장 야시장",
"이곳이 깡통시장인 이유는 6.25 때 미군부대에서 나온 캔 같은 깡통 제품을 많이 팔았기 때문이라고 한다. 이곳은 밤에 운영하는 야시장이 유명하다. 
야시장 운영 시간은 19:30 ~ 23:00이다. 
시장 골목의 한 곳에 갖가지 먹거리 부스들이 한 줄로 늘어서 있다. 
약 110m 거리에 30개 정도의 노점이 운영되고 있다고 한다. 음식들은 맛이 있다.
비주얼도 좋아서 눈으로 보면 다 먹고 싶을 정도이다. 
인기가 있는 몇 군데는 줄도 길게 서 있다. 구매하면 거의 서서 먹어야 한다. 
군데군데 서서 먹을 수 있는 스탠딩 테이블이 놓여 있긴 한데 사람 수가 더 많다. 
쓰레기통도 많이 비치되어 있기 때문에 다 먹고 쓰레기를 어떻게 해야 할지 걱정할 필요는 없다.
아, 현지인에게 물어보니 유부주머니를 꼭 먹어보라고 하던데 경황이 없어서 먹어보지 못했다.",
"#미식#취미","#부산",101,"2019-09-01 01:33:21","forcetoem"),
(0, 6, 7,"강화석모도 미네랄 온천 ;족욕",
"족욕하는 다른 곳이 공사중으로 문을 닫아 미네랄 온천 무료 족욕.
오전 시간이었는데도 대기 번호 100번이 넘는... 오픈 했을때 배타고 들어 올때는 이렇게 밀리지 않았는데
석모대교 개통이후에는 사람이 많아 입장하기가 쉽지 않다. 새벽에 와야 할 듯 하다^^~",
"#레저#취미#교양","#인천",2,"2020-01-27 21:08:01" ,"babe"),
(0, 3,4,"울산 자수정동굴나라 및 보트체험 후기!",
"울산 여행의 마지막을 장식하는 곳으로 울산에 유명한 자수정동굴나라를 다녀왔습니다.
마침 대구 가는길에 있는곳이기도 하지만 큰 기대는 하지 않았습니다. 전날 숙박업소에서 워낙 기분이 안좋은것도 있었지만...
다만 울산 자수정동굴나라에서 공연한다는건 한번 보고 싶었죠.
얼핏 다른 블로그에서 울산 자수정동굴나라 공연하는 모습을 잠시봤는데 재미있는것 같더라고요.
그래서 공연은 꼭 한번 보고 싶었죠.
울산 자수정동굴나라만 관람하는것은 7천원이고 보트까지 같이 체험하는것은 합쳐서 12000원이라
동굴+보트 둘이 같이 해서 관람료를 냈습니다.
전날 네이버에서 표를 예약하면 천원정도 할인되니 참고 하시길 바랍니다
(당일은 안됩니다.) 자수정동굴나라 보기전에 먼저 보트를 타시면됩니다.
보트를 타는 입구에 가면 구명조끼를 입고 보트를 타고 출발하게되는데
안에 날씨가 밖에보다 훨씬 낮긴합니다.
물은 진한 회색에 가까운편이고 보트를 타고 볼수 있는건 그냥 불빛에 비춰지는 동굴정도라고
생각하시면될겁니다. 크게 확 와~ 하고 그러는건 없습니다.
보트 관람자체는 솔직히 금방 끝나는편입니다.
한 5분? 조금 넘는시간이였던것 같네요 보트로 슝슝~ 가다보니 금방 끝납니다.
자수정 동굴나라 입구쪽에 원래 매표소가 있는데 보트를 타는곳에 나중에 보니 
자수정동굴나라 공연시간과 결제하는기계가 있더군요.
자수정동굴나라 공연은 오복학춤 정종수(그냥 장기자랑같은;;)
필리핀판타스틱 아크로바트 공연단(이게 볼만합니다 ^^) 두가지의 공연을 같이 하는데
1회부터 6회까지 합니다. 10시30분,12시,1시30분,3시,4시30분,6시 이렇게 하루에 6번의 공연을 합니다.
공연은 정말 필수로 보시길 바랍니다.
집에 돌아오니 정말 이 공연 다시 생각납니다. 여행이 짱이구너,,,,",
"#교양#레저","#울산",11," 2019-11-11 18:45:22" ,"merung"),
(0, 7, 8,"가평 아침고요수목원 오색별빌정원전",
"크리스마스를 기념하여 여자친구와 떠난 가평의 오색별빛정원전. 
사실 이런 곳이 있는지도 모르고 있었던 찰나에 강원도 여행을 취소하고
서울 인근인 가평여행을 선택하게 되었다. 우연찮게 아침고요수목원의 
오색별빛정원전의 빛축제 기간이 딱 맞아 떨어져서 이곳에 갈 수 있께 되었다. 
주말인 토요일이라서 그런지 정말 많은 인파가 몰려 차에서 꽤나 오랫동안 기다리며 들어갈 수 있었다. 
주차공간들이 꽤나 많이 준비되어 있어서 주차 문제는 크게 신경쓰지 않았던 것 같다. 
이외에도 버스로 이곳에 갈 수 있다고 하니 위의 시간표를 참고하여
차를 가지고 오지 않으신 분들은 버스를 이용하시면 좋을 것 같다.",
"#인문#취미#레저","#경기도",301,"2018-12-24 07:10:02","dksi"),
(0, 11,12,"5","서천 판교마을, -시간이 멈춘 마을","
대학후배와 어찌어찌하다가 주말 여행을 가기로 했는데, 어디로 갈까 검색하다가 좀 색다른 곳으로 가보고 싶다는 생각을 하다가 찾은 서천 판교마을
검색에는 영 재능이 없는 내가 찾은 레트로 감성이 가득한 레트로 마을, 시간이 멈춘 듯한 공간이라는 소개가 마음에 들었다.
북적한 도시보다는 뭔가 여유롭게 옛스런 느낌이 더 반가울거같았기에 둘다 여기로 마음을 먹었다. 
숙소 정보가 별로 없어서 서천 판교마을에서 놀고, 대천으로 넘어가는 일정으로 계획한 주말 여행이었다.",
"#충청남도",109,"2019-11-30 11:26:23","용이뿐님")
;
SELECT * FROM POST;





INSERT INTO COMMENT
(post_no, mem_no, cmt_regtime,cmt_writer, cmt_content)
VALUES
	(1, 10, "2020-01-10 13:40:21","merung","화천 산천어 축제 세계 축제인지는 몰랐어요ㅎㅎ 좋은 정보 감사합니다!"),
	(1, 10, "2020-01-11 08:12:33","abcd","ㅋㅋㅋㅋ얼음나라라니 너무 귀여워요"),
	(2, 1, "2019-01-03 01:24:44","forcetome","송월동 동화마을에 해바라기 그려져 있는 벽화 보셨나요? 거기 인생 스팟이에요"),
	(2, 1, "2019-01-03 18:22:23","abcd","남자친구랑 가봐야겠어요 ㅎㅎ"),
	(2, 1, "2019-01-06 11:53:22","babe","오 사진으로 봤을땐 작아보이던데 규모가 크군요!"),
	(3, 3, "2019-12-24 12:34:44","여행마스터","죽녹원 앞에 '어머니 손맛' 칼국수 맛집 가보셨나요? 존맛입니다"),
	(3, 3, "2019-12-26 14:43:33","내가짱임","떡갈비집 주소좀 알려주세요"),
	(3, 3, "2019-12-26 14:55:11","nullid","저도 취미가 혼자 여행하는건데 항상 먹을때 외롭긴 해요,,"),
	(3, 3, "2019-12-28 12:22:44","메타세콰이어길 진짜 예뻐요","dksi"),
	(4, 4, "2019-01-20 11:35:33","dksi","아이들이랑 애니메이션 박물관 갔는데 너무 재밌어했어요 ㅋㅋㅋ"),
	(4, 4, "2019-01-21 01:35:33","여행덕후","티켓 값은 얼마인가요?"),
	(4, 4, "2019-01-25 22:10:11","여행마스터","crazy님! 춘천 시민은 7000원 일반 시민은 14000원이에요!"),
	(5, 2, "2020-01-11 12:35:25","merung","할인카드 혹시 어떤건가요?"),
	(6, 6, "2019-09-02 11:44:23","내가짱임","할매곱창의 곱창 떡볶이 존맛..."),
	(7, 7, "2020-01-27 22:10:44","babe","대기번호 100번은 양호합니다.. 저 저번에 227번이었어요"),
	(8, 4, "2019-11-14 10:44:22","여행덕후","공연 특별할게 있어요? 전 재미없던데요"),
	(9, 8, "2018-12-25 12:26:31","merung","솔직히 저는 여기 홍보빨이라고 생각"),
	(9, 8, "2018-12-26 11:23:52","abcd","남친이랑 작년에도 가보고 이번에도 갔는데 진짜 좋더라구요. 데이트코스로 추천"),
	(9, 8, "2018-12-30 17:34:54","babe","오 자동차 끌고 가야겠네요 ㅎㅎ 좋은 정보 감사횽ㅋㅋ"),
	(10, 4, "2019-11-30 18:23:55","merung","letroo.......")
;
SELECT * FROM COMMENT;
SELECT * FROM LIKES;
INSERT INTO LIKES
(like_type, post_no, liker_mem_no)
VALUES
	(1, 1, 2),
    (1, 1, 3),
    (1, 1, 5),
    (1, 1, 7),
    (1, 1, 9),
    (1, 1, 8),
    (1, 2, 3),
    (1, 2, 2),
    (1, 2, 5),
    (1, 2, 6),
    (1, 3, 1),
    (1, 3, 2);
INSERT INTO LIKES
(like_type, hotplace_no, liker_mem_no)
VALUES
    (2, 3, 10),
    (2, 4, 1),
    (2, 4, 10),
    (2, 5, 1),
    (2, 5, 10),
    (2, 5, 3),
    (2, 5, 4),
    (2, 6, 1),
    (2, 6, 2),
    (2, 6, 3),
    (2, 6, 4);
    DESC BOARD;
INSERT INTO LIKES
(like_type, festival_no, liker_mem_no)
VALUES
(3, 6, 5),
(3, 7, 1),
(3, 7, 8),
(3, 8, 1),
(3, 8, 2),
(3, 8, 9),
(3, 8, 10),
(3, 9, 1),
(3, 10, 2),
(3, 10, 3)
;
select * from festival;

select * from post;
select * from members;

SELECT * FROM LIKES;






INSERT INTO LIKES
(post_no, liker_mem_no)
VALUES
	(1, 2),
    (1, 3),
    (2, 3),
    (2, 2),
    (3, 1),
    (3, 2),
    (4, 1),
    (5, 1),
    (6, 1),
    (6, 2),
    (6, 3),
    (7, 1)
;

select post_no from post order by post_no desc limit 0, 1;


select * from likes;

 
select *
from post
where post_no in (select post_no from likes l
					right join members m
					on m.mem_no = l.liker_mem_no
					where m.mem_no = 1);
select * from likes l
					right join members m
					on m.mem_no = l.liker_mem_no
					where m.mem_no = 1;
                   
# 좋아하는 포스트들 체크하기     - members 에서 필요한 것 같은데      
select mem_id, like_no, l.post_no, post_title, post_category, post_regtime, post_hits, post_city
from members m
left join likes l on m.mem_no = l.liker_mem_no
left join post p on l.post_no = p.post_no
where m.mem_no = 1;

select *
		from members m
		left join likes l on m.mem_no = l.liker_mem_no
		where m.mem_no = 1;
DESC post;
# post 별 likes 개수
SELECT COUNT(*) 
FROM likes
WHERE post_no = 1;
DESC likes;
select * from post;
UPDATE post SET post_hits = post_hits + 1 WHERE post_no = 4;


select following_no from 
members
left join follow on members.mem_no = follow.follower_no
where members.mem_no = 1;
#member가 List로 followerList 있으면 되냐 되겠군a

select * from members 
	where mem_no in (select following_no 
					from members m
					left join follow f on m.mem_no = f.follower_no
					where m.mem_no = 1);

insert into follow(follower_no, following_no) values(1,3);
select * from follow;




SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PJT1DB';
SHOW DATABASES;
SHOW TABLES FROM PJT1DB;
SHOW TABLE STATUS FROM PJT1DB LIKE 'MEMBER'; 

use pjt1db;

show table status;

show tables;

SELECT 
m.mem_id, 
l.like_no, 
l.post_no, 
p.post_title, 
p.post_category, 
p.post_regtime, 
p.post_city, 
p.post_hits
FROM members m
LEFT JOIN likes l ON m.mem_no = l.liker_mem_no AND l.like_del_check=FALSE
LEFT JOIN post p ON l.post_no = p.post_no AND p.post_del_check=FALSE
WHERE m.mem_no = 1 AND m.mem_del_check = FALSE;

#searchMemberLikePost
SELECT 
m.mem_id, 
l.like_no, 
l.post_no, 
p.post_title, 
p.post_category, 
p.post_regtime, 
p.post_city, 
p.post_hits
FROM members m
LEFT JOIN likes l ON m.mem_no = l.liker_mem_no AND l.like_del_check=FALSE AND l.like_type = 1
LEFT JOIN post p ON l.post_no = p.post_no AND p.post_del_check=FALSE
WHERE m.mem_no = 1 AND m.mem_del_check = FALSE; 

#searchMemberLikeHotPlace
Select * from likes;
SELECT 
m.mem_id, 
l.like_no, 
l.hotplace_no, 
h.hp_name, 
h.hp_theme, 
h.hp_tag, 
h.hp_address,
h.hp_detail_adr, 
h.hp_content,
h.hp_homepage,
h.hp_holiday,
h.hp_fee,
h.hp_img
FROM members m
LEFT JOIN likes l ON m.mem_no = l.liker_mem_no AND l.like_del_check=FALSE AND l.like_type = 2
LEFT JOIN hotplace h ON l.hotplace_no = h.hp_no AND h.hp_del_check=FALSE
WHERE m.mem_no = 1 AND m.mem_del_check = FALSE; 
#searchMemberLikeFestival
select * from board;
SELECT 
m.mem_id, 
l.like_no, 
l.festival_no, 
f.fval_name, 
f.fval_theme, 
f.fval_tag, 
f.fval_address,
f.fval_detail_adr, 
f.fval_content,
f.fval_homepage,
f.fval_start_day,
f.fval_end_day,
f.fval_fee,
f.fval_host,
f.fval_img,
f.fval_ended
FROM members m
LEFT JOIN likes l ON m.mem_no = l.liker_mem_no AND l.like_del_check=FALSE AND l.like_type = 3
LEFT JOIN festival f ON l.festival_no = f.fval_no AND f.fval_del_check=FALSE
WHERE m.mem_no = 1 AND m.mem_del_check = FALSE; 


select *
from hotplace
where hp_del_check = false 
and hp_theme like concat('%','#자연','%')
or hp_theme like concat('%','#힐링','%')
;

select * from hotplace;

select * from festival;
select * from members;
#맛집 #가족 #데이트 #쇼핑 #문화 #실내 #힐링 #전통
update festival set
fval_theme = '#데이트 #힐링 #문화 #가족'
where fval_no = 9;


select * from festival
where fval_del_check = FALSE
AND
(fval_name like concat('%','','%') OR
fval_content like concat('%','','%') OR
fval_tag like concat('%','','%'));
DESC hotplace;
update festival set fval_tag = '노꿀' where fval_no = 8; 
update festival set fval_del_check = true where fval_no = 2; 
SELECT *
FROM festival
WHERE fval_del_check = FALSE 
ORDER BY fval_no
LIMIT 0, 4;
select * from hotplace;
desc files;

##########################
# 연관 DELETE를 위한 추출 쿼리
# post - like, hotplace - like, festival - like
UPDATE LIKES SET like_del_check = TRUE WHERE like_no in (0);
select * from likes;
SELECT like_no
FROM likes
WHERE like_type = 1 AND post_no = 4 AND like_del_check = FALSE;

SELECT like_no
FROM likes
WHERE like_type = 2 AND hotplace_no = 4 AND like_del_check = FALSE;

SELECT like_no
FROM likes
WHERE like_type = 3 AND festival_no = 4 AND like_del_check = FALSE;

select * from likes;
select * from members;
# post - comment, post - files
#UPDATE COMMENT SET cmt_del_check = TRUE WHERE post_no in (,,,,,,);

SELECT post_no
FROM comment
WHERE post_no = 3 AND cmt_del_check = FALSE;

#UPDATE FILES SET files_del_check = TRUE WHERE post_no in (,,,,,,);

SELECT post_no
FROM files
WHERE post_no = 2 AND files_del_check = FALSE;

# city - hotplace, city - festival 

# members - follow, members - likes, members - post, members - comment, members - qna
select * from likes;
update likes set like_del_check = false where liker_mem_no = 2 and post_no = 2;
update post set post_del_check = false where post_no = 2;
select * from post;

SELECT 
m.mem_id, 
l.like_no, 
l.post_no, 
p.post_title, 
p.post_category, 
p.post_regtime, 
p.post_city, 
p.post_hits
FROM members m
LEFT JOIN likes l ON m.mem_no = l.liker_mem_no AND l.like_del_check=FALSE AND l.like_type = 1
LEFT JOIN post p ON l.post_no = p.post_no AND p.post_del_check=FALSE
		WHERE m.mem_no = 2 AND m.mem_del_check = FALSE; 
        select * from post;
select * from comment;