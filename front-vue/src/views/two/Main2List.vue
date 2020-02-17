<template>
  <q-page class="page">
    <div
      class="row justify-center q-my-xl q-py-xl"
      style="height: 550px; background: #f9f9f9"
    >
      <q-select
        bordered
        class="col-1 q-mx-xs text-grey"
        v-model="searchOption"
        :options="searchOptions"
      />
      <q-input
        bordered
        class="col-3 text-h6"
        v-model="word"
        type="text"
        :placeholder="[
          searchOption === null ? '' : searchOption + '을 검색하세요'
        ]"
      >
        <template v-slot:append>
          <q-btn
            outline
            flat
            color="grey"
            icon="search"
            @click="onSearchBtn()"
          />
        </template>
      </q-input>
    </div>
    <div class>
      <h4>이건 fval</h4>
      {{ fval_list }}
      <h4>이건 hp</h4>
      {{ hp_list }}
    </div>

    <!-- <div class="row" style="height: 550px">
      <div class="col text-h5"></div>
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
      <div class="col text-h5"></div>

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
    </div>-->
  </q-page>
</template>

<script>
import { mapState } from "vuex";
// import HotPlaceCard from "@/views/two/HotPlaceCard.vue";
// import FestivalCard from "@/views/two/FestivalCard.vue";

export default {
  // components: {
  // HotPlaceCard,
  // FestivalCard
  // },
  data() {
    return {
      hpBtnCnt: 1,
      fvalBtnCnt: 1,
      //
      hpLoadMore: false,
      fvalLoadMore: false,
      //
      searchOption: null,
      searchOptions: ["전체", "제목", "내용", "태그", "도시"],
      searchOptionValue: {
        전체: "all",
        제목: "title",
        내용: "content",
        태그: "tag",
        도시: "city"
      },
      word: ""
    };
  },
  computed: mapState({
    hp_list: state => state.hotplace.hps,
    fval_list: state => state.festival.fvals
  }),
  methods: {
    onSearchBtn() {
      const payLoad = {
        btnCnt: this.hpBtnCnt, // fval
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.word
      };
      this.$store.dispatch("hotplace/searchMoreHotplace", payLoad);
      payLoad.btnCnt = this.fvalBtnCnt;
      this.$store.dispatch("festival/searchMoreFestival", payLoad);
    },
    checkLoadMoreBtn() {
      if (this.hp_list.length < 4) this.hpLoadMore = false;
      if (this.fval_list.length < 4) this.fvalLoadMore = false;
    }
  }
};
</script>

<style></style>
