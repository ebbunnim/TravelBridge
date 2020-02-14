<template>
  <div>
    <h1>픽(테마)</h1>
    <div style="display: inline" v-for="(item, idx) in thema" :key="idx">
      <q-btn
        color="grey"
        class="q-ma-sm"
        size="xl"
        v-if="item.state"
        @click="
          item.state = !item.state;
          onSubmit();
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
          onSubmit();
        "
        >{{ item.name }}</q-btn
      >
    </div>
    <div>
      {{ hp_list }}
      {{ fval_list }}
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      user: null,
      currentChoices: "",
      thema: {
        food: { state: false, name: "#맛집 " },
        family: { state: false, name: "#가족 " },
        date: { state: false, name: "#데이트 " },
        shopping: { state: false, name: "#쇼핑 " },
        culture: { state: false, name: "#문화 " },
        indoor: { state: false, name: "#실내 " },
        healing: { state: false, name: "#힐링 " },
        tradition: { state: false, name: "#전통 " }
      },
      themaKor: {
        food: "#맛집 ",
        family: "#가족 ",
        date: "#데이트 ",
        shopping: "#쇼핑 ",
        culture: "#문화 ",
        indoor: "#실내 ",
        healing: "#힐링 ",
        tradition: "#전통 "
      }
    };
  },
  computed: mapState({
    hp_list: state => state.hotplace.hps,
    fval_list: state => state.festival.fvals
  }),
  methods: {
    setPastInterest() {
      if (this.user !== null) {
        const interest = this.user.mem_interest;
        let temp = interest.split(" ");
        for (let key in temp) {
          const themaKey = temp[key] + " ";
          // thema 를 돌면서 name 이 themaKey 와 일치하는 것의 state 를 true 로 고친다.
          for (let the in this.thema) {
            if (this.themaKor[the] === themaKey) {
              this.thema[the].state = true;
            }
          }
        }
      }
    },
    onSubmit() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += this.themaKor[key];
        }
      }
      console.log("온섭밋 실행", this.currentChoices);
      this.getAllPicks();
    },
    getAllPicks() {
      console.log("받니?", this.currentChoices)
      const batni = this.currentChoices.replace("#","")
      console.log("미친건가",batni)
      this.$store.dispatch("hotplace/searchMoreHotPlaceByTheme", {
        btnCnt: 1,
        word: batni
      });
      // this.$store.dispatch("festival/searchMoreFestivalByTheme", {
      //   btnCnt: this.hpBtnCnt,
      //   word: keyword
      // });
    }
  },
  created() {
    this.user = this.$store.state.user.user;
    console.log("현재 user:", this.user);
    // this.setPastInterest();
  }
};
</script>

<style></style>
