<template>
  <div class="text-center">
    <h4>myPage</h4>
    <div class="q-pa-md">
      <div style="max-width: 70%; margin: 0 15% 0 15%">
        <q-card>
          <q-tabs
            v-model="tab"
            dense
            class="text-grey"
            active-color="primary"
            indicator-color="primary"
            align="justify"
            narrow-indicator
          >
            <q-tab name="activity" label="내 활동" />
            <q-tab name="info" label="내 정보" />
            <q-tab name="etc" label="etc" />
          </q-tabs>

          <q-separator />

          <q-tab-panels v-model="tab" animated>
            <q-tab-panel name="activity" style="height:900px">
              <div class="text-h6">내 활동</div>Lorem ipsum dolor sit amet consectetur adipisicing elit.
            </q-tab-panel>

            <q-tab-panel name="info" style="font-size:20px">
              <div class="text-h4">내정보</div>
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>아이디 :</span>
                </div>
                <q-input
                  v-model="user.mem_id"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>
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
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>전화번호 :</span>
                </div>
                <q-input
                  v-model="user.mem_phone"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
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
                />
              </div>
              <div class="row">
                <div class="col-3 self-center" style="text-align:right">
                  <span>생년월일 :</span>
                </div>
                <q-input
                  v-model="user.mem_birth"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
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
                  <span>이메일 수신 여부 :</span>
                </div>
                <q-input
                  v-model="user.mem_recive_email"
                  type="text"
                  class="col-6"
                  style="text-align:left; margin-left:10px"
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
                />
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
                  v-model="user.mem_followerd"
                  type="text"
                  class="col-5"
                  style="text-align:left; margin-left:10px"
                  readonly
                />
              </div>
            </q-tab-panel>

            <q-tab-panel name="etc">
              <div class="text-h6">etc</div>Lorem ipsum dolor sit amet consectetur adipisicing elit.
            </q-tab-panel>
          </q-tab-panels>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {},
      tab: "info"
    };
  },
  created() {
    this.user = this.$store.state.user.user;
  }
};
</script>

<style>
</style>