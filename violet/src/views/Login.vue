<template>
  <div class="text-center">
    <h3>Login</h3>
    <div class="q-pa-md display: inline-block">
      <div class="q-gutter-y-md column" style="width: 350px">
        <!-- email input -->
        <q-input filled v-model="email" type="email" prefix="Email:" suffix="@gmail.com">
          <template v-slot:prepend>
            <q-icon name="mail" />
          </template>
        </q-input>
        <!-- password input-->
        <q-input
          filled
          v-model="password"
          :type="isPwd ? 'password' : 'text'"
          hint="Password with toggle"
          prefix="Password:"
        >
          <template v-slot:prepend>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>
        <!-- submit btn -->
        <q-btn>LogIn</q-btn>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      password: "",
      isPwd: true,

      email: "",
      search: "",
      tel: "",
      url: "",
      time: "",
      date: ""
    };
  }
};
</script>

<style>
</style>