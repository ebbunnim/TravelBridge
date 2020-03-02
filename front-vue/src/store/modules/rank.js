import RankService from "@/services/RankService";

const state = {
  TotalRanking: [],
  AreaRanking: []
};
const actions = {
  getTotalRanking: store => {
    RankService.TotalRank().then(Response => {
      store.commit("setTotalRanking", { TotalRank: Response.data.data });
    });
  },
  getAreaRanking: (store, payLoad) => {
    RankService.AreaRank(payLoad.area).then(Response => {
      store.commit("setAreaRanking", { AreaRanking: Response.data.data });
    });
  }
};
const mutations = {
  setTotalRanking(state, payLoad) {
    let w = [];
    for (let x of Array(3).keys()) {
      w.push(payLoad.TotalRank[x]);
    }
    state.TotalRanking = w;
  },
  setAreaRanking(state, payLoad) {
    let w = [];
    for (let x of Array(3).keys()) {
      w.push(payLoad.AreaRanking[x]);
    }

    state.AreaRanking = w;
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
