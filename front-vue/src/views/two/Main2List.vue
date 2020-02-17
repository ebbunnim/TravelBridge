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
    <div class="row justify-center q-mx-xl q-px-xl">
      <div
        v-if="searchTitle === null ? false : searchTitle"
        class="col-12 text-center text-h5 q-mb-lg"
      >
        {{ searchTitle }} 검색결과
      </div>
      <div
        class="col-lg-3 col-md-6 col-xm-12"
        v-for="i in hp_list_length"
        :key="i"
      >
        <!-- 카드가 들어가는 부분 -->
        <HotPlaceCard
          class="q-ma-lg"
          :hp_img="hp_list[i - 1].hp_img"
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
          :hp_no="hp_list[i - 1].hp_no"
        ></HotPlaceCard>
        <!--  -->
      </div>
      <q-btn outline square class="col-11 q-px-xl" @click="loadMoreHp()"
        >더보기</q-btn
      >

      <div
        class="col-lg-3 col-md-6 col-xm-12"
        v-for="i in fval_list_length"
        :key="i"
      >
        <!-- 카드가 들어가는 부분 -->
        <FestivalCard
          class="q-ma-lg"
          :fval_img="fval_list[i - 1].fval_img"
          :fval_name="fval_list[i - 1].fval_name"
          :fval_start_day="fval_list[i - 1].fval_start_day"
          :fval_end_day="fval_list[i - 1].fval_end_day"
          :fval_detail_adr="fval_list[i - 1].fval_detail_adr"
          :fval_tag="fval_list[i - 1].fval_tag"
          :fval_no="fval_list[i - 1].fval_no"
        ></FestivalCard>
        <!--  -->
      </div>
      <q-btn outline square class="col-11 q-px-xl" @click="loadMoreFval()"
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
      searchTitle: null,
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
      fval_list_length: state => state.festival.fval_list_length,
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
      payLoad.btnCnt = this.fvalBtnCnt + 1;
      this.$store.dispatch("festival/searchMoreFestival", payLoad);
      this.searchTitle = this.word;
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
