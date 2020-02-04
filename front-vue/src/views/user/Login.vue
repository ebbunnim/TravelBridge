<template>
  <div class="text-center">
    <p class="text-h4 q-pt-lg q-mt-lg">로그인</p>
    <div class="row q-pa-md justify-center">
      <div class="col-4 col-8 col-xs-12 text-center">
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
                type="submit"
                class="inline-block q-mr-md"
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

          <!-- submit btn -->
        </q-form>
      </div>
    </div>
    <div class="row q-pa-md justify-center">
      <p>비밀번호가 기억나지 않는다면?</p>
      <!-- <q-btn
        label="비밀번호 찾기"
        size="small"
        type="reset"
        color="primary"
        flat
        to="/passwordfind"
        class="q-ma-xs q-pa-xs"
      /> -->
      <p class="q-ml-sm q-mr-none"><a href="/passwordfind">비밀번호 찾기</a> 를 이용하세요</p>
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

      // input rules
      rules: {
        required: value => !!value || "Password is required."
      },
      emailRules: [
        v => !!v || "E-mail is required",
        v => /.+@.+\..+/.test(v) || "E-mail must be valid"
      ]
    };
  },
  methods: {}
};
</script>

<style></style>
