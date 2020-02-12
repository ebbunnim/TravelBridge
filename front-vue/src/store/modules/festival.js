import FestivalService from "@/services/FestivalService.js";

const state = {
  fvals: []
};

const actions = {
  searchAllFvals: ({ commit }) => {
    FestivalService.searchAll(fvals => {
      commit("saveFvals", fvals);
    });
  }
};

const mutations = {
  saveFvals(state, fvals) {
    state.fvals = fvals;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
