import HotPlaceService from "@/services/HotPlaceService.js";

const state = {
  hps: []
};

const actions = {
  searchAllHPs: ({ commit }) => {
    HotPlaceService.searchAll(hps => {
      commit("saveHPs", hps);
    });
  },
  searchMoreHotPlaceByCityName: ({ commit }, payload) => {
    HotPlaceService.searchMoreHotPlaceByCityName(
      payload.btnCnt,
      payload.cityName
    )
      .then(res => {
        console.log("여긴 hotplace vuex");
        commit("saveHPs", res);
        console.log("hp state: ", state.hps);
      })
      .catch(error => {
        console.log(error);
      });
  },
  searchMoreHotplace: ({ commit }, payload) => {
    HotPlaceService.searchMoreHotplace(
      payload.btnCnt,
      payload.searchOption,
      payload.word
    )
      .then(res => {
        console.log("여긴vuex", res);
        commit("saveHPs", res);
        console.log("hp state: ", state.hps);
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
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
