<template>
  <div>
    <div class="q-ma-xl q-pa-xl">
      <q-card flat bordered>
        <q-card-section class="row justify-center">
          <div class="text-h6 q-my-sm text-center col-12">
            {{ fval.fval_start_day }} ~ {{ fval.fval_end_day }}
          </div>
          <div class="text-h4 q-my-sm text-center col-12">
            {{ fval.fval_name }}
          </div>
          <div class="text-h6 q-my-sm text-center col-12">
            <div>
              {{ fval.fval_detail_adr }}
              <a :href="fval.fval_homepage">
                <q-btn size="lg" flat>
                  <q-icon name="home"></q-icon>
                </q-btn>
              </a>
            </div>
          </div>
          <q-separator inset />
        </q-card-section>
        <q-card-section class="q-ma-lg text-center tag-color col-6">{{
          fval.fval_tag
        }}</q-card-section>
        <div class="row justify-center">
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <!-- <q-img :src="getImgUrl(fval.fval_img)" basic :ratio="16 / 9" /> -->
            </div>
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <div class="text-subtitle1">{{ fval.fval_holiday }}</div>
              <div class="text-subtitle1">{{ fval.fval_fee }}</div>
            </div>
            <div class="q-ma-md">
              <div class="text-body1">{{ fval.fval_content }}</div>
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
    })
  },
  methods: {
    // getImgUrl(img) {
    //   return require("../../../../back-spring/src/main/resources" + img);
    // },
    getFestival() {
      this.$store.dispatch("festival/searchByNo", this.fval_no);
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
