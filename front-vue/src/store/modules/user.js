// import userService from "../../services/UserService";
import fireService from "../../services/FirebaseService";
import UserService from "../../services/UserService";
// import naverService from "../../services/NaverService";
import router from "../../router";

const state = {
  user: {},
  following: [],
  follower: [],
  likePost: [],
  likeFesta: [],
  likeHot: [],
  another: {}
};

const actions = {
  check: () => {
    UserService.check();
  },
  postSignUp: (store, payload) => {
    //네이버는 아니야
    var signUpCheck = UserService.signUp(payload);
    console.log("signup check" + signUpCheck);
    if (signUpCheck) {
      fireService
        .signUpWithDefault(payload.mem_email, payload.mem_password)
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
            console.log("result", result);
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
        store.commit("postLogIn", { user: response.data.data });
      })
      .catch(exp => alert("로그인 실패 " + exp));
    //뒤에 우리디비에서 로그인 요청
  },
  changeDeafultPw: (store, payLoad) => {
    fireService.resetPw(payLoad.email);
  },
  getFollower: (store, payLoad) => {
    UserService.followerUser(payLoad.userNo)
      .then(Response => {
        console.log(Response);
        store.commit("getFollowerUser", { a: Response });
      })
      .catch(exp => console.log(exp));
  },
  getFollowing: (store, payLoad) => {
    UserService.followingUser(payLoad.userNo)
      .then(Response => {
        console.log(Response);
        store.commit("getFollowingUser", { a: Response });
      })
      .catch(exp => console.log(exp));
  },
  getLikePost: (store, payLoad) => {
    UserService.likePost(payLoad.userNo)
      .then(Response => {
        console.log(Response);
        store.commit("getLikePostUser", { likePost: Response });
      })
      .catch(exp => console.log(exp));
  },
  getLikeHot: (store, payLoad) => {
    UserService.likeHot(payLoad.userNo)
      .then(Response => {
        console.log(Response);
        store.commit("getLikeHotUser", { likeHot: Response });
      })
      .catch(exp => console.log(exp));
  },
  getLikeFesta: (store, payLoad) => {
    UserService.likeFesta(payLoad.userNo)
      .then(Response => {
        console.log(Response);
        store.commit("getLikeFestaUser", { likeFesta: Response });
      })
      .catch(exp => console.log(exp));
  },
  getAnother: (store, payLoad) => {
    UserService.anotherUser(payLoad.userNo)
      .then(Response => {
        console.log(Response);
        store.commit("getAnotherUser", { another: Response });
      })
      .catch(exp => console.log(exp));
  }
};

const mutations = {
  postLogIn(state, payLoad) {
    state.user = payLoad.user;
  },
  postGoogleLogIn: (state, payLoad) => {
    state.user = payLoad.user;
  },
  getFollowerUser: (state, payLoad) => {
    console.log(payLoad);
    state.follower = payLoad.a;
  },
  getFollowingUser: (state, payLoad) => {
    console.log(payLoad);
    state.following = payLoad.a;
  },
  getLikePostUser: (state, payLoad) => {
    console.log(payLoad);
    state.likePost = payLoad.likePost;
  },
  getLikeFestaUser: (state, payLoad) => {
    console.log(payLoad);
    state.likeFesta = payLoad.likeFesta;
  },
  getLikeHotUser: (state, payLoad) => {
    console.log(payLoad);
    state.likeHot = payLoad.likeHot;
  },
  getAnotherUser: (state, payLoad) => {
    console.log(payLoad);
    state.another = payLoad.another;
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
