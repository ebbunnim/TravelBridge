<template>
  <div>
    <div>
      <q-carousel
        v-model="slide"
        animated
        swipeable
        autoplay
        navigation
        infinite
        height="680px"
      >
        <q-carousel-slide :name="1" :img-src="getImgUrl('main2bg.jpg')">
          <div
            class="row q-my-xl text-center justify-center absolute-center custom-caption"
            style="width: 100%;"
          >
            <p class="col-12 text-h4 q-pt-lg">
              <b>테마별 여행지 추천</b>
            </p>
            <p class="col-12 text-body1">
              {{ user.mem_name }}님을 위한 맞춤 여행지를 추천해 드립니다.
            </p>

            <div
              style="display: inline"
              v-for="(item, idx) in thema"
              :key="idx"
            >
              <q-btn
                color="info"
                class="q-ma-sm"
                size="lg"
                rounded
                v-if="item.state"
                @click="
                  item.state = !item.state;
                  onToggle();
                "
                >#{{ item.name }}</q-btn
              >
              <q-btn
                color="info"
                class="q-ma-sm"
                rounded
                size="lg"
                v-if="!item.state"
                outline
                @click="
                  item.state = !item.state;
                  onToggle();
                "
                >#{{ item.name }}</q-btn
              >
            </div>
            <q-btn
              outline
              flat
              color="white"
              icon="search"
              @click="onPickBtn()"
            />

            <!-- <q-input class="col-7 text-h6" v-model="word" type="text" placeholder="검색어를 검색하세요">
              <template v-slot:append>
                <q-btn outline flat color="grey" icon="search" @click="onSearchBtn()" />
              </template>
            </q-input>-->
          </div>
        </q-carousel-slide>
        <q-carousel-slide :name="2" :img-src="getImgUrl('main2bg2.jpg')">
          <div
            class="row q-my-xl text-center justify-center absolute-center custom-caption"
            style="width: 100%;"
          >
            <p class="col-12 text-h4 q-pt-lg">
              <b>여행지 정보 검색</b>
            </p>
            <p class="col-12 text-body1">
              제목, 내용, 도시, 태그로 핫플레이스와 축제를 검색하세요.
            </p>
            <q-select
              filled
              no-wrap
              class="col-md-2 col-xs-4 text-h6 text-white q-mx-sm q-px-lg"
              v-model="searchOption"
              :options="searchOptions"
            />
            <q-input
              filled
              class="col-md-4 col-xs-8 text-h6"
              v-model="word"
              placeholder="검색어를 검색하세요"
            >
              <template v-slot:append>
                <q-btn
                  outline
                  flat
                  color="white"
                  icon="search"
                  @click="onMainSearchBtn()"
                />
              </template>
            </q-input>
          </div>
        </q-carousel-slide>
      </q-carousel>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  data() {
    return {
      currentChoices: "",
      hpBtnCnt: 1,
      fvalBtnCnt: 1,
      word: "",
      slide: 1,
      searchOption: "전체",
      searchOptions: ["전체", "제목", "내용", "태그", "도시"],
      searchOptionValue: {
        전체: "all",
        제목: "title",
        내용: "content",
        태그: "tag",
        도시: "city"
      },
      thema: {
        food: { state: false, name: "맛집" },
        family: { state: false, name: "가족" },
        date: { state: false, name: "데이트" },
        shopping: { state: false, name: "쇼핑" },
        culture: { state: false, name: "문화" },
        indoor: { state: false, name: "실내" },
        healing: { state: false, name: "힐링" },
        tradition: { state: false, name: "전통" }
      }
    };
  },
  computed: {
    ...mapState({
      user: state => state.user.user,
      hp_list: state => state.hotplace.hps,
      fval_list: state => state.festival.fvals
    })
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    },
    onMainSearchBtn() {
      //
      console.log(this.searchOptionValue[this.searchOption]);
      console.log(this.word);
      //
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
      this.$router.push("/page2/list");
    },
    onToggle() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      console.log("###### Home에서 onToggle 눌림 ######", this.currentChoices);
      this.user.mem_interest = this.currentChoices;
      console.log(this.user.mem_interest);
    },
    onPickBtn() {
      this.$router.push("/page2/pick");
    }
  }
};
</script>

<style>
.custom-caption {
  text-align: center;
  color: white;
  background-color: rgba(0, 0, 0, 0.3);
}
</style>
