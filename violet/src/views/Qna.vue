<template>
  <div class="info">
    <h2>Q&A`</h2>
    <q-list v-for="(qnaList,index) in QnaList" :key="index" bordered>
      <q-expansion-item expand-separator :label="qnaList.label" :caption="qnaList.caption">
        <q-card>
          <q-card-section>{{qnaList.body}}</q-card-section>
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
      QnaList: [
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid."
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid."
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid."
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid."
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid."
        },
        {
          caption: "Jone Doe",
          label: "Account Settings",
          body:
            "  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, eius reprehenderit eos corrupti commodi magni quaerat ex numquam, dolorum officiis modi facere maiores architecto suscipit iste eveniet doloribus ullam aliquid."
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