<template>
  <div>
    <div class="q-pa-xl">
      <q-card class="q-pa-xl q-ma-lg" flat bordered>
        <q-card-section align="center">
          <div class="text-h5 text-weight-bold">
            {{ fval.fval_name }}
          </div>
          {{ fval.fval_start_day }} ~ {{ fval.fval_end_day }}
          <div class="q-mt-md">
            <q-chip
              class="q-mx-xs"
              size="md"
              v-for="(tag, index) in tagToArray"
              :key="index"
              >{{ tag }}</q-chip
            >
          </div>
        </q-card-section>
        <q-card-section class="row justify-center">
          <div class="col-md-4">
            <q-btn
              flat
              no-wrap
              color="primary"
              icon="arrow_back"
              label="목록으로"
              @click="goBack()"
            />
          </div>

          <div class="col-md-4 offset-md-4 text-h6 q-my-xs text-center">
            <div>
              <q-chip icon="directions">{{ fval.fval_detail_adr }} </q-chip>
              <q-chip clickable icon="home"
                ><a :href="fval.fval_homepage"> 홈페이지</a></q-chip
              >
            </div>
          </div>
        </q-card-section>
        <q-separator inset />

        <div class="row justify-center">
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <q-img :src="getImgUrl(fval.fval_img)" basic :ratio="16 / 9" />
            </div>
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <p v-html="fval.fval_holiday"></p>
              <p v-html="fval.fval_fee"></p>
            </div>
            <div class="q-ma-md">
              <p v-html="fval.fval_content"></p>
            </div>
          </q-card-section>
        </div>
      </q-card>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  computed: {
    fval_no() {
      return this.$route.params.fval_no;
    },
    ...mapState({
      fval: state => state.festival.fval
    }),
    tagToArray() {
      const arr = this.fval.fval_tag.split(" ");
      return arr;
    }
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets" + img);
    },
    getFestival() {
      this.$store.dispatch("festival/searchByNo", this.fval_no);
    },
    goBack: function() {
      this.$router.go(-1);
      return;
    }
  },
  mounted() {
    this.getFestival();
  }
};
</script>
<style>
.tag-color {
  color: #4527a0;
}
</style>
