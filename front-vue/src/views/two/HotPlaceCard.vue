<template>
  <div>
    <div class="q-ma-xl q-pa-xl">
      <q-card flat bordered>
        <q-card-section class="row">
          <div class="text-h4 q-mt-xl text-center col-12">{{ hp.hp_name }}</div>
          <div class="text-h6 q-my-md text-center col-12">
            <div>
              {{ hp.hp_detail_adr }}
              <a :href="hp.hp_homepage">
                <q-btn size="lg" flat>
                  <q-icon name="home"></q-icon>
                </q-btn>
              </a>
            </div>
          </div>
          <q-separator inset />
        </q-card-section>
        <q-card-section class="q-ma-lg text-center tag-color col-6">
          {{
          hp.hp_tag
          }}
        </q-card-section>
        <div class="row justify-center">
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <q-img :src="getImgUrl(hp.hp_img)" basic :ratio="16 / 9" />
            </div>
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <div class="text-subtitle1">{{ hp.hp_holiday }}</div>
              <div class="text-subtitle1">{{ hp.hp_fee }}</div>
            </div>
            <div class="q-ma-lg">
              <div class="text-body1">{{ hp.hp_content }}</div>
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
    })
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/hotplace/" + img);
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
