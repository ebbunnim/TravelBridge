<template>
  <div>
    <div>
      <q-img :src="getImgUrl('cutbg.jpg')" style="width: 100%">
        <div class="absolute-center text-center" style="width: 100%">
          <p class="text-h3 text-center">
            <q-icon name="contact_support" />1:1 문의하기
          </p>
          <p class="text-h5 text-center">
            빠르고 신속하게 답변드리겠습니다.
          </p>
        </div>
      </q-img>
    </div>

    <div class="info">
      <p class="text-h5 text-weight-medium">자주 묻는 질문 BEST</p>
      <q-form class="q-my-lg">
        <q-input v-model="QuaTitle" type="text" label="제목" />
        <q-input v-model="QuaText" type="textarea" label="내용" />
      </q-form>

      <div class="row q-mx-auto" style="display: flex;">
        <q-btn outline to="/qna" color="primary" class="col-4"
          >1:1 문의하기</q-btn
        >
      </div>
    </div>

    <q-list v-for="(qnaList, index) in QnaList" :key="index" bordered>
      <q-expansion-item
        expand-separator
        :label="qnaList.label"
        :caption="qnaList.caption"
      >
        <q-card dark bordered class="bg-grey-9 my-card">
          <q-card-section>{{ qnaList.body }}</q-card-section>
          <q-separator dark inset />
          <q-card-section>
            <div class="text-h6">답변</div>
            <div class="text-subtitle2">{{ qnaList.answer }}</div>
          </q-card-section>
        </q-card>
      </q-expansion-item>
      <q-separator />
    </q-list>
  </div>
</template>

<script>
export default {
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    }
  },
  data() {
    return {
      tab: "mails",

      QuaTitle: "",
      QuaText: "",
      QnaList: [
        // 나의
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid.",
          answer: "잘 대답했지요"
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid.",
          answer: "잘 대답했지요"
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid.",
          answer: "잘 대답했지요"
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid.",
          answer: "잘 대답했지요"
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid.",
          answer: "잘 대답했지요"
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid.",
          answer: "잘 대답했지요"
        }
      ]
    };
  }
};
</script>

<style>
.info {
  margin: 5% 25%;
}
</style>
