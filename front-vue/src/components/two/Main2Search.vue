<template>
  <q-page padding="">
    <div class="row justify-center q-my-xl q-py-xl">
      <q-input
        align="center"
        class="col-xs-12 col-lg-6 self-center"
        v-model="search"
        type="search"
        @input="onInput()"
      >
        <template v-slot:prepend>
          <q-icon name="search" />
        </template>
        <template v-slot:after>
          <q-btn outline color="grey" label="SEARCH" @click="onSearchBtn()" />
        </template>
      </q-input>
    </div>
  </q-page>
</template>

<script>
export default {
  data() {
    return {
      search: ""
    };
  },
  methods: {
    onInput() {
      // console.log(this.search)
    },
    onSearchBtn() {
      console.log(this.search);
    }
  }
};
</script>

<style></style>
