<template>
  <div class="text-center">
    <p class="text-h4 q-pt-lg q-mt-lg">로그인</p>
    <div class="q-pa-md justify-center">
      <div class="text-center">
        <q-form>
          <!-- email input -->
          <q-input
            filled
            :rules="emailRules"
            v-model="email"
            type="text"
            class="q-pa-md display: block"
            placeholder="이메일을 입력하세요"
          >
            <template v-slot:prepend>
              <q-icon name="perm_identity" />
            </template>
          </q-input>
          <!-- password input-->
          <q-input
            filled
            v-model="password"
            :type="isPwd ? 'password' : 'text'"
            hint="Password with toggle"
            placeholder="패스워드를 입력하세요"
            class="q-pa-md display: block"
          >
            <template v-slot:prepend>
              <q-icon
                :name="isPwd ? 'visibility_off' : 'visibility'"
                class="cursor-pointer"
                @click="isPwd = !isPwd"
              />
            </template>
          </q-input>
          <div class="col-2 text-center">
            <div class="q-pt-lg">
              <q-btn
                color="primary"
                size="large"
                width="100%"
                label="로그인"
                class="inline-block q-mr-md"
                v-on:click="DefaultLogin()"
              />
              <q-btn
                size="large"
                outline
                color="primary"
                width="100%"
                label="회원가입"
                class="display: inline q-ml-md"
                to="/signup"
              ></q-btn>
            </div>
          </div>
          <div class="col-2 text-center">
            <q-btn
              dark
              v-on:click="NaverLogin()"
              style="width:30%;     height: 60px; margin-top:10px;"
              label="네이버 아이디로 로그인 (초록색에 흰색)"
            />
          </div>
          <div class="col-2 text-center">
            <q-btn
              dark
              v-on:click="GoogleLogin()"
              style="width:30%;     height: 60px; margin-top:10px;"
              label="구글 아이디로 로그인(파란에 흰색)"
            />
          </div>
          <div class="col-2 text-center">
            <q-btn
              dark
              v-on:click="GithubLogin()"
              style="width:30%;     height: 60px; margin-top:10px;"
              label="깃허브 아이디로 로그인(흑백 반전)"
            />
          </div>
        </q-form>
      </div>
    </div>
    <div class="row q-pa-md justify-center">
      <p>비밀번호가 기억나지 않는다면?</p>

      <p class="q-ml-sm q-mr-none">
        <a href="/passwordfind">비밀번호 찾기</a> 를 이용하세요
      </p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: "",
      isPwd: true,

      rules: {
        required: value => !!value || "Password is required."
      },
      emailRules: [
        v => !!v || "E-mail is required",
        v => /.+@.+\..+/.test(v) || "E-mail must be valid"
      ]
    };
  },
  methods: {
    DefaultLogin() {
      this.$store.dispatch("user/postLogIn", {
        user_email: this.email,
        user_pw: this.password
      });
    },
    NaverLogin() {
      this.$store.dispatch("user/check");
      this.SNSLoginCheck(false);
    },
    GoogleLogin() {
      this.SNSLoginCheck(false);
    },
    GithubLogin() {
      this.SNSLoginCheck(false);
    },
    SNSLoginCheck(check) {
      if (check) {
        alert("SNS 로그인 성공");
      } else {
        if (confirm("등록된 ")) {
          alert("ok");
        } else {
          alert("false");
        }
      }
    }
  }
};
</script>

<style></style>
