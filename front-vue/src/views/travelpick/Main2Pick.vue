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

    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img style="height: 300px" :src="getImgUrl('cutbg.jpg')" class="q-mb-xl">
      <div
        class="row justify-center items-center q-mb-xl q-pb-xl"
        style="width: 100%; height: 100%"
      >
        <div class="col-12 text-h4 text-center q-mt-xl text-white text-weight-bold">테마별 여행지 추천</div>
        <div v-for="(item, idx) in thema" :key="idx">
          <q-btn
            push
            color="grey"
            class="q-mx-sm"
            size="lg"
            rounded
            v-if="item.state"
            @click="
            item.state = !item.state;
            onToggle();
          "
          >#{{ item.name }}</q-btn>
          <q-btn
            push
            color="white"
            class="q-mx-sm"
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
    </q-img>

    <!-- 검색결과 -->
    <div class="row justify-center q-mx-xl q-px-xl" v-if="hp_list_length > 0">
      <div class="col-12 text-h5 text-center">핫플레이스 추천</div>
      <q-btn
        no-ripple
        flat
        no-wrap
        rounded
        class="text-center col-1"
        color="info"
        v-show="hpBtnCheck"
        label="더보기"
        unelevated
        @click="loadMoreHotplace()"
      />
    </div>
    <div v-else-if="hp_list_length === 0">
      <div class="text-h6 text-center col-8">핫플레이스 추천 결과가 없습니다.</div>
    </div>
    <div class="row justify-center">
      <HotPlaceCard
        v-for="i in hp_list_length"
        :key="i"
        class="q-ma-md col-lg-2 col-md-4 col-xs-10"
        :hp_img="hp_list[i - 1].hp_img"
        :hp_name="hp_list[i - 1].hp_name"
        :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
        :hp_tag="hp_list[i - 1].hp_tag"
        :hp_no="hp_list[i - 1].hp_no"
      ></HotPlaceCard>
    </div>

    <div class="q-my-xl q-py-lg">
      <div class="row justify-center q-mx-xl q-px-xl q-mt-xl" v-if="fval_list_length > 0">
        <div class="col-12 text-h5 text-center">페스티벌 추천</div>
        <q-btn
          no-ripple
          flat
          rounded
          no-wrap
          class="text-center col-1"
          color="info"
          v-show="fvalBtnCheck"
          label="더보기"
          @click="loadMoreFestival()"
        />
      </div>
      <div v-else-if="fval_list_length === 0">
        <div class="text-h6 text-center col-8">페스티벌 추천 결과가 없습니다.</div>
      </div>
      <div class="row justify-center">
        <FestivalCard
          v-for="j in fval_list_length"
          :key="j"
          class="q-ma-md col-lg-2 col-md-4 col-xs-10"
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
  </q-page>
</template>

<script>
import { mapState } from "vuex";
import HotPlaceCard from "@/views/travelpick/HotPlaceCard.vue";
import FestivalCard from "@/views/travelpick/FestivalCard.vue";
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
      hpBtnCheck: true,
      hpBtnCnt: 1,
      fvalBtnCheck: true,
      fvalBtnCnt: 1
    };
  },
  computed: {
    ...mapState({
      user: state => state.user.user,
      hp_list_length: state => state.hotplace.hp_list_length, // vuex 에서 데려옴
      fval_list_length: state => state.festival.fval_list_length,
      hp_list: state => state.hotplace.hps,
      fval_list: state => state.festival.fvals
    })
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    // loadPreviousFestival() {
    //   this.fvalBtnCnt--;
    //   this.getAllPicks();
    // },
    // loadPreviousHotplace() {
    //   this.hpBtnCnt--;
    //   this.getAllPicks();
    // },
    loadMoreFestival() {
      this.fvalBtnCnt++;
      this.getAllPicks();
    },
    loadMoreHotplace() {
      this.hpBtnCnt++;
      this.getAllPicks();
    },
    checkIfLoggedIn() {
      if (this.user.mem_interest === undefined) {
        this.alert = true; // 아예 미로그인 시
      } else if (this.user.mem_interest === "") {
        this.choiceAlert = true; // 로그인은 했으나 초이스 없을 경우
      } else {
        this.checkPastInterest(); // this.user.mem_interest 를 체크한다.
      }
    },
    useWithoutLogin() {
      // alert 에서 끄는 순간 바로 실행, 비회원일 때
      this.tempUser = {
        mem_id: "비회원",
        mem_interest: ""
      };
      this.user = this.tempUser;
      
    },
    checkPastInterest() {
      // 기존에 회원가입 혹은 MyPage 에서 설정한 THEMA state 를 true 로 설정 역할
      this.currentChoices = this.user.mem_interest;
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
      // this.currentChoices = "";
      this.getAllPicks();
    },
    onToggle() {
      // state 가 true 인 값들만 String 으로 합친 후 this.currentchoices 에 저장한다.
      // this.$store.commit("hotplace/clearHPs");
      // this.$store.commit("festival/clearFvals");
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      if (this.currentChoices === "") {
        // react to route changes...
        this.$store.commit("hotplace/clearHPs");
        this.$store.commit("festival/clearFvals");
      } else {
        this.getAllPicks();
      }
    },
    getAllPicks() {
      // 마운티드 직후 혹은 추가 토글해서 getAllpicks 실행
      
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
    }
  },
  // LifeCycle Hooks
  created() {
    this.checkIfLoggedIn(); // 로그인과 선택을 다 한 유저라면 이어서 checkPastineterst --> getAllPicks도 실행됨
  }
};
</script>

<style>
.festival-bg {
  background-color: #f9f9f9;
}
</style>
