import FaqService from "@/services/FaqService";

const state = {
  faqList: []
};

const actions = {
  getAllFaqs({ commit }) {
    FaqService.selectAllFaqs().then(response => {
      commit("setAllFaqs", response.data.data);
    });
  }
};

const mutations = {
  setAllFaqs(state, faqs) {
    state.faqList = faqs;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
