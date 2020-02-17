<template>
  <div>
    <div>ㅎㅎㅎ</div>
    <div>ㅎㅎㅎ</div>
    <div>ㅎㅎㅎ</div>
    <div>{{ hp_no }}</div>
  </div>
</template>

<script>
export default {
  computed: {
    hp_no() {
      return this.$route.params.hp_no;
    }
  }
};
</script>

<style></style>
