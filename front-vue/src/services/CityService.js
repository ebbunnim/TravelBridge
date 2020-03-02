import Api from "./Api";

class CityService {
  searchAll() {
    return Api.get("/City")
      .then(res => {
        
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
  search(no) {
    return Api.get(`/City/${no}`)
      .then(res => {
  
        return res.data.data;
      })
      .catch(e => console.log(e));
  }
 
}

export default new CityService();
