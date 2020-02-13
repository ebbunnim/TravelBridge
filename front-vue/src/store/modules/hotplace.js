import HotPlaceService from "@/services/HotplaceService.js";

const state = {
  hps: []
};

const actions = {
  searchAllHPs: ({ commit }) => {
    HotPlaceService.searchAll(hps => {
      commit("saveHPs", hps);
    });
  },
  searchMoreHotPlaceByCityName: ({commit}, cityName) => {
    HotPlaceService.searchMoreHotPlaceByCityName(res => {
      console.log(res)
    })
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
