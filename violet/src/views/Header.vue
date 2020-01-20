<template>
  <q-layout view="lHh lpR lff" style="min-height: 90px;">
    <q-header elevated class="bg-primary text-white">
      <q-toolbar align="center">
        <q-btn dense flat round icon="menu" @click="left = !left" />
        <q-toolbar-title>title</q-toolbar-title>
        <div v-if="false">
          <q-btn>내 정보</q-btn>
          <q-btn>로그아웃</q-btn>
        </div>
        <div v-else>
          <q-btn>로그인</q-btn>
        </div>
      </q-toolbar>

      <q-tabs align="center">
        <q-space />
        <q-route-tab to="/p" label="홈" />
        <q-space />
        <q-route-tab to="/page2" label="메인기능 1번" />
        <q-space />
        <q-route-tab to="/page3" label="메인기능 2번" />
        <q-space />
        <q-route-tab to="/page3" label="서브기능" />
        <q-space />
      </q-tabs>
    </q-header>

    <q-drawer v-model="left" side="left" overlay bordered>
      <q-scroll-area class="fit">
        <q-list v-for="(menuItem, index) in menuList" :key="index">
          <q-item v-if="menuItem.btn" clickable>
            <q-item-section avatar>
              <q-icon :name="menuItem.icon" />
            </q-item-section>
            <q-item-section>
              <q-item-label>{{menuItem.label}}</q-item-label>
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
          >
            <q-list v-for="(menuListSub,index) in menuListSub[index]" :key="index">
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
export default {
  data() {
    return {
      left: false,
      menuList: [
        { label: "홈", icon: "home", separator: "true", btn: "true" },
        { label: "메인기능 1번", icon: "bookmark", separator: "true" },
        { label: "메인기능 2번", icon: "card_travel", separator: "true" },
        { label: "서브기능", icon: "extension", separator: "true" },
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
  }
};
</script>

<style>
</style>