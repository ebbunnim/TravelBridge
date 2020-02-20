<template>
  <div class="text-grey q-py-md" style="background: #f9f9f9">
    <div class="row" v-if="!footerHidden">
      <div class="col-4 text-center q-pt-sm">
        © 2020 TravelBridge SSAFY All rights reserved.
      </div>
      <div class="col-4 text-center"></div>
      <div class="col-4 text-center">
        <q-btn no-caps flat to="/about/us" label="About Us" /> /
        <q-btn no-caps flat to="/faq" label="FAQ" /> /
        <q-btn no-caps flat to="/qna" label="Q&A" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      window: {
        width: 0,
        height: 0
      }
    };
  },
  computed: {
    footerHidden() {
      return this.window.width < 600;
    }
  },
  methods: {
    handleResize() {
      // 반응형 조절할 때
      this.window.width = window.innerWidth;
      this.window.height = window.innerHeight;
    }
  },
  created() {
    window.addEventListener("resize", this.handleResize);
    this.handleResize();
  },
  destroyed() {
    window.removeEventListener("resize", this.handleResize);
  }
};
</script>

<style>
.border {
  border-block-color: black;
  border-top-style: solid;
  border-top-width: thin;
  border-top-color: grey;
}
</style>
