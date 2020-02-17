import Vue from "vue";
import VueRouter from "vue-router";
//user
import Login from "../views/user/Login.vue";
import PasswordFind from "../views/user/PasswordFind.vue";
import SignUp from "../views/user/SignUp.vue";
import MyPage from "../views/user/MyPage.vue";
//about
import AboutTeam from "../views/about/AboutTeam.vue";
import AboutService from "../views/about/AboutService.vue";
//faq&qna
import Qna from "../views/Qna.vue";
import Faq from "../views/Faq.vue";
//main1
import Main1 from "../views/one/Main1.vue";
import Main1Search from "../views/one/Main1Search.vue";
import PostDetail from "../views/one/PostDetail.vue";
import Main1Main from "../views/one/Main1Main.vue";
import Main1Write from "../views/one/Main1Write.vue";
//main2
import Home from "../views/Home.vue";
import Main2 from "../views/two/Main2.vue";
import Main2Search from "../views/two/Main2Search.vue";
import Main2Pick from "../views/two/Main2Pick.vue";
import Main2Home from "../views/two/Main2Home.vue";
import Main2List from "../views/two/Main2List.vue";
import HotPlaceDetail from "../views/two/HotPlaceDetail.vue";
import FestivalDetail from "../views/two/FestivalDetail.vue";
// sub기능, 전체 통합검색 Search Page
import Sub from "../views/Sub.vue";
import Search from "../views/Search.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  // {
  //   path: "/home", // footer 의 site map 에서 home 아닌 다른 페이지 눌러도 home 이 같이 눌리는 버그 수정하려고 만듦
  //   name: "home",
  //   component: Home
  // },
  {
    path: "/search",
    name: "search",
    component: Search
  },
  {
    path: "/page1",
    component: Main1,
    children: [
      { path: "", component: Main1Main },
      { path: "main1search", component: Main1Search },
      { path: "postdetail/:postNo", component: PostDetail, props: true },
      { path: "write", component: Main1Write }
    ]
  },
  {
    path: "/page2",
    component: Main2,
    children: [
      { path: "", component: Main2Home },
      { path: "pick", component: Main2Pick },
      { path: "list", component: Main2List },
      { path: "main2search", component: Main2Search }
    ]
  },
  {
    path: "/hotplace/:hp_no",
    name: "hotplace-detail",
    component: HotPlaceDetail
  },
  {
    path: "/festival/:fval_no",
    name: "festival-detail",
    component: FestivalDetail
  },
  {
    path: "/page3",
    name: "sub",
    component: Sub
  },
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
    path: "/about/service",
    name: "service",
    component: AboutService
  },
  // 로그인 페이지
  {
    path: "/login",
    name: "login",
    component: Login
  },
  // 비밀번호 찾기 페이지
  {
    path: "/passwordfind",
    name: "passwordfind",
    component: PasswordFind
  },
  // signup 페이지
  {
    path: "/signup",
    name: "signup",
    component: SignUp,
    props: route => ({ query: route.query.q })
  },
  // 마이페이지
  {
    path: "/mypage",
    name: "mypage",
    component: MyPage
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
