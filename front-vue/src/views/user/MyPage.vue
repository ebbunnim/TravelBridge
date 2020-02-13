<template>
  <div class="text-center">
    <h4>마이 페이지</h4>
    <div class="q-pa-md">
      <div style="max-width: 70%; margin: 0 15% 0 15%">
        <!-- card start -->
        <q-card>
          <q-tabs
            v-model="tab"
            class="text-grey"
            active-color="primary"
            indicator-color="primary"
            align="justify"
          >
            <q-tab name="activity" label="내 활동" />
            <q-tab name="info" label="내 정보" />
            <q-tab name="etc" label="etc" />
          </q-tabs>

          <q-tab-panels v-model="tab">
            <q-tab-panel name="activity" style="height:900px">
              <div class="text-h6">내 활동</div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
            </q-tab-panel>

            <q-tab-panel name="info" style="font-size:20px">
              <!-- 수정 불가능 -->
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>이메일 :</span>
                </div>
                <q-input
                  v-model="user.mem_email"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>
              <!-- 수정 가능한 필드 -->
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>이메일 수신 여부 :</span>
                </div>
                <q-input
                  v-model="user.mem_receive_email"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  readonly
                  v-show="!onEditReceive"
                />

                <div
                  v-show="onEditReceive"
                  class="col-6 q-my-sm q-mr-xs q-ml-sm"
                  align="left"
                >
                  <q-radio
                    v-model="user.mem_receive_email"
                    val="true"
                    label="Email 수신에 동의합니다"
                  />
                  <q-radio
                    v-model="user.mem_receive_email"
                    val="false"
                    label="Email 수신에 동의하지 않습니다 "
                  />
                </div>
              </div>

              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>아이디 :</span>
                </div>
                <q-input
                  v-model="user.mem_id"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  v-bind="{ readonly: readOnly }"
                />
              </div>
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>전화번호 :</span>
                </div>
                <q-input
                  v-model="user.mem_phone"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  v-bind="{ readonly: readOnly }"
                />
              </div>

              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>이름 :</span>
                </div>
                <q-input
                  v-model="user.mem_name"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  v-bind="{ readonly: readOnly }"
                />
              </div>
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>생년월일 :</span>
                </div>
                <q-input
                  v-model="user.mem_birth"
                  type="date"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  v-bind="{ readonly: readOnly }"
                />
              </div>

              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>주소 :</span>
                </div>
                <q-input
                  v-model="user.mem_address"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  v-bind="{ readonly: readOnly }"
                />
              </div>
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>회원 등급 :</span>
                </div>
                <q-input
                  v-model="user.mem_grant"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>

              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>최근 로그인 :</span>
                </div>
                <q-input
                  v-model="user.mem_lastlogin"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>

              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>나의 관심사 :</span>
                </div>

                <q-input
                  v-model="user.mem_interest"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  v-show="!onInterestEdit"
                  readonly
                />

                <div
                  v-show="onInterestEdit"
                  class="row"
                  style="display: inline"
                  v-for="(item, idx) in thema"
                  :key="idx"
                >
                  <q-btn
                    color="grey"
                    unelevated
                    class="q-mb-sm q-mt-md q-px-xs"
                    size="md"
                    v-if="item.state"
                    @click="
                      item.state = !item.state;
                      onThemaChoice();
                    "
                    >{{ item.name }}</q-btn
                  >
                  <q-btn
                    color="grey"
                    size="md"
                    class="q-mb-sm q-mt-md q-px-xs"
                    v-if="!item.state"
                    bordered
                    flat
                    @click="
                      item.state = !item.state;
                      onThemaChoice();
                    "
                    >{{ item.name }}</q-btn
                  >
                </div>
              </div>

              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>팔로잉 :</span>
                </div>
                <q-input
                  v-model="user.mem_following"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>팔로워 :</span>
                </div>
                <q-input
                  v-model="user.mem_followed"
                  type="text"
                  class="col-5"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>

              <q-btn
                class="q-my-lg"
                label="수정하기"
                color="primary"
                icon="edit"
                v-if="!submitted"
                @click="
                  onEditReceive = !onEditReceive;
                  readOnly = !readOnly;
                  onInterestEdit = !onInterestEdit;
                  submitted = !submitted
                "
              />
              <q-btn
                class="q-my-lg"
                label="수정완료"
                color="info"
                icon="check"
                v-if="submitted"
                @click="updateUser()"
              />
            </q-tab-panel>

            <q-tab-panel name="etc">
              <div class="text-h6">etc</div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
            </q-tab-panel>
          </q-tab-panels>
        </q-card>
        <!-- card end -->
      </div>
    </div>
  </div>
</template>

<script>
import UserService from "@/services/UserService.js";

export default {
  data() {
    return {
      currentChoices: "",
      thema: {
        food: { state: false, name: "#맛집 " },
        family: { state: false, name: "#가족 " },
        date: { state: false, name: "#데이트 " },
        shopping: { state: false, name: "#쇼핑 " },
        culture: { state: false, name: "#문화 " },
        indoor: { state: false, name: "#실내 " },
        healing: { state: false, name: "#힐링 " },
        tradition: { state: false, name: "#전통 " }
      },
      themaKor: {
        food: "#맛집 ",
        family: "#가족 ",
        date: "#데이트 ",
        shopping: "#쇼핑 ",
        culture: "#문화 ",
        indoor: "#실내 ",
        healing: "#힐링 ",
        tradition: "#전통 "
      },

      readOnly: true,
      onInterestEdit: false,
      onEditReceive: false,
      submitted: false,
      user: {}, // created 하면서 받아옴
      tab: "info"
    };
  },
  computed: {
    emailForLoginAfterUpdate() {
      return this.user.mem_email;
    }
  },
  methods: {
    onThemaChoice() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += this.themaKor[key];
        }
      }
      console.log(this.currentChoices);
      this.user.mem_interest = this.currentChoices
    },
    updateUser() {
      UserService.updateUser(this.user).then(res => {
        console.log(res);
        UserService.LogIn(this.emailForLoginAfterUpdate).then(response =>
          console.log(response)
        );
      });
      this.readOnly = true
      this.onInterestEdit = false
      this.onEditReceive = false
      this.submitted = false
    }
  },
  created() {
    this.user = this.$store.state.user.user;
  }
};
</script>

<style></style>
