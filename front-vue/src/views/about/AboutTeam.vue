<template>
  <div class="back">
    <br />
    <h2>Team Violet</h2>

    <h2>Member</h2>
    <q-layout mt-5 class="row justify-around">
      <div
        class="col-5"
        style="margin-bottom:2%"
        v-for="(dev, index) in developer"
        :key="index"
      >
        <q-card-section horizontal>
          <q-img class="col-6" :src="getImgUrl(dev.imgsrc)"></q-img>

          <q-card-section class="col-6">
            <div class="text-h6">{{ dev.name }}</div>
            <div class="text-subtitle2" style="margin-bottom:5%">
              {{ dev.job }}
            </div>
            <q-separator />
            <div style="margin-top:5%; word-break:break-all;">
              {{ dev.content }}
            </div>
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
            "어서오세요. 프론트 개발자 김준목 입니다. 쓰러지지 않고 같이 올수 있어서 너무 좋았습니다. ",
          imgsrc: "profile/김준목.jpg"
        },
        {
          name: "honion",
          job: "backend",
          content:
            "안녕하세요, 백엔드파트를 맡은 정구헌입니다.좋은 팀원들과 만나 재미있게 코딩했습니다.많은 도움이 된 프로젝트였습니다. 감사합니다",
          imgsrc: "profile/정구헌.jpg"
        },
        {
          name: "ebbeni",
          job: "backend",
          content:
            "안녕하세요, 백엔드를 맞은 신지영입니다! 팀원들이 많이 도와줘서 6주간 힘내서 코딩할 수 있었습니다. 정말 많이 배웠어요, 감사합니다",
          imgsrc: "profile/신지영.jpeg"
        },
        {
          name: "susuminmin",
          job: "팀장, frontend",
          content:
            "안녕하세요, 프런트엔드를 담당한 김수민입니다. 1학기 관통프로젝트를 제외하면 처음으로 프로젝트를 경험해 보는데, 조원들 덕분에 많이 배우고 성장하는 시간을 보냈습니다. 감사합니다.",
          imgsrc: "profile/김수민.jpg"
        }
      ]
    };
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    }
  },
  mounted() {
    Reveal.initialize();
  }
};
</script>

<style scoped>
.back {
  /* background-image: url(../assets/teambg.jpg); */
  background-size: 100%;
}
</style>
