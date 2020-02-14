<template>
  <q-layout style="min-height: 50px;">
    <q-header class="bg-white">
      <q-toolbar class="gt-md" align="center">
        <div class="col-4">
          <div class="row justify-start">
            <q-btn class="text-black q-mx-sm" flat to="/" label="HOME"></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page1"
              label="트래블 카드"
              @mouseover="menuOn1 = true"
            ></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page2"
              label="트래블 서치"
              @mouseover="menuOn2 = true"
            ></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page3"
              label="SUB기능"
              @mouseover="menuOn3 = true"
            ></q-btn>
          </div>
        </div>

        <!-- hover 시 보이는 부분 -->
        <!-- 메뉴 개수 많지 않으므로 
        1) 단순 dropdown 형태로 수정하거나 
        2) 메뉴 + 이미지 함께 보여주면 좋을 듯-->

        <q-menu
          square
          v-model="menuOn1"
          @mouseleave="menuOn1 = false"
          class="gt-sm"
          fit
        >
          <q-list class="q-ma-sm">
            <div class="row">
              <q-btn to="/page1" flat class="col-3">메인</q-btn>
              <q-btn to="/page1/write" flat class="col-3">글쓰기</q-btn>
              <q-btn to="/page1/postdetail" flat class="col-3"
                >포스트 디테일</q-btn
              >
              <q-btn to="/page1/main1search" flat class="col-3" icon="search"
                >검색</q-btn
              >
            </div>
          </q-list>
        </q-menu>
        <q-menu
          square
          v-model="menuOn2"
          @mouseleave="menuOn2 = false"
          class="gt-sm"
          fit
        >
          <q-list class="q-ma-sm">
            <!-- NavBar Hover 메뉴 부분 -->
            <div class="row justify-center">
              <q-btn to="/page2" flat class="col-3">Main 2 의 홈</q-btn>
              <q-btn to="/page2/pick" flat class="col-3">여행지 추천받기</q-btn>
              <q-btn to="/page2/list" flat class="col-3"
                >도시별 축제, 핫플 검색</q-btn
              >
              <q-btn to="/page2/main2search" flat class="col-3" icon="search"
                >검색</q-btn
              >
            </div>
          </q-list>
        </q-menu>
        <q-menu
          square
          v-model="menuOn3"
          @mouseleave="menuOn3 = false"
          class="gt-sm"
          fit
        >
          <q-list class="q-ma-sm">
            <div class="row justify-center">
              <q-btn to="/page3" flat class="col-3">서브기능의</q-btn>
              <q-btn to="/page3" flat class="col-3">호버이다</q-btn>
              <q-btn to="/page3" flat class="col-3">router를</q-btn>
              <q-btn to="/page3" flat class="col-3">연결할것</q-btn>
            </div>
          </q-list>
        </q-menu>

        <q-toolbar-title class="col-4 text-black">
          <q-btn size="xl" unelevated flat to="/">트래블브릿지</q-btn>
        </q-toolbar-title>

        <div
          v-if="
            this.$store.state.user.user.mem_id == null ||
              this.$store.state.user.user.mem_id == undefined
          "
          class="col-4"
          align="right"
        >
          <q-btn size="md col-5" class="text-grey q-pa-md" flat to="/login"
            >로그인</q-btn
          >
          <q-btn size="md col-5" class="text-grey q-pa-md" flat to="/search"
            >검색</q-btn
          >
        </div>
        <div class="col-4" align="right" v-else>
          <q-btn size="md" class="text-grey q-py-md" flat to="/mypage"
            >내 정보</q-btn
          >
          <q-btn size="md" class="text-grey q-py-md" flat v-on:click="logout"
            >로그아웃</q-btn
          >
          <q-btn size="md" class="text-grey q-py-md" flat to="/search"
            >검색</q-btn
          >
        </div>
      </q-toolbar>
      <!-- 햄버거버튼 누르면 drawer open -->
      <q-toolbar class="lt-lg" align="center">
        <div class="col-4" align="left">
          <q-btn
            class="q-py-sm"
            size="large"
            color="grey-7"
            flat
            icon="menu"
            @click="left = !left"
          ></q-btn>
        </div>

        <q-toolbar-title class="col-4 text-black">
          <q-btn size="xl" unelevated flat to="/">트래블브릿지</q-btn>
        </q-toolbar-title>

        <div
          v-if="
            this.$store.state.user.user.mem_id == null ||
              this.$store.state.user.user.mem_id == undefined
          "
          class="col-4"
          align="right"
        >
          <q-btn size="md" class="text-grey darken--2 q-pa-md" flat to="/login"
            >로그인</q-btn
          >
        </div>
        <div class="col-4" align="right">
          <q-btn size="md" class="text-grey q-py-md" flat to="/mypage"
            >내 정보</q-btn
          >
          <q-btn size="md" class="text-grey q-py-md" flat v-on:click="logout"
            >로그아웃</q-btn
          >
        </div>
      </q-toolbar>
    </q-header>

    <!-- 반응형: 태블릿, 모바일 사이즈일 때 -->
    <q-drawer v-model="left" overlay side="left" elevated behavior="mobile">
      <!-- <q-drawer v-model="left" show-if-above content-class="bg-grey-1"> -->
      <q-scroll-area class="fit">
        <q-list v-for="(menuItem, index) in menuList" :key="index">
          <q-item v-if="menuItem.btn" clickable :to="menuItem.path">
            <q-item-section avatar>
              <q-icon :name="menuItem.icon" />
            </q-item-section>
            <q-item-section>
              <q-item-label>{{ menuItem.label }}</q-item-label>
            </q-item-section>
          </q-item>

          <q-expansion-item
            v-else
            expand-separator
            :icon="menuItem.icon"
            :label="menuItem.label"
            :content-inset-level="0.5"
            :to="menuItem.path"
          >
            <q-list
              v-for="(menuListSub, index) in menuListSub[index]"
              :key="index"
            >
              <q-item clickable :to="menuListSub.path">
                <q-item-section>
                  <q-item-label>{{ menuListSub.label }}</q-item-label>
                </q-item-section>
              </q-item>
            </q-list>
          </q-expansion-item>

          <q-separator v-if="menuItem.separator" />
        </q-list>
      </q-scroll-area>
    </q-drawer>
  </q-layout>
