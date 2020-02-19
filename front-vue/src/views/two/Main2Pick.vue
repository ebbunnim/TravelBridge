<template>
  <q-page class="page">
    <q-dialog v-model="alert">
      <q-card>
        <q-card-section>
          <div class="text-subtitle1 text-center">선택한 테마가 없습니다!</div>
          <div class="text-h6">로그인하시거나 관심 테마를 직접 추가해보세요!</div>
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
          <div class="text-h6">지금 관심 테마를 선택하고 여행지를 추천받아 보세요!</div>
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

    <div class="row justify-center items-center q-my-xl q-py-xl bg-image">
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
        >#{{ item.name }}</q-btn>
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
        >#{{ item.name }}</q-btn>
      </div>
    </div>

    <div class="row justify-center q-mx-xl q-px-xl">
      <div
        class="col-lg-3 col-md-6 col-xs-12"
        v-for="i in hp_list_length > 4 * hpPageCnt
          ? 4 * hpPageCnt
          : hp_list_length"
        :key="i"
      >
        <HotPlaceCard
          class="q-ma-lg"
          :hp_img="hp_list[i - 1].hp_img"
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
          :hp_no="hp_list[i - 1].hp_no"
        ></HotPlaceCard>
      </div>
      <q-btn class="q-my-lg full-width" flat v-if="hpBtnCheck" @click="loadMoreHpBtn()">핫플레이스 더보기</q-btn>
    </div>

    <div class="row justify-center q-mx-xl q-px-xl">
      <div
        class="col-xs-12 col-md-6 col-lg-3"
        v-for="j in fval_list_length > 4 * fvalPageCnt
          ? 4 * fvalPageCnt
          : fval_list_length"
        :key="j"
      >
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
      <q-btn
        class="q-my-lg full-width"
        flat
        v-if="fvalBtnCheck"
        @click="loadMoreFestivalBtn()"
      >페스티벌 더보기</q-btn>
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
      tempUser: {}, // 비로그인 유저 - 임시적인 검색 기능만 제공한다.
      alert: false, // dialog
      choiceAlert: false,
      loggedIn: false,
      notSelected: false,
      // choice 관련
      currentChoices: "",
      thema: {
        food: { state: false, name: "맛집" },
        family: { state: false, name: "가족" },
        date: { state: false, name: "데이트" },
        shopping: { state: false, name: "쇼핑" },
        culture: { state: false, name: "문화" },
        indoor: { state: false, name: "실내" },
        healing: { state: false, name: "힐링" },
        tradition: { state: false, name: "전통" }
      },
      hpPageCnt: 1,
      fvalPageCnt: 1,
      hpBtnCheck: true,
      fvalBtnCnt: 10,
      fvalBtnCheck: true,
      hpBtnCnt: 10
    };
  },
  computed: {
    ...mapState({
      user: state => state.user.user,
      hp_list_length: state => state.hotplace.hp_list_length, // vuex 에서 데려옴
      fval_list_length: state => state.festival.fval_list_length,
      hp_list: state => state.hotplace.hps,
      fval_list: state => state.festival.fvals,
      hpByTheme: state => state.hotplace.hpByTheme
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
      console.log("실행");
      this.currentChoices = this.user.mem_interest;
      console.log("check Past Interest ==> ", this.currentChoices);
      if (this.currentChoices !== undefined) {
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
      // this.$store.commit("hotplace/clearHPs");
      // this.$store.commit("festival/clearFvals");
      // 토글할 때 마다 getAllPicks 도 실행한다.
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      console.log("====== TravelPick - onToggle =======", this.currentChoices);
      this.getAllPicks();
    },
    getAllPicks() {
      // 토글해서 getAllpicks
      console.log("====== getAllPicks 실행 ========== ", this.currentChoices);
      if (this.currentChoices !== undefined) {
        this.$store.dispatch("hotplace/searchMoreHotPlaceByTheme", {
          btnCnt: this.hpBtnCnt,
          word: this.currentChoices
        });
        this.$store.dispatch("festival/searchMoreFestivalByTheme", {
          btnCnt: this.fvalBtnCnt,
          word: this.currentChoices
        });
      }
    },
    loadMoreHpBtn() {
      this.hpPageCnt += 1;
      if (this.hp_list_length < 4 * this.hpPageCnt) this.hpBtnCheck = false;
    },
    loadMoreFestivalBtn() {
      this.fvalPageCnt += 1;
      if (this.fval_list_length < 4 * this.fvalPageCnt)
        this.fvalBtnCheck = false;
    }
  },
  created() {
    console.log("========= Main2Pick.vue mounted =======");
    console.log("user: ", this.user);
    console.log("interest: ", this.user.mem_interest);
    this.checkIfLoggedIn();
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
</style>