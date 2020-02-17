import HotPlaceService from "@/services/HotplaceService.js";

const state = {
  hps: [],
  hp_list_length: 0
};

const actions = {
  searchAllHPs: ({ commit }) => {
    HotPlaceService.searchAll(hps => {
      commit("saveHPs", hps);
    });
  },
  searchMoreHotplace: ({ commit }, payload) => {
    HotPlaceService.searchMoreHotplace(
      payload.btnCnt,
      payload.searchOption,
      payload.word
    )
      .then(res => {
        console.log("여긴 hotplace.js", res);
        commit("saveHPs", res);
        console.log("state.hps 확인 ", state.hps);
        console.log("길이 측정!!!!!: ", state.hp_list_length);
      })
      .catch(e => {
        console.log(e);
      });
  },
  searchMoreHotPlaceByTheme: ({ commit }, payload) => {
    HotPlaceService.searchMoreHotPlaceByTheme(payload.btnCnt, payload.word)
      .then(res => {
        console.log("여긴vuex", res);
        commit("saveHPs", res);
        console.log("hp state: ", state.hps);
      })
      .catch(e => {
        console.log(e);
      });
  }
};

// 동기
const mutations = {
  saveHPs(state, hps) {
    state.hps = hps;
    state.hp_list_length = hps.length;
  },
  clearHPs(state) {
    state.hps = [];
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
