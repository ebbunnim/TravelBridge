import Api from "./Api";

class HotPlaceService {
  // 전체 찾아오기
  searchAll() {
    return Api.get("/HotPlace")
      .then(res => {
        console.log("js다");
        console.log(res.data.data);
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  // 번호로 찾아오기
  searchByNo(payload) {
    console.log("pay", payload)
    let pay = payload
  
    // const no = pay.no
    return Api.get(`/HotPlace/`+pay)
      .then(res => {
        console.log(typeof pay);
        console.log("서비스", res.data);
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // insert(hp) {
  //   return Api.post(`/HotPlace`, hp);
  // }
  // delete(no) {
  //   return Api.delete(`/HotPlace/${no}`);
  // }
  // update(hp) {
  //   return Api.update(`/HotPlace`, hp);
  // }
  //

  // 더보기 버튼으로 처리
  searchMoreHotPlaceAll(btnCnt) {
    return Api.get(`/HotPlace/search/more/${btnCnt}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // 도시 (city table) 로 검색
  searchMoreHotPlaceByCityName(btnCnt, cityName) {
    return Api.get(`/HotPlace/search/more/cityname/${btnCnt}/${cityName}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // Tag 로 검색
  searchMoreHotPlaceByTag(btnCnt, tag) {
    return Api.get(`/HotPlace/search/more/tag/${btnCnt}/${tag}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  // 주소로 검색
  searchMoreHotPlaceByAddress(btnCnt, address) {
    return Api.get(`/HotPlace/search/more/address/${btnCnt}/${address}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 테마(8개) 로 검색
  searchMoreHotPlaceByTheme(btnCnt, word) {
    console.log(`/HotPlace/search/more/theme/${btnCnt}/${word}`);
    return Api.get(`/HotPlace/search/more/theme/${btnCnt}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  // 더보기로 HotPlace 검색하기 조회 - searchOption은 all/ title / content/ tag중 전달
  searchMoreHotplace(btnCnt, searchOption, word) {
    return Api.get(`/HotPlace/search/more/${btnCnt}/${searchOption}/${word}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}

export default new HotPlaceService();
