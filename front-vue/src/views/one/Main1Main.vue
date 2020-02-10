<template>
  <div class="q-pa-none">
    <div class="q-col-gutter-lg items-start">
      <div class="col-12">
        <q-img :src="getImgUrl('post.gif')" :ratio="16/5">
          <div class="absolute-center text-center" style="width: 100%">
            <p class="text-h4 q-pt-lg">
              <b>트래블 카드</b>
            </p>
            <p class="text-body1">당신의 여행이 궁금합니다.</p>
          </div>
        </q-img>
      </div>
    </div>
    <div>
      <h3>추천</h3>
    </div>
    <div>
      <h3>내용</h3>
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

<style>
</style>