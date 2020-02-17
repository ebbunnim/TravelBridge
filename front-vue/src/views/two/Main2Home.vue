<template>
  <div>
    <q-img :src="getImgUrl('global.jpg')" :ratio="16 / 4">
      <div class="absolute-top text-center" style="width: 100%">
        <p class="text-h4 q-pt-lg">
          <b>트래블 서치</b>
        </p>
        <p class="text-body1">트래블 브릿지와 함께 다음 여행지를 골라보세요.</p>

        <q-input
          class="text-h6"
          v-model="cityName"
          type="text"
          placeholder="도시 이름을 검색하세요(예: 서울, 전주)"
        >
          <template v-slot:append>
            <q-btn
              outline
              flat
              color="grey"
              icon="search"
              @click="onSearchBtn()"
            />
          </template>
        </q-input>
      </div>

      <!-- <div class="row justify-center q-my-xl q-py-xl" style="height: 550px; background: #f9f9f9">
        
      </div>-->
    </q-img>

    <q-card
      style="margin: 100px 150px; height: 400px; text-align: center;"
      class="q-pa-lg"
      flat
      bordered
      square
      >ㅎㅇ</q-card
    >
    <q-card
      style="margin: 100px 150px; height: 400px; text-align: center;"
      class="q-pa-lg"
      flat
      bordered
      square
      >ㅎㅇ</q-card
    >

    <h2>이달의 축제 >> 이전 해야함 >> 매인2번으로</h2>
    <q-carousel
      arrows
      animated
      swipeable
      infinite
      v-model="slideThr"
      height="600px"
    >
      <q-carousel-slide
        v-for="(mainCard, index) in ThrCard"
        :key="index"
        :name="index"
        style="background-color:#cecece"
        class="column justify-center"
      >
        <div class="snow layer2"></div>
        <div class="snow layer2 a"></div>
        <div class="row justify-around">
          <div class="col-5" style="text-align:center;">
            <div class="text-h2">{{ mainCard.title }}</div>
            <q-separator spaced inset />
            <div class="text-subtitle1">{{ mainCard.sub }}</div>
          </div>
          <q-img
            :src="mainCard.img"
            :ratio="16 / 9"
            spinner-color="primary"
            spinner-size="82px"
            class="col-5"
            align="left"
          />
        </div>
      </q-carousel-slide>
    </q-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cities: this.$store.state.city.cities, // 모듈 접근해야 불러와진다.
      ThrCard: [
        {
          img:
            "https://support.visitkorea.or.kr/img/call?cmd=VIEW&id=ef4fe9a4-afa2-4bc6-97e2-cec199f22496",
          title: "오색별빛정원전 2020",
          sub:
            "10만여 평의 야외 정원 곳곳을 다채로운 조명과 빛을 이용하여 특별한 주제를 가지고 표현한 야간 조명 점등행사이다. 자연과 빛의 조화를 추구하며 국내 최초로 시도된 새로운 빛의 풍경인 ‘오색별빛정원전’은, 인공적인 조명 속에서도 한국 자연의 미(美)를 한껏 느낄 수 있어 많은 관람객들에게 사랑받고 있다. 매년 12월에서 3월 (동절기)사이 개최되는 '오색별빛정원전'은 수목원 내 전 정원을 밑그림 삼아 친환경 소재인 LED 전구를 사용하여 그려진 화려한 빛 축제의 장이 될 것이다."
        },
        {
          img: require("../../assets/main.gif"),
          title: "second stop",
          sub: "Mountains"
        },
        {
          img: "https://cdn.quasar.dev/img/donuts.png",
          title: "thrid stop",
          sub: "Mountains"
        }
      ],
      slideThr: 0
    };
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    }
  }
};
</script>

<style></style>
