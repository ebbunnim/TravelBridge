import requests
import json
URL = 'https://korean.visitkorea.or.kr/call'
save =[]
cnt = 0;
for i in range(1, 24):
    response = requests.post(
        URL, data={'areaCode': 'All', 'cmd': 'TOUR_CONTENT_LIST_VIEW', 'cnt': '1000', 'locationx': '37.511168000000005', 'locationy': '127.029248', 'month': 'All', 'page': i, 'sigunguCode': 'All', 'sortkind': '1', 'stampId': '3d815f1c-afa0-421a-8d6c-efae95167f65', 'tagId': 'All'})
    for item in response.json()['body']['result']:
        if 'tagName' not in item :
            continue

        target = item['tagName']
        name = item['title']
        if target.find("스파") != -1 :
            continue
        elif target.find("숙박") != -1:
            continue
        elif target.find("음식") != -1:
            continue
        elif target.find("맛집") != -1:
            continue
        elif name.find("순대") != -1:
            continue
        elif name.find("국밥") != -1:
            continue
        elif target.find("비") != -1:
            continue
        elif target.find("목욕탕") != -1:
            continue
        elif target.find("묘") != -1:
            continue
        elif target.find("교육") != -1:
            continue
        elif target.find("천연기념물") != -1:
            continue
        else:
            cnt+=1

            # print(
            #     "https://korean.visitkorea.or.kr/detail/ms_detail.do?cotid=" + item['cotId'] + "&big_category=" + item[
            #         'cat1'] + "&mid_category" + item['cat2'] + "&big_area=" + item['areaCode'])

print(cnt)