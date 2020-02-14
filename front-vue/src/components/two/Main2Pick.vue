<template>
  <div>
    <h1>픽(테마)</h1>

    <q-dialog v-model="alert">
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
            @click="useWithoutLogin()"
            v-close-popup
          />
          <q-btn
            flat
            label="로그인 후 이용하기"
            color="primary"
            to="/login"
          ></q-btn>
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
      <div v-if="fval_list === '이 페이지에는 게시글이 존재하지 않습니다'">
        암모것도 없음 ㅎㅠㅠ
      </div>
      <h1>이건 핫플</h1>
      {{ fval_list }}
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
      if (this.user.length === undefined) {
        this.alert = true; // 로그인 또는 테마 선택 유도
        // 지금 바로 선택하기 하면 userWithoutLogin 함수 실행 
      }
    },
    useWithoutLogin() {
      // 비회원일 때
      this.tempUser = {
        mem_id: "비회원",
        mem_interest: ""
      };
      console.log("비회원유저", this.tempUser);
    },
    checkPastInterest() {
      // 회원일 때
      this.currentChoices = this.user.mem_interest;
    },
    onToggle() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      console.log("==========onToggle 선택됨:======== ", this.currentChoices);
      this.getAllPicks();
    },
    getAllPicks() {
      console.log("getAllPicks의 parameter 체크: ", this.currentChoices);
      if (this.currentChoices !== "") {
        this.$store.dispatch("hotplace/searchMoreHotPlaceByTheme", {
          btnCnt: this.fvalBtnCnt,
          word: this.currentChoices
        });
        this.$store.dispatch("festival/searchMoreFestivalByTheme", {
          btnCnt: this.hpBtnCnt,
          word: this.currentChoices
        });
      }
    }
  },
  mounted() {
    console.log(this.user);
    this.checkIfLoggedIn();
    this.checkPastInterest();
  }
};
</script>

<style></style>
