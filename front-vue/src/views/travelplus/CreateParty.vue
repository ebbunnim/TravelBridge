<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <!-- <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold" style="padding-top: 10%">메이트 글쓰기</div>
      </div>
    </q-img>-->

    <div class="pad">
      <div class="row">
        <div class="col-12 text-weight-bold text-h5 text-center">파티생성</div>
        <div class="col-12 text-subtitle1 text-center">함께 여행을 떠날 TravelMate를 모집하세요</div>
        <div class="col-4" align="left">
          <q-btn
            class="q-my-lg"
            flat
            no-wrap
            color="black"
            icon="arrow_back"
            label="뒤로가기"
            @click="goBack()"
          />
        </div>
      </div>
      <q-card style flat bordered>
        <div class="row justify-center q-my-lg">
          <q-input class="col-8" type="text" label="제목" v-model="title" />
          <div class="row justify-around col-5" style="margin-top:2%;"></div>
          <div class="col-10 justify-center row" style="margin-top:1%;"></div>
        </div>

        <div class="row justify-around">
          <q-editor min-height="20rem" max-height="25rem" class="col-8" v-model="content" />
          <div class="col-3">
            <div class="row items-justify">
              <div class="col-12 q-my-lg text-center text-h6">참여인원 <b>{{people}}</b></div>
              <q-slider
                v-model="people"
                :min="0"
                :max="8"
                :step="1"
                label
                label-always
                class="col-12 q-my-xl q-pt-xl"
                color="light-green"
              ></q-slider>
            </div>
          </div>
        </div>
        <div class="row justify-center">
          <div class="col-12 q-my-lg" align="center">
            <q-btn rounded outline color="primary" icon="clear" label="초기화" />
            <q-btn
              rounded
              outline
              color="primary"
              icon="check"
              label="등록"
              style="margin-left:2%;"
              @click="createParty"
            />
          </div>
        </div>
      </q-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "",
      content: "",
      people: 0
    };
  },
  computed: {},
  methods: {
    goBack: function() {
      this.$router.go(-1);
      return;
    },
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    goParty(partyNo) {
      this.$router.push("mate/" + partyNo);
    },
    createParty() {
      let party = {
        host_name: this.$store.state.user.user.mem_name,
        host_no: this.$store.state.user.user.mem_no,
        party_contents: this.content,
        party_num: this.people,
        party_title: this.title
      };
      this.$store.dispatch("party/makeParty", {
        party
      });
    }
  }
};
</script>

<style></style>
