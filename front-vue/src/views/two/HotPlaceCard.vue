<template>
  <q-card flat bordered class="my-card">
    <q-img :src="hp_img === undefined ? '' : hp_img" basic :ratio="16 / 9">
      <div class="absolute-bottom text-h6 text-center ">{{ hp_name }}</div>
    </q-img>

    <q-card-section>
      <div class="text-subtitle1 text-center text-card-address">{{ hp_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-subtitle2 text-body tag-color">{{ hp_tag }}</div>
    </q-card-section>
    <q-card-section class="absolute-bottom row justify-between">
      <q-btn
        flat
        class="col-4 q-mr-xl"
        color="grey"
        @click="
          $router.push({ name: 'hotplace-detail', params: { hp_no: hp_no } })
        "
        >상세보기</q-btn
      >
      <q-btn
        v-if="!btnCheck"
        flat
        unelevated
        class="offset-3 col-2"
        round
        color="red"
        icon="favorite_border"
        @click="insertLike()"
      ></q-btn>
      <q-btn
        v-if="btnCheck"
        flat
        unelevated
        class="offset-3 col-2"
        round
        color="red"
        icon="favorite"
        @click="deleteLike(hp_no)"
      ></q-btn>
    </q-card-section>
  </q-card>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "HotPlaceCard",
  props: {
    hp_img: { type: String },
    hp_name: { type: String },
    hp_detail_adr: { type: String },
    hp_tag: { type: String },
    hp_no: { type: Number }
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets" + img);
    },
    insertLike() {
      console.log("insert 실행");
      const payload = {
        festival_no: 0,
        hotplace_no: this.hp_no,
        like_del_check: false,
        like_type: 2,
        liker_mem_no: this.user.mem_no
      };
      console.log("payload확인", payload);
      this.$store.dispatch("like/insertLike", payload);
    },
    deleteLike(no) {
      console.log("del 실행");
      console.log(no);
      this.$store.dispatch("like/deleteHotplaceLike", no);
    }
  },
  computed: {
    btnCheck() {
      const have = element => element.hotplace_no === this.hp_no;
      return this.allLikedHPs.some(have);
    },
    ...mapState({
      user: state => state.user.user,
      allLikedHPs: state => state.like.allLikedHPs
    })
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
.text-card-address {
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
  -webkit-line-clamp: 1;
}
.my-card {
  height: 400px;
  width: 300px;
  max-height: 550px;
  margin: 10px;
}

.tag-color {
  color: orange;
}
</style>
