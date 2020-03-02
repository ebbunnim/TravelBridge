<template>
  <div class="row justify-center">
    <div class="col-12" style="height: 65px; background: #f9f9f9;"></div>
    <q-card class="col-xs-12 col-md-4 my-card card-top-margin" flat>
      <q-card-section>
        <div class="text-h6 text-weight-bold text-center">
          <span class="travel">Travel</span>
          <span class="bridge">Bridge</span>
          로그인
        </div>
      </q-card-section>

      <q-card-section>
        <!-- email input -->
        <q-input
          outlined
          filled
          class="q-mb-sm"
          :rules="emailRules"
          v-model="email"
          type="text"
          placeholder="이메일을 입력하세요"
          lazy-rules
        >
          <template v-slot:prepend>
            <q-icon name="email" />
          </template>
        </q-input>
        <!-- password input-->
        <q-input
          filled
          v-model="password"
          :type="isPwd ? 'password' : 'text'"
          hint="Password with toggle"
          placeholder="패스워드를 입력하세요"
        >
          <template v-slot:prepend>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>
      </q-card-section>

      <q-card-section>
        <q-btn
          class="full-width q-mb-sm"
          size="md"
          style="height: 50px"
          color="black"
          outline
          label="로그인"
          v-on:click="DefaultLogin()"
        ></q-btn>
        <a href="/passwordfind">
          <p class="text text-center">비밀번호를 잊으셨나요?</p>
        </a>
      </q-card-section>

      <q-separator inset></q-separator>

      <q-card-section>
        <!-- <div class="text-center q-my-sm">
          <q-btn
            size="md"
            style="height: 50px"
            class="full-width"
            outline
            v-on:click="NaverLogin()"
            label="네이버 아이디로 로그인 (초록색에 흰색)"
          />
        </div>-->
        <div class="text-center q-my-sm">
          <q-btn
            icon="img:https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png"
            size="md"
            style="height: 50px"
            class="full-width"
            outline
            v-on:click="GoogleLogin()"
            label="구글 아이디로 로그인"
          />
        </div>
        <div class="text-cente q-my-sm">
          <q-btn
            icon="img:https://image.flaticon.com/icons/svg/25/25231.svg"
            size="md"
            style="height: 50px"
            class="full-width"
            outline
            v-on:click="GithubLogin()"
            label="깃허브 아이디로 로그인"
          />
        </div>
      </q-card-section>
      <q-separator inset></q-separator>
      <q-card-section>
        <p class="text-body2 text text-center">
          TravelBridge 회원이 아닌가요?
          <a class="text" href="/signup">지금 가입하세요</a>
        </p>
      </q-card-section>
    </q-card>
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
    GoogleLogin() {
      this.$store.dispatch("user/postGoogleLogIn", {
        user_email: this.email,
        user_pw: this.password
      });
      this.$trouter.push("/");
    },
    GithubLogin() {
      this.$store.dispatch("user/postGitHubLogIn", {
        user_email: this.email,
        user_pw: this.password
      });
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

<style>
.my-card {
  width: 100%;
  max-width: 450px;
}

.text {
  color: navy;
  font-weight: bold;
}

a {
  text-decoration: none;
}

p a {
  text-decoration: none;
}

.card-top-margin {
  margin-top: 70px;
  margin-bottom: 70px;
}
</style>
