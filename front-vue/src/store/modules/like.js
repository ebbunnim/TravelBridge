// import LikeService from "@/services/LikeService.js";
import UserService from "@/services/UserService.js";

const state = {
  allLikedHPs: [],
  allLikedFvals: []
};

const actions = {
  getLikedHotplaces: ({ commit }, mem_no) => {
    UserService.getLikedHotplaces(mem_no).then(res => {
      console.log(res);
      commit("getLikedHotplaces", res);
    });
  }
};

const mutations = {
  getLikedHotplaces(state, res) {
    console.log("뮤테이션 뚝딱");
    state.allLikedHPs = res;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
