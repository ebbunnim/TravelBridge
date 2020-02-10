<template>
  <q-layout view="lHh lpR lff" style="min-height: 50px;">
    <q-header class="bg-white" style="height: 68px;">
      <q-toolbar align="center">
        <div class="col-4">
          <div class="row justify-start">
            <q-btn class="text-black q-mx-sm" flat to="/" label="HOME"></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page1"
              label="트래블 카드"
              @mouseenter="menuOn = true;"
            ></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page2"
              label="트래블 픽"
            ></q-btn>
            <q-btn
              class="text-black q-mx-sm"
              flat
              to="/page3"
              label="SUB기능"
            ></q-btn>
          </div>
        </div>

        <!-- hover 시 보이는 부분 -->
        <q-menu class="window-width no-scroll">
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
                <q-item clickable>홈홈홈홈</q-item>
                <q-item clickable>홈홈홈홈</q-item>
                <q-item clickable>홈홈홈홈</q-item>
              </div>
            </div>
            <div class="row">
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메3메3</q-item>
                <q-item clickable>메3메3</q-item>
                <q-item clickable>메3메3</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메3메3</q-item>
                <q-item clickable>메3메3</q-item>
                <q-item clickable>메3메3</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메3메3</q-item>
                <q-item clickable>메3메3</q-item>
                <q-item clickable>메3메3</q-item>
              </div>
            </div>
            <div class="row">
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메4메4</q-item>
                <q-item clickable>메4메4</q-item>
                <q-item clickable>메4메4</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메4메4</q-item>
                <q-item clickable>메4메4</q-item>
                <q-item clickable>메4메4</q-item>
              </div>
              <div class="col-4" style="text-align:center;" v-close-popup>
                <q-item clickable>메4메4</q-item>
                <q-item clickable>메4메4</q-item>
                <q-item clickable>메4메4</q-item>
              </div>
            </div>
          </q-list>
        </q-menu>

        <q-toolbar-title class="col-4 text-black">트래블브릿지</q-toolbar-title>

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
        <div class="col-4" align="right" v-else>
          <q-btn size="sm" class="text-grey q-pa-md" flat to="/mypage"
            >내 정보</q-btn
          >
          <q-btn size="sm" class="text-grey q-pa-md" flat v-on:click="logout"
            >로그아웃</q-btn
          >
        </div>
      </q-toolbar>
    </q-header>

    <!-- 반응형: 태블릿, 모바일 사이즈일 때 -->
    <q-drawer v-model="left" side="left" overlay elevated behavior="mobile">
      <q-scroll-area class="fit">
        <q-list v-for="(menuItem, index) in menuList" :key="index">
          <q-item v-if="menuItem.btn" clickable :to="menuItem.path">
            <q-item-section avatar>
              <q-icon :name="menuItem.icon" />
            </q-item-section>
            <q-item-section>
              <q-item-label>{{ menuItem.label }}</q-item-label>
              <q-item-label caption>quasar.dev</q-item-label>
            </q-item-section>
          </q-item>

          <q-expansion-item
            v-else
            expand-separator
            :icon="menuItem.icon"
            :label="menuItem.label"
            caption="5 unread emails"
            :content-inset-level="0.5"
            :to="menuItem.path"
          >
            <q-list
              v-for="(menuListSub, index) in menuListSub[index]"
              :key="index"
            >
              <q-item clickable>
                <q-item-section>
                  <q-item-label>{{ menuListSub.label }}</q-item-label>
                  <q-item-label caption>quasar.dev</q-item-label>
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
// import { debounce } from "quasar";
export default {
  data() {
    return {
      menuOn: false,
      itemOneOn: false,
      // itemTwoOn: false,
      // itemThreeOn: false,
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
        { label: "고객센터", icon: "dashboard", separator: "true" }
      ],
      menuListSub: [
        [],
        [{ label: "main 1" }, { label: "main 1" }],
        [{ label: "main 2" }, { label: "main 2" }],
        [{ label: "1 세부 항목" }, { label: "1 세부 항목" }],
        [{ label: "faq" }, { label: "qna" }, { label: "about we" }]
      ]
    };
  },
  methods: {
    logout() {
      this.$store.state.user.user = {};
    },
    // debounceFunc: debounce(function() {
    //   this.checkMenu();
    // }, 300),
    // checkMenu() {
    //   if (this.menuOn) {
    //     this.menuOn = true;
    //   } else {
    //     this.menu = false;
    //   }
    // }
  },
  // watch: {
  //   menuOn(val) {
  //     console.log("클릭watch");
  //     // this.debounceFunc();
  //   },
  //   listOver(val) {
  //     this.debounceFunc();
  //   }
  // }
};
</script>

<style>
.hright {
  display: flex;
  justify-content: flex-end;
}
</style>
