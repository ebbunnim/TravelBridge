<template>
  <q-layout>
    <q-page-container>
      <router-view />
    </q-page-container>
    <bot></bot>
  </q-layout>
</template>

<script>
import bot from "./components/Footer.vue";

export default {
  name: "MyLayout",
  components: {
    bot
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