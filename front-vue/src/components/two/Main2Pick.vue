<template>
  <div>
    <h1>픽(테마)</h1>

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

    <div style="display: inline" v-for="(item, idx) in thema" :key="idx">
      <q-btn
        color="grey"
        class="q-ma-sm"
        size="xl"
        v-if="item.state"
        @click="
          item.state = !item.state;
          onToggle();
        "
        >{{ item.name }}</q-btn
      >
      <q-btn
        color="grey"
        class="q-ma-sm"
        size="xl"
        v-if="!item.state"
        outline
        @click="
          item.state = !item.state;
          onToggle();
        "
        >{{ item.name }}</q-btn
      >
    </div>
    <div>
      <h1>이건 페스티발</h1>
      {{ fval_list }}
      <h1>이건 핫플</h1>
      {{ hp_list }}
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      tempUser: {}, // 비로그인 유저 - 임시적인 검색 기능만 제공한다.
      alert: false, // dialog
      choiceAlert: false,
      loggedIn: false,
      notSelected: false,
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
      fvalBtnCnt: 1,
      hpBtnCnt: 1
    };
  },
  computed: mapState({
    user: state => state.user.user, // 현재 접속자
    hp_list: state => state.hotplace.hps,
    fval_list: state => state.festival.fvals
  }),
  methods: {
    checkIfLoggedIn() {
      if (this.user.mem_interest === undefined) {
        this.alert = true;
      } else if (this.user.mem_interest === "") {
        this.choiceAlert = true;
      } else {
        this.checkPastInterest()
      }
    },
    useWithoutLogin() {
      // alert 에서 끄는 순간 바로 실행
      // 비회원일 때
      this.tempUser = {
        mem_id: "비회원",
        mem_interest: ""
      };
      this.user = this.tempUser;
      console.log("비회원유저", this.user);
    },

    checkPastInterest() {
      this.currentChoices = this.user.mem_interest;
      // console.log('회원일 때', this.currentChoices)
      console.log("check Past Interest ==> ", this.currentChoices);
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
    },
    onToggle() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      console.log("###### 1. onToggle 눌림 ######", this.currentChoices);
      this.getAllPicks();
    },
    getAllPicks() {
      if (this.currentChoices !== "") {
        this.$store.dispatch("hotplace/searchMoreHotPlaceByTheme", {
          btnCnt: this.fvalBtnCnt,
          word: this.currentChoices
        });
        this.$store.dispatch("festival/searchMoreFestivalByTheme", {
          btnCnt: this.hpBtnCnt,
          word: this.currentChoices
        });
      } else if (this.currentChoices === "") {
        this.$store.commit("hotplace/clearHPs");
        this.$store.commit("festival/clearFvals");
      }
    }
  },
  mounted() {
    console.log("========= mounted =======");
    console.log(this.user);
    console.log(this.user.mem_interest);
    this.checkIfLoggedIn();
  }
};
</script>

<style></style>
