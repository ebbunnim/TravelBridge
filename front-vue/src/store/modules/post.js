import PostService from "../../services/PostService";
// import RouterService from "../../router";

const state = {
  post: {},
  postList: []
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
    PostService.GetSearchPartPost(payload.ListNo).then(response => {
      store.commit("postListPart", { postList: response });
    });
  },
  searchInfoPost: (store, payload) => {
    PostService.GetSearchPost(payload.postNo).then(response => {
      store.commit("postInfo", { post: response });
      console.log(response);
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

    state.postList = titles;
  },
  postListPart(state, payLoad) {
    var titles = [];
    var cnt = 0;
    var ti = [];

    for (var i of payLoad.postList) {
      if (i == 1) cnt = cnt + 1;
      else if (i == 2) cnt = cnt + 2;

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
    state.postList.push(titles);
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
