import Vue from "vue";
import VueRouter from "vue-router";
//user
import Login from "../views/user/Login.vue";
import PasswordFind from "../views/user/PasswordFind.vue";
import SignUp from "../views/user/SignUp.vue";
import MyPage from "../views/user/MyPage.vue";
import UserPage from "../views/user/UserPage.vue";
//about
import AboutService from "../views/about/AboutService.vue";
import AboutUs from "../views/about/AboutUs.vue";
//faq&qna
import Qna from "../views/Qna.vue";
import Faq from "../views/Faq.vue";
//main1
import Main1 from "../views/travelcard/Main1.vue";
import Main1Search from "../views/travelcard/Main1Search.vue";
import PostDetail from "../views/travelcard/PostDetail.vue";
import Main1Main from "../views/travelcard/Main1Main.vue";
import Main1Write from "../views/travelcard/Main1Write.vue";
import Main1follow from "../views/travelcard/Main1follow.vue";
//main2
import Home from "../views/Home.vue";
import Main2 from "../views/travelpick/Main2.vue";
import Main2Home from "../views/travelpick/Main2Home.vue";
import Main2Pick from "../views/travelpick/Main2Pick.vue";
import Main2List from "../views/travelpick/Main2List.vue";
import HotPlaceDetail from "../views/travelpick/HotPlaceDetail.vue";
import FestivalDetail from "../views/travelpick/FestivalDetail.vue";
// Travelplus
import Mate from "../views/travelplus/Mate.vue";
import MateDetail from "../views/travelplus/MateDetail.vue";
import CreateParty from "../views/travelplus/CreateParty.vue";
import Rank from "../views/travelplus/Rank.vue";
import Sub from "../views/travelplus/Sub.vue";
import temp from "../views/temp.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/page1",
    component: Main1,
    children: [
      { path: "", component: Main1Main },
      { path: "main1search", component: Main1Search },
      { path: "main1search/:pageNo", component: Main1Search, props: true },
      {
        path: "main1search/:word/:pageNo",
        component: Main1Search,
        props: true
      },
      {
        path: "main1search/:word/:option/:pageNo",
        component: Main1Search,
        props: true
      },
      { path: "postdetail/:postNo", component: PostDetail, props: true },
      { path: "write", component: Main1Write },
      { path: "feed", component: Main1follow }
    ]
  },
  {
    path: "/page2",
    component: Main2,
    children: [
      {
        path: "",
        component: Main2Home
      },
      {
        path: "pick",
        component: Main2Pick
      },
      {
        path: "list",
        component: Main2List
      },
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
    component: Sub,
    children: [
      { path: "", component: Rank },
      { path: "mate", component: Mate },
      { path: "rank", component: Rank },
      { path: "mate/create", component: CreateParty },
      { path: "mate/:mateNo", component: MateDetail, props: true }
    ]
  },
  // footer 항목
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
    path: "/about/service",
    name: "team",
    component: AboutService
  },
  {
    path: "/about/us",
    name: "about-us",
    component: AboutUs
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
  },

  {
    path: "/userpage/:userNo",
    name: "userpage",
    component: UserPage,
    props: true
  },
  {
    path:"/temp",
    name :"hello",
    component: temp
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
