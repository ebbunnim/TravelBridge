<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold absolute-center">자주 묻는 질문</div>
      </div>
    </q-img>

    <div class="row justify-center text-left q-ma-xl q-px-md">
      <q-list v-for="faqList in FaqList" :key="faqList.faq_no" bordered class="col-md-7 col-xs-12">
        <q-expansion-item
          switch-toggle-side
          expand-separator
          :label="faqList.faq_question"
          class="text-weight-bold"
        >
          <q-card>
            <q-card-section class="text-weight-regular">
              {{
              faqList.faq_answer
              }}
            </q-card-section>
          </q-card>
        </q-expansion-item>
      </q-list>
      <!-- <div class="col-12"></div> -->
      <div class="col-12 text-h5 text-center text-weight-medium q-pt-lg q-my-xl">원하는 답변을 찾지 못하셨나요?</div>

      <q-btn no-wrap to="/qna" color="grey" class="col-md-7 col-xs-12" outline>1:1 문의하러 가기</q-btn>
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
