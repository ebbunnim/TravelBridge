<template>
  <div>
    <div>ㅎㅎ</div>
    <div>ㅎㅎ</div>
    <div>{{ fval_no }}</div>
  </div>
</template>

<script>
export default {
  computed: {
    fval_no() {
      return this.$route.params.fval_no;
    }
  }
};
</script>

<style></style>
