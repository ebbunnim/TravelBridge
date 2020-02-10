<template>
  <div class="q-pa-none">
    <div class="q-col-gutter-lg items-start">
      <div class="col-12">
        <q-img :src="getImgUrl('global.gif')" :ratio="16 / 5">
          <div class="absolute-center text-center" style="width: 100%">
            <p class="text-h4 q-pt-lg">
              <b>트래블 서치</b>
            </p>
            <p class="text-body1">
              트래블 브릿지와 함께 다음 여행지를 골라보세요.
            </p>
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
    }
  }
};
</script>

<style></style>
