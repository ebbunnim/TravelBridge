<template>
  <q-card flat bordered class="my-card">
    <q-img :src="getImgUrl(hp_img)" basic :ratio="16 / 9">
      <div class="absolute-bottom text-h6 text-center">{{ hp_name }}</div>
    </q-img>

    <q-card-section>
      <div class="text-subtitle1 text-center">{{ hp_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-subtitle2 text-body">{{ hp_tag }}</div>
    </q-card-section>
    <q-card-section class="absolute-bottom">
      <q-btn
        flat
        color="primary"
        @click="
          $router.push({ name: 'hotplace-detail', params: { hp_no: hp_no } })
        "
        >상세보기</q-btn
      >
    </q-card-section>
  </q-card>
</template>

<script>
export default {
  name: "HotPlaceCard",
  methods: {
    getImgUrl(img) {
      return require("../../../../back-spring/src/main/resources" + img);
    }
  },
  props: {
    hp_img: { type: String },
    hp_name: { type: String },
    hp_detail_adr: { type: String },
    hp_tag: { type: String },
    hp_no: { type: Number }
  }
};
</script>

<style>
.text-title {
  width: 99%;
  padding: 0 5px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.text-body {
  display: -webkit-box;
  display: -ms-flexbox;
  /* display: box;
  margin-top: 1px;
  max-height: 400px; */
  overflow: hidden;
  vertical-align: top;
  text-overflow: ellipsis;
  word-break: break-all;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 4;
}
.my-card {
  height: 400px;
  width: 300px;
  max-height: 550px;
  margin: 10px;
}
</style>
