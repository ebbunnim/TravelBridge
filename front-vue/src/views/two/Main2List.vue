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
        v-show="searchTitle === null ? false : searchTitle"
        class="col-12 text-center text-h4 q-mb-lg"
      >
        <b>{{ searchTitle }}</b> 검색 결과
      </div>
      <div
        v-show="searchTitle === null ? false : searchTitle"
        v-if="(hp_list_length === undefined) | null | 0 ? false : true"
        class="col-12 text-center text-h6"
      >
        #{{ searchTitle }} 핫플레이스
      </div>
      <div v-else class="col-12 text-center text-h6">
        {{ searchTitle }} 핫플레이스 검색 결과가 없습니다.
      </div>
      <div
        class="col-lg-3 col-md-6 col-xs-12"
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
      </div>
      <!-- <q-btn outline square class="col-11 q-px-xl" @click="loadMoreHp()">더보기</q-btn> -->
      <div
        v-show="searchTitle === null ? false : searchTitle"
        v-if="(fval_list_length === undefined) | null | 0 ? false : true"
        class="col-12 text-center text-h6"
      >
        #{{ searchTitle }} 페스티벌
      </div>
      <div v-else class="col-12 text-center text-h6">
        {{ searchTitle }} 페스티벌 검색 결과가 없습니다.
      </div>

      <div
        class="col-lg-3 col-md-6 col-xs-12"
        v-for="j in fval_list_length"
        :key="j"
      >
        <!-- 카드가 들어가는 부분 -->
        <FestivalCard
          class="q-ma-lg"
          :fval_img="fval_list[j - 1].fval_img"
          :fval_name="fval_list[j - 1].fval_name"
          :fval_start_day="fval_list[j - 1].fval_start_day"
          :fval_end_day="fval_list[j - 1].fval_end_day"
          :fval_detail_adr="fval_list[j - 1].fval_detail_adr"
          :fval_tag="fval_list[j - 1].fval_tag"
          :fval_no="fval_list[j - 1].fval_no"
        ></FestivalCard>
      </div>
      <!-- <q-btn outline square class="col-11 q-px-xl" @click="loadMoreFval()">더보기</q-btn> -->
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
      searchTitle: state => state.hotplace.searchTitle,
      hp_list_length: state => state.hotplace.hp_list_length, // vuex 에서 데려옴
      fval_list_length: state => state.festival.fval_list_length,
      hp_list: state => state.hotplace.hps,
      fval_list: state => state.festival.fvals
    })
  },
  methods: {
    onSearchBtn() {
      const payLoad1 = {
        btnCnt: this.hpBtnCnt,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.word
      };
      const payLoad2 = {
        btnCnt: this.fvalBtnCnt,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.word
      };
      this.$store.dispatch("hotplace/searchMoreHotplace", payLoad1);
      this.$store.dispatch("festival/searchMoreFestival", payLoad2);
      this.$store.commit("hotplace/saveSearchTitle", this.word);
    }
  }
};
</script>

<style></style>
