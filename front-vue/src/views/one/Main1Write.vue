<template>
  <div>
    <div style="max-width: 70%; margin: 5% 15% 0 15%">
      <div class="row" style="margin-bottom:3%;  ">
        <div class="col-4" align="left">
          <q-btn color="primary" icon="check" label="뒤로 가기" />
        </div>
        <div class="col-4" style=" text-align: center;">
          <h3 style="margin-top:0px; margin-bottom:0px;">글쓰기</h3>
        </div>
      </div>
      <q-card>
        <q-tabs
          v-model="tab"
          dense
          class="text-grey"
          active-color="primary"
          indicator-color="primary"
          align="justify"
          narrow-indicator
          @input="planu"
        >
          <q-tab name="post" label="포스트 쓰기" />
          <q-tab name="plan" label="Plan 쓰기" />
        </q-tabs>

        <q-separator />

        <q-tab-panels v-model="tab" animated>
          <q-tab-panel name="post" style="height:800px">
            <div class="row justify-center" style="margin-bottom:15px;">
              <q-input class="col-8" type="text" label="제목" v-model="post.postTitle" />
              <div class="row justify-around col-5" style="margin-top:2%;">
                <q-select
                  filled
                  v-model="post.postArea"
                  use-input
                  hide-selected
                  fill-input
                  input-debounce="0"
                  @input="postInner"
                  :options="post.postSpinArea"
                  class="col-5"
                  label="지역"
                >
                  <template v-slot:no-option>
                    <q-item>
                      <q-item-section class="text-grey">No results</q-item-section>
                    </q-item>
                  </template>
                </q-select>
                <template>
                  <q-select
                    filled
                    v-model="post.postCity"
                    label="도시"
                    :options="post.postSpinCity"
                    class="col-5"
                    behavior="menu"
                  />
                </template>
              </div>
              <div class="col-10 justify-center row" style="margin-top:1%;">
                <div style="display: inline" v-for="(item, idx) in post.postThema" :key="idx">
                  <q-btn
                    color="grey"
                    class="q-ma-sm"
                    size="xl"
                    v-if="item.state"
                    @click="
                      item.state = !item.state;
                      planToggle();
                    "
                  >{{ item.name }}</q-btn>
                  <q-btn
                    color="grey"
                    class="q-ma-sm"
                    size="xl"
                    v-if="!item.state"
                    outline
                    @click="
                      item.state = !item.state;
                      planToggle();
                    "
                  >{{ item.name }}</q-btn>
                </div>
              </div>
            </div>

            <div class="row" style="margin-bottom:15px;margin-left:0px;">
              <q-editor
                v-model="post.postEditor"
                min-height="20rem"
                max-height="25rem"
                class="col-8"
              />
              <div class="col-3" style="margin-left:20px;">
                <q-uploader
                  label="Custom header"
                  extensions=".gif,.jpg,.jpeg,.png"
                  multiple
                  @added="postFileSelected"
                  @removed="postFileRemoved"
                  style="min-height: 30rem;"
                  ref="posts"
                  flat
                  bordered
                >
                  <template v-slot:header="scope">
                    <div class="row no-wrap items-center q-pa-sm q-gutter-xs">
                      <q-btn
                        v-if="scope.queuedFiles.length > 0"
                        icon="clear_all"
                        @click="scope.removeQueuedFiles"
                        round
                        dense
                        flat
                      >
                        <q-tooltip>Clear All</q-tooltip>
                      </q-btn>
                      <q-btn
                        v-if="scope.uploadedFiles.length > 0"
                        icon="done_all"
                        @click="scope.removeUploadedFiles"
                        round
                        dense
                        flat
                      >
                        <q-tooltip>Remove Uploaded Files</q-tooltip>
                      </q-btn>

                      <div class="col">
                        <div class="q-uploader__title">Upload your files</div>
                        <div class="q-uploader__subtitle">
                          {{ scope.uploadSizeLabel }} /
                          {{ scope.uploadProgressLabel }}
                        </div>
                      </div>
                      <q-btn v-if="scope.canAddFiles" type="a" icon="add_box" round dense flat>
                        <q-uploader-add-trigger />
                        <q-tooltip>Pick Files</q-tooltip>
                      </q-btn>
                    </div>
                  </template>
                </q-uploader>
              </div>
            </div>
            <div class="row justify-center">
              <div class="col-12" align="center">
                <q-btn color="primary" icon="clear" label="초기화" @click="postClear()" />
                <q-btn
                  color="primary"
                  icon="check"
                  label="등록"
                  @click="postSave()"
                  style="margin-left:2%;"
                />
              </div>
            </div>
          </q-tab-panel>

          <q-tab-panel name="plan" style="height:1250px">
            <div class="row justify-center" style="margin-bottom:15px;">
              <q-input class="col-8" type="text" label="제목" v-model="plan.planTitle" />
              <div class="row justify-around col-5" style="margin-top:2%;">
                <q-select
                  filled
                  v-model="plan.planArea"
                  use-input
                  hide-selected
                  fill-input
                  input-debounce="0"
                  @input="planInner"
                  :options="plan.planSpinArea"
                  class="col-5"
                  label="지역"
                >
                  <template v-slot:no-option>
                    <q-item>
                      <q-item-section class="text-grey">No results</q-item-section>
                    </q-item>
                  </template>
                </q-select>
                <template>
                  <q-select
                    filled
                    v-model="plan.planCity"
                    label="도시"
                    :options="plan.planSpinCity"
                    class="col-5"
                    behavior="menu"
                  />
                </template>
              </div>
              <div class="col-10 justify-center row" style="margin-top:1%;">
                <div style="display: inline" v-for="(item, idx) in plan.planThema" :key="idx">
                  <q-btn
                    color="grey"
                    class="q-ma-sm"
                    size="xl"
                    v-if="item.state"
                    @click="
                      item.state = !item.state;
                      planToggle();
                    "
                  >{{ item.name }}</q-btn>
                  <q-btn
                    color="grey"
                    class="q-ma-sm"
                    size="xl"
                    v-if="!item.state"
                    outline
                    @click="
                      item.state = !item.state;
                      planToggle();
                    "
                  >{{ item.name }}</q-btn>
                </div>
              </div>
            </div>

            <div class="row" style="margin-bottom:15px;margin-left:0px;">
              <q-editor
                v-model="plan.planEditor"
                min-height="20rem"
                max-height="25rem"
                class="col-8"
              />
              <div class="col-3" style="margin-left:20px;">
                <template v-if="plan.planSelectedFile.length > 0">
                  asdasd
                  <q-uploader
                    ref="plans"
                    label="Custom header"
                    :value="plan.planSelectedFile"
                    extensions=".gif,.jpg,.jpeg,.png"
                    multiple
                    @added="planFileSelected"
                    @removed="planFileRemoved"
                    @start="planu"
                    style="min-height: 30rem;"
                    flat
                    bordered
                  >
                    <template v-slot:header="scope">
                      <div class="row no-wrap items-center q-pa-sm q-gutter-xs">
                        <q-btn
                          v-if="scope.queuedFiles.length > 0"
                          icon="clear_all"
                          @click="scope.removeQueuedFiles"
                          round
                          dense
                          flat
                        >
                          <q-tooltip>Clear All</q-tooltip>
                        </q-btn>
                        <q-btn
                          v-if="scope.uploadedFiles.length > 0"
                          icon="done_all"
                          @click="scope.removeUploadedFiles"
                          round
                          dense
                          flat
                        >
                          <q-tooltip>Remove Uploaded Files</q-tooltip>
                        </q-btn>

                        <div class="col">
                          <div class="q-uploader__title">Upload your files</div>
                          <div class="q-uploader__subtitle">
                            {{ scope.uploadSizeLabel }} /
                            {{ scope.uploadProgressLabel }}
                          </div>
                        </div>
                        <q-btn v-if="scope.canAddFiles" type="a" icon="add_box" round dense flat>
                          <q-uploader-add-trigger />
                          <q-tooltip>Pick Files</q-tooltip>
                        </q-btn>
                      </div>
                    </template>
                  </q-uploader>
                </template>
                <template v-else>
                  <q-uploader
                    ref="plans"
                    label="Custom header"
                    extensions=".gif,.jpg,.jpeg,.png"
                    multiple
                    @added="planFileSelected"
                    @removed="planFileRemoved"
                    style="min-height: 30rem;"
                    flat
                    bordered
                  >
                    <template v-if="plan.planSelectedFile > 0"></template>
                    <template v-slot:header="scope">
                      <div class="row no-wrap items-center q-pa-sm q-gutter-xs">
                        <q-btn
                          v-if="scope.queuedFiles.length > 0"
                          icon="clear_all"
                          @click="scope.removeQueuedFiles"
                          round
                          dense
                          flat
                        >
                          <q-tooltip>Clear All</q-tooltip>
                        </q-btn>
                        <q-btn
                          v-if="scope.uploadedFiles.length > 0"
                          icon="done_all"
                          @click="scope.removeUploadedFiles"
                          round
                          dense
                          flat
                        >
                          <q-tooltip>Remove Uploaded Files</q-tooltip>
                        </q-btn>

                        <div class="col">
                          <div class="q-uploader__title">Upload your files</div>
                          <div class="q-uploader__subtitle">
                            {{ scope.uploadSizeLabel }} /
                            {{ scope.uploadProgressLabel }}
                          </div>
                        </div>
                        <q-btn v-if="scope.canAddFiles" type="a" icon="add_box" round dense flat>
                          <q-uploader-add-trigger />
                          <q-tooltip>Pick Files</q-tooltip>
                        </q-btn>
                      </div>
                    </template>
                  </q-uploader>
                </template>
              </div>
            </div>

            <div class="row justify-center">
              <div class="justify-start">
                <h4>일정 추가하기</h4>
              </div>
              <div class="col-10 row" style="margin-bottom:2%;">
                <q-card
                  flat
                  bordered
                  class="my-card"
                  style="width:25%; max-height:100%; margin-right:10px;"
                >
                  <q-card-section row>
                    <div class="row text-h6 q-mb-xs justify-between">
                      <span>한옥마을</span>
                      <q-btn unelevated color="green" icon="delete"></q-btn>
                    </div>
                  </q-card-section>
                  <q-separator />
                  <q-scroll-area style="width:100%;height:200px;">
                    <q-list>
                      <q-item>
                        <q-item-section>
                          <q-item-label>한복 대여</q-item-label>
                        </q-item-section>
                        <q-item-section avatar>
                          <q-btn unelevated color="amber" icon="delete_forever" />
                        </q-item-section>
                      </q-item>
                      <q-item>
                        <q-item-section>
                          <q-item-label>맛집 탐방</q-item-label>
                        </q-item-section>
                        <q-item-section avatar>
                          <q-btn unelevated color="amber" icon="delete_forever" />
                        </q-item-section>
                      </q-item>
                      <q-item>
                        <q-item-section>
                          <q-item-label>핫스팟에서 사진찍기</q-item-label>
                        </q-item-section>
                        <q-item-section avatar>
                          <q-btn unelevated color="amber" icon="delete_forever" />
                        </q-item-section>
                      </q-item>
                      <q-item>
                        <q-item-section>
                          <q-item-label>행복</q-item-label>
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
                        <q-popup-edit v-model="plan.plan" content-class="bg-amber text-white">
                          <q-input dark color="white" v-model="plan.plan" dense autofocus counter>
                            <template v-slot:append>
                              <q-icon name="edit" />
                            </template>
                          </q-input>
                        </q-popup-edit>
                      </q-item>
                    </q-list>
                  </q-scroll-area>
                </q-card>
                <q-card class="my-card" style="width:25%; max-height:60px; margin-left:2%;">
                  <q-item clickable style="width:100%; height:100%;">
                    <q-card-section row style="padding:8px 0px 0px 20px;">
                      <div class="row text-h6 q-mb-xs">
                        <p>카드 추가하기</p>
                        <q-icon name="add" size="md" style="margin-left:10px" />
                        <q-popup-edit v-model="plan.card" content-class="bg-green-7 text-white">
                          <q-input dark color="white" v-model="plan.card" dense autofocus counter>
                            <template v-slot:append>
                              <q-icon name="edit" />
                            </template>
                          </q-input>
                        </q-popup-edit>
                      </div>
                    </q-card-section>
                  </q-item>
                </q-card>
              </div>
            </div>
            <div class="row justify-center">
              <div class="col-12" align="center">
                <q-btn color="primary" icon="clear" label="초기화" @click="planClear" />
                <q-btn
                  color="primary"
                  icon="check"
                  label="등록"
                  style="margin-left:2%;"
                  @click="planSave"
                />
              </div>
            </div>
          </q-tab-panel>
        </q-tab-panels>
      </q-card>
    </div>
  </div>
