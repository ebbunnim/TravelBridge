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
            <div class="text-h6">내 활동</div>Lorem ipsum dolor sit amet consectetur adipisicing elit.
          </q-tab-panel>

          <q-tab-panel name="plan" style="height:900px">
            <div class="row" style="margin-bottom:15px;">
              <q-editor v-model="postEditor" min-height="20rem" max-height="25rem" class="col-8" />
              <ImgUpLoader class="col-3" style="margin-left:20px;"></ImgUpLoader>
            </div>
            <p>카드 입력</p>
            <div class="row">
              <q-card class="my-card" style="width:25%; max-height:300px;">
                <q-card-section row>
                  <div class="row text-h6 q-mb-xs justify-between">
                    <span>2017-12-12</span>
                    <q-btn icon="delete"></q-btn>
                  </div>
                </q-card-section>
                <q-scroll-area style="width:100%;height:100%;">
                  <q-list>
                    <q-item clickable>
                      <q-item-section avatar>
                        <q-icon color="primary" name="local_bar" />
                      </q-item-section>

                      <q-item-section>
                        <q-item-label>Bar XYZ</q-item-label>
                        <q-item-label caption>Have a drink.</q-item-label>
                      </q-item-section>
                    </q-item>

                    <q-item clickable>
                      <q-item-section avatar>
                        <q-icon color="amber" name="local_movies" />
                      </q-item-section>

                      <q-item-section>
                        <q-item-label>Cinema XYZ</q-item-label>
                        <q-item-label caption>Watch a movie.</q-item-label>
                      </q-item-section>
                    </q-item>
                    <q-item clickable>
                      <q-item-section>
                        <q-item-label>일정 추가하기</q-item-label>
                      </q-item-section>
                      <q-item-section avatar>
                        <q-icon color="amber" name="local_movies" />
                      </q-item-section>ㄴ
                    </q-item>
                  </q-list>
                </q-scroll-area>
              </q-card>
              <q-card class="my-card" style="width:25%; max-height:60px;">
                <q-item clickable style="width:100%; height:100%;">
                  <q-card-section row>
                    <div class="row text-h6 q-mb-xs justify-center">
                      <span>카드 추가하기</span>
                      <q-icon name="alarm_add" size="md" style="margin-left:10px" />
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

export default {
  data() {
    return {
      postEditor: "",
      planEditor: "",
      tab: "post",
      palnlist: {}
    };
  },
  components: {
    ImgUpLoader
  }
};
</script>

<style>
</style>