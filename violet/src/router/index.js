import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Main1 from "../views/Main1.vue";
import Main2 from "../views/Main2.vue";
import Sub from "../views/Sub.vue";
import About from "../views/About.vue";


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
  // Q&N, FAQ 
  {
    path: "/about",
    name: "about",
    component: About
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
