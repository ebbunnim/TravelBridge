import Api from "./Api";

class LikeService {
  insertLike() {
    return Api.post("/Likes/insert", payload)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}

export default new LikeService();
