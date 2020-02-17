<template>
  <q-page class="page">
    <!-- <div class="row justify-center q-my-xl q-py-xl" style="height: 550px; background: #f9f9f9">
      <q-input
        align="center"
        class="col-4 text-h6"
        v-model="cityName"
        type="text"
        placeholder="도시 이름을 검색하세요(예: 서울, 전주)"
      >
        <template v-slot:append>
          <q-btn outline flat color="grey" icon="search" @click="onSearchBtn()" />
        </template>
      </q-input>
    </div> -->

    <div class="row" style="height: 550px">
      <div class="col text-h5">{{ cityName }}의 핫플레이스 정보</div>
      <div
        class="col"
        v-for="i in hp_list.length > 4 * hpBtnCnt
          ? 4 * hpBtnCnt
          : hp_list.length"
        :key="i"
      >
        <HotPlaceCard
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
        ></HotPlaceCard>
      </div>
    </div>
    <div class="row" style="height: 550px; background: #f9f9f9">
      <div class="col text-h5">{{ cityName }}의 축제 정보</div>

      <div
        class="col"
        v-for="i in fval_list.length > 4 * hpBtnCnt
          ? 4 * fvalBtnCnt
          : fval_list.length"
        :key="i"
      >
        <FestivalCard
          :fval_name="fval_list[i - 1].fval_name"
          :fval_detail_adr="fval_list[i - 1].fval_detail_adr"
          :fval_tag="fval_list[i - 1].fval_tag"
        ></FestivalCard>
      </div>
    </div>
  </q-page>
</template>

<script>
import { mapState } from "vuex";
import HotPlaceCard from "@/views/two/HotPlaceCard.vue";
import FestivalCard from "@/views/two/FestivalCard.vue";
export default {
  components: {
    HotPlaceCard,
    FestivalCard
  },
  data() {
    return {
      fval_list: [],
      hp_list: [],
      cityName: null,
      hpBtnCnt: 1,
      fvalBtnCnt: 1,
      hpLoadMore: false,
      fvalLoadMore: false
    };
  },
  // computed: mapState({
  // hp_list: state => state.hotplace.hps,
  // fval_list: state => state.festival.fvals
  // }),
  methods: {
    onSearchBtn() {
      console.log("현재검색어:", this.search);
      this.$store.dispatch("hotplace/searchMoreHotPlaceByCityName", {
        btnCnt: this.hpBtnCnt,
        cityName: this.cityName
      });
      this.$store.dispatch("festival/searchMoreFestivalByCityName", {
        btnCnt: this.fvalBtnCnt,
        cityName: this.cityName
      });
    }
  },
  mounted() {
    this.hp_list = this.$store.state.hotplace.hps;
    this.fval_list = this.$store.state.festival.fvals;
  },
  created() {
    this.hp_list = this.$store.state.hotplace.hps;
    this.fval_list = this.$store.state.festival.fvals;
  }
};
</script>

<style></style>
