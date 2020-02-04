<template>
  <div class="back">
    <br />
    <h2>Team Violet</h2>

    <h2>Member</h2>
    <q-layout mt-5 class="row justify-around">
      <div class="col-5" style="margin-bottom:2%" v-for="(dev,index) in developer" :key="index">
        <q-card-section horizontal>
          <q-img class="col-6" :src="getImgUrl(dev.imgsrc)"></q-img>

          <q-card-section class="col-6">
            <div class="text-h6">{{dev.name}}</div>
            <div class="text-subtitle2" style="margin-bottom:5%">{{dev.job}}</div>
            <q-separator />
            <div style="margin-top:5%; word-break:break-all;">{{dev.content}}</div>
          </q-card-section>
        </q-card-section>
      </div>
    </q-layout>
  </div>
</template>

<script>
export default {
  data() {
    return {
      developer: [
        {
          name: "jtree",
          job: "frontend",
          content:
            "helloddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssss",
          imgsrc: "profile/김준목.jpg"
        },
        {
          name: "honion",
          job: "backend",
          content: "hello",
          imgsrc: "profile/정구헌.jpg"
        },
        {
          name: "ebbeni",
          job: "backend",
          content: "hello",
          imgsrc: "profile/신지영.jpeg"
        },
        {
          name: "susuminmin",
          job: "팀장, frontend",
          content: "hello",
          imgsrc: "profile/김수민.jpg"
        }
      ]
    };
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    }
  }
};
</script>

<style  scoped>
.back {
  /* background-image: url(../assets/teambg.jpg); */
  background-size: 100%;
}
</style>