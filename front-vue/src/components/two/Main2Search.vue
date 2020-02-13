<template>
  <q-page class="page">
    <div class="row justify-center q-my-xl q-py-xl">
      <q-input
        align="center"
        class="col-12 self-center"
        v-model="search"
        type="search"
        placeholder="도시 이름을 검색하세요(예: 서울, 전주)"
      >
        <template v-slot:prepend>
          <q-icon name="search" />
        </template>
        <template v-slot:after>
          <q-btn outline color="grey" label="SEARCH" @click="onSearchBtn()" />
        </template>
      </q-input>
    </div>
    <div class="row">
      <div class="col-3" v-for="i in hp_list.length" :key="i">
        <HotPlaceCard
          :hp_name="hp_list[i - 1].hp_name"
          :hp_detail_adr="hp_list[i - 1].hp_detail_adr"
          :hp_tag="hp_list[i - 1].hp_tag"
        />
      </div>
    </div>
  </q-page>
</template>

<script>
// component
import HotPlaceCard from "@/components/two/HotPlaceCard.vue";
// api service
import FestivalService from "@/services/FestivalService";
import HotPlaceService from "@/services/HotplaceService";

export default {
  components: {
    HotPlaceCard
  },
  data() {
    return {
      search: null,
      hp_list: []
    };
  },
  methods: {
    onSearchBtn() {
      console.log(this.search);
      HotPlaceService.searchMoreHotPlaceByCityName(1, this.search);
    }
  }
};
</script>

<style></style>
