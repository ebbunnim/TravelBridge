<template>
  <div align="center">
    <h1>main1. search</h1>
    <!-- <q-input v-model="text" type="text" label="Label" /> -->
    <div class="row justify-center" align="center">
      <!-- <q-btn color="primary" icon="check" label="OK" @click="onClick" />
      <q-btn color="primary" icon="check" label="OK" @click="onClick" />
      <q-btn color="primary" icon="check" label="OK" @click="onClick" />
      <q-btn color="primary" icon="check" label="OK" @click="onClick" />
      <q-btn color="primary" icon="check" label="OK" @click="onClick" />
      <q-btn color="primary" icon="check" label="OK" @click="onClick" />
      <q-btn color="primary" icon="check" label="OK" @click="onClick" />-->
    </div>
    <q-separator spaced inset vertical dark />
    <div v-for="(tta,index) in this.titles" :key="index" class="row">
      <h3>{{index}}</h3>
      <div v-for="(tt,index) in tta" :key="index">{{tt}}</div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      postList: [
        1,
        1,
        1,
        1,
        1,
        1,
        2,
        1,
        1,
        1,
        2,
        1,
        2,
        2,
        2,
        1,
        1,
        2,
        1,
        2,
        2,
        2
      ]
    };
  },
  computed: {
    titles: function() {
      var titles = [];
      var cnt = 0;
      var ti = [];

      for (var i of this.postList) {
        if (i == 1) cnt = cnt + 1;
        else if (i == 2) cnt = cnt + 2;

        if (cnt == 4) {
          ti.push(i);
          titles.push(ti);
          ti = [];
          cnt = 0;
        } else if (cnt > 4) {
          ti.push(3);
          titles.push(ti);
          ti = [];
          cnt = 2;
          ti.push(i);
        } else if (cnt < 4) {
          ti.push(i);
        }
      }

      return titles;
    }
  }
};
</script>

<style>
</style>