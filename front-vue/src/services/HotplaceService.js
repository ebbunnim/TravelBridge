import Api from "./Api";

class HotplaceService {
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
  searchByNo(no) {
    return Api.get(`/HotPlace/${no}`)
      .then(res => {
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
  // 전체
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
  // searchPageHotPlaceAll() {
  //   return Api.get(`/HotPlace/search/pageAll`);
  // }
  // searchPageHotPlaceByCityName(keyword) {
  //   return Api.get(`/HotPlace/search/page/cityname/${keyword}`);
  // }
  // searchPageHotPlaceByTag(keyword) {
  //   return Api.get(`/HotPlace/search/page/tag/${keyword}`);
  // }
  // searchPageHotPlaceByAddress(keyword) {
  //   return Api.get(`/HotPlace/search/page/address/${keyword}`);
  // }
}

export default new HotplaceService();
