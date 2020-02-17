import FaqService from "@/services/FaqService";

const state = {
  faqList: []
};

const actions = {
  getAllFaqs({ commit }) {
    FaqService.selectAllFaqs().then(response => {
      console.log("여긴 faq.js", response.data.data);
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
