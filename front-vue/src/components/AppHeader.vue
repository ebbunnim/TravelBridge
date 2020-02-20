<template>
  <q-layout style="min-height: 0px;">
    <q-header class="bg-transparent">
      <q-toolbar class="gt-md" align="center">
        <div class="col-5" align="left">
          <q-btn
            no-caps
            @mouserover="menu1 = true"
            class="text-h5 bg-transparent"
            to="/"
            flat
            rounded
          >
            <span class="bridge text-weight-bold">TravelBridge</span>
          </q-btn>
          <!-- 첫번째 메인 기능 버튼 -->
          <q-btn
            no-caps
            flat
            rounded
            size="lg"
            @mouseover="menuOn1 = true"
            class="text-white bg-transparent"
            to="/page1"
          >
            TravelCard
            <q-menu
              content-class="bg-primary text-white"
              auto
              rounded
              v-model="menuOn1"
              @mouseleave="menuOn1 = false"
              class="gt-sm bg-transparent"
              fit
            >
              <!-- 하위 버튼 -->
              <template
                v-if="
                  this.$store.state.user.user.mem_id != null ||
                    this.$store.state.user.user.mem_id != undefined
                "
              >
                <q-btn class="row" to="/page1/write" flat>글쓰기</q-btn>
                <q-btn class="row" to="/page1/follower" flat>팔로워 피드</q-btn>
              </template>
              <q-btn class="row" to="/page1/main1search" flat icon="search"
                >검색</q-btn
              >
            </q-menu>
          </q-btn>
          <!-- 두번째 메인기능 버튼 -->
          <q-btn
            no-caps
            flat
            rounded
            size="lg"
            @mouseover="menuOn2 = true"
            class="text-white bg-transparent"
            to="/page2"
          >
            TravelPick
            <q-menu
              content-class="bg-primary text-white"
              auto
              rounded
              v-model="menuOn2"
              @mouseleave="menuOn2 = false"
              class="gt-sm bg-transparent"
              fit
            >
              <q-list>
                <q-btn class="row" to="/page2/pick" flat>테마별 추천</q-btn>
                <q-btn class="row" to="/page2/list" flat icon="search"
                  >검색</q-btn
                >
              </q-list>
            </q-menu>
          </q-btn>
          <q-btn
            no-caps
            flat
            rounded
            size="lg"
            @mouseover="menuOn3 = true"
            class="text-white bg-transparent"
            @click="$router.push('/page3')"
          >
            TravelPlus+
            <q-menu
              content-class="bg-primary text-white"
              auto
              rounded
              v-model="menuOn3"
              @mouseleave="menuOn3 = false"
              class="gt-sm bg-transparent"
              fit
            >
              <q-list>
                <q-btn class="row" to="/page3/mate" flat>트래블 메이트</q-btn>
                <q-btn class="row" to="/page3/rank" flat>트래블 랭크</q-btn>
              </q-list>
            </q-menu>
          </q-btn>
        </div>

        <div class="col-4"></div>
        <div
          v-if="
            this.$store.state.user.user.mem_id == null ||
              this.$store.state.user.user.mem_id == undefined
          "
          class="col-3"
          align="right"
        >
          <q-btn size="md" filled rounded class="q-ma-md" to="/login"
            >로그인</q-btn
          >
          <!-- <q-btn size="md col-5" class="text-grey q-pa-md" flat to="/search">검색</q-btn> -->
        </div>
        <div class="col-3" align="right" v-else>
          <q-btn size="md" filled rounded class="q-py-md" flat to="/mypage"
            >내 정보</q-btn
          >
          <q-btn
            size="md"
            filled
            rounded
            class="q-py-md"
            flat
            v-on:click="logout"
            >로그아웃</q-btn
          >
          <!-- <q-btn size="md" class="text-grey q-py-md" flat to="/search">검색</q-btn> -->
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

        <div class="col-4" @click="$router.push('/')">
          <q-chip
            clickable
            dense
            class="text-h6 bg-transparent"
            @click="$router.push('/')"
          >
            <span class="bridge text-weight-bold">Travel</span>
            <span class="bridge text-weight-bold">Bridge</span>
          </q-chip>
        </div>

        <div
          v-if="
            this.$store.state.user.user.mem_id == null ||
              this.$store.state.user.user.mem_id == undefined
          "
          class="col-4"
          align="right"
        >
          <q-btn size="md" class="darken--2 q-pa-md" flat to="/login"
            >로그인</q-btn
          >
        </div>
        <div class="col-4" align="right" v-else>
          <q-btn size="md" class="q-py-md" flat to="/mypage">내 정보</q-btn>
          <q-btn size="md" class="q-py-md" flat v-on:click="logout"
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
            <q-item-section>
              <q-item-label>{{ menuItem.label }}</q-item-label>
            </q-item-section>
          </q-item>

          <q-expansion-item
            v-else
            expand-separator
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
          label: "트래블 카드",
          icon: "bookmark",
          separator: "true",
          path: "/page1"
        },
        {
          label: "트래블 픽",
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
          label: "고객센터",
          icon: "dashboard",
          separator: "true",
          path: "/faq"
        },
        {
          label: "검색",
          icon: "search",
          separator: "true",
          path: "/search"
        }
      ],
      menuListSub: [
        [],
        // main 1, main 2, sub 에서 세부항목 페이지 생기면 path 에 추가할 것
        [
          { label: "main 1", path: "" },
          { label: "main 1", path: "" }
        ],
        [
          { label: "테마별 여행지 추천", path: "/page2/pick" },
          { label: "여행지 정보 검색", path: "/page2/list" }
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
  },
  created() {
    console.log(this.$router.currentRoute.fullPath === "/");
    if (this.$router.currentRoute.name === "home") {
      console.log("넹글");
    }
  }
};
</script>

<style>
.hright {
  display: flex;
  justify-content: flex-end;
}
.travel {
  color: #282e56;
}
.bridge2 {
  color: #de6668;
}
.bridge {
  color: #d63840;
}
</style>
