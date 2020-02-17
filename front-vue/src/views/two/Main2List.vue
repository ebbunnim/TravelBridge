<template>
  <q-page class="page">
    <div
      class="row justify-center text-center q-my-xl q-py-xl"
      style="height: 400px; background: #f9f9f9"
    >
      <q-select
        no-wrap
        class="col-md-2 col-xs-4 text-h6 q-mx-sm q-px-lg"
        v-model="searchOption"
        :options="searchOptions"
      />
      <q-input
        class="col-md-4 col-xs-6 text-h6"
        v-model="word"
        :placeholder="[
          (searchOption === null) | (searchOption === '전체')
            ? ''
            : searchOption + '을 검색하세요'
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
    <div class="row justify-center q-mx-xl q-px-xl" style="height: 550px">
      <div
        class="col-lg-3 col-md-6 col-xm-12"
        v-for="i in hp_list_length"
        :key="i"
      >
        <!-- 카드가 들어가는 부분 -->
        <HotPlaceCard
          class="q-ma-lg"
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
          :hp_no="hp_list[i - 1].hp_no"
        ></HotPlaceCard>
        <!--  -->
      </div>
      <q-btn
        outline
        square
        class="col-xs-12 col-lg-10 q-ma-lg"
        v-if="hpLoadMore"
        @click="onSearchBtn()"
        >더보기</q-btn
      >
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
      hpBtnCnt: 1,
      fvalBtnCnt: 1,
      //
      hpLoadMore: false,
      fvalLoadMore: false,
      //
      searchOption: "전체",
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
  computed: {
    ...mapState({
      hp_list_length: state => state.hotplace.hp_list_length, // vuex 에서 데려옴
      hp_list: state => state.hotplace.hps,
      fval_list: state => state.festival.fvals
    })
  },
  methods: {
    onSearchBtn() {
      const payLoad = {
        btnCnt: this.hpBtnCnt + 1,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.word
      };
      console.log("vue에서:", payLoad);
      this.$store.dispatch("hotplace/searchMoreHotplace", payLoad);
    }
    // checkLoadMoreBtn() {
    //   if (4 * this.hpBtnCnt < this.hp_list_length <= 4 * (this.hpBtnCnt + 1)) {
    //     this.hpLoadMore = true;
    //   }
    // }
  }
};
</script>

<style></style>
