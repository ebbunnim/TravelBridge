import requests
import json
URL = 'https://korean.visitkorea.or.kr/call'
save =[]
cnt = 0;

urlList = []
import sys
# sys.stdout = open('outputListHotPlace.txt','w')
# for i in range(1, 24):
#     response = requests.post(
#         URL, data={'areaCode': 'All', 'cmd': 'TOUR_CONTENT_LIST_VIEW', 'cnt': '1000', 'locationx': '37.511168000000005', 'locationy': '127.029248', 'month': 'All', 'page': i, 'sigunguCode': 'All', 'sortkind': '3', 'stampId': '3d815f1c-afa0-421a-8d6c-efae95167f65', 'tagId': 'All'})
#     for item in response.json()['body']['result']:
#         if 'tagName' not in item :
#             continue
#
#         target = item['tagName']
#         name = item['title']
#         if target.find("스파") != -1 :
#             continue
#         elif target.find("숙박") != -1:
#             continue
#         elif target.find("음식") != -1:
#             continue
#         elif target.find("맛집") != -1:
#             continue
#         elif name.find("순대") != -1:
#             continue
#         elif name.find("국밥") != -1:
#             continue
#         elif target.find("비") != -1:
#             continue
#         elif target.find("목욕탕") != -1:
#             continue
#         elif target.find("묘") != -1:
#             continue
#         elif target.find("교육") != -1:
#             continue
#         elif target.find("천연기념물") != -1:
#             continue
#         else:
#             cnt+=1
#         temp = "https://korean.visitkorea.or.kr/detail/ms_detail.do?cotid=" + item['cotId'] + "&big_category=" + item[
#                     'cat1'] + "&mid_category" + item['cat2'] + "&big_area=" + item['areaCode']
#         print(temp)
sys.stdout = open('outputListFestival.txt','w')
a = []
for i in range(1, 18):
    response = requests.post(
        URL, data={"cmd":"FESTIVAL_CONTENT_LIST_VIEW","year":"All","month":"All","areaCode":"All","sigunguCode":"All","tagId":"All","locationx":"37.511168000000005","locationy":"127.029248","sortkind":"1","page":i,"cnt":"100"})
    for item in response.json()['body']['result']:
        if 'tagName' not in item:
            continue
        target = item['tagName']
        name = item['title']
        temp = "https://korean.visitkorea.or.kr/detail/fes_detail.do?cotid=" + item['cotId'] + "&big_category=" + item[
            'cat1'] + "&mid_category" + item['cat2'] + "&big_area=" + item['areaCode']
        print(temp)
# print(len(a))

# print(len(urlList))
#
# filename = 'outputList.txt'
# with open(filename) as file_object:
#     contents = file_object.read()
#
# print(contents)
# urlList = contents
# print(urlList)
# print(urlList[0])
#

