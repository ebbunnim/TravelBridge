<template>
  <div>
    <p>팔로우 유저</p>
    <template v-if=" this.user.mem_id != null ||
              this.user.mem_id != undefined">
      <p>나랑 팔로우함?? {{Check}}</p>
    </template>
    {{another}}
  </div>
</template>

<script>
export default {
  mounted() {
    this.$store.dispatch("user/getAnother", {
      userNo: this.$route.params.userNo
    });
    this.$store.dispatch("user/getFollowing", {
      userNo: this.$store.state.user.user.mem_no
    });
  },
  computed: {
    another() {
      return this.$store.state.user.another;
    },
    user() {
      console.log("asd");
      console.log(this.$store.state.user.user);
      return this.$store.state.user.user;
    },
    Check() {
      if (this.user.mem_id != null || this.user.mem_id != undefined) {
        for (let x in this.$store.state.user.following.mem_followList) {
          if (
            this.$store.state.user.following.mem_followList[x].mem_no ===
            this.another.mem_no
          ) {
            return true;
          }
        }
      }
      return false;
    }
  }
};
</script>

<style>
</style>