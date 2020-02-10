import Api from "./Api";

class HotplaceService {
  // 기본 CRUD
  searchAll() {
    return Api.get("/HotPlace");
  }
  search(no) {
    return Api.get(`/HotPlace/${no}`);
  }
  insert(hp) {
    return Api.post(`/HotPlace`, hp);
  }
  delete(no) {
    return Api.delete(`/HotPlace/${no}`);
  }
  update(hp) {
    return Api.update(`/HotPlace`, hp);
  }
  searchMoreHotPlaceAll(btnCnt) {
    return Api.get(`/HotPlace/search/more/${btnCnt}`);
  }
  searchPageHotPlaceAll() {
    return Api.get(`/HotPlace/search/pageAll`);
  }
  searchMoreHotPlaceByCityName(btnCnt, keyword) {
    return Api.get(`/HotPlace/search/more/cityname/${btnCnt}/${keyword}`);
  }
  searchPageHotPlaceByCityName(keyword) {
    return Api.get(`/HotPlace/search/page/cityname/${keyword}`);
  }
  searchMoreHotPlaceByTag(btnCnt, keyword) {
    return Api.get(`/HotPlace/search/more/tag/${btnCnt}/${keyword}`);
  }
  searchPageHotPlaceByTag(keyword) {
    return Api.get(`/HotPlace/search/page/tag/${keyword}`);
  }
  //
  searchMoreHotPlaceByAddress(btnCnt, keyword) {
    return Api.get(`/HotPlace/search/more/address/${btnCnt}/${keyword}`);
  }
  searchPageHotPlaceByAddress(keyword) {
    return Api.get(`/HotPlace/search/page/address/${keyword}`);
  }
}

export default new HotplaceService();
