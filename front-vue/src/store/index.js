import Vue from "vue";
import Vuex from "vuex";
import user from "./modules/user";
import faq from "./modules/faq";
import qna from "./modules/qna";
import city from "./modules/city";
import hotplace from "./modules/hotplace";
import festival from "./modules/festival";
import post from "./modules/post";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: { user, faq, qna, city, hotplace, festival, post }
});
