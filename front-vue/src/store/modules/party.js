import PartyService from "@/services/PartyService.js";

const state = {
  partyList: [],
  party: {}
};

const actions = {
  getPartyList: store => {
    PartyService.PartyList().then(Response => {
      console.log(Response.data.data);
      store.commit("setPartyList", { PartyList: Response.data.data });
    });
  },
  getParty: (store, payLoad) => {
    PartyService.Party(payLoad.partyNo).then(Response => {
      console.log(Response.data.data);
      store.commit("setParty", { Party: Response.data.data });
    });
  },
  makeParty: (store, payLoad) => {
    let x = PartyService.PartyCreate();
    return x;
  },
  partyIn: (store, payLoad) => {
    let x = PartyService.Partyin();
    return x;
  }
};

const mutations = {
  setPartyList(state, payLoad) {
    state.partyList = payLoad.PartyList;
  },
  setParty(state, payLoad) {
    state.party = payLoad.Party;
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
