import Api from "./Api";

class FestivalService {
  // 기본 CRUD
  searchAll() {
    return Api.get("/Festival/searchAll");
  }
  search(fval_no) {
    return Api.get(`/Festival/search/${fval_no}`);
  }
  insert(festival) {
    return Api.post(`/Festival/insert`, festival);
  }
  delete(fval_no) {
    return Api.delete(`/Festival/delete/${fval_no}`);
  }
  update(city) {
    return Api.update(`/Festival/update`, city);
  }
  searchMoreFestivalAll(btnCnt) {
    return Api.get(`/Festival/search/more/${btnCnt}`);
  }
  searchPageFestivalAll() {
    return Api.get(`/Festival/search/pageAll`);
  }
  searchMoreFestivalByCityName(btnCnt, keyword) {
    return Api.get(`/Festival/search/more/cityname/${btnCnt}/${keyword}`);
  }
  searchPageFestivalByCityName(keyword) {
    return Api.get(`/Festival/search/page/cityname/${keyword}`);
  }
  searchMoreFestivalByTag(btnCnt, keyword) {
    return Api.get(`/Festival/search/more/tag/${btnCnt}/${keyword}`);
  }
  searchPageFestivalByTag(keyword) {
    return Api.get(`/Festival/search/page/tag/${keyword}`);
  }
}

export default new FestivalService();
