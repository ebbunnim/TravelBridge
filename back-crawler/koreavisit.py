from selenium import webdrver

driver = webdriver.Chrome('Users/multicampus/Downloads/chromedriver_win32/chormedriver')

driver.implicitly_wait(3)

driver.get('https://korean.visitkorea.or.kr/main/fes_main.do')