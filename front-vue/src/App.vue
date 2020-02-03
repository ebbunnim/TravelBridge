<template>
  <q-layout>
    <navbar></navbar>
    <router-view />
    <bot></bot>
  </q-layout>
</template>

<script>
import navbar from "./components/Header.vue";
import bot from "./components/Footer.vue";

export default {
  name: "MyLayout",
  components: {
    bot,
    navbar
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