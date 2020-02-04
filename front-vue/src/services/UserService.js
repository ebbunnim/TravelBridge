import Api from "./Api";

class UserService {
  searchAllComment() {
    let temp = Api.get("comment/search").then(result => {
      return result.data.data;
    });
    return temp;
  }

  selectComment(cmt_no) {
    return Api.get(`comment/${cmt_no}`);
  }
}

export default new UserService();
