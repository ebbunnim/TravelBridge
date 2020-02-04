import Api from "../../services/Api";
import userService from "../../services/UserService";
const state = {
  isSignUp: false,
  user: {}
};

const actions = {
  postSignIn: (store, payload) => {
    console.log("hello");
    store.state.isSignUp = false;
    userService.searchAllComment;
    Api.post("/user/info", {
      user_email: payload.user_email,
      user_pw: payload.user_pw,
      user_id: payload.user_id,
      user_grant: 0
    })
      .then(() => {
        alert("회원가입 성공");
        store.state.isSignUp = true;
      })
      .catch(exp => alert("회원가입 실패 ") + exp);
  },
  postLogIn: (store, payLoad) => {
    console.log("POST_LOGIN");
    console.log(payLoad.user_email);
    console.log(payLoad.user_pw);
    Api.post("/user/login", {
      user_email: payLoad.user_email,
      user_pw: payLoad.user_pw
    })
      .then(response => {
        console.log(response.data);
        store.commit("postLogIn", { user: response.data.data });
      })
      .catch(exp => alert("로그인 처리에 실패하였다 .") + exp);
  },
  postGoogleLogIn: (store, payLoad) => {
    console.log(payLoad.user_email + " " + payLoad.user_id);
    Api.post("/loginGoogle", {
      user_email: payLoad.user_email,
      user_id: payLoad.user_id
    })
      .then(response => {
        console.log(response.data);
        store.commit("postGoogleLogIn", {
          user: response.data.data
        });
      })
      .catch(exp => alert("google login 처리에 실패하였다" + exp));
  }
};
const mutations = {
  postLogIn(state, payLoad) {
    state.user = payLoad.user;
  },
  postGoogleLogIn: (state, payLoad) => {
    state.user = payLoad.user;
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
