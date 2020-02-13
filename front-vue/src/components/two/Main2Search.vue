<template>
  <div>
    <h1>태그, 제목, 내용, all 검색</h1>
    <!-- 검색 option 과 검색어를 입력받는 div -->
    <div class="row justify-center">
      <q-select
        bordered
        class="col-1 q-mx-xs"
        v-model="searchOption"
        :options="searchOptions"
      />

      <q-input
        bordered
        class="col-3 text-h6"
        v-model="word"
        type="text"
        placeholder="??????"
      >
        <template v-slot:append>
          <q-btn
            outline
            flat
            color="grey"
            icon="search"
            @click="onSubmitBtn()"
          />
        </template>
      </q-input>
    </div>
    <!-- 입력받은 내용을 보여주는 div -->
    <div class="row" style="height: 550px">
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
  </div>
</template>

<script>
import { mapState } from "vuex";
import HotPlaceCard from "@/components/two/HotPlaceCard.vue";
import FestivalCard from "@/components/two/FestivalCard.vue";

export default {
  components: {
    HotPlaceCard,
    FestivalCard
  },
  data() {
    return {
      hpBtnCnt: 1,
      fvalBtnCnt: 1,
      // 더보기로 HotPlace 또는 Festival 검색하기 조회
      // searchOption은 all / title / content/ tag 중 전달
      searchOption: null,
      searchOptions: ["전체", "제목", "내용", "태그"],
      searchOptionValue: {
        전체: "all",
        제목: "title",
        내용: "content",
        태그: "tag"
      },
      word: ""
    };
  },
  computed: mapState({
    hp_list: state => state.hotplace.hps,
    fval_list: state => state.festival.fvals
  }),
  methods: {
    onSubmitBtn() {
      console.log(this.searchOption);
      console.log(this.word);
      console.log(this.searchOptionValue[this.searchOption]);

      this.$store.dispatch("hotplace/searchMoreHotplace", {
        btnCnt: this.hpBtnCnt,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.word
      });
      this.$store.dispatch("festival/searchMoreFestival", {
        btnCnt: this.fvalBtnCnt,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.word
      });
    }
  }
};
</script>

<style></style>
