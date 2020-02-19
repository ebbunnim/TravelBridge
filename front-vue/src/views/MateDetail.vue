<template>
  <div>
    <h3>Main3 - matedetail</h3>
    {{party}}
    <q-btn color="primary" icon="check" label="OK" @click="partyIn" />
  </div>
</template>

<script>
export default {
  created() {
    this.$store.dispatch("party/getParty", {
      partyNo: this.$route.params.mateNo
    });
  },
  computed: {
    party() {
      return this.$store.state.party.party;
    }
  },
  methods: {
    partyIn() {
      console.log("참가");
    }
  }
};
</script>

<style>
</style>