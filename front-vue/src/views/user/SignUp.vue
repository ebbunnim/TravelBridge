<template>
  <div class="row justify-center q-my-xl q-py-xl">
    <q-card class="col-4 my-card q-ma-md" flat bordered>
      <q-card-section>
        <div class="text-h6">회원가입</div>
      </q-card-section>

      <q-card-section align="center">
        <!-- 입력할 필드들 -->
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
          v-model="user.mem_address"
          label="주소"
          type="string"
        />

        <q-input outlined hint v-model="user.mem_birth" type="date" />
        <div align="center">
          <q-radio v-model="user.mem_sex" val="0" label="Male" />
          <q-radio v-model="user.mem_sex" val="1" label="Female" />
        </div>
      </q-card-section>

      <q-card-section align="center" class="col inline q-px-xl q-mx-lg">
        <div
          class="row"
          style="display: inline"
          v-for="(item, idx) in thema"
          :key="idx"
        >
          <q-btn
            color="grey"
            class="q-pa-xs q-ma-xs"
            size="md"
            v-if="item.state"
            @click="
              item.state = !item.state;
              onSubmit();
            "
            >{{ item.name }}</q-btn
          >
          <q-btn
            color="grey"
            class="q-pa-xs q-ma-xs"
            size="md"
            v-if="!item.state"
            outline
            @click="
              item.state = !item.state;
              onSubmit();
            "
            >{{ item.name }}</q-btn
          >
        </div>
      </q-card-section>
    </q-card>
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
    thema: {
      // 초기 상태를 회원 정보에 따라서 created 할 때 저장해 노해을 것
      // 그래서 pick 페이지에 들어오는 순간 / 이미 선택한 칸은 눌려있는 상태이다.
      food: { state: false, name: "#맛집 " },
      family: { state: false, name: "#가족 " },
      date: { state: false, name: "#데이트 " },
      shopping: { state: false, name: "#쇼핑 " },
      culture: { state: false, name: "#문화 " },
      indoor: { state: false, name: "#실내 " },
      healing: { state: false, name: "#힐링 " },
      tradition: { state: false, name: "#전통 " }
    },
    choiceChange: {
      food: "#맛집 ",
      family: "#가족 ",
      date: "#데이트 ",
      shopping: "#쇼핑 ",
      culture: "#문화 ",
      indoor: "#실내 ",
      healing: "#힐링 ",
      tradition: "#전통 "
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

.my-card {
  width: 100%;
  max-width: 350px;
}
</style>
