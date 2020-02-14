<template>
  <div>
    <div style="max-width: 70%; margin: 5% 15% 0 15%">
      <q-btn color="primary" icon="check" label="목록으로" />
      <h3>타이틀</h3>
      <div class="justify-between row">
        <p>도시</p>
        <p>작성일 작성자</p>
      </div>

      <p>해시태그</p>
      <p>사진</p>
      <q-carousel arrows animated swipeable autoplay infinite v-model="slideOne" height="600px">
        <q-carousel-slide
          v-for="(mainCard, index) in MainCard"
          :key="index"
          :name="index"
          :img-src="mainCard.img"
        ></q-carousel-slide>
      </q-carousel>
      <p>콘텐트</p>
      <div>v-html</div>

      <div>
        <p>댓글</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slideOne: 0,
      MainCard: [
        {
          img: require("../../assets/bg.jpg"),
          title: "이번엔 어디로 여행가지?",
          sub: "국내 축제와 핫플은 다모아놨다!"
        },
        {
          img: require("../../assets/main.gif"),
          title: "다른 사람들은 여행을 어떻게 갈까?",
          sub: "여행 정보 공유 라고 쓰고 자랑이라고 말하지"
        },
        {
          img: require("../../assets/train.gif"),
          title: "가자 내일로 그런데 어디로?",
          sub: "내일로 추천의 신!"
        }
      ]
    };
  }
};
</script>

<style></style>
