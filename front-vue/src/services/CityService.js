import Api from "./Api";

class CityService {
  searchAll() {
    return Api.get("/City")
      .then(res => {
        console.log(res.data.data);
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  search(no) {
    return Api.get(`/City/${no}`)
      .then(res => {
        console.log(res.data.data);
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  // insert(city) {
  //   return Api.post(`/City/`, city);
  // }
  // delete(no) {
  //   return Api.delete(`/city/${no}`);
  // }
  // update(city) {
  //   return Api.update(`/City`, city);
  // }
}

export default new CityService();
