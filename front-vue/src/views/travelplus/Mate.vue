<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold absolute-center">TravelMate</div>
      </div>
    </q-img>
    <div class="row justify-center">
      <q-btn
        class="col-md-2 col-xs-6 q-my-lg"
        rounded
        outline
        push
        size="xl"
        color="info"
        icon="people"
        label="파티생성"
        @click="createParty()"
      />
    </div>
    <div class="row justify-center q-mb-xl">
      <q-list bordered separator class="col-8">
        <q-item class="row" v-for="(p, index) of partyList" :key="index">
          <q-item-section class="col-2">{{ p.party_inMemList.length }}/{{ p.party_num }} 명 모집</q-item-section>
          <q-item-section>
            <q-item-label>
              <q-chip class="q-mx-none" :label="p.host_name" />
              <span class="text-weight-bold">{{ p.party_title }}</span>
            </q-item-label>
            <q-item-title class="q-mx-sm">
              <span class="text-grey">{{ p.party_regtime }}</span>
            </q-item-title>
            <q-item-label>
              <!-- {{ p.host_name }}  -->
              <!-- 댓글수 : {{ p.party_cmtList.length }} -->
              <q-item-label class="q-ma-sm" v-html="p.party_contents"></q-item-label>
            </q-item-label>
          </q-item-section>

          <q-item-section side top>
            <!-- <q-item-label>게시일</q-item-label> -->
            <q-item-section>
              <q-btn
                rounded
                outline
                color="info"
                icon="check"
                label="자세히 보기"
                @click="goParty(p.party_no)"
              />
            </q-item-section>
          </q-item-section>
        </q-item>
      </q-list>
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
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    goParty(partyNo) {
      this.$router.push("mate/" + partyNo);
    },
    createParty() {
      this.$router.push("mate/create");
    }
  }
};
</script>

<style></style>
