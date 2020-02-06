import Api from "./Api";

class UserService {
  async signUp(email) {
    console.log("hello");
    return await Api.post("/Members/insert", {
      mem_email: email,
      mem_id: "asd",
      mem_phone: "010-000-0000"
    })
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
