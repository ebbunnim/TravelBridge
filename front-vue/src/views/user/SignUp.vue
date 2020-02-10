<template>
  <div class="text-center">
    <div>
      <p class="text-h4 q-pt-lg q-mt-lg">회원가입</p>
      <div class="row justify-center">
        <div class="col-5">
          <div class="row q-my-none">
            <q-input
              clearable
              clear-icon="close"
              filled
              class="q-ma-lg col-5"
              v-model="user.mem_id"
              type="string"
              label="ID를 입력하세요"
              stack-label
            />
            <q-input
              filled
              v-model="user.mem_name"
              label="이름을 입력하세요"
              class="q-ma-lg col-5"
              type="string"
              stack-label
            />
          </div>
          <q-input
            clearable
            clear-icon="close"
            v-model="user.mem_email"
            class="q-ma-lg q-pb-none"
            filled
            :rules="emailRules"
            lazy-rules
            type="email"
            label="Email을 입력하세요"
            v-bind:readonly="isReadOnly"
            stack-label
          />
          <div class="row justify-center q-pt-none">
            <q-radio v-model="user.mem_receive_email" val="true" label="Email 수신에 동의합니다" />
            <q-radio v-model="user.mem_receive_email" val="false" label="Email 수신에 동의하지 않습니다 " />
          </div>
          <q-input
            v-model="user.mem_password"
            class="q-ma-lg"
            filled
            label="Password를 입력하세요"
            :type="isPwd ? 'password' : 'text'"
            hint="Password with toggle"
            v-bind:readonly="isReadOnly"
            stack-label
          />
          <q-input
            v-model="user.mem_phone"
            class="q-ma-lg"
            filled
            type="tel"
            label="전화번호를 입력하세요"
            stack-label
          />
          <q-input
            filled
            v-model="user.mem_address"
            label="주소를 입력하세요"
            class="q-ma-lg"
            type="string"
            stack-label
          />
          <div class="row justify-left">
            <q-input
              v-model="user.mem_birth"
              filled
              type="date"
              label="생년월일을 입력하세요"
              class="q-ma-lg col-6"
              stack-label
            ></q-input>
            <q-radio v-model="user.mem_sex" val="0" label="Male" />
            <q-radio v-model="user.mem_sex" val="1" label="Female" />
          </div>

          <div class="row justify-center q-pt-none">
            <q-checkbox dense v-model="choice.food" label="음식" />
            <q-checkbox dense v-model="choice.leisuresport" label="레포츠" />
            <q-checkbox dense v-model="choice.shopping" label="쇼핑" />
            <q-checkbox dense v-model="choice.culture" label="문화시설" />
            <q-checkbox dense v-model="choice.history" label="역사" />
            <q-checkbox dense v-model="choice.inside" label="실내여행지" />
            <q-checkbox dense v-model="choice.nature" label="자연" />
            <q-checkbox dense v-model="choice.tourplace" label="관광지" />
            <q-checkbox dense v-model="choice.experience" label="체험" />
          </div>

          <q-btn
            color="primary"
            size="large"
            width="100%"
            label="회원가입"
            v-on:click="SignUp()"
            class="q-ma-md"
          />
          <q-btn
            size="large"
            outline
            color="primary"
            width="100%"
            label="취소"
            class="q-ma-md"
            v-on:click="cancle()"
          ></q-btn>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isSNS: {
      type: String,
      default: ""
    }
  },
  data: () => ({
    choice: {
      food: false,
      leisuresport: false,
      shopping: false,
      culture: false,
      history: false,
      inside: false,
      nature: false,
      tourplace: false,
      experience: false
    },
    choiceChange: {
      food: "#음식",
      leisuresport: "#레포츠",
      shopping: "#쇼핑",
      culture: "#문화시설",
      history: "#역사",
      inside: "#실내여행지",
      nature: "#자연",
      tourplace: "#관광지",
      experience: "#체험"
    },
    isPwd: true,
    user: {
      mem_email: "",
      mem_name: "",
      password: "",
      mem_id: "",
      mem_phone: "",
      mem_birth: null,
      mem_sex: null,
      mem_interest: "",
      mem_address: null
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

  methods: {
    SignUp() {
      const choice = this.choice;
      for (let key in choice) {
        if (choice[key] === true) {
          this.user.mem_interest += this.choiceChange[key];
        }
      }
      console.log("나와서", this.user.mem_interest);
      this.$store.dispatch("user/postSignUp", this.user);
      console.log(this.user);
      this.clearUserForm();
      this.clearChoice();
      console.log("청소 후", this.user);
    },
    cancle() {
      alert("회원가입을 취소 하셨습니다.");
      this.$router.push("/login");
    },
    clearUserForm() {
      this.user = {
        mem_email: "",
        password: "",
        mem_id: "",
        mem_phone: "",
        mem_name: "",
        mem_birth: null,
        mem_sex: null,
        mem_interest: "",
        mem_address: null
      };
    },
    clearChoice() {
      this.choice = {
        food: false,
        leisuresport: false,
        shopping: false,
        culture: false,
        history: false,
        inside: false,
        nature: false,
        tourplace: false,
        experience: false
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
</style>
