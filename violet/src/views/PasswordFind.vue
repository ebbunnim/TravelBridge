<template>
  <div class="text-center">
    <!-- <h3>Login</h3> -->
    <div class="q-pa-md display: inline-block">
      <div class="q-gutter-y-md column" max-width="450px">
        <q-form>
          <!-- email input -->
          <q-input filled v-model="id" type="text" prefix="ID : " class="q-pa-md display: block">
            <template v-slot:prepend>
              <q-icon name="perm_identity" />
            </template>
          </q-input>
          <!-- submit btn -->
          <div class="q-pt-lg">
            <q-btn label="RESET PASSWORD" type="submit" color="primary" flat />
          </div>
        </q-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>