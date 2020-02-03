<template>
  <div class="info">
    <h2>Q&A</h2>
    <q-expansion-item expand-separator icon="contact_support" label="질문하기">
      <q-input v-model="QuaTitle" type="text" label="제목" />

      <q-input v-model="QuaText" type="textarea" label="내용" />
      <div align="right">
        <q-btn color="primary" icon="contact_support" label="질문 하기" />
      </div>
    </q-expansion-item>

    <q-list v-for="(qnaList,index) in QnaList" :key="index" bordered>
      <q-expansion-item expand-separator :label="qnaList.label" :caption="qnaList.caption">
        <q-card dark bordered class="bg-grey-9 my-card">
          <q-card-section>{{qnaList.body}}</q-card-section>
          <q-separator dark inset />
          <q-card-section>
            <div class="text-h6">답변</div>
            <div class="text-subtitle2">{{qnaList.answer}}</div>
          </q-card-section>
        </q-card>
      </q-expansion-item>
      <q-separator />
    </q-list>
  </div>
</template>

<script>
export default {
  data() {
    return {
      QuaTitle: "",
      QuaText: "",
      QnaList: [
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
  margin: 0% 25% 0% 25%;
}
</style>