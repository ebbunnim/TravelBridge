<template>
  <div>
    <q-img :src="getImgUrl('bg7.jpg')" style="height: 760px">
      <div
        class="row q-mt-xl text-center justify-center absolute-center bg-transparent"
      >
        <div
          class="col-12 text-h1 text-weight-bold cursor-pointer"
          @click="$router.push('/')"
        >
          <span class="travel">Travel</span>
          <span class="bridge">Bridge</span>
        </div>
        <div class="col-12 q-my-xl q-py-xl">
          <q-chip
            clickable
            size="20px"
            class="q-mx-lg"
            @click="$router.push('/page1')"
            @mouseover="alert()"
          >
            <q-avatar
              icon="bookmark"
              color="red"
              text-color="white"
            />TravelCard
          </q-chip>
          <q-chip
            clickable
            size="20px"
            class="q-mx-lg"
            @click="$router.push('/page2')"
          >
            <q-avatar
              icon="directions"
              color="red"
              text-color="white"
            />TravelSearch
          </q-chip>
          <q-chip
            clickable
            size="20px"
            class="q-mx-lg"
            @click="$router.push('/page3')"
          >
            <q-avatar icon="add" color="red" text-color="white" />TravelPlus+
          </q-chip>
        </div>
      </div>
    </q-img>
    <!-- <q-carousel animated v-model="slide" navigation infinite height="725px">
      <q-carousel-slide :name="1" :img-src="getImgUrl('bg7.jpg')" />

      <h1 class="text-white">미ㅏㅇ러미;ㅏ얼</h1>
    </q-carousel>-->
    <!-- <q-carousel
      arrows
      animated
      swipeable
      autoplay
      infinite
      v-model="slideOne"
      height="680px"
    >
      <q-carousel-slide
        v-for="(mainCard, index) in MainCard"
        :key="index"
        :name="index"
        :img-src="mainCard.img"
      >
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">{{ mainCard.title }}</div>
          <div class="text-subtitle1">{{ mainCard.sub }}</div>
        </div>
      </q-carousel-slide>
    </q-carousel>-->
    <!-- <q-separator /> -->
  </div>
</template>

<script>
export default {
  methods: {
    getImgUrl(img) {
      return require("../assets/" + img);
    }
  },
  data() {
    return {
      slide: 1
    };
  }
};
</script>

<style>
.chip-position {
  position: relative;
  top: 20px;
}
.custom-bg {
  background-color: rgba(0, 0, 0, 0.3);
  width: 100%;
}
</style>
