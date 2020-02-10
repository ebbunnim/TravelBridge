<template>
  <div>
    <h1>픽</h1>
    <!-- <q-btn-toggle v-model="selected">하이하이</q-btn-toggle> -->
    <!-- <q-btn-toggle v-model="choice.leisuresport"></q-btn-toggle> -->
    <!-- <q-btn-toggle v-model="choice.shopping"></q-btn-toggle> -->
  </div>
</template>

<script>
// import CityService from "@/services/CityService";

export default {
  data() {
    return {
      // choice: {
      //   food: false,
      //   leisuresport: false,
      //   shopping: false,
      //   culture: false,
      //   history: false,
      //   inside: false,
      //   nature: false,
      //   tourplace: false,
      //   experience: false
      // }
    };
  },
  methods: {
    // searchAll() {
    //   CityService.searchAll().then(response => {
    //     console.log(response.data);
    //   });
    // }
  },
  created() {
    // this.searchAll();
  }
};
</script>

<style></style>
