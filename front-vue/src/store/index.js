import Vue from "vue";
import Vuex from "vuex";
import user from "./modules/user";
import faq from "./modules/faq";
import qna from "./modules/qna";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: { user, faq, qna }
});
