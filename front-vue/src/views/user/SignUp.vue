<template>
  <div class="row justify-center">
    <div class="col-12" style="height: 65px; background: #f9f9f9;"></div>
    <q-card class="col-xs-12 col-md-4 my-card card-top-margin" flat>
      <q-card-section>
        <div class="text-h6 text-weight-bold text-center">
          <span class="travel">Travel</span>
          <span class="bridge">Bridge</span>
          회원가입
        </div>
      </q-card-section>

      <q-card-section align="center">
        <!-- 입력할 필드들 -->
        <template v-if="email !=''">
          <q-input
            outlined
            flat
            v-model="email"
            type="email"
            :rules="emailRules"
            lazy-rules
            readonly
            label="이메일 주소"
          />
        </template>
        <template v-else>
          <q-input
            outlined
            flat
            v-model="user.mem_email"
            type="email"
            :rules="emailRules"
            lazy-rules
            v-bind:readonly="isReadOnly"
            label="이메일 주소"
          />
        </template>
        <q-radio v-model="user.mem_receive_email" val="true" label="Email 수신에 동의합니다" />
        <q-radio v-model="user.mem_receive_email" val="false" label="Email 수신에 동의하지 않습니다 " />
        <q-separator inset></q-separator>
      </q-card-section>
      <q-card-section>
        <q-input
          clearable
          clear-icon="close"
          outlined
          hint
          v-model="user.mem_id"
          type="string"
          label="ID"
        />
        <template v-if="email ==''">
          <q-input
            clearable
            clear-icon="close"
            outlined
            v-model="user.mem_password"
            label="비밀번호"
            :type="isPwd ? 'password' : 'text'"
            hint
            v-bind:readonly="isReadOnly"
          />
        </template>
        <q-input
          outlined
          hint
          v-model="user.mem_phone"
          mask="### - #### - ####"
          type="tel"
          label="전화번호"
          placeholder="숫자만 입력하세요"
        />
        <q-input
          outlined
          hint
          v-model="user.mem_name"
          label="이름"
          placeholder="예: 홍길동"
          type="string"
        />

        <q-input
          outlined
          hint
          v-model="user.mem_birth"
          label="생년월일"
          placeholder="YYYY/MM/DD"
          mask="date"
          :rules="['date']"
        >
          <template v-slot:after>
            <q-icon name="event" class="cursor-pointer">
              <q-popup-proxy ref="qDateProxy" transition-show="scale" transition-hide="scale">
                <q-date v-model="user.mem_birth" @input="() => $refs.qDateProxy.hide()" />
              </q-popup-proxy>
            </q-icon>
          </template>
        </q-input>

        <div align="center">
          <q-radio v-model="user.mem_sex" val="0" label="Male" />
          <q-radio v-model="user.mem_sex" val="1" label="Female" />
        </div>
      </q-card-section>

      <q-card-section align="center" class="col inline q-px-xl q-mx-lg">
        <div class="row" style="display: inline" v-for="(item, idx) in thema" :key="idx">
          <q-btn
            color="grey"
            rounded
            class="q-pa-xs q-ma-xs"
            size="md"
            v-if="item.state"
            @click="
              item.state = !item.state;
              onThemaChoice();
            "
          >#{{ item.name }}</q-btn>
          <q-btn
            color="grey"
            rounded
            class="q-pa-xs q-ma-xs"
            size="md"
            v-if="!item.state"
            outline
            @click="
              item.state = !item.state;
              onThemaChoice();
            "
          >#{{ item.name }}</q-btn>
        </div>
      </q-card-section>
      <q-card-section>
        <q-btn
          class="full-width q-mb-sm"
          size="md"
          style="height: 50px"
          color="black"
          outline
          label="회원가입"
          v-on:click="SignUp()"
        ></q-btn>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  data: () => ({
    date: "2020/01/01",
    currentChoices: "",
    thema: {
      food: { state: false, name: "맛집 " },
      family: { state: false, name: "가족 " },
      date: { state: false, name: "데이트 " },
      shopping: { state: false, name: "쇼핑 " },
      culture: { state: false, name: "문화 " },
      indoor: { state: false, name: "실내 " },
      healing: { state: false, name: "힐링 " },
      tradition: { state: false, name: "전통 " }
    },
    themaKor: {
      food: "맛집 ",
      family: "가족 ",
      date: "데이트 ",
      shopping: "쇼핑 ",
      culture: "문화 ",
      indoor: "실내 ",
      healing: "힐링 ",
      tradition: "전통 "
    },
    isPwd: true,
    user: {
      mem_id: "",
      mem_email: "",
      mem_name: "",
      mem_phone: "",
      mem_sex: null,
      mem_birth: null,
      mem_address: null,
      mem_grant: 0,
      mem_receive_email: true,
      mem_interest: "",
      mem_login_type: 0, // 기본 로그인
      mem_password: ""
    },
    isReadOnly: false,
    isCheckSns: false,
    nameRules: [
      v => !!v || "Name is required",
      v => (v && v.length <= 10) || "Name must be less than 10 characters"
    ],
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ]
  }),
  computed: {
    email() {
      return this.$store.state.user.tempEmail;
    }
  },

  methods: {
    SignUp() {
      this.user.mem_interest = this.currentChoices;
      // console.log(this.user.mem_birth)
      let x = true;
      if (this.email != "") {
        this.user.mem_email = this.email;
        x = false;
      }
      this.$store.dispatch("user/postSignUp", { user: this.user, status: x });
    },
    cancle() {
      alert("회원가입을 취소 하셨습니다.");
      this.$router.push("/login");
    },
    onThemaChoice() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += this.themaKor[key];
        }
      }
      console.log("signup에서 테마 선택: ", this.currentChoices);
    },
    clearUserForm() {
      this.user = {
        mem_id: "",
        mem_email: "",
        mem_name: "",
        mem_phone: "",
        mem_sex: null,
        mem_birth: null,
        mem_address: "",
        mem_grant: 0,
        mem_receive_email: true,
        mem_interest: "",
        mem_login_type: 0, // 기본 로그인
        mem_password: ""
      };
    },
    clearChoice() {
      this.thema = {
        food: { state: false, name: "맛집 " },
        family: { state: false, name: "가족 " },
        date: { state: false, name: "데이트 " },
        shopping: { state: false, name: "쇼핑 " },
        culture: { state: false, name: "문화 " },
        indoor: { state: false, name: "실내 " },
        healing: { state: false, name: "힐링 " },
        tradition: { state: false, name: "전통 " }
      };
    }
  }
};
</script>

<style>
.title {
  text-align: center;
  font-weight: bold;
}

.my-card {
  width: 100%;
  max-width: 350px;
}

.card-top-margin {
  margin-top: 70px;
  margin-bottom: 70px;
}
</style>
