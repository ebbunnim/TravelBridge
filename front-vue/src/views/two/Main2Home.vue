<template>
  <div>
    <div>
      <q-carousel
        animated
        v-model="slide"
        arrows
        navigation
        infinite
        height="680px"
      >
        <q-carousel-slide :name="1" :img-src="getImgUrl('main2bg.jpg')">
          <div class="row q-my-xl justify-center absolute-center custom-caption" style="width: 100%; height: 30%">
            <p class="col-12 text-h4 q-pt-lg"><b>트래블 픽</b></p>
            <p class="col-12 text-body1 ">트래블 브릿지와 함께 다음 여행지를 골라보세요.</p>
            <q-input class="col-7 text-h6" v-model="word" type="text" placeholder="검색어를 검색하세요"
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
        </q-carousel-slide>
        <q-carousel-slide
          :name="2"
          :img-src="getImgUrl('main2bg2.jpg')"
        ></q-carousel-slide>
      </q-carousel>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      word: "",
      slide: 1,
      cities: this.$store.state.city.cities // 모듈 접근해야 불러와진다.
    };
  },
  methods: {
    getImgUrl(img) {
      return require("../../assets/" + img);
    }
  }
};
</script>

<style>
.custom-caption {
  text-align: center;
  color: white;
  background-color: rgba(0, 0, 0, 0.3);
}
</style>
