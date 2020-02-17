<template>
  <div class="row justify-center">
    <div class="q-pt-md col-12">
      <q-img :src="getImgUrl('cutbg.jpg')">
        <div style="width: 100%; height: 100%"></div>
      </q-img>
    </div>

    <div v-if="!submitted" class="q-ma-xl col-md-7 col-sm-10 col-xs-12">
      <q-tabs
        v-model="tab"
        dense
        class="q-ma-lg"
        active-color="primary"
        indicator-color="primary"
        align="justify"
        narrow-indicator
      >
        <q-tab name="qna" label="1:1 문의하기" />
        <q-tab name="past" label="문의내역" />
      </q-tabs>

      <q-tab-panels v-model="tab" animated>
        <q-tab-panel dark name="qna">
          <q-form class="q-ma-lg">
            <q-input v-model="newQna.qna_title" type="text" label="제목" />
            <q-input
              v-model="newQna.qna_content"
              type="textarea"
              label="내용"
            />
          </q-form>

          <div class="row justify-center">
            <q-btn
              no-wrap
              @click="postQna(newQna)"
              align="center"
              outline
              color="grey"
              class="col-4"
              >1:1 문의하기</q-btn
            >
          </div>

          <q-form class="q-ma-lg" v-if="grant === 1">
            <q-input
              v-model="newQna.qna_answer"
              type="textarea"
              label="관리자 답변"
            />
          </q-form>

          <div class="row justify-center" v-if="grant === 1">
            <q-btn
              no-wrap
              @click="answerQna()"
              align="center"
              outline
              color="grey"
              class="col-4"
              >관리자 답변</q-btn
            >
          </div>
        </q-tab-panel>

        <q-tab-panel name="past">
          <div v-for="(q, index) in QnaList" :key="index">
            <div class="q-pa-none q-ma-none row justify-center">
              <div style="width: 100%;">
                <q-chat-message
                  :name="q.qna_regtime"
                  :text="[q.qna_content]"
                  sent
                  size="10"
                  class="q-pl-lg"
                />
                <q-chat-message
                  class="q-pr-lg"
                  name="TravelBridge"
                  :text="[
                    (q.qna_answer === null) | (q.qna_answer === '')
                      ? '답변 대기 중'
                      : q.qna_answer
                  ]"
                  size="10"
                  text-color="white"
                  bg-color="brown-3"
                />
              </div>
            </div>
          </div>
        </q-tab-panel>
      </q-tab-panels>
    </div>
    <!-- <div v-else>
      <h4>1:1 문의가 등록되었습니다.</h4>
      <q-btn @click="clearQna()" to="/" class="col-4" color="primary" outline>메인화면으로</q-btn>
    </div>-->
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  data() {
    return {
      tab: "qna", // tab : qna 와 past 중 선택
      submitted: false,
      newQna: {
        mem_no: this.$store.state.user.user.mem_no,
        qna_answer: null,
        qna_category: null,
        qna_content: null,
        qna_title: null
      },
      grant: this.$store.state.user.user.mem_grant
    };
  },
  computed: {
    ...mapState({
      QnaList: state => state.qna.QnaList
    })
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    ...mapActions({
      getAllQnas: "qna/getAllQnas"
    }),
    postQna() {
      console.log("vue에서 확인", this.newQna);
      this.$store.dispatch("qna/postQna", this.newQna);
    }
  },
  created() {
    this.getAllQnas();
  }
};
</script>

<style></style>
