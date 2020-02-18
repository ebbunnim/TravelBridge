import FestivalService from "@/services/FestivalService.js";

const state = {
  fvals: [],
  fval_list_length: 0,
  fval: null
};

const actions = {
  searchAllFvals: ({ commit }) => {
    FestivalService.searchAll(fvals => {
      commit("saveFvals", fvals);
    });
  },
  searchByNo({ commit }, no) {
    FestivalService.searchByNo(no).then(res => {
      console.log("결과 => ", res);
      commit("saveFval", res);
    });
  },
  searchMoreFestival: ({ commit }, payload) => {
    FestivalService.searchMoreFestival(
      payload.btnCnt,
      payload.searchOption,
      payload.word
    )
      .then(res => {
        console.log("여긴 festival.js", res);
        commit("saveFvals", res);
        console.log("state.fvals: ", state.fvals);
        console.log("fval length 측정: ", state.fval_list_length);
      })
      .catch(e => {
        console.log(e);
      });
  },
  searchMoreFestivalByTheme: ({ commit }, payload) => {
    FestivalService.searchMoreFestivalByTheme(payload.btnCnt, payload.word)
      .then(res => {
        commit("saveFvals", res);
      })
      .catch(e => {
        console.log(e);
      });
  }
};

const mutations = {
  saveFvals(state, fvals) {
    state.fvals = fvals;
    state.fval_list_length = fvals.length;
  },
  clearFvals(state) {
    state.fvals = [];
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
