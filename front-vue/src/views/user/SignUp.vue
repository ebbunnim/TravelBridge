<template>
  <div class="text-center">
    <p class="text-h4 q-pt-lg q-mt-lg">회원가입</p>
    <div>
      <div class="row justify-center text-center">
        <div class="col-5">
          <div class="row q-my-none justify-even">
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
              v-model="user.mem_interest"
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
          <q-input
            v-model="user.password"
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
            >
            </q-input>
            <q-radio v-model="user.mem_sex" val="0" label="Male" />
            <q-radio v-model="user.mem_sex" val="1" label="Female" />
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
            class=" q-ma-md"
            v-on:click="cancle()"
          ></q-btn>

          <!-- 주소 -->
          <!-- 나의 관심사?  -->
        </div>

        <!-- <div class="col-2 text-center">
          <div class="q-pt-lg">
            <q-btn
              color="primary"
              size="large"
              width="100%"
              label="회원가입"
              v-on:click="SignUp()"
              class="inline-block q-mr-md"
            />
            <q-btn
              size="large"
              outline
              color="primary"
              width="100%"
              label="취소"
              class="display: inline q-ml-md"
              v-on:click="cancle()"
            ></q-btn>
          </div>
        </div> -->
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
    isPwd: true,
    user: {
      mem_email: "",
      password: "",
      mem_id: "",
      mem_phone: "",
      mem_name: "",
      mem_birth: null,
      mem_sex: null,
      mem_intertest: null,
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
  // mounted() {
  //   user() {
  //     if (this.props.isSNS != "") {
  //       alert("하이");
  //       return {};
  //     } else {
  //       this.isReadOnly = true;
  //       return this.$store.state.user;
  //     }
  //   }
  // },
  methods: {
    SignUp() {
      // object 자체를 action 에 넘긴다. 
      this.$store.dispatch("user/postSignUp", this.user);
      this.clearUserForm();
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
        mem_intertest: null,
        mem_address: null
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
