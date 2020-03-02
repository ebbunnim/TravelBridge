import Api from "./Api";

class HotPlaceService {
  // 전체 찾아오기
  searchAll() {
    return Api.get("/HotPlace")
      .then(res => {
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  // 번호로 찾아오기
  searchByNo(no) {
    return Api.get(`/HotPlace/${no}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 더보기로 HotPlace 검색하기 조회 - searchOption은 all/ title / content/ tag /city 중 전달
  searchMoreHotplace(btnCnt, searchOption, word) {
    return Api.get(`/HotPlace/search/page/${btnCnt}/${searchOption}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 테마(8개) 로 검색 - 테마 추천에 사용
  searchMoreHotPlaceByTheme(btnCnt, word) {
    return Api.get(`/HotPlace/search/page/theme/${btnCnt}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}

export default new HotPlaceService();
