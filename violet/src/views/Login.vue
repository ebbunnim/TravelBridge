<template>
  <div class="text-center">
    <h3>Login</h3>
    <div class="q-pa-md display: inline-block">
      <div class="q-gutter-y-md column" max-width="450px">
        <q-form>
          <!-- email input -->
          <q-input filled v-model="id" type="text" prefix="ID : " class="q-pa-md display: block">
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
            prefix="Password : "
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
          <!-- submit btn -->
          <div class="q-pt-lg">
            <q-btn
              label="SIGN UP"
              color="primary"
              flat
              class="q-ml-sm display: inline"
              to="/signup"
            ></q-btn>
            <q-btn label="LOGIN" type="submit" color="primary" flat />
            <q-btn
              label="FIND PASSWORD"
              type="reset"
              color="primary"
              flat
              class="q-ml-sm"
              to="/passwordfind"
            />
          </div>
        </q-form>
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

      id: "",
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