<template>
  <q-page padding="">
    <div>
      <h2>검색 컴포넌트다</h2>
      <q-input v-model="search" type="search" hint="Search">
        <template v-slot:prepend>
          <q-icon name="search" />
        </template>
        <template v-slot:append>
          <q-btn outline color="primary" label="SEARCH" @click="onSearchBtn(event.target.value)"/>
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
    onSearchBtn() {
      console.log(event.target.value)
    }
  }
};
</script>

<style></style>
