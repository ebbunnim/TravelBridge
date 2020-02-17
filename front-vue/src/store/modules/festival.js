import FestivalService from "@/services/FestivalService.js";

const state = {
  fvals: []
};

const getters = {
  getFvalsByTheme: (state) => (theme) => {
    return state.fvals.find(fval => fval.fval_theme.includes(theme))
  }
};

const actions = {
  searchAllFvals: ({ commit }) => {
    FestivalService.searchAll(fvals => {
      commit("saveFvals", fvals);
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
      })
      .catch(e => {
        console.log(e);
      });
  },
  searchMoreFestivalByTheme: ({ commit }, payload) => {
    FestivalService.searchMoreFestivalByTheme(payload.btnCnt, payload.word)
      .then(res => {
        console.log("여긴 vuex", res);
        commit("saveFvals", res);
        console.log("fval state: ", state.fvals);
      })
      .catch(e => {
        console.log(e);
      });
  }
};

const mutations = {
  saveFvals(state, fvals) {
    state.fvals = fvals;
  },
  clearFvals(state) {
    state.fvals = [];
  }
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};
