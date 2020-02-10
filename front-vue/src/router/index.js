import Vue from "vue";
import VueRouter from "vue-router";
//user
import Login from "../views/user/Login.vue";
import PasswordFind from "../views/user/PasswordFind.vue";
import SignUp from "../views/user/SignUp.vue";
import MyPage from "../views/user/MyPage.vue";
//main
import Home from "../views/Home.vue";
import Main2 from "../views/Main2.vue";
import Sub from "../views/Sub.vue";
import Search from "../views/Search.vue";
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

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/search",
    name: "search",
    component: Search
  },
  {
    path: "/page1",
    name: "main1",
    component: Main1,
    children: [
      // UserHome will be rendered inside User's <router-view>
      // when /user/:id is matched
      { path: "", component: Main1Main },

      // UserProfile will be rendered inside User's <router-view>
      // when /user/:id/profile is matched
      { path: "main1search", component: Main1Search },

      // UserPosts will be rendered inside User's <router-view>
      // when /user/:id/posts is matched
      { path: "postdetail", component: PostDetail }
    ]
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
