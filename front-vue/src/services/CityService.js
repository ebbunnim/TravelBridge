import Api from "./Api";

class CityService {
  searchAll() {
    return Api.get("/City");
  }
  search(no) {
    return Api.get(`/City/${no}`);
  }
  insert(city) {
    return Api.post(`/City/`, city);
  }
  delete(no) {
    return Api.delete(`/city/${no}`);
  }
  update(city) {
    return Api.update(`/City`, city);
  }
}

export default new CityService();
