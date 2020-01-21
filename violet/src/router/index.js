import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

import Main1 from "../views/Main1.vue";
import Main2 from "../views/Main2.vue";
import Sub from "../views/Sub.vue";
import AboutTeam from "../views/AboutTeam.vue";
import AboutProject from "../views/AboutProject.vue";

import Qna from "../views/Qna.vue";
import Faq from "../views/Faq.vue";

Vue.use(VueRouter);

const routes = [
  {
    // 홈, 메인기능 1번, 메인기능 2번, 서브기능
    path: "/home",
    name: "home",
    component: Home
  },
  {
    path: "/page1",
    name: "main1",
    component: Main1
  },
  {
    path: "/page2",
    name: "main2",
    component: Main2
  },
  {
    path: "/page3",
    name: "sub",
    component: Sub
  },
  // Footer - Q&N, FAQ, About Us 라우팅
  {
    path: "/faq",
    name: "faq",
    component: Faq
  },
  {
    path: "/qna",
    name: "qna",
    component: Qna
  },
  {
    path: "/about/team",
    name: "team",
    component: AboutTeam
  },
  {
    path: "/about/project",
    name: "project",
    component: AboutProject
  },
  // 로그인 페이지
  {
    path: "/login",
    name: "login",
    component: Login
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
