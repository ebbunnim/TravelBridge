import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Main1 from "../views/Main1.vue";
import Main2 from "../views/Main2.vue";
import Sub from "../views/Sub.vue";
import FAQ from "../views/FAQ.vue";
import QNA from "../views/QNA.vue";
import AboutTeam from "../views/AboutTeam.vue";
import AboutProject from "../views/AboutProject.vue";

Vue.use(VueRouter);

const routes = [
  {
    // 홈, 메인기능 1번, 메인기능 2번, 서브기능
    path: "/",
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
    component: FAQ
  },
  {
    path: "/qna",
    name: "qna",
    component: QNA
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
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
