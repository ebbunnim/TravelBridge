import FaqService from "@/services/FaqService";

const state = {
  faqList: []
};

const actions = {
  getAllFaqs({ commit }) {
    console.log("뷰");
    FaqService.selectAllFaqs().then(response => {
      console.log(response.data.data);
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