</template>

<script>
export default {
  data() {
    return {
      // btn 개수만큼 menuOn 필요
      menuOn1: false,
      menuOn2: false,
      menuOn3: false,
      left: false,
      menuList: [
        {
          label: "홈",
          icon: "home",
          separator: "true",
          btn: "true",
          path: "/"
        },
        {
          label: "메인기능 1번",
          icon: "bookmark",
          separator: "true",
          path: "/page1"
        },
        {
          label: "메인기능 2번",
          icon: "card_travel",
          separator: "true",
          path: "/page2"
        },
        {
          label: "서브기능",
          icon: "extension",
          separator: "true",
          path: "/page3"
        },
        {
          label: "검색",
          icon: "search",
          separator: "true",
          path: "/search"
        },
        { label: "고객센터", icon: "dashboard", separator: "true" }
      ],
      menuListSub: [
        [],
        // main 1, main 2, sub 에서 세부항목 페이지 생기면 path 에 추가할 것
        [
          { label: "main 1", path: "" },
          { label: "main 1", path: "" }
        ],
        [
          { label: "main 2", path: "" },
          { label: "main 2", path: "" }
        ],
        [
          { label: "1 세부 항목", path: "" },
          { label: "1 세부 항목", path: "" }
        ],
        [
          { label: "자주 묻는 질문", path: "/faq" },
          { label: "1:1 문의하기", path: "/qna" },
          { label: "About Service", path: "/about/team" },
          { label: "About Team", path: "/about/service" }
        ]
      ]
    };
  },
  methods: {
    logout() {
      this.$store.state.user.user = {};
    }
  }
};
</script>

<style>
.hright {
  display: flex;
  justify-content: flex-end;
}
</style>
