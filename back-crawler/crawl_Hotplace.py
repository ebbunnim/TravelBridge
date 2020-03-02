# -*-coding:utf-8 -*-
import pymysql
import logging as logger
from selenium import webdriver
from bs4 import BeautifulSoup
from pprint import pprint as pp
from selenium.webdriver.common.alert import Alert
# Read Files
filename = 'outputListHotPlace.txt'
with open(filename) as data:
    hotplace = data.readlines()


def find_xpath(url):
    return driver.find_element_by_xpath(url)


# Insert To Festival


def insertToDB(hp):
    # 접속
    db = pymysql.connect(host='pjt1db.c0qtd0bxrfyu.ap-northeast-2.rds.amazonaws.com',
                         port=3306,
                         user='TravelBridge',
                         passwd='xmfoqmfqmfltwl',
                         db='pjt1db',
                         charset='utf8')

    try:
        with db.cursor() as cursor:  # control structure of database
            fakeStr = str(hp[hp_key[0]]) + ',"' + str(hp[hp_key[1]]) + '","' + str(hp[hp_key[2]])+'","' + str(hp[hp_key[3]]) + '","' + str(hp[hp_key[4]]) + '","' + str(
                hp[hp_key[5]]) + '","' + str(hp[hp_key[6]]) + '","' + str(hp[hp_key[7]])+'","' + str(hp[hp_key[8]])+'","' + str(hp[hp_key[9]])+'","' + str(hp[hp_key[10]]+'"')
            sql = """
                INSERT INTO 
                HOTPLACE
                (city_no, hp_name, hp_address,
                hp_detail_adr, hp_content,
                hp_tag, hp_homepage,
                hp_holiday, hp_fee,
                hp_img, hp_theme) 
                VALUES (""" + fakeStr+""")"""
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
    "서울": 1,
    "전북": 2,
    "부산": 3,
    "대구": 4,
    "인천": 5,
    "광주": 6,
    "대전": 7,
    "울산": 8,
    "세종": 9,
    "경기": 10,
    "강원": 11,
    "충북": 12,
    "충남": 13,
    "전남": 14,
    "경북": 15,
    "경남": 16,
    "제주": 17
}
tags = ["맛집", "가족", "데이트", "쇼핑", "문화", "실내", "힐링", "전통"]
hp_key = ["city_no", "hp_name", "hp_address", "hp_detail_adr", "hp_content",
          "hp_tag", "hp_homepage", "hp_holiday", "hp_fee", "hp_img", "hp_theme"]

# Selenium + Beautiful Soup
chromeOptions = webdriver.ChromeOptions()
# 다운로드 폴더 설정
prefs = {"download.default_directory": "D:\\workspace_python\\chromedriver_win32\\down"}
chromeOptions.add_experimental_option("prefs", prefs)
# 드라이버 실행

DRIVER_PATH = 'D:\\workspace_python\\chromedriver_win32\\chromedriver.exe'
length = len(hotplace)
for i in range(0, length):
    driver = webdriver.Chrome(DRIVER_PATH, chrome_options=chromeOptions)
    url = hotplace[i].replace("\n", "")
    driver.get(url)
    hp = {"city_no": 0, "hp_name": " ", "hp_address": " ", "hp_detail_adr": " ", "hp_content": " ",
          "hp_tag": " ", "hp_homepage": " ", "hp_holiday": " ", "hp_fee": " ", "hp_img": " ", "hp_theme": " "}
    # title
    elem = find_xpath('//*[@id="contents"]/div[1]/h2')
    hp[hp_key[1]] = elem.text
    # address
    elem = find_xpath('//*[@id="contents"]/div[1]/div[2]/span[1]')
    temp = elem.text
    hp[hp_key[2]] = temp
    hp[hp_key[0]] = city_no[temp.split(" ")[0]]
    # content
    elem = find_xpath('//*[@id="contents"]/div[2]/div[3]/div[1]/div/div/p')
    hp[hp_key[4]] = elem.text
    hp[hp_key[4]] = hp[hp_key[4]].replace("\n", "<br>").replace('"', "'")
    # tag
    elem = find_xpath('//*[@id="contents"]/div[2]/div[4]/ul')
    temp = elem.text
    temp = temp.replace("\n", " ")
    hp[hp_key[5]] = temp
    tagString = ""
    for tag in tags:
        if hp["hp_tag"].find(tag) != -1:
            tagString += ("#"+tag+" ")
    hp[hp_key[10]] = tagString
    # img
    try:
        elem = find_xpath(
            '//*[@id="contents"]/div[2]/div[2]/div[1]/div[1]/div/div/span/img').get_attribute("src")
        hp[hp_key[9]] = elem
    except:
        hp[hp_key[9]] = " "
        pass
    # detail_info
    elem = find_xpath('//*[@id="contents"]/div[2]/div[3]/div[2]/div/div/ul')
    html = driver.page_source
    soup = BeautifulSoup(html, 'lxml')
    detail_info = soup.find('div', 'area_txtView bottom').find_all('li')
    for j in (detail_info):
        Str = j.find('strong').get_text()
        Txt = j.find('span').get_text().replace("\n", "<br>")
        if Str == "주소":
            hp[hp_key[3]] = Txt
        elif Str == "홈페이지":
            hp[hp_key[6]] = Txt
        elif Str == "휴일":
            hp[hp_key[7]] = Txt
        elif Str == "입 장 료":
            hp[hp_key[8]] = Txt
    driver.close()
    pp(hp)
    insertToDB(hp)
