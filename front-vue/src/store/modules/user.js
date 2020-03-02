import fireService from "../../services/FirebaseService";
import UserService from "../../services/UserService";

import router from "../../router";
import PostService from "../../services/PostService";

const state = {
  user: {},
  following: [],
  follower: [],
  likePost: [],
  likeFesta: [],
  likeHot: [],
  another: {},
  userPost: [],
  gogo: false,
  tempEmail: ""
};

const actions = {
  check: () => {
    UserService.check();
  },
  postSignUp: (store, payload) => {
    //네이버는 아니야
    var signUpCheck = UserService.signUp(payload.user);

    if (payload.status) {
      if (signUpCheck) {
        fireService
          .signUpWithDefault(payload.user.mem_email, payload.user.mem_password)
          .then(check => {
            if (check) router.push("/login");
          });
      } else {
        if (signUpCheck) router.push("/login");
      }
    }
  },
  postLogIn: (store, payLoad) => {
    fireService
      .loginWithDefault(payLoad.user_email, payLoad.user_pw)
      .then(check => {
        if (check) {
          UserService.LogIn(payLoad.user_email).then(result => {
            store.commit("postLogIn", { user: result });
          });
          router.push("/");
        } else {
          alert("등록되지 않거나 비밀번호를 잘못입력하셧습니다.");
        }
      });
  },
  postGoogleLogIn: (store, payLoad) => {
    fireService
      .loginWithGoogle(payLoad.user_email, payLoad.user_pw)
      .then(async response => {
        await UserService.LogIn(response.user.email).then(Response => {
          if (Response.status != undefined && !Response.status) {
            store.commit("signUpSubEmail", { email: Response.email });
            router.push("/signup");
          } else {
            store.commit("postLogIn", { user: Response });
            router.push("/");
          }
        });
      })
      .catch(exp => alert("로그인 실패" + exp));
    //뒤에 우리디비에서 로그인 요청
  },
  postGitHubLogIn: (store, payLoad) => {
    fireService
      .loginWithGitHub(payLoad.user_email, payLoad.user_pw)
      .then(async response => {
        await UserService.LogIn(response.user.email)
          .then(Response => {
            if (Response.status != undefined && !Response.status) {
              store.commit("signUpSubEmail", { email: Response.email });
              router.push("/signup");
            } else {
              store.commit("postLogIn", { user: Response });
              router.push("/");
            }
          })
          .catch(exp => {
            alert("이미 가입된 아이디 이거나 로그인에 실패하셧습니다.");
          });
      })
      .catch(exp => alert("로그인 실패 " + exp));
  },
  changeDeafultPw: (store, payLoad) => {
    fireService.resetPw(payLoad.email);
    router.push("/login");
  },
  getFollower: (store, payLoad) => {
    UserService.followerUser(payLoad.userNo)
      .then(Response => {
        if (Response == null) {
          store.commit("getFollowerUser", { a: [] });
        } else {
          store.commit("getFollowerUser", { a: Response });
        }
      })
      .catch(exp => console.log(exp));
  },
  getFollowing: (store, payLoad) => {
    UserService.followingUser(payLoad.userNo)
      .then(Response => {
        if (Response == null) {
          store.commit("getFollowingUser", { a: [] });
        } else {
          store.commit("getFollowingUser", { a: Response });
        }
      })
      .catch(exp => console.log(exp));
  },
  getLikePost: (store, payLoad) => {
    UserService.likePost(payLoad.userNo)
      .then(Response => {
        store.commit("getLikePostUser", { likePost: Response });
      })
      .catch(exp => console.log(exp));
  },
  getLikeHot: (store, payLoad) => {
    UserService.likeHot(payLoad.userNo)
      .then(Response => {
        store.commit("getLikeHotUser", { likeHot: Response });
      })
      .catch(exp => console.log(exp));
  },
  getLikeFesta: (store, payLoad) => {
    UserService.likeFesta(payLoad.userNo)
      .then(Response => {
        store.commit("getLikeFestaUser", { likeFesta: Response });
      })
      .catch(exp => console.log(exp));
  },
  getAnother: (store, payLoad) => {
    UserService.anotherUser(payLoad.userNo)
      .then(Response => {
        store.commit("getAnotherUser", { another: Response });
      })
      .catch(exp => console.log(exp));
  },
  addF: async (store, payLoad) => {
    await UserService.addF(payLoad.x)
      .then(Response => {})
      .catch(exp => console.log(exp));
    UserService.followingUser(payLoad.x.follower_no)
      .then(Response => {
        if (Response == null) {
          store.commit("getFollowingUser", { a: [] });
        } else {
          store.commit("getFollowingUser", { a: Response });
        }
      })
      .catch(exp => console.log(exp));
  },
  delF: async (store, payLoad) => {
    await UserService.delF(payLoad.r, payLoad.ing);
    UserService.followingUser(payLoad.r)
      .then(Response => {
        if (Response == null) {
          store.commit("getFollowingUser", { a: [] });
        } else {
          store.commit("getFollowingUser", { a: Response });
        }
      })
      .catch(exp => console.log(exp));
  },
  getPostListMem: (store, payLoad) => {
    PostService.getPostListMem(payLoad.no)
      .then(Response => {
        store.commit("getUserPost", { userPost: Response });
      })
      .catch(exp => console.log(exp));
  }
};

const mutations = {
  signUpSubEmail(state, payLoad) {
    state.tempEmail = payLoad.email;
  },
  getUserPost(state, payLoad) {
    var titles = [];
    var cnt = 0;
    var ti = [];

    for (var i of payLoad.userPost) {
      if (i.post_type == 0) cnt = cnt + 1;
      else if (i.post_type == 1) cnt = cnt + 2;

      if (cnt == 4) {
        ti.push(i);
        titles.push(ti);
        ti = [];
        cnt = 0;
      } else if (cnt > 4) {
        ti.push(3);
        titles.push(ti);
        ti = [];
        cnt = 2;
        ti.push(i);
      } else if (cnt < 4) {
        ti.push(i);
      }
    }
    if (ti.length != 0) titles.push(ti);
    if (payLoad.pageNo === 1) {
      state.userPost = titles;
    } else {
      state.userPost = titles;
    }
    state.gogo = true;
  },
  postLogIn(state, payLoad) {
    state.user = payLoad.user;
  },
  postGoogleLogIn: (state, payLoad) => {
    state.user = payLoad.user;
  },
  getFollowerUser: (state, payLoad) => {
    state.follower = payLoad.a;
  },
  getFollowingUser: (state, payLoad) => {
    state.following = payLoad.a;
  },
  getLikePostUser: (state, payLoad) => {
    state.likePost = payLoad.likePost;
  },
  getLikeFestaUser: (state, payLoad) => {
    state.likeFesta = payLoad.likeFesta;
  },
  getLikeHotUser: (state, payLoad) => {
    state.likeHot = payLoad.likeHot;
  },
  getAnotherUser: (state, payLoad) => {
    state.another = payLoad.another;
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
