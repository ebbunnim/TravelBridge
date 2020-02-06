import Api from "./Api";

class UserService {
  signUp(email, password) {
    console.log("hello");
    Api.post("/user/info", {
      user_email: email,
      user_pw: password,
      user_grant: 0
    })
      .then(() => {
        alert("회원가입 성공");
        return true;
      })
      .catch(exp => {
        alert("회원가입 실패 ") + exp;
        return false;
      });
  }

  LogIn(email) {
    console.log(email);
    Api.post("/user/login", {
      user_email: email
    }).then(response => {
      alert("로그인 성공" + response);
    });
  }
}

export default new UserService();
