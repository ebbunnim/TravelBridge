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
            class="bg-transparent"
            to="/page1"
          >
            <span class="travel text-weight-bold">TravelCard</span>
            <q-menu
              content-class="bg-transparent text-primary"
              auto
              rounded
              v-model="menuOn1"
              @mouseleave="menuOn1 = false"
              class="gt-sm bg-transparent"
              fit
            >
              <q-btn
                v-for="(item, index) in menuListSub[1]"
                :key="index"
                class="row"
                :icon="item.icon"
                :to="item.path"
                flat
                no-caps
              >
                <span class="text-h6 q-pl-md">{{ item.label }}</span>
              </q-btn>
            </q-menu>
          </q-btn>
          <!-- 두번째 메인기능 버튼 -->
          <q-btn no-caps flat rounded size="lg" @mouseover="menuOn2 = true" to="/page2">
            <span class="travel text-weight-bold">TravelPick</span>
            <q-menu
              content-class="bg-transparent text-primary"
              auto
              rounded
              v-model="menuOn2"
              @mouseleave="menuOn2 = false"
              class="gt-sm bg-transparent"
              fit
            >
              <q-btn
                v-for="(item, index) in menuListSub[2]"
                :key="index"
                class="row"
                :icon="item.icon"
                :to="item.path"
                flat
                no-caps
              >
                <span class="text-h6 q-pl-md">{{ item.label }}</span>
              </q-btn>
            </q-menu>
          </q-btn>
          <!-- 세번째 기능 버튼 -->
          <q-btn
            no-caps
            flat
            rounded
            size="lg"
            @mouseover="menuOn3 = true"
            @click="$router.push('/page3')"
          >
            <span class="travel text-weight-bold">TravelPlus+</span>
            <q-menu
              content-class="bg-transparent text-primary"
              auto
              rounded
              v-model="menuOn3"
              @mouseleave="menuOn3 = false"
              class="gt-sm bg-transparent"
              fit
            >
              <q-btn
                v-for="(item, index) in menuListSub[3]"
                :key="index"
                class="row"
                :icon="item.icon"
                :to="item.path"
                flat
                no-caps
              >
                <span class="text-h6 q-pl-md">{{ item.label }}</span>
              </q-btn>
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
          <q-btn size="md" no-caps filled flat rounded class="q-ma-md" to="/login">
            <span class="travel text-body2 text-weight-bold">Login</span>
          </q-btn>
          <!-- <q-btn size="md col-5" class="text-grey q-pa-md" flat to="/search">검색</q-btn> -->
        </div>
        <div class="col-3" align="right" v-else>
          <q-btn size="md" no-caps filled rounded class="q-py-md" flat to="/mypage">
            <span class="travel text-body2 text-weight-bold">Mypage</span>
          </q-btn>
          <q-btn size="md" no-caps filled rounded class="q-py-md" flat v-on:click="logout">
            <span class="travel text-body2 text-weight-bold">Logout</span>
          </q-btn>
          <!-- <q-btn size="md" class="text-grey q-py-md" flat to="/search">검색</q-btn> -->
        </div>
      </q-toolbar>
      <!-- 햄버거버튼 누르면 drawer open -->
      <q-toolbar class="lt-lg" align="center">
        <div class="col-4" align="left">
          <q-btn class="q-py-sm" size="large" color="grey-9" flat icon="menu" @click="left = !left"></q-btn>
        </div>

        <div class="col-4" @click="$router.push('/')">
          <q-chip clickable dense class="text-h6 bg-transparent" @click="$router.push('/')">
            <span class="travel text-weight-bold">Travel</span>
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
          <q-btn align="left" no-caps filled rounded flat to="/login">
            <span class="no-wrap travel">Login</span>
          </q-btn>
        </div>

        <div class="col-4" align="right" v-else>
          <div class="row">
            <div class="col-4"></div>
            <q-btn
              class="col-4 q-pr-sm"
              no-caps
              filled
              rounded
              color="grey-9"
              icon="account_circle"
              flat
              to="/mypage"
            >
              <!-- <span class="no-wrap travel">Mypage</span> -->
            </q-btn>
            <q-btn class="col-4" no-caps filled no-wrap rounded flat v-on:click="logout">
              <span class="no-wrap travel">Logout</span>
            </q-btn>
          </div>
        </div>
      </q-toolbar>
    </q-header>

    <!-- 반응형: 모바일 사이즈일 때 -->
    <q-drawer v-model="left" overlay side="left" elevated behavior="mobile">
      <!-- <q-drawer v-model="left" show-if-above content-class="bg-grey-1"> -->
      <q-scroll-area class="fit">
        <q-list v-for="(menuItem, index) in menuList" :key="index">
          <q-item exact v-if="menuItem.btn" clickable :to="menuItem.path">
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
            <q-list v-for="(menuListSub, index) in menuListSub[index]" :key="index">
              <q-item exact clickable :to="menuListSub.path">
                <q-item-section>
                  <q-item-label>
                    <q-icon size="sm" :name="menuListSub.icon"></q-icon>
                    {{ menuListSub.label }}
                  </q-item-label>
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
          label: "Home",
          icon: "home",
          separator: "true",
          btn: "true",
          path: "/"
        },
        {
          label: "TravelCard",
          icon: "bookmark",
          separator: "true",
          path: "/page1"
        },
        {
          label: "TravelPick",
          icon: "card_travel",
          separator: "true",
          path: "/page2"
        },
        {
          label: "TravelPlus+",
          icon: "extension",
          separator: "true",
          path: "/page3"
        },
        {
          label: "고객센터",
          icon: "dashboard",
          separator: "true",
          path: "/faq"
        }
      ],
      menuListSub: [
        [],
        [
          { icon: "create", label: "Post / Plan", path: "/page1/write" },
          { icon: "rss_feed", label: "Follower Feed", path: "/page1/feed" },
          { icon: "search", label: "Search Post", path: "/page1/main1search" }
        ],
        [
          { icon: "place", label: "Thema Pick", path: "/page2/pick" },
          { icon: "search", label: "Search Place", path: "/page2/list" }
        ],
        [
          { icon: "group", label: "Travel Mate", path: "/page3/mate" },
          { icon: "thumb_up_alt", label: "Travel Rank", path: "/page3/rank" }
        ],
        [
          { label: "자주 묻는 질문", path: "/faq" },
          { label: "1:1 문의하기", path: "/qna" },
          { label: "About Service", path: "/about/service" },
          { label: "About Us", path: "/about/us" }
        ]
      ]
    };
  },
  methods: {
    logout() {
      this.$store.state.user.user = {};
      this.$router.push("/");
    }
  }
};
</script>

<style>
.travel {
  color: #282e56;
}
.bridge {
  color: #d63840;
}
</style>
