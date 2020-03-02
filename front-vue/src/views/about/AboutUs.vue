<template>
  <div>
    <div class>
      <div style="height: 65px; background: #f9f9f9"></div>
      <q-img :src="getImgUrl('cutbg.jpg')">
        <div style="width: 100%; height: 100%" class="text-center">
          <div class="text-h5 text-weight-bold absolute-center">About Us</div>
        </div>
      </q-img>

      <div class="row justify-center q-my-xl q-py-lg">
        <q-card
          class="col-md-5 col-xs-10 q-ma-md"
          flat
          bordered
          v-for="(dev, index) in developer"
          :key="index"
        >
          <q-card-section class="row justify-between items-center">
            <q-img
              style="max-width: 250px;"
              class="rounded-borders q-px-lg q-mx-auto col-md-4 col-xs-12"
              :src="getImgUrl(dev.imgsrc)"
              :ratio="9/16"
            />


            <div class="col-md-7 col-xs-12 q-my-lg">
              <span class="text-h5 text-weight-bold q-pr-lg">{{ dev.name }}</span>
              <span class="text-h6">{{ dev.job }}</span>
              <div class="q-my-lg">
                <div>{{ dev.content }}</div>
              </div>
              <q-btn
                type="a"
                round
                flat
                icon="img:https://image.flaticon.com/icons/svg/25/25231.svg"
                target="_blank"
                :href="dev.github"
              />
            </div>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      developer: [
        {
          name: "정구헌",
          id: "honeion",
          job: "Backend",
          github: "https://github.com/honeion",
          content:
            "안녕하세요, 백엔드파트를 맡은 정구헌입니다.좋은 팀원들과 만나 재미있게 코딩했습니다.많은 도움이 된 프로젝트였습니다. 감사합니다",
          imgsrc: "profile/정구헌.jpg"
        },
        {
          name: "신지영",
          id: "ebbunnim",
          github: "https://github.com/ebbunnim",
          job: "Backend",
          content:
            "안녕하세요, 백엔드를 맞은 신지영입니다! 팀원들이 많이 도와줘서 6주간 힘내서 코딩할 수 있었습니다. 정말 많이 배웠어요, 감사합니다",
          imgsrc: "profile/신지영.jpeg"
        },
        {
          name: "김준목",
          id: "jtree",
          github: "https://github.com/JunMock",
          job: "Frontend",
          content:
            "어서오세요. 프론트 개발자 김준목 입니다. 쓰러지지 않고 같이 올수 있어서 너무 좋았습니다. ",
          imgsrc: "profile/김준목.jpg"
        },
        {
          name: "김수민",
          id: "susuminmin",
          github: "https://github.com/susuminmin",
          job: "Frontend",
          content:
            "안녕하세요, 프런트엔드를 담당한 김수민입니다. 1학기 관통프로젝트를 제외하면 처음으로 프로젝트를 경험해 보는데, 조원들 덕분에 많이 배우고 성장하는 시간을 보냈습니다. 감사합니다.",
          imgsrc: "profile/김수민.jpg"
        }
      ]
    };
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    }
  }
};
</script>

<style>
/*  */
</style>
