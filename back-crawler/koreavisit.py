import requests
import json
URL = 'https://korean.visitkorea.or.kr/call'
response = requests.post(
    URL, data={'areaCode': 'All', 'cmd': 'TOUR_CONTENT_LIST_VIEW', 'cnt': '10', 'locationx': '37.511168000000005', 'locationy': '127.029248', 'month': 'All', 'page': '2', 'sigunguCode': 'All', 'sortkind': '1', 'stampId': '3d815f1c-afa0-421a-8d6c-efae95167f65', 'tagId': 'All'})

print(response.text)
