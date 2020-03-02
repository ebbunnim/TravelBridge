<template>
  <div>
    <q-img
      :src="getImgUrl('home_bridge_bg.jpg')"
      style="height: 760px; opactiy: 0.5;"
      :img-style="{ opacity: 0.7 }"
    >
      <div class="row q-my-xl text-center absolute-center bg-transparent">
        <div class="col-12 q-my-xl"></div>

        <div class="gt-md col-12 text-h1 text-weight-bold cursor-pointer" @click="$router.push('/')">
          <span class="travel">Travel</span>
          <span class="bridge">Bridge</span>
        </div>
        <div class="lt-lg col-12 text-h2 text-weight-bold cursor-pointer" @click="$router.push('/')">
          <span class="travel">Travel</span>
          <span class="bridge">Bridge</span>
        </div>
        <div class="col-12 q-mt-lg q-pa-xl"></div>
        <div class="col-12 q-my-xl q-py-xl button-position">
          <q-chip
            clickable
            size="20px"
            class="q-mx-lg"
            @click="$router.push('/page1')"
            @mouseover="alert()"
          >
            <q-avatar icon="bookmark" color="red" text-color="white" />
            <span class="text-weight-bold">TravelCard</span>
          </q-chip>
          <q-chip clickable size="20px" class="q-mx-lg" @click="$router.push('/page2')">
            <q-avatar icon="directions" color="red" text-color="white" />
            <span class="text-weight-bold">TravelPick</span>
          </q-chip>
          <q-chip clickable size="20px" class="q-mx-lg" @click="$router.push('/page3')">
            <q-avatar icon="add" color="red" text-color="white" />
            <span class="text-weight-bold">TravelPlus+</span>
          </q-chip>
        </div>
      </div>
    </q-img>
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
  },
  computed: {
    // textSize() {

    // }
  },
  mounted() {
  }
};
</script>

<style>
.button-position {
  padding-top: 100px;
}
.custom-bg {
  background-color: rgba(117, 69, 69, 0.3);
  width: 100%;
}
</style>