</template>

<script>
const area = [
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
const seoul = [
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
];
const qntks = [
  "강서구",
  "사하구",
  "서구",
  "수영구",
  "연제구",
  "영도구",
  "중구",
  "해운대구",
  "금정구",
  "기장군",
  "남구",
  "동구",
  "동래구",
  "부산진구",
  "북구",
  "사상구"
];
const eorn = [
  "남구",
  "달서구",
  "달성군",
  "동구",
  "북구",
  "서구",
  "수성구",
  "중구"
];
const dlscjs = [
  "강화군",
  "중구",
  "계양구",
  "미추홀구",
  "남동구",
  "동구",
  "부평구",
  "서구",
  "연수구",
  "옹진군"
];
const rhkdwn = ["광산구", "남구", "동구", "북구", "서구"];
const eowjs = ["대덕구", "동구", "서구", "유성구", "중구"];
const dnftks = ["중구", "남구", "동구", "북구", "울주군"];
const tpwhd = ["세종시"];
const rudrl = [
  "가평군",
  "동두천시",
  "부천시",
  "성남시",
  "수원시",
  "시흥시",
  "안산시",
  "안성시",
  "안양시",
  "양주시",
  "양평군",
  "고양시",
  "여주시",
  "연천군",
  "오산시",
  "용인시",
  "의왕시",
  "의정부시",
  "이천시",
  "파주시",
  "평택시",
  "포천시",
  "과천시",
  "하남시",
  "화성시",
  "광명시",
  "광주시",
  "구리시",
  "군포시",
  "김포시",
  "남양주시"
];
const rkddnjs = [
  "강릉시",
  "인제군",
  "정선군",
  "철원군",
  "춘천시",
  "태백시",
  "평창군",
  "홍천군",
  "화천군",
  "횡성군",
  "고성군",
  "동해시",
  "삼척시",
  "속초시",
  "양구군",
  "양양군",
  "영월군",
  "원주시"
];
const cndqnr = [
  "괴산군",
  "청주시",
  "충주시",
  "증평군",
  "단양군",
  "보은군",
  "영동군",
  "옥천군",
  "음성군",
  "제천시",
  "진천군"
];
const cndska = [
  "공주시",
  "예산군",
  "천안시",
  "청양군",
  "태안군",
  "홍성군",
  "계룡시",
  "금산군",
  "논산시",
  "당진시",
  "보령시",
  "부여군",
  "서산시",
  "서천군",
  "아산시"
];
const rudqnr = [
  "경산시",
  "성주군",
  "안동시",
  "영덕군",
  "영양군",
  "영주시",
  "영천시",
  "예천군",
  "울릉군",
  "울진군",
  "의성군",
  "경주시",
  "청도군",
  "청송군",
  "칠곡군",
  "포항시",
  "고령군",
  "구미시",
  "군위군",
  "김천시",
  "문경시",
  "봉화군",
  "상주시"
];
const rudska = [
  "거제시",
  "양산시",
  "의령군",
  "진주시",
  "창녕군",
  "창원시",
  "통영시",
  "하동군",
  "함안군",
  "거창군",
  "함양군",
  "합천군",
  "고성군",
  "김해시",
  "남해군",
  "밀양시",
  "사천시",
  "산청군"
];
const wjsqnr = [
  "고창군",
  "임실군",
  "장수군",
  "전주시",
  "정읍시",
  "진안군",
  "군산시",
  "김제시",
  "남원시",
  "무주군",
  "부안군",
  "순창군",
  "완주군",
  "익산시"
];
const wjsska = [
  "강진군",
  "보성군",
  "순천시",
  "신안군",
  "여수시",
  "영광군",
  "영암군",
  "완도군",
  "장성군",
  "고흥군",
  "장흥군",
  "진도군",
  "함평군",
  "해남군",
  "화순군",
  "곡성군",
  "광양시",
  "구례군",
  "나주시",
  "담양군",
  "목포시",
  "무안군"
];
const wpwn = ["서귀포시", "제주시"];

export default {
  data() {
    return {
      tab: "post",
      post: {
        postTitle: "",
        postEditor: "",
        postSpinArea: area,
        postArea: "",
        postCity: "",
        postSpinCity: [],
        postChoices: "",
        postSelectedFile: []
      },

      postThema: {
        food: { state: false, name: "맛집" },
        family: { state: false, name: "가족" },
        date: { state: false, name: "데이트" },
        shopping: { state: false, name: "쇼핑" },
        culture: { state: false, name: "문화" },
        indoor: { state: false, name: "실내" },
        healing: { state: false, name: "힐링" },
        tradition: { state: false, name: "전통" }
      },
      plan: {
        planSelectedFile: [],
        planTitle: "",
        planEditor: "",
        planSpinArea: area,
        planArea: "",
        planCity: "",
        planSpinCity: [],
        planChoices: "",
        card: "",
        plan: "",
        planList: []
      },
      planThema: {
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

  methods: {
    postFileSelected(file) {
      console.log(file);
      for (var x in file) {
        this.post.postSelectedFile.push(file[x]);
      }
      console.log(this.postSelectedFile);
    },
    postFileRemoved(file) {
      const idx = this.postSelectedFile.findIndex(function(item) {
        return item.name === file[0].name;
      });
      if (idx > -1) this.postSelectedFile.splice(idx, 1);
    },
    postInner() {
      this.post.postCity = "";
      if (this.post.postArea === "서울") this.post.postSpinCity = seoul;
      else if (this.post.postArea === "부산") this.post.postSpinCity = qntks;
      else if (this.post.postArea === "대구") this.post.postSpinCity = eorn;
      else if (this.post.postArea === "인천") this.post.postSpinCity = dlscjs;
      else if (this.post.postArea === "광주") this.post.postSpinCity = rhkdwn;
      else if (this.post.postArea === "대전") this.post.postSpinCity = eowjs;
      else if (this.post.postArea === "울산") this.post.postSpinCity = dnftks;
      else if (this.post.postArea === "세종") this.post.postSpinCity = tpwhd;
      else if (this.post.postArea === "경기") this.post.postSpinCity = rudrl;
      else if (this.post.postArea === "강원") this.post.postSpinCity = rkddnjs;
      else if (this.post.postArea === "충북") this.post.postSpinCity = cndqnr;
      else if (this.post.postArea === "충남") this.post.postSpinCity = cndska;
      else if (this.post.postArea === "경북") this.post.postSpinCity = rudqnr;
      else if (this.post.postArea === "경남") this.post.postSpinCity = rudska;
      else if (this.post.postArea === "전북") this.post.postSpinCity = wjsqnr;
      else if (this.post.postArea === "전남") this.post.postSpinCity = wjsska;
      else if (this.post.postArea === "제주") this.post.postSpinCity = wpwn;
      else {
        this.postSpinCity = [];
      }
    },
    planFileSelected(file) {
      console.log(file);
      for (var x in file) {
        this.plan.planSelectedFile.push(file[x]);
      }
      console.log(this.planSelectedFile);

      //이 버튼 필요없고 글쓰기 버튼누르면 글쓰면서 이 친구들 대리고가야한다.
    },
    planFileRemoved(file) {
      const idx = this.planSelectedFile.findIndex(function(item) {
        return item.name === file[0].name;
      });
      if (idx > -1) this.planSelectedFile.splice(idx, 1);
    },
    planInner() {
      this.plan.planCity = "";
      if (this.plan.planArea === "서울") this.plan.planSpinCity = seoul;
      else if (this.plan.planArea === "부산") this.plan.planSpinCity = qntks;
      else if (this.plan.planArea === "대구") this.plan.planSpinCity = eorn;
      else if (this.plan.planArea === "인천") this.plan.planSpinCity = dlscjs;
      else if (this.plan.planArea === "광주") this.plan.planSpinCity = rhkdwn;
      else if (this.plan.planArea === "대전") this.plan.planSpinCity = eowjs;
      else if (this.plan.planArea === "울산") this.plan.planSpinCity = dnftks;
      else if (this.plan.planArea === "세종") this.plan.planSpinCity = tpwhd;
      else if (this.plan.planArea === "경기") this.plan.planSpinCity = rudrl;
      else if (this.plan.planArea === "강원") this.plan.planSpinCity = rkddnjs;
      else if (this.plan.planArea === "충북") this.plan.planSpinCity = cndqnr;
      else if (this.plan.planArea === "충남") this.plan.planSpinCity = cndska;
      else if (this.plan.planArea === "경북") this.plan.planSpinCity = rudqnr;
      else if (this.plan.planArea === "경남") this.plan.planSpinCity = rudska;
      else if (this.plan.planArea === "전북") this.plan.planSpinCity = wjsqnr;
      else if (this.plan.planArea === "전남") this.plan.planSpinCity = wjsska;
      else if (this.plan.planArea === "제주") this.plan.planSpinCity = wpwn;
      else {
        this.planSpinCity = [];
      }
    },
    postToggle() {
      this.postChoices = "";
      const themaChoice = this.postThema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.postChoices += themaChoice[key].name + " ";
        }
      }
      console.log("### TravelPick - onToggle 눌림 ###", this.postChoices);
    },
    planToggle() {
      this.planChoices = "";
      const themaChoice = this.planThema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.planChoices += themaChoice[key].name + " ";
        }
      }
      console.log("### TravelPick - onToggle 눌림 ###", this.planChoices);
    },
    postClear() {
      console.log("post clear");
      (this.post.postTitle = ""),
        (this.post.postEditor = ""),
        (this.post.postArea = ""),
        (this.post.postCity = ""),
        (this.post.postSpinCity = []),
        (this.post.postChoices = ""),
        (this.post.postSelectedFile = []);
    },
    planClear() {
      console.log("plan clear");
      (this.plan.planSelectedFile = []),
        (this.plan.planTitle = ""),
        (this.plan.planEditor = ""),
        (this.plan.planArea = ""),
        (this.plan.planCity = ""),
        (this.plan.planSpinCity = []),
        (this.plan.planChoices = ""),
        (this.plan.card = ""),
        (this.plan.plan = ""),
        (this.plan.planList = []);
    },
    planSave() {
      console.log("plan save");
      console.log(this.plan);
    },
    postSave() {
      console.log("post save");
      console.log(this.post);
    },
    planu() {
      this.postClear();
      this.planClear();
    }
  }
};
</script>

<style></style>
