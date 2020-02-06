<template>
  <div class="text-center">
    <h3>Password Reset</h3>
    <p>Forgot your password? Enter your email in the form below and we'll send you instructions for creating a new one.</p>

    <div class="bg">
      <div class="q-pa-md q-ma-md display: inline">
        <div class="column">
          <q-form>
            <!-- email input -->
            <q-input
              filled
              v-model="email"
              type="text"
              placeholder="이메일 주소를 입력하세요."
              class="q-pa-md"
              :rules="[
              val => val.includes('@') || '이메일 형식에 맞게 입력하세요'
              ]"
              lazy-rules
            >
              <template v-slot:prepend>
                <q-icon name="email" />
              </template>
            </q-input>

            <!-- submit btn -->
            <div class="q-pt-lg">
              <q-btn label="SEND" type="submit" color="primary" flat />
            </div>
          </q-form>
        </div>
      </div>
    </div>
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
      this.$refs.input.resetValidation();
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