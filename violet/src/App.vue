<template>
  <div>
    <navbar></navbar>
    <router-view />
  </div>
</template>

<script>
import navbar from "./views/Header.vue";
export default {
  name: "LayoutDefault",

  components: { navbar },

  data() {
    return {
      leftDrawerOpen: false
    };
  }
};
</script>

<style>
</style>
