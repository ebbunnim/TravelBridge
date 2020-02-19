<template>
  <q-card flat bordered class="my-card">
    <!-- <q-img :src="getImgUrl(fval_img)" basic :ratio="16 / 9">
      <div class="absolute-bottom text-h6 text-center">{{ fval_name }}</div>
    </q-img> -->

    <q-card-section>
      <div class="text-subtitle1 text-center">{{ fval_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-subtitle2 text-body text-center">
        {{ fval_start_day }} ~ {{ fval_end_day }}
      </div>
    </q-card-section>
    <q-card-section>
      <div class="text-subtitle2 text-body2">{{ fval_tag }}</div>
    </q-card-section>

    <q-card-section class="absolute-bottom">
      <q-btn
        flat
        color="primary"
        @click="
          $router.push({
            name: 'festival-detail',
            params: { fval_no: fval_no }
          })
        "
        >상세보기</q-btn
      >
      <q-icon
        class="col"
        name="bookmark_border"
        size="md"
        @click="insertLike()"
      ></q-icon>
      <!-- <q-icon class="col" name="bookmark" size="md"></q-icon> -->
    </q-card-section>
  </q-card>
</template>

<script>
export default {
  name: "FestivalCard",
  methods: {
    // getImgUrl(img) {
    //   return require("../../../../back-spring/src/main/resources" + img);
    // }
  },
  props: {
    fval_img: { type: String },
    fval_name: { type: String },
    fval_start_day: { type: String },
    fval_end_day: { type: String },
    fval_detail_adr: { type: String },
    fval_tag: { type: String },
    fval_no: { tyle: Number }
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
.text-body2 {
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
  -webkit-line-clamp: 2;
}
.my-card {
  height: 400px;
  width: 300px;
  max-height: 550px;
  margin: 10px;
}
</style>
