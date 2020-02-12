<template>
  <div class="row justify-center q-my-xl q-py-xl">
    <q-card class="col-4 my-card q-ma-md" flat bordered>
      <q-card-section>
        <div class="text-h6">비밀번호 찾기</div>
      </q-card-section>

      <q-card-section>
        <div class="text-body2">이메일을 통해 비밀번호을 재설정 하세요</div>
        <q-input
          filled
          v-model="email"
          type="email"
          placeholder="이메일 주소를 입력하세요"
          class="q-my-sm"
          :rules="[
                val => val.includes('@') || '이메일 형식에 맞게 입력하세요'
              ]"
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
          color="primary"
          outline
          type="submit"
          label="이메일 전송"
          v-on:click="reset()"
        ></q-btn>
      </q-card-section>

      <!-- submit btn -->
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
</style>
