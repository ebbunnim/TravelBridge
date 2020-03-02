# -*-coding:utf-8 -*-
from selenium import webdriver
from bs4 import BeautifulSoup
from pprint import pprint as pp;
from selenium.webdriver.common.alert import Alert
filename = 'outputListFestival.txt'
with open(filename) as data:
    festival = data.readlines()

def find_xpath(url):
    return driver.find_element_by_xpath(url)

from datetime import datetime
import pymysql
import logging as logger
#
# def insertToBackupTable(cursor, word, repword, index, system):
#     repword = ''.join(headword.split()) #공백제거
#     channel = system.split("-")[0] # 시스템단계구분제거
#     query="""insert into word_backup_"""+channel+"""(word,repword,index,system) values ("%s","%s","%s","%s)""" % (word,repword,index,system)
#     cursor.execute(query)
# [출처] 파이썬 pymysql 사용하기(예외처리)|작성자 Benny
def insertToDB(fval):
    # 접속
    db = pymysql.connect(host='pjt1db.c0qtd0bxrfyu.ap-northeast-2.rds.amazonaws.com',
                         port=3306,
                         user='TravelBridge',
                         passwd='xmfoqmfqmfltwl',
                         db='pjt1db',
                         charset='utf8')

    try:
        with db.cursor() as cursor:  # control structure of database
            fakeStr =   str(fval[fval_key[0]]) +',"'\
                      + str(fval[fval_key[1]]) +'","'\
                      + str(fval[fval_key[2]])+'","'\
                      + str(fval[fval_key[3]]) +'","'\
                      + str(fval[fval_key[4]]) +'","'\
                      + str(fval[fval_key[5]]) +'","'\
                      + str(fval[fval_key[6]]) +'","'\
                      + str(fval[fval_key[7]])+'","'\
                      + str(fval[fval_key[8]])+'","'\
                      + str(fval[fval_key[9]])+'","' \
                      + str(fval[fval_key[10]]) + '","' \
                      + str(fval[fval_key[11]]) + '","' \
                      + str(fval[fval_key[12]]+'"')

            sql = """
            INSERT
            INTO
            FESTIVAL
            (city_no, fval_name,
             fval_address, fval_detail_adr,
             fval_content, fval_tag,
             fval_start_day, fval_end_day,
             fval_homepage,
             fval_fee, fval_img,
             fval_host, fval_theme)
            VALUES( """ + fakeStr +""")"""
        # sql 실행
            cursor.execute(sql)
            # result = cursor.fetchall()
            # for row_data in result:
            #     print(row_data)
            # db에 commit
            db.commit()
    except Exception as e:
        logger.error(e)
        logger.exception(e)
        raise
        print("INSERT 실패")
    finally:
        db.close()

city_no = {
    "서울" : 1,
    "전북" : 2,
    "부산" : 3,
    "대구" : 4,
    "인천" : 5,
    "광주" : 6,
    "대전" : 7,
    "울산" : 8,
    "세종" : 9,
    "경기" : 10,
    "강원" : 11,
    "충북" : 12,
    "충남" : 13,
    "전남" : 14,
    "경북" : 15,
    "경남" : 16,
    "제주" : 17
}
tags = ["맛집", "가족", "데이트", "쇼핑", "문화", "실내", "힐링", "전통"]
# hp_key = ["city_no", "hp_name", "hp_address", "hp_detail_adr", "hp_content", "hp_tag" , "hp_homepage", "hp_holiday", "hp_fee", "hp_img", "hp_theme"]
fval_key = ["city_no", "fval_name", "fval_address", "fval_detail_adr", "fval_content", "fval_tag", "fval_start_day", "fval_end_day", "fval_homepage", "fval_fee", "fval_img", "fval_host", "fval_theme","fval_ended"]

chromeOptions = webdriver.ChromeOptions()
prefs = {"download.default_directory": "D:\\workspace_python\\chromedriver_win32\\down"}  # 다운로드 폴더 설정
chromeOptions.add_experimental_option("prefs", prefs)
# 드라이버 실행

