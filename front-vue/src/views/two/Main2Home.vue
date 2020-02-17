<template>
  <div>
    <q-img :src="getImgUrl('global.jpg')" :ratio="16 / 4">
      <div class="absolute-top text-center" style="width: 100%">
        <p class="text-h4 q-pt-lg">
          <b>트래블 픽</b>
        </p>
        <p class="text-body1">트래블 브릿지와 함께 다음 여행지를 골라보세요.</p>

        <q-input
          class="text-h6"
          v-model="cityName"
          type="text"
          placeholder="도시 이름을 검색하세요(예: 서울, 전주)"
        >
          <template v-slot:append>
            <q-btn
              outline
              flat
              color="grey"
              icon="search"
              @click="onSearchBtn()"
            />
          </template>
        </q-input>
      </div>
    </q-img>

    <q-card
      style="margin: 100px 150px; height: 400px; text-align: center;"
      class="q-pa-lg"
      flat
      bordered
      square
      >ㅎㅇ</q-card
    >
    <q-card
      style="margin: 100px 150px; height: 400px; text-align: center;"
      class="q-pa-lg"
      flat
      bordered
      square
      >ㅎㅇ</q-card
    >
  </div>
</template>

<script>
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
