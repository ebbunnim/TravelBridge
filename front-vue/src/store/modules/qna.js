import QnaService from "@/services/QnaService";

const state = {
  qnaList: []
};

const actions = {
  // 사용자 입장 필요
  getUserQnas({ commit }, mem_no) {
    QnaService.getUserQnas(mem_no).then(res => {
      commit("setQnaList", res);
    });
  },
  insertQna({ commit }, payload) {
    QnaService.insertQna(payload).then(res => {
      commit("pushQna", payload);
    });
  },
  deleteQna({ commit }, qna_no) {
    QnaService.delete(qna_no).then(res => {
      commit("deleteQna", qna_no);
    });
  },
  // 관리자 입장에서 필요
  getAllQnas({ commit }) {
    QnaService.getAllQnas();
   
  }
};

const mutations = {
  setQnaList(state, qnas) {
    state.qnaList = qnas;
  },
  pushQna(state, qna) {
    state.qnaList.push(qna);
  },
  deleteQna(state, qna_no) {
    const newQnas = state.qnas.filter(qna => qna.qna_no !== qna_no);
    state.qnaList = newQnas;
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
