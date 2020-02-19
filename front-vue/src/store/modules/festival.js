import FestivalService from "@/services/FestivalService.js";
const state = {
  fvals: [],
  fval_list_length: 0,
  fval: {} // 번호로 찾아올 때 단일 fval
};
const actions = {
  searchAllFvals: ({ commit }) => {
    FestivalService.searchAll(fvals => {
      commit("saveFvals", fvals);
    });
  },
  searchByNo({ commit }, no) {
    // fval_no 로 festival 찾기
    FestivalService.searchByNo(no).then(res => {
      commit("saveOneFval", res);
    });
  },
  searchMoreFestival: ({ commit }, payload) => {
    // 페이지 처리, 더보기
    FestivalService.searchMoreFestival(
      payload.btnCnt,
      payload.searchOption,
      payload.word
    )
      .then(res => {
        console.log(res);

        commit("saveFvals", res);

        console.log("state.fvals 확인 ", state.fvals);
        console.log("길이 측정!!!!!: ", state.fval_list_length);
      })
      .catch(e => {
        console.log(e);
      });
  },
  searchMoreFestivalByTheme: ({ commit }, payload) => {
    // 테마로 찾은 후 fvals 에 저장
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
  saveOneFval(state, fval) {
    state.fval = fval;
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
