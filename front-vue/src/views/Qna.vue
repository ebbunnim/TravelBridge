<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold absolute-center">1:1 문의</div>
      </div>
    </q-img>
    <!-- {{ qnaList }} -->
    <div>
      <q-tabs
        dense
        v-model="tab"
        class="q-ma-lg"
        active-color="primary"
        indicator-color="primary"
        narrow-indicator
        align="center"
      >
        <q-tab name="qna" label="1:1 문의하기" />
        <q-tab name="past" label="문의내역" />
      </q-tabs>

      <q-tab-panels v-model="tab" animated>
        <q-tab-panel dark name="qna">
          <div class="row justify-center">
            <q-form class="q-ma-xl col-xs-10 col-lg-8">
              <q-input v-model="newQna.qna_title" type="text" label="제목" />
              <q-input v-model="newQna.qna_content" type="textarea" label="내용" />
            </q-form>
            <q-btn
              @click="postQna(newQna)"
              align="center"
              outline
              color="grey"
              class="q-ma-xl col-xs-10 col-lg-8"
            >1:1 문의하기</q-btn>
          </div>
        </q-tab-panel>

        <q-tab-panel name="past">
          <div v-if="user.mem_no !== undefined">
            <div v-for="(q, index) in qnaList" :key="index">
              <div class="row justify-center">
                <div style="width: 60%;">
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
          </div>
          <div v-else>
            <div class="row justify-center q-py-xl q-my-xl">로그인한 회원만 문의 내역을 확인할 수 있습니다.</div>
          </div>
        </q-tab-panel>
      </q-tab-panels>
    </div>
    <q-dialog v-model="alert">
      <q-card>
        <q-card-section class="q-pa-lg">1:1 문의는 로그인한 회원만 남길 수 있습니다.</q-card-section>
        <q-card-actions align="center">
          <q-btn flat to="login" label="로그인" color="primary" v-close-popup />
          <q-btn flat label="닫기" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
    <q-dialog v-model="submitted">
      <q-card>
        <q-card-section class="q-pa-lg">1:1 문의가 등록되었습니다.</q-card-section>
        <q-card-actions align="center">
          <q-btn flat to="/" label="홈으로" color="primary" v-close-popup @click="submitted = false" />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      tab: "qna", // tab : qna 와 past 중 선택
      submitted: false,
      alert: false,
      newQna: {
        mem_no: this.$store.state.user.user.mem_no,
        qna_answer: null,
        qna_category: null,
        qna_content: null,
        qna_title: null
      }
    };
  },
  computed: {
    ...mapState({
      user: state => state.user.user,
      qnaList: state => state.qna.qnaList
    })
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    getUserQnas() {
      this.$store.dispatch("qna/getUserQnas", this.user.mem_no);
    },
    postQna(qna) {
      if (this.user.mem_no === undefined) {
        console.log("로그인 필요");
        this.alert = true;
      } else {
        this.$store.dispatch("qna/insertQna", qna);
        this.newQna = {
          mem_no: this.$store.state.user.user.mem_no,
          qna_answer: null,
          qna_category: null,
          qna_content: null,
          qna_title: null
        };
        this.submitted = true;
      }
    }
  },
  created() {
    console.log("====== QNA PAGE CREATED ======");
    console.log("앗", this.user.mem_no);
    this.getUserQnas();
  }
};
</script>

<style></style>
