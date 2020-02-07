// import userService from "../../services/UserService";
import fireService from "../../services/FirebaseService";
import UserService from "../../services/UserService";
// import naverService from "../../services/NaverService";
import router from "../../router";

const state = {
  user: {}
};

const actions = {
  check: () => {
    UserService.check();
  },
  postSignUp: (store, payload) => {
    //네이버는 아니야
    var signUpCheck = UserService.signUp(payload.user_email, payload.pw);
    console.log("signup check" + signUpCheck);
    if (signUpCheck) {
      fireService
        .signUpWithDefault(payload.user_email, payload.pw)
        .then(check => {
          if (check) router.push("/login");
          else console.log("실패");
        });
    }
  },
  postLogIn: (store, payLoad) => {
    fireService
      .loginWithDefault(payLoad.user_email, payLoad.user_pw)
      .then(check => {
        if (check) {
          UserService.LogIn(payLoad.user_email).then(result => {
            console.log(result);
            store.commit("postLogIn", { user: result });
          });
          router.push("/");
        }
      });
  },
  postGoogleLogIn: (store, payLoad) => {
    fireService
      .loginWithGoogle(payLoad.user_email, payLoad.user_pw)
      .then(response => {
        store.commit("postLogIn", {
          user: response.data.data
        });
      })
      .catch(exp => alert("로그인 실패" + exp));
    //뒤에 우리디비에서 로그인 요청
  },
  postGitHubLogIn: (store, payLoad) => {
    fireService
      .loginWithGitHub(payLoad.user_email, payLoad.user_pw)
      .then(response => {
        store.commit("postLogIn"), { user: response.data.data };
      })
      .catch(exp => alert("로그인 실패 " + exp));
    //뒤에 우리디비에서 로그인 요청
  },
  changeDeafultPw: (store, payLoad) => {
    fireService.resetPw(payLoad.email);
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
