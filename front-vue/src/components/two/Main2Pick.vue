<template>
  <div>
    <h1>픽</h1>
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
    <!-- 보이는 부분 -->
    <div>
      {{ currentChoices }}
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentChoices: "",
      thema: {
        // 초기 상태를 회원 정보에 따라서 created 할 때 저장해 노해을 것
        // 그래서 pick 페이지에 들어오는 순간 / 이미 선택한 칸은 눌려있는 상태이다.
        food: { state: false, name: "#맛집 " },
        family: { state: false, name: "#가족 " },
        date: { state: false, name: "#데이트 " },
        shopping: { state: false, name: "#쇼핑 " },
        culture: { state: false, name: "#문화 " },
        indoor: { state: false, name: "#실내 " },
        healing: { state: false, name: "#힐링 " },
        tradition: { state: false, name: "#전통 " }
      },
      //#맛집 #가족 #데이트 #쇼핑 #문화 #실내 #힐링 #전통 split할것임
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
  methods: {
    onSubmit() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += this.themaKor[key];
        }
      }
      console.log(this.currentChoices);
    }
  }
};
</script>

<style></style>
