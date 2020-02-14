<template>
  <q-card class="my-card">
    <q-card-section>
      <div class="text-h5 text-center">{{ fval_name }}</div>
      <div class="text-subtitle2 text-center">{{ fval_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-h6">{{ fval_tag }}</div>
    </q-card-section>
  </q-card>
</template>

<script>
export default {
  name: "HotPlaceCard",
  methods: {
    // getImgUrl(img) {
    //   return require("../../assets/" + img);
    // }
  },
  props: {
    fval_name: { type: String },
    fval_detail_adr: { type: String },
    fval_tag: { type: String }
  }
};
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  max-width: 300px
</style>
