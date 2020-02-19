<template>
  <q-page class="page">
    <div
      class="row justify-center items-center q-my-xl q-py-xl bg-image"
      style="width: 100%;"
    >
      <div class="col-12 text-h4 text-center text-white">
        <b>여행지 정보 검색</b>
      </div>
      <q-select
        wrap
        rounded
        bg-color="grey"
        standout="bg-glossy text-white"
        v-model="searchOption"
        class="col-md-2 col-xs-4 text-h6 q-mx-sm"
        :options="searchOptions"
      />
      <template v-if="this.searchOption == '지역'">
        <div class="row justify-around col-5">
          <q-select
            rounded
            bg-color="grey"
            standout="bg-glossy text-white"
            v-model="area"
            use-input
            input-debounce="0"
            @input="postInner"
            :options="spinArea"
            class="col-5 text-h6"
            label="광역시·도"
          >
            <template v-slot:no-option>
              <q-item>
                <q-item-section class="text-grey">No results</q-item-section>
              </q-item>
            </template>
          </q-select>
          <template>
            <q-select
              rounded
              bg-color="grey"
              standout="bg-glossy text-white"
              v-model="city"
              label="시·군·구"
              :options="spinCity"
              class="col-5 text-h6"
              behavior="menu"
            />
          </template>
          <q-btn
            outline
            flat
            color="grey"
            icon="search"
            @click="onSearchSubBtn()"
          />
        </div>
      </template>
      <template v-else>
        <q-input
          rounded
          bg-color="grey"
          standout="bg-glossy text-white"
          class="col-md-3 col-xs-6 text-h6"
          v-model="word"
          text-
          placeholder="검색어를 입력하세요"
        >
          <template v-slot:append>
            <q-btn
              outline
              flat
              color="white"
              icon="search"
              @click="onSearchBtn()"
            />
          </template>
        </q-input>
      </template>
      <!-- 버튼을 누른다.  -->
      <!--  -->
    </div>
    <div class="row justify-center q-mx-xl q-px-xl">
      <div
        v-show="searchTitle === null ? false : searchTitle"
        class="col-12 text-center text-h4 q-mb-lg"
      >
        <b>{{ searchTitle }}</b> 검색 결과
      </div>
    </div>

    <div class="row justify-center q-mx-xl q-px-xl">
      <div v-if="hp_list_length > 0" class="col-12 text-center text-h6">
        #{{ searchTitle }} 핫플레이스
      </div>
      <div v-if="hp_list_length === 0" class="col-12 text-center text-h6">
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
    </div>

    <div class="festival-bg q-my-xl q-py-xl">
      <div class="row justify-center q-mx-xl q-px-xl">
        <div v-if="fval_list_length > 0" class="col-12 text-center text-h6">
          #{{ searchTitle }} 페스티벌
        </div>
        <div v-if="fval_list_length === 0" class="col-12 text-center text-h6">
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
      </div>
    </div>
  </q-page>
</template>

<script>
import { mapState } from "vuex";
import HotPlaceCard from "@/views/two/HotPlaceCard.vue";
import FestivalCard from "@/views/two/FestivalCard.vue";

