<template>
  <!-- <div>
    <h1>Sub페이지</h1>
  </div>-->
  <div>
    <!-- <h3>Main3 - calendar</h3> -->
    <q-img :src="getImgUrl('cutbg.jpg')" style="width: 100%">
      <div class="absolute-center text-center" style="width: 100%">
        <p class="text-h3 text-center">
          <q-icon name="calendar_today" />Planner
        </p>
        <p class="text-h5 text-center">너와나를 이어주는 공간.</p>
      </div>
    </q-img>
    <Calendar />
  </div>
</template>

<script>
import Calendar from "../components/Calendar";
export default {
  components: {
    Calendar
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    }
  }
};
</script>

<style>
</style>