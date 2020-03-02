<template>
  <q-card flat bordered class="my-card">
    <q-img :src="fval_img" basic :ratio="16 / 9">
      <div class="absolute-bottom text-h6 text-center">{{ fval_name }}</div>
    </q-img>

    <q-card-section>
      <div class="text-subtitle1 text-cente text-card-address">{{ fval_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-subtitle2 text-body text-center">{{ fval_start_day }} ~ {{ fval_end_day }}</div>
    </q-card-section>
    <q-card-section class="text-center">
      <div class="text-subtitle2 text-body2 tag-color">{{ fval_tag }}</div>
    </q-card-section>

    <q-card-section class="row justify-between">
      <q-btn
        flat
        class="col-5"
        color="grey"
        @click="
          $router.push({
            name: 'festival-detail',
            params: { fval_no: fval_no }
          })
        "
      >상세보기</q-btn>
      <q-btn
        v-if="!btnCheck & user.mem_no !== undefined"
        flat
        class="offset-1 col-3"
        color="red"
        round
        icon="favorite_border"
        @click="insertLike()"
      ></q-btn>
      <q-btn
        v-if="btnCheck"
        flat
        class="offset-1 col-3"
        color="red"
        round
        icon="favorite"
        @click="deleteLike(fval_no)"
      ></q-btn>
    </q-card-section>
  </q-card>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "FestivalCard",
  props: {
    fval_img: { type: String },
    fval_name: { type: String },
    fval_start_day: { type: String },
    fval_end_day: { type: String },
    fval_detail_adr: { type: String },
    fval_tag: { type: String },
    fval_no: { tyle: Number }
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets" + img);
    },
    insertLike() {
      console.log("insert 실행");
      const payload = {
        festival_no: this.fval_no,
        hotplace_no: 0,
        like_del_check: false,
        like_type: 3,
        liker_mem_no: this.user.mem_no
      };
      console.log("payload확인", payload);
      this.$store.dispatch("like/insertLike", payload);
    },
    deleteLike(no) {
      console.log("del 실행");
      console.log(no);
      this.$store.dispatch("like/deleteFestivalLike", no);
    }
  },
  computed: {
    btnCheck() {
      const have = element => element.festival_no === this.fval_no;
      return this.allLikedFvals.some(have);
    },
    ...mapState({
      user: state => state.user.user,
      allLikedFvals: state => state.like.allLikedFvals
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
}
.tag-color {
  color: #4527a0;
}
</style>
