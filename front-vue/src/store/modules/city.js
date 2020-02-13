import CityService from "@/services/CityService";

const state = {
  cities: []
};

const actions = {
  getAllCities: ({ commit }) => {
    CityService.searchAll().then(cities => {
      // console.log("액숀");
      // console.log(cities);
      commit("saveCities", cities);
    });
  }
};

const mutations = {
  saveCities(state, cities) {
    console.log("저장");
    state.cities = cities;
    console.log(state.cities);
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
