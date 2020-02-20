<template>
  <div>
    <h3>Main3 - mate</h3>
    <div>
      <q-btn color="primary" icon="파티생성" label="OK" @click="createParty" />
    </div>
    <div v-for="(p,index) of partyList" :key="index">
      {{p}}
      <q-btn color="primary" icon="check" label="OK" @click="goParty(p.party_no)" />
      <br />
    </div>
  </div>
</template>

<script>
export default {
  created() {
    this.$store.dispatch("party/getPartyList");
  },
  computed: {
    partyList() {
      return this.$store.state.party.partyList;
    }
  },
  methods: {
    goParty(partyNo) {
      this.$router.push("mate/" + partyNo);
    },
    createParty() {
      this.$router.push("mate/create");
    }
  }
};
</script>

<style>
</style>