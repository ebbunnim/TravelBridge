import CityService from "@/services/CityService";

const state = {
  cities: []
};

const actions = {
  getAllCities: ({ commit }) => {
    CityService.searchAll().then(cities => {
      commit("saveCities", cities);
    });
  }
};

const mutations = {
  saveCities(state, cities) {
    state.cities = cities;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
