# -*-coding:utf-8 -*-
from datetime import datetime
import logging as logger
import pymysql
from selenium import webdriver
from bs4 import BeautifulSoup
from pprint import pprint as pp
from selenium.webdriver.common.alert import Alert
# Read Files
filename = 'outputListFestival.txt'
with open(filename) as data:
    festival = data.readlines()


def find_xpath(url):
    return driver.find_element_by_xpath(url)


# Insert To Festival


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
            fakeStr = str(fval[fval_key[0]]) + ',"'\
                + str(fval[fval_key[1]]) + '","'\
                + str(fval[fval_key[2]])+'","'\
                + str(fval[fval_key[3]]) + '","'\
                + str(fval[fval_key[4]]) + '","'\
                + str(fval[fval_key[5]]) + '","'\
                + str(fval[fval_key[6]]) + '","'\
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
            VALUES( """ + fakeStr + """)"""
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
fval_key = ["city_no", "fval_name", "fval_address", "fval_detail_adr", "fval_content", "fval_tag", "fval_start_day",
            "fval_end_day", "fval_homepage", "fval_fee", "fval_img", "fval_host", "fval_theme", "fval_ended"]

# Selenium + Beautiful Soup
chromeOptions = webdriver.ChromeOptions()
# 다운로드 폴더 설정
prefs = {"download.default_directory": "D:\\workspace_python\\chromedriver_win32\\down"}
chromeOptions.add_experimental_option("prefs", prefs)
# 드라이버 실행

DRIVER_PATH = 'D:\\workspace_python\\chromedriver_win32\\chromedriver.exe'
length = len(festival)
try:
    for i in range(0, length):
        driver = webdriver.Chrome(DRIVER_PATH, chrome_options=chromeOptions)
        url = festival[i].replace("\n", "")
        driver.get(url)
        fval = {"city_no": 0, "fval_name": " ", "fval_address": " ", "fval_detail_adr": " ", "fval_content": " ", "fval_tag": " ", "fval_start_day": " ",
                "fval_end_day": " ", "fval_homepage": " ", "fval_fee": " ", "fval_img": " ", "fval_host": " ", "fval_theme": " ", "fval_ended": "FALSE"}
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
        content = find_xpath(
            '//*[@id="contents"]/div[2]/div[3]/div[1]/div/div/p')
        fval[fval_key[4]] = content.text
        fval[fval_key[4]] = fval[fval_key[4]].replace(
            "\n", "<br>").replace('"', "'")
        # tag
        elem = find_xpath('//*[@id="contents"]/div[2]/div[4]/ul')
        temp = elem.text
        temp = temp.replace("\n", " ")
        fval[fval_key[5]] = temp
        # theme
        tagString = ""
        for tag in tags:
            if fval["fval_tag"].find(tag) != -1:
                tagString += ("#"+tag+" ")
        fval[fval_key[12]] = tagString
        # img
        try:
            html = driver.page_source
            soup = BeautifulSoup(html, 'lxml')
            imgs = soup.find('div', 'imgReg').find_all('img')[1]
            # find_xpath('//*[@id="contents"]/div[2]/div[2]/div[1]/div[1]/div/div/span/img').get_attribute("src")
            fval[fval_key[10]] = imgs["src"]
        except:
            fval[fval_key[10]] = " "
            pass
        # detail_info
        elem = find_xpath(
            '//*[@id="contents"]/div[2]/div[3]/div[2]/div/div/ul')
        html = driver.page_source
        soup = BeautifulSoup(html, 'lxml')
        detail_info = soup.find('div', 'area_txtView bottom').find_all('li')

        for j in (detail_info):
            Str = j.find('strong').get_text()
            Txt = j.find('span').get_text().replace("\n", "<br>")

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
                fval[fval_key[11]] = Txt

        driver.close()
        pp(fval)
        insertToDB(fval)
except:
    pass
