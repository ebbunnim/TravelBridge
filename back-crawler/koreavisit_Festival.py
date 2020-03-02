import sys
import requests
import json
URL = 'https://korean.visitkorea.or.kr/call'
save = []
cnt = 0

urlList = []
sys.stdout = open('outputListFestival.txt', 'w')
a = []
for i in range(1, 18):
    response = requests.post(
        URL, data={"cmd": "FESTIVAL_CONTENT_LIST_VIEW", "year": "All", "month": "All", "areaCode": "All", "sigunguCode": "All", "tagId": "All", "locationx": "37.511168000000005", "locationy": "127.029248", "sortkind": "1", "page": i, "cnt": "100"})
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
