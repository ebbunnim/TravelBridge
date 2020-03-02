import PartyService from "@/services/PartyService.js";
import UserService from "@/services/UserService.js";
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
    console.log(payLoad.party)
    let x = PartyService.PartyCreate(payLoad.party);
  },
  partyIn: async (store, payLoad) => {
    let x = await PartyService.Partyin(payLoad.mem_no, payLoad.party_no);
    PartyService.Party(payLoad.party_no).then(Response => {
      console.log(Response.data.data);
      store.commit("setParty", { Party: Response.data.data });
    });
  },
  addCmt: async (store, payLoad) => {
    await UserService.addCmt(payLoad.x)
      .then(Response => {})
      .catch(exp => console.log(exp));
    PartyService.Party(payLoad.partyNo).then(Response => {
      console.log(Response.data.data);
      store.commit("setParty", { Party: Response.data.data });
    });
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