DRIVER_PATH = 'D:\\workspace_python\\chromedriver_win32\\chromedriver.exe'
length = len(festival)
try:
    for i in range(24, length):
        driver = webdriver.Chrome(DRIVER_PATH, chrome_options=chromeOptions)
        url = festival[i].replace("\n", "")
        driver.get(url)
        fval = {"city_no":0, "fval_name":" ", "fval_address":" ", "fval_detail_adr":" ", "fval_content":" ", "fval_tag":" ", "fval_start_day":" ", "fval_end_day":" ", "fval_homepage":" ", "fval_fee":" ", "fval_img":" ","fval_host":" ", "fval_theme":" ","fval_ended":"FALSE"}
        # hp = {"city_no":0, "hp_name":" ", "hp_address":" ", "hp_detail_adr":" ", "hp_content":" ", "hp_tag":" " , "hp_homepage":" ", "hp_holiday":" ", "hp_fee":" ", "hp_img":" ", "hp_theme":" "}
        # title
        title = find_xpath('//*[@id="contents"]/div[1]/h2')
        fval[fval_key[1]] = title.text
        # address
        elem = find_xpath('//*[@id="contents"]/div[1]/div[2]/span[1]')
        address = elem.text
        fval[fval_key[2]] = address
        try:
            fval[fval_key[0]] = city_no[address.split(" ")[0]]
        except:
            pass
        # content
        content = find_xpath('//*[@id="contents"]/div[2]/div[3]/div[1]/div/div/p')
        fval[fval_key[4]] = content.text
        fval[fval_key[4]] = fval[fval_key[4]].replace("\n", "<br>").replace('"', "'")
        #tag
        elem = find_xpath('//*[@id="contents"]/div[2]/div[4]/ul')
        temp = elem.text
        temp = temp.replace("\n", " ")
        fval[fval_key[5]] = temp
        #theme
        tagString = ""
        for tag in tags:
            if fval["fval_tag"].find(tag) != -1:
                tagString += ("#"+tag+" ")
        fval[fval_key[12]] = tagString
        #img
        try:
            html = driver.page_source
            soup = BeautifulSoup(html, 'lxml')
            imgs = soup.find('div','imgReg').find_all('img')[1];#find_xpath('//*[@id="contents"]/div[2]/div[2]/div[1]/div[1]/div/div/span/img').get_attribute("src")
            fval[fval_key[10]] = imgs["src"]
        except:
            fval[fval_key[10]] = " "
            pass
        # detail_info
        elem = find_xpath('//*[@id="contents"]/div[2]/div[3]/div[2]/div/div/ul')
        html = driver.page_source
        soup = BeautifulSoup(html, 'lxml')
        detail_info = soup.find('div', 'area_txtView bottom').find_all('li')

        for j in (detail_info):
            Str = j.find('strong').get_text()
            Txt = j.find('span').get_text().replace("\n","<br>")

            if Str == "주소":
                fval[fval_key[3]] = Txt
            elif Str == "시작일":
                fval[fval_key[6]] = Txt
            elif Str == "종료일":
                fval[fval_key[7]] = Txt
            elif Str == "홈페이지":
                fval[fval_key[8]] = Txt
            elif Str == "이용요금":
                fval[fval_key[9]] = Txt
            elif Str == "주관":
                fval[fval_key[11]] =Txt


        driver.close()
        pp(fval)
        insertToDB(fval)
except:
    pass

 # '충남 당진시',
 # 'hp_content': '해변이 남북으로 길게뻗은 충청남도 서해의 땅끝 해안이 동쪽을 향해 툭 튀어 나와 일출, 일몰, 월출을 한 곳에서 '
 #               '볼 수 있는 관광명소로 신년 해돋이 축제 때에는 10만여 명의 인파가 몰린다. 동해의 일출이 정열적이라면 '
 #               '왜목마을의 일출은 서정적이라 할 수 있다. 하지와 동지를 기준으로 국화도와 장고한 해안선 끝자락 산을 사이에 '
 #               '두고 해돋이를 감상할 수 있으며 해안선을 따라 수변데크가 설치되어 맨발로 해변을 산책할 수 있다. 해가 장고항의 '
 #               '노적봉(남근바위)에 걸리는 11월과 2월이 마치 한폭의 동양화처럼 아름다워 전국의 사진작가들이 많이 찾는다.',
 # 'hp_detail_adr': '충청남도 당진시 석문면 왜목길 26',
 # 'hp_fee': ' ',
 # 'hp_holiday': ' ',
 # 'hp_homepage': 'a href="http://www.waemok.org/" target="_blank" title="새창 : '
 #                '왜목마을 사이트로 이동">http://www.waemok.org왜목마을 <br>관광지번영회 '
 #                'http://www.waemok.kr',
 # 'hp_img': 'https://support.visitkorea.or.kr/img/call?cmd=VIEW&id=89f7e104-0ff5-4132-8ee7-69593365241b',
 # 'hp_name': '왜목마을',
 # 'hp_tag': '#가족여행 #경치좋은곳 #관광지 #수상지관광코스 #연인과함께 #연중무휴 #왜목마을 #일출일몰명소 #자연 #자연마을 '
 #           '#자연환경 #추천가볼만한곳 #충청권 #해넘이여행 #해돋이 #해맞이',