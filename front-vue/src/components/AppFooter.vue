<template>
  <div class="bg-white text-grey footer border">
    <!-- footer, border class -->
    <div class="footer">
      <div class="row">
        <div class="col-4" style="text-align: center;">
          <div class="q-pa-md" style="max-height: 150px">
            <p class="text-subtitle1 text-uppercase">About Us</p>
            <q-list dense padding>
              <q-item v-for="(menu, index) in aboutUsMenus" :key="index" :to="menu.path">
                <q-item-section>{{ menu.label }}</q-item-section>
              </q-item>
            </q-list>
          </div>
        </div>
        <div class="col-4" style="text-align: center;">
          <div class="q-pa-md" style="max-height: 150px">
            <p class="text-subtitle1 text-uppercase">Customer Service</p>

            <q-list dense padding>
              <q-item v-for="(menu, index) in CSmenus" :key="index" clickable :to="menu.path">
                <q-item-section>{{ menu.label }}</q-item-section>
              </q-item>
            </q-list>
          </div>
        </div>
        <div class="col-4" style="text-align: center;">
          <div class="q-pa-md" style="max-height: 150px;">
            <p class="text-subtitle1 text-uppercase">Site Map</p>

            <q-list dense padding>
              <q-item v-for="(menu, index) in siteMapMenus" :key="index" clickable :to="menu.path">
                <q-item-section>{{ menu.label }}</q-item-section>
              </q-item>
            </q-list>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      leftDrawerOpen: false,
      aboutUsMenus: [
        { label: "About Team", path: "/about/team" },
        { label: "About Service", path: "/about/service" }
      ],
      CSmenus: [
        { label: "자주 묻는 질문", path: "/faq" }, // 자주 묻는 질문
        { label: "1:1 문의하기", path: "/qna" } // 1:1 문의하기
      ],
      siteMapMenus: [
        { label: "HOME", path: "/" },
        { label: "메인기능 1", path: "/page1" }, // 이름 수정할 것
        { label: "메인기능 2", path: "/page2" }, // 이름 수정할 것
        { label: "서브기능", path: "/page3" } // 이름 수정할 것
      ],
      window: {
        width: 0,
        height: 0
      }
    };
  },
  methods: {
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
.footer {
  margin-left: 0;
  margin-right: 0;
}
.border {
  border-block-color: black;
  border-top-style: solid;
  border-top-width: thin;
  border-top-color: grey;
}
</style>