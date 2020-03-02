import HotPlaceService from "@/services/HotplaceService.js";

const state = {
  hps: [],
  hp_list_length: null,
  hp: {}, // 번호로 찾아올 때 단일 hp
  searchTitle: ""
};

const actions = {
  searchAllHPs: ({ commit }) => {
    HotPlaceService.searchAll(hps => {
      commit("saveHPs", hps);
    });
  },
  searchByNo({ commit }, no) {
    HotPlaceService.searchByNo(no).then(res => {
      commit("saveOneHP", res);
    });
  },
  searchMoreHotplace: ({ commit }, payload) => {
    HotPlaceService.searchMoreHotplace(
      payload.btnCnt,
      payload.searchOption,
      payload.word
    )
      .then(res => {
        commit("saveHPs", res);
      })
      .catch(e => {
        console.log(e);
      });
  },
  searchMoreHotPlaceByTheme: ({ commit }, payload) => {
    HotPlaceService.searchMoreHotPlaceByTheme(payload.btnCnt, payload.word)
      .then(res => {
        commit("saveHPs", res);
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
    if (typeof state.hps === "string") state.hp_list_length = 0;
  },
  saveOneHP(state, hp) {
    state.hp = hp;
  },
  clearHPs(state) {
    state.hps = [];
    state.hp_list_length = 0;
  },
  saveSearchTitle(state, title) {
    state.searchTitle = title;
  },
  clearSearchTitle(state) {
    state.searchTitle = "";
  }
};

export default {
  namespaced: true,
  state,
  // getters,
  mutations,
  actions
};
