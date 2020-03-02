import QnaService from "@/services/QnaService";

const state = {
  qnaList: []
};

const actions = {
  // 사용자 입장 필요
  getUserQnas({ commit }, mem_no) {
    console.log("실행")
    QnaService.getUserQnas(mem_no)
      .then(res => {
        commit("setQnaList", res)
      })
  },
  insertQna({ commit }, payload) {
    QnaService.insertQna(payload)
      .then(res => {
        console.log(res)
        commit("pushQna", payload)
      })
  },
  deleteQna({ commit }, qna_no) {
    QnaService.delete(qna_no)
      .then(res => {
        console.log(res)
        commit("deleteQna", qna_no)
      })
  },
  // 관리자 입장에서 필요
  getAllQnas({ commit }) {
    QnaService.getAllQnas()
    // .then(res => {
    // commit("")
    // })
  }
};

const mutations = {
  setQnaList(state, qnas) {
    state.qnaList = qnas;
  },
  pushQna(state, qna) {
    console.log(qna) // object 한 개? 확인 필요
    state.qnaList.push(qna)
  },
  deleteQna(state, qna_no) {
    const newQnas = state.qnas.filter(qna => qna.qna_no !== qna_no)
    state.qnaList = newQnas
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
