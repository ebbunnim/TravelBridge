// import LikeService from "@/services/LikeService.js";
import UserService from "@/services/UserService.js";
import LikeService from "@/services/LikeService.js";

const state = {
  allLikedHPs: [],
  allLikedFvals: []
};

const actions = {
  getLikedHotplaces: ({ commit }, mem_no) => {
    UserService.getLikedHotplaces(mem_no).then(res => {
      commit("getLikedHotplaces", res);
    });
  },
  getLikedFestivals: ({ commit }, mem_no) => {
    UserService.getLikedFestivals(mem_no).then(res => {
      commit("getLikedFestivals", res);
    });
  },
  insertLike: ({ commit }, payload) => {
    LikeService.insertLike(payload).then(res => {
      commit("insertLike", payload);
    });
  },
  deleteHotplaceLike: ({ commit }, no) => {
    LikeService.deleteLike(no).then(res => {
      commit("deleteHotplaceLike", no);
    });
  },
  deleteFestivalLike: ({ commit }, no) => {
    LikeService.deleteLike(no).then(res => {
      commit("deleteFestivalLike", no);
    });
  }
};

const mutations = {
  getLikedHotplaces(state, res) {
    state.allLikedHPs = res;
  },
  getLikedFestivals(state, res) {
    state.allLikedFvals = res;
  },
  insertLike(state, payload) {
    if (payload.like_type === 2) {
      state.allLikedHPs.push(payload);
    } else if (payload.like_type === 3) {
      state.allLikedFvals.push(payload);
    }
  },
  deleteHotplaceLike(state, no) {
    const idx = state.allLikedHPs.findIndex(function(item) {
      return item.hotplace_no === no;
    });
    if (idx > -1) state.allLikedHPs.splice(idx, 1);
  },
  deleteFestivalLike(state, no) {
    const idx = state.allLikedFvals.findIndex(function(item) {
      return item.festival_no === no;
    });
    if (idx > -1) state.allLikedFvals.splice(idx, 1);
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
