<template>
  <div>
    <div>
      <q-img :src="getImgUrl('cutbg.jpg')" style="width: 100%">
        <div class="absolute-center text-center" style="width: 100%">
          <p class="text-h3 text-center">
            <q-icon name="question_answer" />FAQ
          </p>
          <p class="text-h5 text-center">
            고객님께서 자주 문의하시는 질문과 답변을 모았습니다.
          </p>
        </div>
      </q-img>
    </div>
    <div class="info">
      <p class="text-h5 text-weight-medium">자주 묻는 질문 BEST</p>
      <q-list
        v-for="(faqList, index) in FaqList"
        :key="index"
        bordered
        class="q-my-lg"
      >
        <q-expansion-item
          switch-toggle-side
          expand-separator
          :label="faqList.label"
        >
          <q-card>
            <q-card-section
              ><i class="fas fa-arrow-circle-right"></i
              >{{ faqList.body }}</q-card-section
            >
          </q-card>
        </q-expansion-item>
        <q-separator />
      </q-list>
    </div>
    <div class="info">
      <p class="text-h5 text-weight-medium">원하는 답변을 찾지 못하셨나요?</p>
      <div class="row" style="display: flex; justify: center">
        <q-btn to="/qna" color="purple" class="col-4">1:1 문의하러 가기</q-btn>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
// import

export default {
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    ...mapActions(["getFaqList"])
  },
  data() {
    return {
      FaqList: []
    };
  },
  mounted() {
    this.getFaqList();
    this.FaqList = $store.state.FaqList;
  }
};
</script>

<style>
.info {
  margin: 5% 25%;
}
</style>
