import PostService from "../../services/PostService";
import UserService from "../../services/UserService";
import router from "../../router";

const state = {
  post: {},
  postList: [],
  gogo: false,
  postLast: 0,
  likePost: {}
};

const actions = {
  addPost: async (store, payLoad) => {
    await PostService.PostInsertPost(payLoad.x).then(response => {});
    router.push("/page1/main1search");
  },
  searchAllPost: store => {
    PostService.GetSearchAllPost().then(response => {
      store.commit("postListAll", { postList: response });
    });
  },
  searchPartPost: (store, payload) => {
    PostService.GetSearchAllPost(
      payload.pageNo,
      payload.option,
      payload.keyword
    ).then(response => {
      store.commit("postListAll", {
        postList: response,
        pageNo: payload.pageNo
      });
    });
  },
  searchInfoPost: (store, payload) => {
    PostService.GetSearchPost(payload.postNo).then(response => {
      store.commit("postInfo", { post: response });
    });
  },
  searchAllFollower: (store, payload) => {
    PostService.GetSearchFollow(payload.userno).then(Response => {
      store.commit("postListAll", { postList: Response });
    });
  },
  insertFile: (store, payLoad) => {
    PostService.insertPostFile(payLoad.x);
  },
  postLast: store => {
    PostService.LastNo().then(Response => {
      store.commit("postLastNo", { lastNo: Response });
    });
  },
  insertPlan: (store, payLoad) => {
    PostService.insertPlan(payLoad.x);
  },
  getPostLike: (store, payLoad) => {
    PostService.getSearchLikePost(payLoad.mem_no, payLoad.post_no).then(
      Response => {
        store.commit("postGetLike", { likePost: Response });
      }
    );
  },
  setPostLike: async (store, payLoad) => {
    await PostService.setPostLike(payLoad.x).then(Response => {});

    PostService.getSearchLikePost(
      payLoad.x.liker_mem_no,
      payLoad.x.post_no
    ).then(Response => {
      store.commit("postGetLike", { likePost: Response });
    });
  },
  deleteLikePost: async (store, payLoad) => {
    await PostService.deleteLikePost(payLoad.no).then(() => {
      store.commit("deletePostLike");
    });

    PostService.getSearchLikePost(payLoad.mem_no, payLoad.post_no).then(
      Response => {
        store.commit("postGetLike", { likePost: Response });
      }
    );
  },
  addCmt: async (store, payLoad) => {
    await UserService.addCmt(payLoad.x)
      .then(Response => {})
      .catch(exp => console.log(exp));
    PostService.GetSearchPost(payLoad.postNo).then(response => {
      store.commit("postInfo", { post: response });
    });
  }
};

const mutations = {
  deletePostLike(state, payLoad) {
    state.likePost = {};
  },
  postSetLike(state, payLoad) {
    state.like = payLoad.like;
  },
  postUnLike(state, payLoad) {
    state.like = payLoad.like;
  },
  postGetLike(state, payLoad) {
    state.likePost = payLoad.likePost;
  },
  postLastNo(state, payLoad) {
    state.postLast = payLoad.lastNo;
  },
  postInfo(state, payLoad) {
    state.post = payLoad.post;
  },
  postListAll(state, payLoad) {
    var titles = [];
    var cnt = 0;
    var ti = [];
    console.log(payLoad.postList);
    for (var i of payLoad.postList) {
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
      state.postList = titles;
    } else {
      state.postList = titles;
    }
    state.gogo = true;
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
