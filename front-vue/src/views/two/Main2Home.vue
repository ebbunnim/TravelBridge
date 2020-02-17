<template>
  <div class="">
    <div class="">
      <div class="">
        <q-img :src="getImgUrl('global.jpg')" :ratio="16 / 8">
          <div class="absolute-center text-center" style="width: 100%">
            <p class="text-h4 q-pt-lg">
              <b>트래블 서치</b>
            </p>
            <p class="text-body1">
              트래블 브릿지와 함께 다음 여행지를 골라보세요.
            </p>
          </div>
        </q-img>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  data() {
    return {
      cities: this.$store.state.city.cities // 모듈 접근해야 불러와진다.
    };
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    }
  }
};
</script>

<style></style>
