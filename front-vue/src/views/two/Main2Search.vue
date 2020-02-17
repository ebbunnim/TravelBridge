<template>
  <div>
    <h1>태그, 제목, 내용, all 검색</h1>
    <!-- 검색 option 과 검색어를 입력받는 div -->
    <!-- <div class="row justify-center" style="margin:5% 0 0 0 ; height: 550px;">
      <q-select bordered class="col-1 q-mx-xs" v-model="searchOption" :options="searchOptions" />

      <q-input bordered class="col-3 text-h6" v-model="word" type="text">
        <template v-slot:append>
          <q-btn outline flat color="grey" icon="search" @click="onSubmitBtn()" />
        </template>
      </q-input>
    </div> -->
    <!-- 입력받은 내용을 보여주는 div -->
    <div class="row q-mx-xl q-px-xl">
      <div
        class="col-xs-12 col-md-6 col-lg-3"
        v-for="i in hp_list.length > 4 * hpBtnCnt
          ? 4 * hpBtnCnt
          : hp_list.length"
        :key="i"
      >
        <HotPlaceCard
          class="my-content"
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
        ></HotPlaceCard>
      </div>
      <q-btn label="더보기" @click="loadMoreHp()"></q-btn>
    </div>
    <div class="row" style="height: 550px; background: #f9f9f9">
      <div
        v-for="i in fval_list.length > 4 * fvalBtnCnt
          ? 4 * fvalBtnCnt
          : fval_list.length"
        :key="i"
      >
        <FestivalCard
          class="col-3"
          :fval_name="fval_list[i - 1].fval_name"
          :fval_detail_adr="fval_list[i - 1].fval_detail_adr"
          :fval_tag="fval_list[i - 1].fval_tag"
        ></FestivalCard>
      </div>
    </div>
  </div>
</template>

<script>
import HotPlaceCard from "@/views/two/HotPlaceCard.vue";
import FestivalCard from "@/views/two/FestivalCard.vue";

export default {
  components: {
    HotPlaceCard,
    FestivalCard
  },
  data() {
    return {
      hp_list: [],
      fval_list: [],
      hpBtnCnt: 1,
      fvalBtnCnt: 1,
      loadMoreHpCheck: true,
      loadMoreFvalCheck: true,
      // 더보기로 HotPlace 또는 Festival 검색하기 조회
      // searchOption은 all / title / content/ tag / city 중 전달
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
  methods: {
    onSubmitBtn() {
      // console.log(this.searchOption);
      // console.log(this.word);
      // console.log(this.searchOptionValue[this.searchOption]);
      // this.$store.dispatch("hotplace/searchMoreHotplace", {
      //   btnCnt: this.hpBtnCnt,
      //   searchOption: this.searchOptionValue[this.searchOption],
      //   word: this.word
      // });
      // this.$store.dispatch("festival/searchMoreFestival", {
      //   btnCnt: this.fvalBtnCnt,
      //   searchOption: this.searchOptionValue[this.searchOption],
      //   word: this.word
      // });
    },
    loadMoreBtnCheck() {
      if (this.hp_list.length < 4) this.loadMoreHpCheck = false;
      if (this.fval_list.length < 4) this.loadMoreFvalCheck = false;
    },
    loadMoreHp() {
      this.hpBtnCnt++;
      console.log("버튼 카운트", this.hpBtnCnt);
      this.onSubmitBtn();
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

<style lang="sass" scoped>
.my-content
  padding: 10px 15px
  border: 1px solid rgba(86,61,124,.2)
</style>
