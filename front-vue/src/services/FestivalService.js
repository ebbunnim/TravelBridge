import Api from "./Api";

class FestivalService {
  // 전체 찾아오기
  searchAll() {
    return Api.get("/Festival/searchAll")
      .then(res => {
        console.log(res.data.data);
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  // 번호로 찾아오기
  searchByNo(fval_no) {
    return Api.get(`/Festival/search/${fval_no}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // insert(festival) {
  //   return Api.post(`/Festival/insert`, festival);
  // }
  // delete(fval_no) {
  //   return Api.delete(`/Festival/delete/${fval_no}`);
  // }
  // update(city) {
  //   return Api.update(`/Festival/update`, city);
  // }

  // 더보기 버튼으로 처리 (모두 GET)
  // 전체 검색
  searchMoreFestivalAll(btnCnt) {
    return Api.get(`/Festival/search/more/${btnCnt}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // 도시 (city table) 로 검색
  searchMoreFestivalByCityName(btnCnt, keyword) {
    return Api.get(`/Festival/search/more/cityname/${btnCnt}/${keyword}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // Tag 로 검색
  searchMoreFestivalByTag(btnCnt, keyword) {
    return Api.get(`/Festival/search/more/tag/${btnCnt}/${keyword}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  searchMoreFestivalByTheme(btnCnt, word) {
    return Api.get(`/Festival/search/more/theme/${btnCnt}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 더보기로 Festival 검색하기 조회 - searchOption은 all/ title / content/ tag중 전달
  searchMoreFestival(btnCnt, searchOption, word) {
    return Api.get(`/Festival/search/more/${btnCnt}/${searchOption}/${word}`)
      .then(res => {
        console.log("여그가 여그냐!!!!? ", res);
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}

export default new FestivalService();
