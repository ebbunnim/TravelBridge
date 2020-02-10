<template>
  <q-layout style="min-height: 50px;">
    <q-header class="bg-white">
      <!-- <q-toolbar v-if="$breakpoint-md" align="center"> -->
      <q-toolbar align="center">
        <div  class="col-4 gt-md">
          <div class="row justify-start">
            <q-btn class="text-black q-mx-sm" flat to="/" label="HOME"></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page1"
              label="트래블 카드"
              @mouseenter="menuOn1 = true"
            ></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page2"
              label="트래블 픽"
              @mouseenter="menuOn2 = true"
            ></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page3"
              label="SUB기능"
              @mouseenter="menuOn3 = true"
            ></q-btn>
          </div>
        </div>

        <!-- hover 시 보이는 부분 -->
        <!-- 메뉴 개수 많지 않으므로 
        1) 단순 dropdown 형태로 수정하거나 
        2) 메뉴 + 이미지 함께 보여주면 좋을 듯-->
        <q-menu
          v-model="menuOn1"
          @mouseleave="menuOn1 = false"
          class="window-width gt-md"
        >
          <q-list class="window-width q-ma-lg">
            <div class="row">
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>11111</q-item>
                <q-item clickable>11111</q-item>
                <q-item clickable>11111</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>11111</q-item>
                <q-item clickable>11111</q-item>
                <q-item clickable>11111</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>11111</q-item>
                <q-item clickable>11111</q-item>
                <q-item clickable>11111</q-item>
              </div>
            </div>
          </q-list>
        </q-menu>
        <q-menu
          v-model="menuOn2"
          @mouseleave="menuOn2 = false"
          class="window-width"
        >
          <q-list class="window-width q-ma-lg">
            <div class="row">
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메2메2</q-item>
                <q-item clickable>메2메2</q-item>
                <q-item clickable>메2메2</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메2메2</q-item>
                <q-item clickable>메2메2</q-item>
                <q-item clickable>메2메2</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item dense clickable>메2메2</q-item>
                <q-item clickable>메2메2</q-item>
                <q-item clickable>메2메2</q-item>
              </div>
            </div>
          </q-list>
        </q-menu>
        <q-menu
          v-model="menuOn3"
          @mouseleave="menuOn3 = false"
          class="window-width gt-lg"
        >
          <q-list class="window-width q-ma-lg">
            <div class="row">
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>aldkjf</q-item>
                <q-item clickable>dskjfad</q-item>
                <q-item clickable>33333</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>aldkjf</q-item>
                <q-item clickable>dskjfad</q-item>
                <q-item clickable>33333</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>aldkjf</q-item>
                <q-item clickable>dskjfad</q-item>
                <q-item clickable>33333</q-item>
              </div>
            </div>
          </q-list>
        </q-menu>

       <div class="col-4 lt-lg "  align="left">
          <q-btn
            class="q-py-sm"
            size="large"
            color="grey-7"
            flat
            icon="menu"
            @click="leftDrawerOpen = !leftDrawerOpen"
          ></q-btn>
        </div>

        <q-toolbar-title class="col-4 text-black">
          <q-btn unelevated flat to="/">트래블브릿지</q-btn>
        </q-toolbar-title>

        <div
          v-if="
            this.$store.state.user.user.mem_id == null ||
              this.$store.state.user.user.mem_id == undefined
          "
          class="col-4 "
          align="right"
        >
          <q-btn size="md" class="text-grey darken--2 q-pa-md" flat to="/login"
            >로그인</q-btn
          >
        </div>
        <div class="col-4" align="right" v-else>
          <q-btn size="md" class="text-grey q-py-md" flat to="/mypage"
            >내 정보</q-btn
          >
          <q-btn size="md" class="text-grey q-py-md" flat v-on:click="logout"
            >로그아웃</q-btn
          >
        </div>
      </q-toolbar>
      <!-- 햄버거버튼 누르면 drawer open -->
      <!-- <q-toolbar v-if="window.width < 676"> -->
      
       
  
    </q-header>

    <!-- 반응형: 태블릿, 모바일 사이즈일 때 -->
    <!-- <q-drawer v-if="left" overlay side="left" elevated behavior="mobile"> -->
    <q-drawer v-model="leftDrawerOpen" show-if-above content-class="bg-grey-1" class="lt-lg">
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
      leftDrawerOpen: false,
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
      ],
      window: {
        width: 0,
        height: 0
      }
    };
  },
  methods: {
    logout() {
      this.$store.state.user.user = {};
    },
    handleResize() {
      this.window.width = window.innerWidth;
      this.window.height = window.innerHeight;
    }
  },
  created() {
    window.addEventListener("resize", this.handleResize);
    this.handleResize();
  },
  destroyed() {
    window.removeEventListener("resize", this.handleResize);
  }
};
</script>

<style>
.hright {
  display: flex;
  justify-content: flex-end;
}
</style>
