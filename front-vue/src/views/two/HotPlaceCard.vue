<template>
  <q-card flat bordered>
    <q-card-section>
      <div class="text-h5 text-center text-title">{{ hp_name }}</div>
      <div class="text-subtitle2 text-center">{{ hp_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-subtitle1 text-body">{{ hp_tag }}</div>
    </q-card-section>
    <q-card-section>
      <q-btn
        @click="
          $router.push({ name: 'hotplace-detail', params: { hp_no: hp_no } })
        "
        >상세보기</q-btn
      >
    </q-card-section>
  </q-card>
</template>

<v-btn @click="$router.push({ path: `${id}/edit` })">수정</v-btn>
<v-btn>수정</v-btn>

<script>
export default {
  name: "HotPlaceCard",
  methods: {
    // getImgUrl(img) {
    //   return require("../../assets/" + img);
    // }
  },
  props: {
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
</style>
