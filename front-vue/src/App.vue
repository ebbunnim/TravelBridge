<template>
  <q-layout>
    <AppHeader></AppHeader>
    <router-view />
    <AppFooter></AppFooter>
  </q-layout>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";
import AppFooter from "./components/AppFooter.vue";

export default {
  name: "MyLayout",
  components: {
    AppFooter,
    AppHeader
  },
  data() {
    return {
      leftDrawerOpen: false
    };
  }
};
</script>

<style>
</style>