<template>
  <div>
    <div>
      <q-img :src="getImgUrl('cutbg.jpg')" style="width: 100%">
        <div class="absolute-center text-center" style="width: 100%">
          <p class="text-h3 text-center">
            <q-icon name="contact_support" />1:1 문의하기
          </p>
          <p class="text-h5 text-center">빠르고 신속하게 답변드리겠습니다.</p>
        </div>
      </q-img>
    </div>

    <div class="info" v-if="!submitted">
      <div class="q-mb-lg">
        <p class="text-h5 text-weight-medium">1:1 문의하기</p>
        <q-form class="q-my-lg">
          <q-input v-model="newQna.qna_title" type="text" label="제목" />
          <q-input v-model="newQna.qna_content" type="textarea" label="내용" />
        </q-form>

        <div class="row justify-center">
          <q-btn
            @click="postQna()"
            align="center"
            outline
            color="primary"
            class="col-4"
            >1:1 문의하기</q-btn
          >
        </div>

        <!-- 관리자에게만 보이게 처리 -->
        <q-form class="q-my-lg">
          <q-input
            v-model="newQna.qna_answer"
            type="textarea"
            label="관리자 답변"
          />
          <div class="row justify-center">
            <q-btn
              @click="postQna()"
              align="center"
              outline
              color="primary"
              class="col-4"
              >1:1 문의하기</q-btn
            >
          </div>
        </q-form>
      </div>

      <div v-for="(q, index) in qnaList" :key="index">
        <div class="q-pa-none q-ma-none row justify-center">
          <div style="width: 100%;">
            <q-chat-message
              name="질문"
              avatar="https://cdn.quasar.dev/img/avatar3.jpg"
              :text="[q.qna_content]"
              :stamp="q.qna_regtime"
              sent
              size="10"
              class="q-pl-lg"
            />
            <q-chat-message
              class="q-pr-lg"
              name="관리자 답변"
              avatar="https://cdn.quasar.dev/img/avatar5.jpg"
              :text="[q.qna_answer]"
              size="10"
              text-color="white"
              bg-color="brown-3"
            />
          </div>
        </div>
      </div>
    </div>
    <div class="info" v-else>
      <h4>You submitted successfully!</h4>
      <q-btn @click="clearQna()" to="/" class="col-4" color="primary" outline
        >메인화면으로</q-btn
      >
    </div>
  </div>
</template>

<script>
import QnaService from "@/services/QnaService";

export default {
  data() {
    return {
      newQna: {
        mem_no: 1, // user 받아오기
        qna_title: "",
        qna_content: "",
        qna_answer: ""
      },
      qnaList: [
        {
          mem_no: "트래블 픽",
          qna_category: "메인1번카테",
          qna_title: "궁금합니다. 질문",
          qna_content:
            "두손을 눈이 싹이 가치를 얼음이 교향악이다. 끓는 석가는 기관과 철환하였는가? 힘차게 얼마나 생명을 길지 싹이 교향악이다. 가슴이 구할 가는 같지 쓸쓸한 피에 할지라도 이것이다. 되는 긴지라 소리다.이것은 내려온 시들어 철환하였는가? 있는 있는 아니한 이것이다. 만천하의 용감하고 예가 우리 인생을 원질이 것이다. 우리 끓는 때에, 황금시대의 있으랴? 크고 천고에 꾸며 보이는 사랑의 관현악이며, 그들은 사막이다.",
          qna_answer:
            "별 나는 동경과 언덕 보고, 내린 있습니다. 가득 나는 추억과 이름과, 까닭입니다. 이웃 시인의 마디씩 너무나 위에 아직 우는 하나에 별을 봅니다. 이국 별 밤을 보고, 쓸쓸함과 많은 까닭입니다. 이네들은 경, 다하지 잠, 있습니다. 못 딴은 계집애들의 소학교 버리었습니다. 가슴속에 하나에 못 언덕 이국 별 까닭입니다. 나는 다하지 아이들의 겨울이 봄이 봅니다. 이제 것은 애기 쓸쓸함과 봅니다.",
          qna_regtime: "200205"
        }
      ],
      tab: "mails",
      submitted: false
    };
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    postQna() {
      console.log("호출");
      QnaService.insert(this.newQna);
    },
    // api 와는 무관
    clearQna() {
      this.submitted = false;
      this.qna = {};
    },
    getQna() {
      QnaService.searchAll().then(response => {
        this.qnaList = response.data.data;
      });
    },
    answerQna() {
      // 현재 화면에 보여지고 있는 qna 를 qna List 에서 받아온 후... 저장하고
      // 그것의 qna_answer 필드에 답변을 넣는다. 
      QnaService.answerTheQuestion()
    }
  },
  created() {
    this.getQna();
  }
  // updated() {
  //   this.getQna();
  // }
};
</script>

<style>
.info {
  margin: 5% 25%;
}
</style>
