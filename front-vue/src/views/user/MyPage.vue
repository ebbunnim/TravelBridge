<template>
  <div class="text-center">
    <h4>마이 페이지</h4>
    <div class="q-pa-lg">
      <!-- <div style="max-width: 70%; margin: 0 15% 0 15%"> -->
      <div>
        <q-tabs
          dense
          v-model="tab"
          class="text-grey"
          active-color="primary"
          indicator-color="primary"
          narrow-indicator
          align="center"
        >
          <q-tab name="activity" label="팔로우" />
          <q-tab name="info" label="개인정보" />
          <q-tab name="etc" label="내 활동" />
        </q-tabs>

        <q-tab-panels v-model="tab">
          <!-- 첫번째 패널 -->
          <q-tab-panel name="activity" style="height:900px">
            <q-tabs
              dense
              v-model="followTab"
              class="text-black"
              active-color="primary"
              indicator-color="primary"
              narrow-indicator
              align="center"
            >
              <q-tab name="follower" label="팔로워">{{follower.mem_followMe.length}}</q-tab>
              <q-tab name="following" label="팔로잉">{{following.mem_followList.length}}</q-tab>
            </q-tabs>

            <q-tab-panels v-model="followTab" animated>
              <q-tab-panel name="follower">
                <div v-for="(mem,index) in follower.mem_followMe" :key="index">{{mem.mem_id}}</div>
              </q-tab-panel>
              <q-tab-panel name="following">
                <div v-for="(mem,index) in following.mem_followList" :key="index">{{mem.mem_id}}</div>
              </q-tab-panel>
            </q-tab-panels>
          </q-tab-panel>

          <!-- 두번째 패널 -->
          <q-tab-panel name="info" style="font-size:20px">
            <div class="q-pa-md row justify-center q-gutter-md">
              <!-- 첫번째 카드 -->
              <q-card flat bordered class="my-card col-xs-12 col-md-9">
                <q-card-section>
                  <div class="text-h6">계정정보</div>
                </q-card-section>
                <q-separator inset />
                <q-card-section>
                  <div class="text-body2 text-left">이메일</div>
                  <q-input
                    v-model="user.mem_email"
                    type="text"
                    class="text-h6"
                    readonly
                    dense
                    borderless
                  />
                </q-card-section>
                <q-card-section>
                  <div class="text-subtitle2 text-left">
                    <span>이메일 수신 여부</span>
                    <q-btn
                      class="q-ml-lg"
                      round
                      flat
                      size="sm"
                      color="primary"
                      icon="edit"
                      v-if="!onEditReceive"
                      @click="onEditReceive = !onEditReceive"
                    />
                    <q-btn
                      class="q-ml-lg"
                      round
                      flat
                      size="sm"
                      color="info"
                      icon="edit"
                      v-if="onEditReceive"
                      @click="
                        onEditReceive = !onEditReceive;
                        updateUser();
                      "
                    />
                  </div>
                  <q-input
                    v-model="user.mem_receive_email"
                    type="text"
                    class="text-h6"
                    readonly
                    dense
                    borderless
                    v-show="!onEditReceive"
                  />
                  <div v-show="onEditReceive" align="left " class="row justify-center">
                    <q-radio v-model="user.mem_receive_email" val="true" label="Email 수신에 동의합니다" />
                    <q-radio
                      v-model="user.mem_receive_email"
                      val="false"
                      label="Email 수신에 동의하지 않습니다 "
                    />
                  </div>
                </q-card-section>
                <q-card-section class="row">
                  <div class="col-md-6 col-xs-12">
                    <div class="text-subtitle2 text-left">최종 로그인</div>
                    <q-input
                      v-model="user.mem_lastlogin"
                      type="text"
                      class="text-subtitle1"
                      readonly
                      dense
                      borderless
                    />
                  </div>
                  <div class="col-md-6 col-xs-12">
                    <div class="text-subtitle2 text-left">가입일시</div>
                    <q-input
                      v-model="user.mem_regtime"
                      type="text"
                      class="text-subtitle1"
                      readonly
                      dense
                      borderless
                    />
                  </div>
                </q-card-section>
                <q-card-section>
                  <!-- 기능 아직 구현 안 됨 -->
                  <div class="text-h4 text-left">회원탈퇴</div>
                </q-card-section>
              </q-card>
              <!-- 두번째 카드 -->
              <q-card flat bordered class="my-card col-xs-12 col-md-9">
                <q-card-section>
                  <div class="text-h6">회원정보</div>
                  <div class="text-right">
                    <q-btn
                      flat
                      class="q-ml-lg"
                      label="수정하기"
                      color="primary"
                      icon="edit"
                      v-if="readOnly"
                      @click="readOnly = !readOnly"
                    />
                    <q-btn
                      outline
                      class="q-ml-lg"
                      label="수정완료"
                      color="primary"
                      icon="edit"
                      v-if="!readOnly"
                      @click="
                        readOnly = !readOnly;
                        updateUser();
                      "
                    />
                  </div>
                </q-card-section>
                <q-separator inset />
                <q-card-section class="row">
                  <div class="col-6">
                    <div class="text-body2 text-left">이름</div>
                    <q-input
                      v-model="user.mem_name"
                      type="text"
                      class="text-h6 q-pr-lg"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                      dense
                      borderless
                    />
                  </div>
                  <div class="col-6">
                    <div class="text-body2 text-left">닉네임</div>
                    <q-input
                      v-model="user.mem_id"
                      type="text"
                      class="text-h6 q-pr-lg"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                      dense
                      borderless
                    />
                  </div>
                </q-card-section>

                <q-card-section class="row">
                  <div class="col-6">
                    <div class="text-body2 text-left">연락처</div>
                    <q-input
                      v-model="user.mem_phone"
                      type="text"
                      class="text-h6 q-mr-md q-pr-lg"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                      dense
                      borderless
                    />
                  </div>
                  <div class="col-6">
                    <div class="text-body2 text-left">생년월일</div>
                    <q-input
                      dense
                      borderless
                      v-model="user.mem_birth"
                      placeholder="YYYY/MM/DD"
                      mask="date"
                      class="text-h6 q-pr-lg"
                      :rules="['date']"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                    >
                      <template v-slot:append>
                        <q-icon name="event" class="cursor-pointer" v-if="!readOnly">
                          <q-popup-proxy
                            ref="qDateProxy"
                            transition-show="scale"
                            transition-hide="scale"
                          >
                            <q-date
                              minimal
                              v-model="user.mem_birth"
                              @input="() => $refs.qDateProxy.hide()"
                            />
                          </q-popup-proxy>
                        </q-icon>
                      </template>
                    </q-input>
                  </div>
                </q-card-section>
              </q-card>
              <!-- 세번째 카드 -->
              <q-card flat bordered class="my-card col-xs-12 col-md-9">
                <q-card-section>
                  <div class="text-h6">관심분야</div>
                  <div class="text-right">
                    <q-btn
                      flat
                      class="q-ml-lg"
                      label="수정하기"
                      color="primary"
                      icon="edit"
                      v-if="!onInterestEdit"
                      @click="onInterestEdit = !onInterestEdit"
                    />
                    <q-btn
                      outline
                      class="q-ml-lg"
                      label="수정완료"
                      color="primary"
                      icon="edit"
                      v-if="onInterestEdit"
                      @click="
                        onInterestEdit = !onInterestEdit;
                        updateUser();
                      "
                    />
                  </div>
                </q-card-section>
                <q-separator inset />
                <q-card-section>
                  <!-- <q-input
                    v-model="user.mem_interest"
                    type="text"
                    class="col-"
                    style="text-align:left; margin-left:10px"
                    readonly
                  />-->

                  <div class="row" style="display: inline" v-for="(item, idx) in thema" :key="idx">
                    <q-btn
                      v-bind="{ disabled: !onInterestEdit }"
                      color="grey"
                      unelevated
                      class="q-mb-sm q-mt-md q-px-xs"
                      size="md"
                      v-if="item.state"
                      @click="
                        item.state = !item.state;
                        onToggle();
                      "
                    >#{{ item.name }}</q-btn>
                    <q-btn
                      v-bind="{ disabled: !onInterestEdit }"
                      color="grey"
                      size="md"
                      class="q-mb-sm q-mt-md q-px-xs"
                      v-if="!item.state"
                      bordered
                      flat
                      @click="
                        item.state = !item.state;
                        onToggle();
                      "
                    >#{{ item.name }}</q-btn>
                  </div>
                </q-card-section>
              </q-card>
            </div>
          </q-tab-panel>
          <!-- 세번재 패널 -->
          <q-tab-panel name="etc" style="height:900px">
            <q-tabs
              dense
              v-model="likeTab"
              class="text-black"
              active-color="primary"
              indicator-color="primary"
              narrow-indicator
              align="center"
            >
              <q-tab name="post" label="좋아요 포스트"></q-tab>
              <q-tab name="hot" label="좋아요 핫플"></q-tab>
              <q-tab name="festa" label="좋아요 축제"></q-tab>
            </q-tabs>

            <q-tab-panels v-model="likeTab" animated>
              <q-tab-panel name="post">{{likePost.mem_likePost}}</q-tab-panel>
              <q-tab-panel name="hot"></q-tab-panel>
              <!-- {{likeHot.mem_likeHotPlace}} -->
              <q-tab-panel name="festa"></q-tab-panel>
              <!-- {{likeFesta.mem_likeFestival}} -->
            </q-tab-panels>
          </q-tab-panel>
        </q-tab-panels>
        <!-- card end -->
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import UserService from "@/services/UserService.js";
export default {
  data() {
    return {
      currentChoices: "",
      thema: {
        food: { state: false, name: "맛집" },
        family: { state: false, name: "가족" },
        date: { state: false, name: "데이트" },
        shopping: { state: false, name: "쇼핑" },
        culture: { state: false, name: "문화" },
        indoor: { state: false, name: "실내" },
        healing: { state: false, name: "힐링" },
        tradition: { state: false, name: "전통" }
      },
      onEditReceive: false,
      readOnly: true,
      onInterestEdit: false,
      submitted: false,
      tab: "info",
      followTab: "follower",
      likeTab: "post"
    };
  },
  computed: {
    emailForLoginAfterUpdate() {
      return this.user.mem_email;
    },
    ...mapState({
      user: state => state.user.user // 현재 접속자
    }),
    follower() {
      return this.$store.state.user.follower;
    },
    following() {
      return this.$store.state.user.following;
    },
    likePost() {
      return this.$store.state.user.likePost;
    },
    likeHot() {
      return this.$store.state.user.likeHot;
    },
    likeFesta() {
      return this.$store.state.user.likeFesta;
    }
  },
  methods: {
    onToggle() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      console.log("###### onToggle 눌림 ######", this.currentChoices);
      this.user.mem_interest = this.currentChoices;
      console.log(this.user.mem_interest);
    },
    updateUser() {
      UserService.updateUser(this.user).then(res => {
        console.log("업데이트 유저 실행됨");
        console.log(res);
        console.log(this.user.mem_interest);
      });
    },
    getPastInterest() {
      const pastChoice = this.user.mem_interest;
      console.log("과거 초이스", pastChoice);
      if (pastChoice !== "undefined") {
        const tempInterest = pastChoice.split(" ");
        for (let key in tempInterest) {
          for (let themaKey in this.thema) {
            if (this.thema[themaKey].name === tempInterest[key]) {
              this.thema[themaKey].state = true;
            }
          }
        }
      }
    }
  },
  mounted() {
    console.log("========= mypage mounted =======");
    console.log(this.user);
    console.log(this.user.mem_interest);
    this.getPastInterest();
    this.$store.dispatch("user/getFollower", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getFollowing", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getLikePost", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getLikeHot", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getLikeFesta", {
      userNo: this.$store.state.user.user.mem_no
    });
  }
};
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  max-width: 450px
</style>
