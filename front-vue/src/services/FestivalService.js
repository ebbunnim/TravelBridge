import Api from "./Api";

class FestivalService {
  // 전체 찾아오기
  searchAll() {
    return Api.get("/Festival/searchAll")
      .then(res => {
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  // 번호로 찾아오기
  searchByNo(no) {
    return Api.get(`/Festival/search/${no}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 더보기로 Festival 검색하기 조회 - searchOption은 all/ title / content/ tag /city 중 전달 - 통합 검색에 사용
  searchMoreFestival(btnCnt, searchOption, word) {
    return Api.get(`/Festival/search/page/${btnCnt}/${searchOption}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 페이지로 Festival 테마로 목록 조회 - 테마 추천에 사용
  searchMoreFestivalByTheme(btnCnt, word) {
    return Api.get(`/Festival/search/page/theme/${btnCnt}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}

export default new FestivalService();
