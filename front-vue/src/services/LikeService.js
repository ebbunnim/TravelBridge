import Api from "./Api";

class LikeService {
  insertLike(payload) {
    return Api.post(`/Likes/insert`, payload)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  deleteLike(like_no) {
    return Api.delete(`/Likes/delete/${like_no}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  //
}

export default new LikeService();
