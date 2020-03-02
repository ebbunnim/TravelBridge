<template>
  <div class="gt-md text-grey q-py-md" style="background: #f9f9f9">
    <div class="row">
      <div class="col-3 text-center q-pt-sm">© 2020 TravelBridge SSAFY All rights reserved.</div>
      <div class="col-6 text-center"></div>
      <div class="col-3 text-center">
        <q-btn no-caps flat to="/faq" label="FAQ" />/
        <q-btn no-caps flat to="/qna" label="Q&A" />/
        <q-btn no-caps flat to="/about/service" label="About Service" />/
        <q-btn no-caps flat to="/about/us" label="About Us" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
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