const area = [
  "서울",
  "부산",
  "대구",
  "인천",
  "광주",
  "대전",
  "울산",
  "세종",
  "경기",
  "강원",
  "충북",
  "충남",
  "경북",
  "경남",
  "전북",
  "전남",
  "제주"
];
const seoul = [
  "강남구",
  "도봉구",
  "동대문구",
  "동작구",
  "마포구",
  "서대문구",
  "서초구",
  "성동구",
  "성북구",
  "송파구",
  "양천구",
  "강동구",
  "영등포구",
  "용산구",
  "은평구",
  "종로구",
  "중구",
  "중랑구",
  "강북구",
  "강서구",
  "관악구",
  "광진구",
  "구로구",
  "금천구",
  "노원구"
];
const qntks = [
  "강서구",
  "사하구",
  "서구",
  "수영구",
  "연제구",
  "영도구",
  "중구",
  "해운대구",
  "금정구",
  "기장군",
  "남구",
  "동구",
  "동래구",
  "부산진구",
  "북구",
  "사상구"
];
const eorn = [
  "남구",
  "달서구",
  "달성군",
  "동구",
  "북구",
  "서구",
  "수성구",
  "중구"
];
const dlscjs = [
  "강화군",
  "중구",
  "계양구",
  "미추홀구",
  "남동구",
  "동구",
  "부평구",
  "서구",
  "연수구",
  "옹진군"
];
const rhkdwn = ["광산구", "남구", "동구", "북구", "서구"];
const eowjs = ["대덕구", "동구", "서구", "유성구", "중구"];
const dnftks = ["중구", "남구", "동구", "북구", "울주군"];
const tpwhd = ["세종시"];
const rudrl = [
  "가평군",
  "동두천시",
  "부천시",
  "성남시",
  "수원시",
  "시흥시",
  "안산시",
  "안성시",
  "안양시",
  "양주시",
  "양평군",
  "고양시",
  "여주시",
  "연천군",
  "오산시",
  "용인시",
  "의왕시",
  "의정부시",
  "이천시",
  "파주시",
  "평택시",
  "포천시",
  "과천시",
  "하남시",
  "화성시",
  "광명시",
  "광주시",
  "구리시",
  "군포시",
  "김포시",
  "남양주시"
];
const rkddnjs = [
  "강릉시",
  "인제군",
  "정선군",
  "철원군",
  "춘천시",
  "태백시",
  "평창군",
  "홍천군",
  "화천군",
  "횡성군",
  "고성군",
  "동해시",
  "삼척시",
  "속초시",
  "양구군",
  "양양군",
  "영월군",
  "원주시"
];
const cndqnr = [
  "괴산군",
  "청주시",
  "충주시",
  "증평군",
  "단양군",
  "보은군",
  "영동군",
  "옥천군",
  "음성군",
  "제천시",
  "진천군"
];
const cndska = [
  "공주시",
  "예산군",
  "천안시",
  "청양군",
  "태안군",
  "홍성군",
  "계룡시",
  "금산군",
  "논산시",
  "당진시",
  "보령시",
  "부여군",
  "서산시",
  "서천군",
  "아산시"
];
const rudqnr = [
  "경산시",
  "성주군",
  "안동시",
  "영덕군",
  "영양군",
  "영주시",
  "영천시",
  "예천군",
  "울릉군",
  "울진군",
  "의성군",
  "경주시",
  "청도군",
  "청송군",
  "칠곡군",
  "포항시",
  "고령군",
  "구미시",
  "군위군",
  "김천시",
  "문경시",
  "봉화군",
  "상주시"
];
const rudska = [
  "거제시",
  "양산시",
  "의령군",
  "진주시",
  "창녕군",
  "창원시",
  "통영시",
  "하동군",
  "함안군",
  "거창군",
  "함양군",
  "합천군",
  "고성군",
  "김해시",
  "남해군",
  "밀양시",
  "사천시",
  "산청군"
];
const wjsqnr = [
  "고창군",
  "임실군",
  "장수군",
  "전주시",
  "정읍시",
  "진안군",
  "군산시",
  "김제시",
  "남원시",
  "무주군",
  "부안군",
  "순창군",
  "완주군",
  "익산시"
];
const wjsska = [
  "강진군",
  "보성군",
  "순천시",
  "신안군",
  "여수시",
  "영광군",
  "영암군",
  "완도군",
  "장성군",
  "고흥군",
  "장흥군",
  "진도군",
  "함평군",
  "해남군",
  "화순군",
  "곡성군",
  "광양시",
  "구례군",
  "나주시",
  "담양군",
  "목포시",
  "무안군"
];
const wpwn = ["서귀포시", "제주시"];

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
      searchOptions: ["전체", "제목", "내용", "태그", "지역"],
      searchOptionValue: {
        전체: "all",
        제목: "title",
        내용: "content",
        태그: "tag",
        지역: "city"
      },
      word: "",
      //
      city: "",
      area: "",
      spinArea: area,
      spinCity: []
    };
  },
  computed: {
    ...mapState({
      searchTitle: state => state.hotplace.searchTitle,
      hp_list_length: state => state.hotplace.hp_list_length, // length 를 mounting 될 때 계산시 오류 떠서 vuex 에서 계산하고 불러옴
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
      console.log("Vue:", payLoad1);
      console.log("Vue:", payLoad2);
      //
      this.$store.dispatch("hotplace/searchMoreHotplace", payLoad1);
      this.$store.dispatch("festival/searchMoreFestival", payLoad2);
      //
      this.$store.commit("hotplace/saveSearchTitle", this.word);
    },
    onSearchSubBtn() {
      const payLoad1 = {
        btnCnt: this.hpBtnCnt,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.area + " " + this.city
      };
      const payLoad2 = {
        btnCnt: this.fvalBtnCnt,
        searchOption: this.searchOptionValue[this.searchOption],
        word: this.area + " " + this.city
      };
      console.log("Vue:", payLoad1);
      console.log("Vue:", payLoad2);
      //
      this.$store.dispatch("hotplace/searchMoreHotplace", payLoad1);
      this.$store.dispatch("festival/searchMoreFestival", payLoad2);
      //
      this.$store.commit(
        "hotplace/saveSearchTitle",
        this.area + " " + this.city
      );
    },
    postInner() {
      this.city = "";
      if (this.area === "서울") this.spinCity = seoul;
      else if (this.area === "부산") this.spinCity = qntks;
      else if (this.area === "대구") this.spinCity = eorn;
      else if (this.area === "인천") this.spinCity = dlscjs;
      else if (this.area === "광주") this.spinCity = rhkdwn;
      else if (this.area === "대전") this.spinCity = eowjs;
      else if (this.area === "울산") this.spinCity = dnftks;
      else if (this.area === "세종") this.spinCity = tpwhd;
      else if (this.area === "경기") this.spinCity = rudrl;
      else if (this.area === "강원") this.spinCity = rkddnjs;
      else if (this.area === "충북") this.spinCity = cndqnr;
      else if (this.area === "충남") this.spinCity = cndska;
      else if (this.area === "경북") this.spinCity = rudqnr;
      else if (this.area === "경남") this.spinCity = rudska;
      else if (this.area === "전북") this.spinCity = wjsqnr;
      else if (this.area === "전남") this.spinCity = wjsska;
      else if (this.area === "제주") this.spinCity = wpwn;
      else {
        this.spinCity = [];
      }
    }
  },
  created() {
    this.$store.commit("hotplace/clearHPs");
    this.$store.commit("festival/clearFvals");
  }
};
</script>

<style>
.bg-image {
  background-image: url("../../assets/global.jpg");
  background-repeat: no-repeat;
  background-size: 100% 100%;
  height: 450px;
  min-height: 350px;
}
.festival-bg {
  background-color: #f9f9f9;
}
</style>
