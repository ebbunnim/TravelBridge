<template>
  <div class="q-pt-md">
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%"></div>
    </q-img>
    <div class="row justify-center text-left q-ma-xl q-px-md">
      <p class="col-12 text-h4 text-weight-medium text-center q-pb-lg">
        자주 묻는 질문 BEST
      </p>
      <q-list
        v-for="faqList in FaqList"
        :key="faqList.faq_no"
        bordered
        class="col-md-7 col-xs-12"
      >
        <q-expansion-item
          switch-toggle-side
          expand-separator
          :label="faqList.faq_question"
          class="text-weight-bold"
        >
          <q-card>
            <q-card-section class="text-weight-regular">{{
              faqList.faq_answer
            }}</q-card-section>
          </q-card>
        </q-expansion-item>
      </q-list>
    </div>
    <div class="q-ma-lg text-center">
      <p class="text-h5 text-weight-medium">원하는 답변을 찾지 못하셨나요?</p>
      <div class="row justify-center" style="display: flex">
        <q-btn no-wrap to="/qna" color="grey" class="col-4" outline
          >1:1 문의하러 가기</q-btn
        >
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  computed: mapState({
    FaqList: state => state.faq.faqList
  }),
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    ...mapActions({
      getAllFaqs: "faq/getAllFaqs"
    })
  },
  created() {
    this.getAllFaqs();
  }
};
</script>

<style></style>
