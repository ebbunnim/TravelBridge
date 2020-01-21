<template>
  <div>
    <div class="bg-white text-grey footer border">
      <!-- footer, border class -->
      <div class="footer">
        <div class="card">
          <!-- card class -->
          <div class="q-pa-md" style="max-width: 350px">
            <p class="text-h6 text-bold">About Us</p>
            <q-list dense class="rounded-borders">
              <q-item v-for="(menu, index) in aboutUsMenus" :key="index" :to="menu.path">
                <q-item-section>{{ menu.label }}</q-item-section>
              </q-item>
            </q-list>
          </div>
        </div>

        <div class="card">
          <div class="q-pa-md" style="max-width: 350px">
            <p class="text-h6 text-bold">Customer Service</p>
            <q-list dense class="rounded-borders">
              <q-item v-for="(menu, index) in CSmenus" :key="index" :to="menu.path">
                <q-item-section>{{ menu.label }}</q-item-section>
              </q-item>
            </q-list>
          </div>
        </div>

        <div class="card">
          <div class="q-pa-md" style="max-width: 350px">
            <p class="text-h6 text-bold">Site Map</p>
            <q-list dense class="rounded-borders">
              <q-item v-for="(menu, index) in siteMapMenus" :key="index" :to="menu.path">
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
  name: "MyLayout",
  data() {
    return {
      leftDrawerOpen: false,
      aboutUsMenus: [
        { label: "Contact Us", path: "/temporary" }, // 추후에 이메일 modal 연결 
        { label: "About Team", path: "/about/team" },
        { label: "About Project", path: "/about/project" }
      ],
      CSmenus: [
        { label: "FAQ", path: "/faq" },
        { label: "Q&N", path: "/qna" }
      ],
      siteMapMenus: [
        { label: "Home", path: "/" },
        { label: "메인기능 1", path: "/page1" },
        { label: "메인기능 2", path: "/page2" },
        { label: "서브기능", path: "/page3" }
      ]
    };
  }
};
</script>

<style>
.footer {
  margin-left: 0;
  margin-right: 0;
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 2%;
  padding-bottom: 3%;
}
.border {
  border-block-color: black;
  border-top-style: solid;
  border-top-width: thin;
  border-top-color: grey;
}
.card {
  padding-left: 2%;
  display: inline-block;
  width: 33%;
  height: 40%;
  vertical-align: top;
}
</style>