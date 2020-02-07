import Api from "./Api";

class UserService {
  async signUp(member) {
    console.log("hello");
    return await Api.post("/Members/insert", member)
      .then(() => {
        alert("회원가입 성공");
        return true;
      })
      .catch(exp => {
        alert("회원가입 실패 " + exp);
        return false;
      });
  }

  LogIn(email) {
    console.log(email);
    return Api.post("/Members/login", {
      mem_email: email
    }).then(response => {
      return response.data.data;
    });
  }
}

export default new UserService();
