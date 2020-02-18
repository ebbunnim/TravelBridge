import PostService from "../../services/PostService";
// import RouterService from "../../router";

const state = {
  post: {},
  postList: [],
  gogo: false
};
// GetSearchAllPost
//GetSearchPartPost
//GetSearchPost
//PostInsertPost
const actions = {
  searchAllPost: store => {
    PostService.GetSearchAllPost().then(response => {
      store.commit("postListAll", { postList: response });
    });
  },
  searchPartPost: (store, payload) => {
    console.log(payload);
    PostService.GetSearchAllPost(
      payload.pageNo,
      payload.option,
      payload.keyword
    ).then(response => {
      store.commit("postListAll", {
        postList: response,
        pageNo: payload.pageNo
      });
      console.log(state.postList);
    });
  },
  searchInfoPost: (store, payload) => {
    PostService.GetSearchPost(payload.postNo).then(response => {
      store.commit("postInfo", { post: response });
      console.log(response);
    });
  },
  searchAllFollower: (store, payload) => {
    console.log(payload.userno);
    PostService.GetSearchFollow(payload.userno).then(Response => {
      console.log(Response);
      store.commit("postListAll", { postList: Response });
      console.log(state.postList);
    });
  }
};

const mutations = {
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
