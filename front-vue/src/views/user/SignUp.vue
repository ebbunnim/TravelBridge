<template>
  <div class="text-center">
    <p class="text-h4 q-pt-lg q-mt-lg">회원가입</p>
    <div class="row q-pa-md justify-center">
      <div class="col-4 col-8 col-xs-12 text-center">
        <q-input
          v-model="email"
          filled
          type="email"
          hint="Email"
          v-bind:readonly="isReadOnly"
        />
        <q-input
          v-model="password"
          filled
          :type="isPwd ? 'password' : 'text'"
          hint="Password with toggle"
          v-bind:readonly="isReadOnly"
        >
          <template v-slot:append>
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
              label="회원가입"
              v-on:click="Signup()"
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
    isPwd: true,
    email: "",
    password: "",
    name: "",
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
  mounted: {
    user() {
      if (this.props.isSNS != "") {
        alert("하이");
        return {};
      } else {
        this.isReadOnly = true;
        return this.$store.state.user;
      }
    }
  },
  methods: {
    SignUp() {
      alert("hello");
    },
    cancle() {
      alert("회원가입을 취소 하셨습니다.");
      this.$router.push("/login");
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
