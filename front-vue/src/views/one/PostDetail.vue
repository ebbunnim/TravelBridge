<template>
  <div>
    <div style="max-width: 70%; margin: 5% 15% 0 15%">
      <q-btn color="primary" icon="check" label="목록으로" />
      <h4>{{ post.post_title }}</h4>
      <div class="justify-between row">
        <p>도시 : {{ post.post_city }}</p>
        <p>
          작성일 : {{ post.post_regtime }}
          <span>작성자 : {{ post.post_writer }}</span>
        </p>
      </div>
      <div class="justify-between row">
        <p>해시태그 :{{ post.post_category }}</p>
        <p>조회수 : {{ post.post_hits }}</p>
      </div>
      <p>사진 : {{ post.post_filesList }}</p>
      <q-carousel
        arrows
        animated
        swipeable
        autoplay
        infinite
        v-model="slideOne"
        height="600px"
      >
        <q-carousel-slide
          v-for="(mainCard, index) in MainCard"
          :key="index"
          :name="index"
          :img-src="mainCard.img"
        ></q-carousel-slide>
      </q-carousel>
      <div><p v-html="post.post_content"></p></div>
      {{ post }}
      <template v-if="post.post_plan_start != null">플랜</template>
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
  },
  mounted() {
    if (this.$route.params != null) {
      this.$store.dispatch("post/searchInfoPost", {
        postNo: this.$route.params.postNo
      });
    }
  },
  computed: {
    post() {
      return this.$store.state.post.post;
    }
  }
};
</script>

<style></style>
