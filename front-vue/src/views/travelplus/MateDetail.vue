<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-card class="q-ma-xl q-pa-xl" flat bordered>
      <q-card-section align="left">
        <div class="col-md-4">
          <q-btn
            class="col-md-4"
            flat
            no-wrap
            color="black"
            icon="arrow_back"
            label="목록으로"
            @click="goBack()"
          />
        </div>
      </q-card-section>

      <q-card-section align="center">
        <div class="text-h5 text-weight-bold q-my-lg">{{ party.party_title }}</div>

        <div class="text-h6 q-my-md">{{party.party_inMemList.length}}/{{party.party_num}} 명 참여</div>

        <template v-if="party.party_inMemList.length != party.party_num">
          <q-btn color="primary" rounded size="lg" icon="check" label="파티 참여" @click="partyIn" />
        </template>
        <template v-else>
          <q-btn color="red" rounded size="lg" icon="check" label="참여 불가" />
        </template>
      </q-card-section>

      <q-card-section class="row justify-between" align="right">
        <div class="col">
          작성일시
          <b>{{ party.party_regtime }}</b> / 작성자
          <b>{{ party.host_name }}</b>
        </div>
      </q-card-section>

      <q-separator inset />

      <q-card-section class="row q-my-xl text-center">
        <div class="text-h6 col-12 q-pa-sm" v-html="party.party_contents"></div>
        <!-- <div
          class="text-subtitle1 col-12"
          v-for=" (join,index) of party.party_inMemList"
          :key="index"
        >참여자 {{index+1}} 번 {{join.mem_name}}</div> -->
      </q-card-section>

      <q-separator inset />

      <!-- 댓글 -->
      <q-card-section class="row">
        <div class="col-12">
          <template v-if="party.party_cmtList != []">
            <q-list class="q-my-lg">
              <q-item v-for="(cmt, index) of party.party_cmtList" :key="index">
                <q-item-section>
                  <q-item-label ><q-chip>{{ cmt.cmt_writer }} </q-chip>{{ cmt.cmt_regtime }}</q-item-label>
                  <q-item-label class="q-ma-sm q-py-md">{{ cmt.cmt_content }}</q-item-label>
                </q-item-section>
              </q-item>
            </q-list>
          </template>
          <div class="q-my-lg">
            댓글 쓰기
            <q-input outlined v-model="cmt">
              <template v-slot:append>
                <q-icon v-if="cmt !== ''" name="close" @click="cmt = ''" class="cursor-pointer" />
                <q-icon name="add" @click="addCmt" />
              </template>
            </q-input>
          </div>
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  data() {
    return { cmt: "" };
  },
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
    addCmt() {
      let x = {
        cmt_content: this.cmt,
        cmt_writer: this.$store.state.user.user.mem_id,
        mem_no: this.$store.state.user.user.mem_no,
        party_no: this.party.party_no
      };
      this.$store.dispatch("party/addCmt", {
        x,
        partyNo: this.$route.params.mateNo
      });
    },
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    partyIn() {
      
      this.$store.dispatch("party/partyIn", {
        mem_no: this.$store.state.user.user.mem_no,
        party_no: this.party.party_no
      });
    },
    goBack: function() {
      this.$router.go(-1);
      return;
    }
  }
};
</script>

<style></style>
