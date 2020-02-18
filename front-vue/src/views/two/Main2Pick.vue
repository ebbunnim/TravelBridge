<template>
  <q-page class="page">
    <q-dialog v-model="alert">
      <q-card>
        <q-card-section>
          <div class="text-subtitle1 text-center">선택한 테마가 없습니다!</div>
          <div class="text-h6">
            로그인하시거나 관심 테마를 직접 추가해보세요!
          </div>
        </q-card-section>

        <q-card-actions align="center">
          <q-btn
            flat
            label="지금 바로 선택하기"
            color="primary"
            @click="
              useWithoutLogin();
              alert = false;
            "
            v-close-popup
          />
          <q-btn
            v-if="!loggedIn"
            flat
            label="로그인 후 이용하기"
            color="primary"
            to="/login"
            @click="alert = false"
          ></q-btn>
        </q-card-actions>
      </q-card>
    </q-dialog>
    <q-dialog v-model="choiceAlert">
      <q-card>
        <q-card-section>
          <div class="text-subtitle1 text-center">선택한 테마가 없습니다</div>
          <div class="text-h6">
            지금 관심 테마를 선택하고 여행지를 추천받아 보세요!
          </div>
        </q-card-section>

        <q-card-actions align="center">
          <q-btn
            flat
            label="지금 바로 선택하기"
            color="primary"
            @click="choiceAlert = false"
            v-close-popup
          />
        </q-card-actions>
      </q-card>
    </q-dialog>

    <div
      class="row justify-center items-center q-my-xl q-py-xl"
      style="height: 350px; background: #f9f9f9"
    >
      <div style="display: inline" v-for="(item, idx) in thema" :key="idx">
        <q-btn
          color="grey"
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
          color="grey"
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
    </div>

    <div class="row justify-center q-mt-xl q-pt-xl q-mx-xl q-px-xl">
      <div
        class="col-lg-3 col-md-6 col-xs-12 col-ma-xl"
        v-for="i in hp_list_length"
        :key="i"
      >
        {{ hp_list[i - 1] }}
        <!-- 카드가 들어가는 부분 -->
        <!-- <HotPlaceCard
          class="q-ma-lg"
          :hp_img="hp_list[i - 1].hp_img"
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
          :hp_no="hp_list[i - 1].hp_no"
        ></HotPlaceCard> -->
      </div>
      <!-- <q-btn outline square class="col-11 q-px-xl" @click="loadMoreHp()">더보기</q-btn> -->
      <!-- 
      <div
        class="col-lg-3 col-md-6 col-xs-12"
        v-for="j in fval_list_length"
        :key="j"
      > -->
      <!-- 카드가 들어가는 부분 -->
      <!-- <FestivalCard
          class="q-ma-lg"
          :fval_img="fval_list[j - 1].fval_img"
          :fval_name="fval_list[j - 1].fval_name"
          :fval_start_day="fval_list[j - 1].fval_start_day"
          :fval_end_day="fval_list[j - 1].fval_end_day"
          :fval_detail_adr="fval_list[j - 1].fval_detail_adr"
          :fval_tag="fval_list[j - 1].fval_tag"
          :fval_no="fval_list[j - 1].fval_no"
        ></FestivalCard> -->
      <!-- </div> -->
    </div>
  </q-page>
</template>

<script>
import { mapState, mapGetters } from "vuex";
// import HotPlaceCard from "@/views/two/HotPlaceCard.vue";
// import FestivalCard from "@/views/two/FestivalCard.vue";
export default {
  // components: {
  //   HotPlaceCard,
  //   FestivalCard
  // },
  data() {
    return {
      hp_food: [],
      tempUser: {}, // 비로그인 유저 - 임시적인 검색 기능만 제공한다.
      alert: false, // dialog
      choiceAlert: false,
      loggedIn: false,
      notSelected: false,
      // choice 관련
      currentChoices: "",
      currentChoicesArray: [],
      thema: {
        food: { state: false, name: "맛집", hp: [], fval: [] },
        family: { state: false, name: "가족", hp: [], fval: [] },
        date: { state: false, name: "데이트", hp: [], fval: [] },
        shopping: { state: false, name: "쇼핑", hp: [], fval: [] },
        culture: { state: false, name: "문화", hp: [], fval: [] },
        indoor: { state: false, name: "실내", hp: [], fval: [] },
        healing: { state: false, name: "힐링", hp: [], fval: [] },
        tradition: { state: false, name: "전통", hp: [], fval: [] }
      },
      fvalBtnCnt: 1,
      hpBtnCnt: 1
    };
  },
  computed: {
    ...mapState({
      user: state => state.user.user,
      hp_list_length: state => state.hotplace.hp_list_length, // vuex 에서 데려옴
      fval_list_length: state => state.festival.fval_list_length,
      hp_list: state => state.hotplace.hps,
      fval_list: state => state.festival.fvals
    }),
    ...mapGetters({
      getFvalsByTheme: "festival/getFvalsByTheme"
    })
  },
  methods: {
    checkIfLoggedIn() {
      if (this.user.mem_interest === undefined) {
        this.alert = true;
      } else if (this.user.mem_interest === "") {
        this.choiceAlert = true;
      } else {
        this.checkPastInterest(); ////////////////////////
      }
    },
    useWithoutLogin() {
      // alert 에서 끄는 순간 바로 실행, 비회원일 때
      this.tempUser = {
        mem_id: "비회원",
        mem_interest: ""
      };
      this.user = this.tempUser;
      console.log("비회원유저", this.user);
    },
    checkPastInterest() {
      this.currentChoices = this.user.mem_interest;
      console.log("check Past Interest method 실행 ==> ", this.currentChoices);
      if (this.currentChoices !== "undefined") {
        const tempInterest = this.currentChoices.split(" ");
        for (let key in tempInterest) {
          for (let themaKey in this.thema) {
            if (this.thema[themaKey].name === tempInterest[key]) {
              this.thema[themaKey].state = true;
            }
          }
        }
      }
      this.getAllPicks();
    },
    onToggle() {
      this.currentChoices = "";
      this.currentChoicesArray = [];
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
          this.currentChoicesArray.push(themaChoice[key].name);
        }
      }
      console.log("### TravelPick - onToggle ###", this.currentChoices);
      this.getAllPicks();
    },
    getAllPicks() {
      if (this.currentChoices !== "") {
        this.$store.dispatch("hotplace/searchMoreHotPlaceByTheme", {
          btnCnt: this.hpBtnCnt,
          word: this.currentChoices
        });
        this.$store.dispatch("festival/searchMoreFestivalByTheme", {
          btnCnt: this.fvalBtnCnt,
          word: this.currentChoices
        });
        this.distribute(); //////////////////////////////////////////////
      } else if (this.currentChoices === "") {
        this.$store.commit("hotplace/clearHPs");
        this.$store.commit("festival/clearFvals");
      }
    },
    // 담아 놓은 fval_list 와 hp_list 를 thema 1개 별로 분류해서 list 에 넣는 함수
    distribute() {
      console.log("분류 대상:", this.hp_list);
      console.log("분류 대상:", this.fval_list);
      for (let key in this.hp_list) {
        for (let the in this.thema) {
          // this.hp_list[key].hp_theme.includes();
          console.log(this.hp_list_length[key], this.thema[the]);
        }
      }
    }
  },
  mounted() {
    console.log("========= Main2Pick.vue mounted =======");
    console.log("user: ", this.user);
    console.log("interest: ", this.user.mem_interest);
    this.checkIfLoggedIn();
  }
};
</script>

<style></style>
