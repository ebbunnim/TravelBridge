import PartyService from "@/services/PartyService.js";
import UserService from "@/services/UserService.js";
import router from "../../router";
const state = {
  partyList: [],
  party: {}
};

const actions = {
  getPartyList: store => {
    PartyService.PartyList().then(Response => {
      store.commit("setPartyList", { PartyList: Response.data.data });
    });
  },
  getParty: (store, payLoad) => {
    PartyService.Party(payLoad.partyNo).then(Response => {
      store.commit("setParty", { Party: Response.data.data });
    });
  },
  makeParty: async (store, payLoad) => {
    let x = await PartyService.PartyCreate(payLoad.party);

    router.push("/page3/mate");
  },
  partyIn: async (store, payLoad) => {
    let x = await PartyService.Partyin(payLoad.mem_no, payLoad.party_no);
    PartyService.Party(payLoad.party_no).then(Response => {
      store.commit("setParty", { Party: Response.data.data });
    });
  },
  addCmt: async (store, payLoad) => {
    await UserService.addCmt(payLoad.x)
      .then(Response => {})
      .catch(exp => console.log(exp));
    PartyService.Party(payLoad.partyNo).then(Response => {
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
