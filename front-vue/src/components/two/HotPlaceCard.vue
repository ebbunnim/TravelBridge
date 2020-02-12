<template>
  <q-card class="my-card">
    <q-card-section>
      <div class="text-h5 text-center">{{ hp_name }}</div>
      <div class="text-subtitle2 text-center">{{ hp_detail_adr }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-h6">{{ hp_tag }}</div>
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
    hp_name: { type: String },
    hp_detail_adr: { type: String },
    hp_tag: { type: String }
  }
};
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  max-width: 300px
</style>
