import QnaService from "@/services/QnaService";

// vuex

const state = {
  QnaList: []
}

const actions = {
  // Posting 
  searchAll({ commit }) {
    QnaService.searchAll().
    then(response => {
      console.log('vuex 에서 확인', response.data.data)
      state.QnaList = response.data.data
      console.log(state.QnaList)
    })
  }
}

const mutations = {
  searchAll(state, all) {
    state.QnaList = all
  }
}


export default {
  namespaced: true,
  state,
  actions,
  mutations,
};