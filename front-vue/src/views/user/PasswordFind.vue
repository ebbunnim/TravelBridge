<template>
  <div class="row justify-center div-margin">
    <div class="col-12" style="height: 65px; background: #f9f9f9;"></div>
    <q-card class="col-xs-12 col-md-4 my-card card-top-margin" flat>
      <q-card-section>
        <div class="text-h6 text-weight-bold text-center">
          <span class="travel">Travel</span>
          <span class="bridge">Bridge</span>
          비밀번호 찾기
        </div>
      </q-card-section>

      <q-card-section>
        <div class="text-body2">이메일을 통해 비밀번호을 재설정 하세요</div>
        <q-input
          filled
          v-model="email"
          type="email"
          placeholder="이메일 주소를 입력하세요"
          class="q-my-sm"
          :rules="[val => val.includes('@') || '이메일 형식에 맞게 입력하세요']"
          lazy-rules
        >
          <template v-slot:prepend>
            <q-icon name="email" />
          </template>
        </q-input>
      </q-card-section>

      <q-card-section>
        <q-btn
          class="full-width q-ma-sm"
          size="md"
          style="height: 50px"
          color="grey"
          outline
          type="submit"
          label="이메일 전송"
          v-on:click="reset()"
        ></q-btn>
        <q-separator inset></q-separator>
        <p class="text-body2 text text-center q-mt-md">
          <a class="text" href="/login">로그인 페이지로 돌아가기</a>
        </p>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: null
    };
  },
  methods: {
    reset() {
      this.$store.dispatch("user/changeDeafultPw", { email: this.email });
    }
  }
};
</script>

<style>
.bg {
  margin-left: 30%;
  margin-right: 30%;
  width: 40%;
}

.my-card {
  width: 100%;
  max-width: 450px;
}

a {
  text-decoration: none;
}

p a {
  text-decoration: none;
}

.card-top-margin {
  margin-top: 150px;
  margin-bottom: 150px;
}

.div-margin {
  margin-bottom: 120px;
}
</style>
