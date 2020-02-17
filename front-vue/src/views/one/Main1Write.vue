<template>
  <div>
    <div style="max-width: 70%; margin: 5% 15% 0 15%">
      <q-btn color="primary" icon="check" label="목록으로" />
      <p>기록하기</p>
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
              <div
                class="row justify-around"
                style="margin-left:20px; width:30%;"
              >
                <q-select
                  filled
                  v-model="v1"
                  use-input
                  hide-selected
                  fill-input
                  input-debounce="0"
                  @input="inner()"
                  :options="spin1"
                  class="col-5"
                  label="지역"
                >
                  <template v-slot:no-option>
                    <q-item>
                      <q-item-section class="text-grey"
                        >No results</q-item-section
                      >
                    </q-item>
                  </template>
                </q-select>
                <template>
                  <q-select
                    filled
                    v-model="v2"
                    label="도시"
                    :options="gangnam"
                    class="col-5"
                    behavior="menu"
                  />
                </template>
              </div>
            </div>
            <span>태그</span>
            <div
              style="display: inline"
              v-for="(item, idx) in thema"
              :key="idx"
            >
              <q-btn
                color="grey"
                class="q-ma-sm"
                size="xl"
                v-if="item.state"
                @click="
                  item.state = !item.state;
                  onToggle();
                "
                >{{ item.name }}</q-btn
              >
              <q-btn
                color="grey"
                class="q-ma-sm"
                size="xl"
                v-if="!item.state"
                outline
                @click="
                  item.state = !item.state;
                  onToggle();
                "
                >{{ item.name }}</q-btn
              >
            </div>
            <div class="row" style="margin-bottom:15px;">
              <q-editor
                v-model="postEditor"
                min-height="20rem"
                max-height="25rem"
                class="col-8"
              />
              <ImgUpLoader
                class="col-3"
                style="margin-left:20px;"
              ></ImgUpLoader>
            </div>
          </q-tab-panel>

          <q-tab-panel name="plan" style="height:1200px">
            <div class="row" style="margin-bottom:15px;">
              <q-input class="col-8" type="text" label="제목" />
              <div
                class="row justify-around"
                style="margin-left:20px; width:30%;"
              >
                <q-select
                  filled
                  v-model="v1"
                  use-input
                  hide-selected
                  fill-input
                  input-debounce="0"
                  :options="spin1"
                  class="col-5"
                  label="지역"
                />

                <template v-if="v1 == '서울'">
                  <q-select
                    filled
                    v-model="v2"
                    use-input
                    hide-selected
                    fill-input
                    input-debounce="0"
                    :options="spin2"
                    class="col-5"
                    label="도시"
                  />
                </template>
                <template v-else>
                  <q-select
                    filled
                    v-model="v2"
                    use-input
                    hide-selected
                    fill-input
                    input-debounce="0"
                    :options="null"
                    class="col-5"
                    label="도시"
                  />
                </template>
              </div>
            </div>
            <span>태그</span>
            <div
              style="display: inline"
              v-for="(item, idx) in thema"
              :key="idx"
            >
              <q-btn
                color="grey"
                class="q-ma-sm"
                size="xl"
                v-if="item.state"
                @click="
                  item.state = !item.state;
                  onToggle();
                "
                >{{ item.name }}</q-btn
              >
              <q-btn
                color="grey"
                class="q-ma-sm"
                size="xl"
                v-if="!item.state"
                outline
                @click="
                  item.state = !item.state;
                  onToggle();
                "
                >{{ item.name }}</q-btn
              >
            </div>
            <div class="row" style="margin-bottom:15px;">
              <q-editor
                v-model="postEditor"
                min-height="20rem"
                max-height="25rem"
                class="col-8"
              />
              <ImgUpLoader
                class="col-3"
                style="margin-left:20px;"
              ></ImgUpLoader>
            </div>
            <p>카드 입력</p>
            <div class="row">
              <q-card
                flat
                bordered
                class="my-card"
                style="width:25%; max-height:100%; margin-right:10px;"
              >
                <q-card-section row>
                  <div class="row text-h6 q-mb-xs justify-between">
                    <span>2017-12-12</span>
                    <q-btn unelevated color="green" icon="delete"></q-btn>
                  </div>
                </q-card-section>
                <q-separator />
                <q-scroll-area style="width:100%;height:200px;">
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
                      </q-item-section> </q-item
                    ><q-item>
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
                      <q-popup-edit
                        v-model="label"
                        content-class="bg-accent text-white"
                      >
                        <q-input
                          dark
                          color="white"
                          v-model="label"
                          dense
                          autofocus
                          counter
                        >
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

const t1 = [
  "서울",
  "부산",
  "대구",
  "인천",
  "광주",
  "대전",
  "울산",
  "세종",
  "경기",
  "강원",
  "충북",
  "충남",
  "경북",
  "경남",
  "전북",
  "전남",
  "제주"
];
export default {
  data() {
    return {
      postEditor: "",
      planEditor: "",
      tab: "post",
      spin1: t1,
      v1: null,
      spin2: "",
      gangnam: [
        "강남구",
        "도봉구",
        "동대문구",
        "동작구",
        "마포구",
        "서대문구",
        "서초구",
        "성동구",
        "성북구",
        "송파구",
        "양천구",
        "강동구",
        "영등포구",
        "용산구",
        "은평구",
        "종로구",
        "중구",
        "중랑구",
        "강북구",
        "강서구",
        "관악구",
        "광진구",
        "구로구",
        "금천구",
        "노원구"
      ],
      v2: null,
      label: "",
      thema: {
        food: { state: false, name: "맛집" },
        family: { state: false, name: "가족" },
        date: { state: false, name: "데이트" },
        shopping: { state: false, name: "쇼핑" },
        culture: { state: false, name: "문화" },
        indoor: { state: false, name: "실내" },
        healing: { state: false, name: "힐링" },
        tradition: { state: false, name: "전통" }
      }
    };
  },
  components: {
    ImgUpLoader
  },
  methods: {
    inner() {
      console.log(this.v1);
    },
    onToggle() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      console.log("### TravelPick - onToggle 눌림 ###", this.currentChoices);
      this.getAllPicks();
    }
  }
};
</script>

<style></style>
