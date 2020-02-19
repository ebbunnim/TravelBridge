<template>
  <div class="q-pa-none">
    <div class="q-col-gutter-lg items-start">
      <div class="col-12">
        <q-img :src="getImgUrl('post.jpg')" :ratio="16 / 7">
          <div
            class="absolute-center text-center row justify-center"
            style="width: 100%;"
          >
            <p class="text-h4 q-pt-lg col-8">
              <b>어떤 여행이 궁금한가요?</b>
            </p>
            <div class="row col-12 justify-center">
              <q-select
                v-model="option"
                :options="options"
                class="col-1"
                color="yellow"
                label-color="orange"
              />
              <q-input
                v-model="word"
                label="지금 구경하러 가기"
                class="col-6"
                color="white"
                label-color="white"
                standout
                style="margin-left:15px;"
                v-on:keyup.enter="search(1)"
              >
                <template v-slot:append>
                  <q-icon
                    v-if="word !== ''"
                    name="close"
                    @click="word = ''"
                    class="cursor-pointer"
                    color="white"
                  />
                  <q-icon
                    name="search"
                    class="cursor-pointer"
                    color="white"
                    @click="search(1)"
                  />
                </template>
              </q-input>
            </div>
            <div class="col-8 q-py-md row justify-center">
              <p style="padding: 16px 0 0 0;">추천 태그 :</p>
              <q-btn color="rgba(0,0,0,0.47)" flat label="#맛집" />
              <q-btn color="rgba(0,0,0,0.47)" flat label="#너네집" />
              <q-btn color="rgba(0,0,0,0.47)" flat label="#우리집" />
            </div>
          </div>
        </q-img>
      </div>
    </div>
    <h2>내맘대로 쓰는 공간</h2>
    <div>뭔가가 있겠지</div>
    <h2>추천태그 포스트</h2>
    <q-carousel
      v-model="slideTwo"
      transition-prev="slide-right"
      transition-next="slide-left"
      swipeable
      animated
      control-color="primary"
      navigation
      padding
      arrows
      autoplay
      infinite
      height="400px"
      class="bg-white text-black shadow-1 rounded-borders no-shadow"
    >
      <q-carousel-slide
        v-for="(subCard, index) in SubCard"
        :key="index"
        :name="index"
        class="column no-wrap"
      >
        <div
          class="row fit justify-start items-center q-gutter-xs q-col-gutter no-wrap"
        >
          <q-img
            v-for="(subContent, index) in subCard"
            :key="index"
            class="col-4 full-height pic"
            :src="subContent.img"
          >
            <span class="pic-caption bottom-to-top">
              <h1 class="pic-title">{{ subContent.title }}</h1>

              <p>{{ subContent.sub }}</p>
            </span>
          </q-img>
        </div>
      </q-carousel-slide>
    </q-carousel>
    <h2>추천태그 플래너</h2>
    <q-carousel
      v-model="slideTwo"
      transition-prev="slide-right"
      transition-next="slide-left"
      swipeable
      animated
      control-color="primary"
      navigation
      padding
      arrows
      autoplay
      infinite
      height="400px"
      class="bg-white text-black shadow-1 rounded-borders no-shadow"
    >
      <q-carousel-slide
        v-for="(subCard, index) in SubCard"
        :key="index"
        :name="index"
        class="column no-wrap"
      >
        <div
          class="row fit justify-start items-center q-gutter-xs q-col-gutter no-wrap"
        >
          <q-img
            v-for="(subContent, index) in subCard"
            :key="index"
            class="col-4 full-height pic"
            :src="subContent.img"
          >
            <span class="pic-caption bottom-to-top">
              <h1 class="pic-title">{{ subContent.title }}</h1>

              <p>{{ subContent.sub }}</p>
            </span>
          </q-img>
        </div>
      </q-carousel-slide>
    </q-carousel>
  </div>
</template>

<script>
export default {
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    },
    search: function(pageNo) {
      console.log(this.word);
      console.log(this.option);
      if (this.word != "") {
        if (this.option != "") {
          this.$router.push(
            "/page1/main1search/" + this.word + "/" + this.option + "/" + pageNo
          );
        } else {
          this.$router.push("/page1/main1search/" + this.word + "/" + pageNo);
        }
      } else {
        if (pageNo !== 1) this.$router.push("/page1/main1search/" + pageNo);
        else this.$router.push("/page1/main1search");
      }
    }
  },
  data() {
    return {
      options: ["전체", "제목", "내용", "태그", "지역"],
      word: "",
      option: "전체",
      text: "",
      slideTwo: 0,
      SubCard: [
        [
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          }
        ],
        [
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          }
        ],
        [
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          }
        ]
      ]
    };
  }
};
</script>

<style></style>
