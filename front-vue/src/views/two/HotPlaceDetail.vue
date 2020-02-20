<template>
  <div>
    <div class="q-pa-xl">
      <q-card class="q-pa-xl q-ma-lg" flat bordered>
        <q-card-section align="center">
          <div class="text-h5 text-weight-bold">
            {{ hp.hp_name }}
          </div>
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
              <q-chip icon="directions">{{ hp.hp_detail_adr }} </q-chip>
              <q-chip clickable icon="home"
                ><a :href="hp.hp_homepage"> 홈페이지</a></q-chip
              >
            </div>
          </div>
        </q-card-section>
        <q-separator inset />

        <div class="row justify-center">
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md ">
              <q-img :src="hp.hp_img" basic :ratio="16 / 9" />
            </div>
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <!-- <div class="text-subtitle1">{{ }}</div> -->
              <!-- <div class="text-subtitle1">{{  }}</div> -->
              <p v-html="hp.hp_holiday"></p>
              <p v-html="hp.hp_fee"></p>
            </div>
            <div class="q-ma-lg">
              <!-- <div class="text-body1" v-html="hp.hp_content"></div> -->
              <p v-html="hp.hp_content"></p>
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
    hp_no() {
      return this.$route.params.hp_no;
    },
    ...mapState({
      hp: state => state.hotplace.hp
    }),
    tagToArray() {
      const arr = this.hp.hp_tag.split(" ");
      return arr;
    }
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets" + img);
    },
    getHotplace() {
      console.log("this.hp_no", this.hp_no);
      this.$store.dispatch("hotplace/searchByNo", this.hp_no);
    }
  },
  created() {
    this.getHotplace();
  }
};
</script>

<style>
.tag-color {
  color: #4527a0;
}
</style>
