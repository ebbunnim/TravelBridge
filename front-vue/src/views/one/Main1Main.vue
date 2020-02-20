<template>
  <div class="q-pa-none">
    <!-- <div class="q-col-gutter-lg items-start"> -->
    <div>
      <div class="col-12">
        <q-img
          :src="getImgUrl('card.jpg')"
          :ratio="16 / 7"
          style="height: 760px"
        >
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
                bg-color="grey"
                class="col-1"
                standout="bg-glossy text-white"
                rounded
              />
              <q-input
                v-model="word"
                rounded
                bg-color="grey"
                label="지금 구경하러 가기"
                class="col-6"
                label-color="white"
                standout="bg-glossy text-white"
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
            <div class="col-8 q-py-md row justify-center"></div>
          </div>
        </q-img>
      </div>
    </div>
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
