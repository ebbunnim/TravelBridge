<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold absolute-center">About Service</div>
      </div>
    </q-img>
    <div
      class="row justify-center q-ma-lg q-pa-lg items-center"
      v-for="(service, index) in serviceList"
      :key="index"
    >
      <div class="col-md-4 col-xs-12">
        <q-img :src="service.img"></q-img>
      </div>
      <div class="col-md-6 col-xs-12">
        <div class="q-my-lg text-center">
          <q-chip clickable size="20px" class="q-mx-lg">
            <q-avatar :icon="service.icon" color="red" text-color="white" />
            <span class="text-weight-bold">{{ service.name }}</span>
          </q-chip>
        </div>
        <div class="gt-md text-center text-h6" v-html="service.content"></div>
        <div class="lt-lg text-center text-body1" v-html="service.content"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      serviceList: [
        {
          name: "TravelCard",
          icon: "bookmark",
          path: "/page1",
          content:
            "나의 여행 플랜과 후기를 다른 트래블러와 공유하세요. <br>다른 회원들의 피드를 받아보거나 검색할 수도 있습니다.",
          img:
            "https://static.wixstatic.com/media/c6ba6c_95d07d0346754bf1b602bb7ffb9072bb~mv2.gif"
        },
        {
          name: "TravelPick",
          path: "/page2",
          icon: "directions",
          content:
            "다음 여행지는 어딜까?<br>TravelBridge 에서 테마 추천 서비스를 이용하세요. <br> 제목, 태그, 지역, 내용으로 직접 검색할 수도 있습니다.",
          img:
            "https://static.wixstatic.com/media/c6ba6c_377676e7db5c4b58ac33dfe0f985bfe0~mv2.gif"
        },
        {
          name: "TravelPlus+",
          icon: "add",
          path: "/page3",
          content:
            "요즘 가장 핫한 여행지는 어디? 이 구역 최고의 트래블러는 누구? <br>Travel Rank에서 확인하세요. <br> 직접 Travel Mate를 모집해보세요. ",
          img:
            "https://static.wixstatic.com/media/c6ba6c_aebcc81da4a34f17b880471dec4ed9cb~mv2.gif"
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
