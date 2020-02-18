import HotPlaceService from "@/services/HotPlaceService.js";

const state = {
  hps: [],
  hp: null,
  searchTitle: ""
};

const actions = {
  searchAllHPs: ({ commit }) => {
    HotPlaceService.searchAll(hps => {
      commit("saveHPs", hps);
    });
  },
  searchByNo({ commit }, payload) {
    console.log("뷰에서 넘겨온 페이로드를 받은 vuex다:", payload);
    console.log(typeof(payload))
    HotPlaceService.searchByNo(payload).then(res => {
      console.log("결과 => ", res);
    });
    // commit("saveHP", result);
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
        console.log("hp length 측정!!!!!: ", state.hp_list_length);
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
  saveHP(state, hp) {
    state.hp = hp;
  },
  clearHPs(state) {
    state.hps = [];
  },
  saveSearchTitle(state, value) {
    state.searchTitle = value;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
