import QnaService from "@/services/QnaService";

const state = {
  QnaList: []
};

const actions = {
  getAllQnas({ commit }) {
    QnaService.searchAll().then(response => {
      console.log("여긴 qna.js", response.data.data);
      commit("setAllQnas", response.data.data);
    });
  },
  postQna({ commit }, payload) {
    QnaService.insert(payload).then(response => {
      console.log("qna.js", response);
      commit("pushQuestion", payload);
    });
  }
};

const mutations = {
  setAllQnas(state, qnas) {
    state.QnaList = qnas;
  },
  pushQuestion(state, qna) {
    state.QnaList.push(qna);
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
