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

###########################
#HOTPLACE DML

INSERT INTO 
hotplace
(city_no, hp_name, hp_address,
hp_detail_adr,hp_content,
hp_tag , hp_homepage, 
hp_holiday, hp_fee,
hp_etc) 
VALUES (
1,
"남산서울타워", "서울 용산구",
"서울특별시 용산구 남산공원길 105", 
"※ 19_20 한국관광 100선 ※ \n 남산서울타워는 한국 최초의 타워형태의 관광명소다. 높이 236.7m를 헤아리는 타워는 해발 243m인 남산의 높이까지 계산하면 실제 높이는 480m에 이르러 가히 동양최고의 타워라고 자랑할 만하다. 남산서울타워는 40년 만에 일반인에게 공개되는 서울타워플라자'와 2005년부터 CJ푸드빌이 임대하여 운영 중인 N서울타워로 구성되어 있다. 남산서울타워는 1969년 TV와 라디오 방송을 수도권에 송출하기 위해 한국 최초의 종합 전파탑으로 세워졌으며, 현재는 서울의 대표적인 복합문화공간이자 랜드마크로 자리잡았다.",
"#15_16한국관광100선 #17_18한국관광100선 #19_20한국관광100선 #가족여행 #경복궁 #고궁 #관광지 #교과서속여행 #당일치기여행 #서울 #서울근교여행 #수도권 #아이와함께 #역사 #역사유적지 #연인과함께 #전통역사문화체험 #친구와함께 #한국관광100선",
"http://www.seoultower.co.kr",
"연중무휴",
"* 전망대 - 대인 11,000원 / 소인 9,000원 \n* 헬로키티아일랜드 - 대인 8,000원 / 소인 7,000원 \n* 2종 패키지(전망대+헬로키티) - 대인 13,500원 / 소인 11,500원 \n※ 경로 요금의 경우, 전망대 및 전시관 요금에만 적용 \n※ 36개월 미만의 유아는 무료(보호자 1명당 1명에 한함, 유치원 단체의 경우 어린이 요금 적용) ※ 장애인 할인 : 1~3급의 경우 본인+동반자 1인 30% 할인, 4~6급의 경우 본인 30%할인 (패키지 및 단체 제외)\n※ 국가 유공상이자 1~3급의 경우 장애우 할인 혜택과 동일하게 적용(국가유공자 본인 경우 30% 할인)\n※ 엔그릴 이용고객은 사전 예약시 전망대를 무료로 관람하실 수 있습니다.\n * 남산 케이블카 \n운행시간 : 10:00 ~ 23:00 (단, 금~토 / 휴일 전날은 상황에 따라 연장 운행)\n운행요금 : 대인왕복 9,500원 / 대인편도 7,000원 / 소인왕복 6,500원 / 소인편도 4,000원\n※ 30명 이상 단체의 경우 단체 할인 적용\n※ 소인 (36개월 ~ 초등학생) / 65세 이상은 소인요금 적용", 
""
),
(
1,
"낙산공원",
"서울 종로구",
"서울특별시 종로구 낙산길 41",
"낙산은 서울의 형국을 구성하던 내사산(남산, 인왕산, 북악산, 낙산)의 하나로 풍수지리상 주산인 북악산의 좌청룡에 해당하는 산이다. \n이렇게 소중한 자연환경과 문화유산을 지니고 있는 낙산은 일제의 강점기를 거쳐 현재에 이르기까지 상당부분 파괴·소실되었고 \n특히 60년대 이후의 근대화 과정에서 무분별한 도시계획으로 인해 아파트와 주택이 낙산을 잠식한 채 오랜 시간 방치되어 역사적 유물로써의 제 기능을 상실하게 되었다.\n이에 서울시에서는 공원녹지확충 5개년 계획의 일환으로 낙산을 근린공원으로 지정하고 주변의 녹지축과의 연결을 도모하면서 낙산의 모습과 역사성을 복원하는 사업을 추진하게 되었다.\n * 총 면적 152,443㎡ (약 46,114평) \n* 녹지대 131,615㎡ / 광장 4,018㎡ / 기타시설 16,810㎡\n* 수목관리\n1) 수목식재 - 소나무 등 47종 107,603주\n2) 지피식물 - 구절초 등 11종 43,075본",
"#가족여행 #관광지 #나들이 #낙산공원 #데이트코스 #드라이브여행 #수도권 #아이와함께 #연인과함께 #체험학습 #친구와함께 #힐링",
"http://parks.seoul.go.kr",
"연중무휴",
"무료", 
""
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
""
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
""
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
""
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
""
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
""
);
select * from city;
select * from hotplace;

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

# 도시별로 가져오기 sub query
SELECT * 
FROM hotplace 
WHERE city_no = (SELECT city_no 
				 FROM city 
				 WHERE city_name = "전주" 
				 AND city_del_check = FALSE) 
AND hp_del_check = FALSE
ORDER BY hp_name
LIMIT 0, 3;


# 태그별로 가져오기 (태그안에 해당 단어가 있으면 다가져옴)
SELECT * 
FROM hotplace
WHERE hp_tag 
LIKE concat('%','휴식','%') 
AND hp_del_check = FALSE
ORDER BY hp_name limit 0, 3;

# 주소별로 가져오기
SELECT * 
FROM hotplace
WHERE hp_address = TRIM("서울 종로구") 
AND hp_del_check = FALSE
ORDER BY hp_name LIMIT 0, 3;

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






select p.* , m.mem_id as cmt_person, c.cmt_no, cmt_title, cmt_content             
from   comment c    
left join members m
on c.mem_no = m.mem_no                                          
right join  (select post_no, post_title, mem_id, post_content, post_category                     
					, date_format(post_regtime, '%y-%m-%d') as post_regtime
					, post_hits, ((post_end_day)-(post_start_day)) as days
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

select *
from post p
left join comment c
on p.post_no = c.post_no
left join files f
on p.post_no = f.post_no
left join course cs
on p.post_no = cs.post_no;


