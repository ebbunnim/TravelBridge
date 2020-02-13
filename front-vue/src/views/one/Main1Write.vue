<template>
  <div>
    <h1>글쓰기</h1>
    <div style="max-width: 70%; margin: 0 15% 0 15%">
      <q-card>
        <q-tabs
          v-model="tab"
          dense
          class="text-grey"
          active-color="primary"
          indicator-color="primary"
          align="justify"
          narrow-indicator
        >
          <q-tab name="post" label="포스트 쓰기" />
          <q-tab name="plan" label="Plan 쓰기" />
        </q-tabs>

        <q-separator />

        <q-tab-panels v-model="tab" animated>
          <q-tab-panel name="post" style="height:900px">
            <div class="row" style="margin-bottom:15px;">
              <q-input class="col-8" type="text" label="제목" />
              <div class="row justify-around" style="margin-left:20px; width:30%;">
                <q-select
                  filled
                  v-model="model"
                  use-input
                  hide-selected
                  fill-input
                  input-debounce="0"
                  :options="options"
                  @filter="filterFn"
                  class="col-5"
                  label="지역"
                >
                  <template v-slot:no-option>
                    <q-item>
                      <q-item-section class="text-grey">No results</q-item-section>
                    </q-item>
                  </template>
                </q-select>
                <q-select
                  standout="bg-teal text-white"
                  bg-color="teal"
                  v-model="model2"
                  :options="options2"
                  label="도시"
                  class="col-5"
                />
              </div>
            </div>
            <div class="row" style="margin-bottom:15px;">tag</div>
            <div class="row" style="margin-bottom:15px;">
              <q-editor v-model="postEditor" min-height="20rem" max-height="25rem" class="col-8" />
              <ImgUpLoader class="col-3" style="margin-left:20px;"></ImgUpLoader>
            </div>
          </q-tab-panel>

          <q-tab-panel name="plan" style="height:1200px">
            <div class="row" style="margin-bottom:15px;">
              <q-input class="col-8" type="text" label="제목" />
              <div class="row justify-around" style="margin-left:20px; width:30%;">
                <q-select
                  standout="bg-teal text-white"
                  bg-color="teal"
                  v-model="model1"
                  :options="options1"
                  label="지역"
                  class="col-5"
                />
                <q-select
                  standout="bg-teal text-white"
                  bg-color="teal"
                  v-model="model2"
                  :options="options2"
                  label="도시"
                  class="col-5"
                />
              </div>
            </div>
            <div class="row" style="margin-bottom:15px;">tag</div>
            <div class="row" style="margin-bottom:15px;">
              <q-editor v-model="postEditor" min-height="20rem" max-height="25rem" class="col-8" />
              <ImgUpLoader class="col-3" style="margin-left:20px;"></ImgUpLoader>
            </div>
            <p>카드 입력</p>
            <div class="row">
              <q-card
                flat
                bordered
                class="my-card"
                style="width:25%; max-height:400px; margin-right:10px;"
              >
                <q-card-section row>
                  <div class="row text-h6 q-mb-xs justify-between">
                    <span>2017-12-12</span>
                    <q-btn unelevated color="green" icon="delete"></q-btn>
                  </div>
                </q-card-section>
                <q-separator />
                <q-scroll-area style="width:100%;height:100%;">
                  <q-list>
                    <q-item>
                      <q-item-section>
                        <q-item-label>Cinema XYZ</q-item-label>
                        <q-item-label caption>Watch a movie.</q-item-label>
                      </q-item-section>
                      <q-item-section avatar>
                        <q-btn unelevated color="amber" icon="delete_forever" />
                      </q-item-section>
                    </q-item>

                    <q-item>
                      <q-item-section>
                        <q-item-label>Cinema XYZ</q-item-label>
                        <q-item-label caption>Watch a movie.</q-item-label>
                      </q-item-section>
                      <q-item-section avatar>
                        <q-btn unelevated color="amber" icon="delete_forever" />
                      </q-item-section>
                    </q-item>
                    <q-item>
                      <q-item-section>
                        <q-item-label>일정 추가하기</q-item-label>
                      </q-item-section>
                      <q-item-section avatar>
                        <q-btn unelevated color="amber" icon="add" />
                      </q-item-section>
                      <q-popup-edit v-model="label" content-class="bg-accent text-white">
                        <q-input dark color="white" v-model="label" dense autofocus counter>
                          <template v-slot:append>
                            <q-icon name="edit" />
                          </template>
                        </q-input>
                      </q-popup-edit>
                    </q-item>
                  </q-list>
                </q-scroll-area>
              </q-card>
              <q-card class="my-card" style="width:25%; max-height:60px; ">
                <q-item clickable style="width:100%; height:100%;">
                  <q-card-section row style="padding:8px 0px 0px 30px;">
                    <div class="row text-h6 q-mb-xs">
                      <p>카드 추가하기</p>
                      <!-- <q-icon name="alarm_add" size="md" style="margin-left:10px" /> -->
                      <!-- <q-icon name="note_add" size="md" 
                      style="margin-left:10px" />-->
                      <!-- <q-icon name="playlist_add" size="md" style="margin-left:10px" /> -->
                      <q-icon name="add" size="md" style="margin-left:10px" />

                      <q-popup-proxy
                        ref="qDateProxy"
                        transition-show="scale"
                        transition-hide="scale"
                      >
                        <q-date v-model="date" @input="() => $refs.qDateProxy.hide()" />
                      </q-popup-proxy>
                    </div>
                  </q-card-section>
                </q-item>
              </q-card>
            </div>
          </q-tab-panel>
        </q-tab-panels>
      </q-card>
    </div>
  </div>
</template>

<script>
import ImgUpLoader from "../../components/ImgUpLoader.vue";

const stringOptions = ["Google", "Facebook", "Twitter", "Apple", "Oracle"];
export default {
  data() {
    return {
      postEditor: "",
      planEditor: "",
      tab: "post",
      palnlist: {},
      label: "",
      model: null,
      options: stringOptions,
      model2: "도시",
      options2: ["Google", "Facebook", "Twitter", "Apple", "Oracle"]
    };
  },
  components: {
    ImgUpLoader
  },
  methods: {
    filterFn(val, update) {
      update(() => {
        const needle = val.toLowerCase();
        this.options = stringOptions.filter(
          v => v.toLowerCase().indexOf(needle) > -1
        );
      });
    }
  }
};
</script>

<style>
</style>