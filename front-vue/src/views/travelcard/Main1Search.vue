<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold absolute-center">검색</div>
      </div>
    </q-img>

    <div class="row justify-center pad">
      <q-select v-model="option" label="옵션" filled class="col-1" :options="options" />
      <q-input
        label="검색"
        class="col-5"
        color="black"
        label-color="black"
        style="margin-left:15px;"
        v-model="word"
        v-on:keyup.enter="search(1)"
      >
        <template v-slot:append>
          <q-icon
            v-if="word !== ''"
            name="close"
            @click="word = ''"
            class="cursor-pointer"
            color="black"
          />
          <q-icon name="search" class="cursor-pointer" color="black" @click="search(1)" />
        </template>
      </q-input>
      
    </div>

    <q-separator spaced inset vertical dark />
    <template v-if="this.postList.length == 0">
      
    </template>
    <template v-else>
      <template v-if="this.gogo">
        <div v-for="(tta, index) of postList" :key="index" class="row justify-center">
          <div
            v-for="(tt, index) of tta"
            :key="index"
            style="margin-bottom:12px; padding-left:12px;"
            v-bind:class="{
              'col-4': fixPost(tta, index),
              'col-2': !fixPost(tta, index)
            }"
            align="left"
          >
            <template v-if="tt.post_type == 0">
              <q-card class="my-card1" flat bordered style="width:100%;" @click="move(tt.post_no)">
                <template v-if="tt.post_filesList.length !== 0">
                  <q-img :src="tt.post_filesList[0].files_url" style="max-height: 160px;" />
                </template>
                <template v-else>
                  <q-img src="https://cdn.quasar.dev/img/parallax2.jpg" style="max-height: 160px;" />
                </template>

                <q-card-section>
                  <div class="text-overline text-orange-9 text-body-3">{{ tt.post_category }}</div>
                  <div class="text-b q-mt-sm q-mb-xs text-body-4">
                    <b>{{ tt.post_title }}</b>
                  </div>
                  <div class="text-caption text-grey text-body-1">
                    <span v-html="tt.post_content"></span>
                  </div>
                </q-card-section>
              </q-card>
            </template>
            <template v-else-if="tt.post_type == 1">
              <q-card class="my-card1" flat bordered style="width:100%;" @click="move(tt.post_no)">
                <q-card-section horizontal style="width:100%;height:100%;">
                  <div class="col-7">
                    <template v-if="tt.post_filesList.length !== 0">
                      <q-img
                        :src="tt.post_filesList[0].files_url"
                        style="max-height: 160px; border-radius:4px;"
                      />
                    </template>
                    <template v-else>
                      <q-img
                        src="https://cdn.quasar.dev/img/parallax2.jpg"
                        style="max-height: 160px; border-radius:4px 0 0 0;"
                      />
                    </template>
                    <q-card-section>
                      <div class="text-overline text-orange-9 text-body-3">{{ tt.post_category }}</div>
                      <div class="q-mt-sm q-mb-xs text-body-4">
                        <b>{{ tt.post_title }}</b>
                      </div>
                      <div class="text-caption text-grey text-body-1">
                        <span v-html="tt.post_content"></span>
                      </div>
                    </q-card-section>
                  </div>
                  <q-card-section class="col-5 flex flex-center">
                    <q-scroll-area style="width:100%;height:100%;">
                      <q-timeline color="secondary">
                        <template v-if="tt.post_courseList.length != 0">
                          <div>
                            <q-timeline-entry v-for="(a, index) of tt.post_courseList" :key="index">
                              <template v-slot:title>{{ a.course_title }}</template>
                              <div class="text-body-4">{{ a.course_description }}</div>
                              <!-- {{a.course_subcourse_list}}
                              <q-timeline-entry
                                v-for="(b, index) of a.course_subcourse_list"
                                :key="index"
                              >
                                <div>{{b}}</div>
                              </q-timeline-entry>-->
                            </q-timeline-entry>
                          </div>
                        </template>
                        <template v-else>
                          <q-timeline-entry>
                            <template v-slot:title>
                              일정을 등록하지
                              <br />않았어요.
                            </template>
                          </q-timeline-entry>
                        </template>
                      </q-timeline>
                    </q-scroll-area>
                  </q-card-section>
                </q-card-section>
              </q-card>
            </template>
            <template v-else>
              <q-card-section>
                <div class="q-mt-sm q-mb-xs text-body-4">
                  <b>
                    다른 서비스를
                    <br />
                  </b>
                  <b>이용해보시는건 어때요?</b>
                </div>
                <q-list>
                  <q-item class="q-my-sm" clickable to="/page2/pick">
                    <q-item-section avatar>
                      <q-icon color="primary" name="train" />
                    </q-item-section>
                    <q-item-section>
                      <div>
                        <b>내일로 코스</b>
                      </div>
                      <div class="text-caption">코스 추천 받자!</div>
                    </q-item-section>
                  </q-item>
                  <q-item class="q-my-sm" clickable to="/page3/rank">
                    <q-item-section avatar>
                      <q-icon color="primary" name="bar_chart" />
                    </q-item-section>
                    <q-item-section>
                      <div>
                        <b>트래블 랭킹</b>
                      </div>
                      <div class="text-caption">여행 장인들의 배틀!</div>
                    </q-item-section>
                  </q-item>
                  <q-item class="q-my-sm" clickable to="/page3/mate">
                    <q-item-section avatar>
                      <q-icon color="primary" name="emoji_people" />
                    </q-item-section>
                    <q-item-section>
                      <div>
                        <b>트래블 메이트</b>
                      </div>
                      <div class="text-caption">가치 여행갈 사람!!</div>
                    </q-item-section>
                  </q-item>
                  <q-item class="q-my-sm" clickable to="/page2">
                    <q-item-section avatar>
                      <q-icon color="primary" name="how_to_vote" />
                    </q-item-section>
                    <q-item-section>
                      <div>
                        <b>트래블 픽</b>
                      </div>
                      <div class="text-caption">어떤여행이 있을까?</div>
                    </q-item-section>
                  </q-item>
                </q-list>
              </q-card-section>
            </template>
          </div>
        </div>
      </template>
    </template>
    <div class="row justify-around">
      <template v-if="this.page != 1">
        <div style="margin-left:15px;" class="col-2 justify-start row">
          <q-btn color="primary" icon="keyboard_arrow_left" label="이전" @click="less()" />
        </div>
      </template>
      <template v-else>
        <div class="col-2"></div>
      </template>
      <template v-if="this.postList.length != 0">
        <div class="col-2 justify-end row">
          <q-btn color="primary" label="다음" @click="more()" style="margin-right:4px;">
            <q-icon name="keyboard_arrow_right" style="margin-left:12px;" />
          </q-btn>
        </div>
      </template>
      <template v-else>
        <div class="col-2"></div>
      </template>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      options: ["전체", "제목", "내용", "태그", "지역"],
      word: "",
      option: "전체",
      page: 1
    };
  },
  created() {
    this.income();
  },
  watch: {
    "$route.params": function() {
      this.income();
    }
  },
  computed: {
    postList() {
      return this.$store.state.post.postList;
    },
    gogo() {
      return this.$store.state.post.gogo;
    }
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    fixPost: function(target, pos) {
      if (target[pos].post_type == 1) return true;
      else return false;
    },
    move: function(postNo) {
      this.$router.push("/page1/postdetail/" + postNo);
    },
    search: function(pageNo) {
      if (this.word != "") {
        if (this.option != "") {
          this.$router.push(
            "/page1/main1search/" + this.word + "/" + this.option + "/" + pageNo
          );
        } else {
          this.$router.push("/page1/main1search/" + this.word + "/" + pageNo);
        }
      } else {
        if (pageNo !== 1) this.$router.push("/page1/main1search/" + pageNo);
        else this.$router.push("/page1/main1search");
      }
    },
    less: function() {
      this.page--;
      this.search(this.page);
    },
    more: function() {
      this.page++;
      this.search(this.page);
    },
    income: function() {
      if (this.$route.params.pageNo != undefined)
        this.page = this.$route.params.pageNo;
      if (this.$route.params.word != null) {
        this.word = this.$route.params.word;
        if (this.$route.params.option != null) {
          this.option = this.$route.params.option;
          var x = "";
          if (this.option === "전체") x = "all";
          else if (this.option === "제목") x = "title";
          else if (this.option === "내용") x = "content";
          else if (this.option === "태그") x = "tag";
          else if (this.option === "지역") x = "city";
          this.$store.dispatch("post/searchPartPost", {
            pageNo: this.page,
            keyword: this.word,
            option: x
          });
        } else {
          this.$store.dispatch("post/searchPartPost", {
            pageNo: this.page,
            keyword: this.word
          });
        }
      } else {
        this.$store.dispatch("post/searchPartPost", { pageNo: this.page });
      }
    }
  }
};
</script>

<style>
.pad {
  padding-top: 150px;
}

.my-card1 {
  width: 100%;
  height: 360px;
}
.card-margin-1 {
  margin-left: 12px;
}
.card-margin-2 {
  margin-left: 12px;
}
.text-body-1 {
  display: -webkit-box;
  display: -ms-flexbox;
  margin-top: 1px;
  max-height: 400px;
  overflow: hidden;
  vertical-align: top;
  text-overflow: ellipsis;
  word-break: break-all;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 4;
}
.text-body-2 {
  display: -webkit-box;
  display: -ms-flexbox;
  margin-top: 1px;
  max-height: 400px;
  overflow: hidden;
  vertical-align: top;
  text-overflow: ellipsis;
  word-break: break-all;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 12;
}
.text-body-3 {
  display: -webkit-box;
  display: -ms-flexbox;
  margin-top: 1px;
  max-height: 400px;
  overflow: hidden;
  vertical-align: top;
  text-overflow: ellipsis;
  word-break: break-all;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
}
.text-body-4 {
  display: -webkit-box;
  display: -ms-flexbox;
  margin-top: 1px;
  max-height: 400px;
  overflow: hidden;
  vertical-align: top;
  text-overflow: ellipsis;
  word-break: break-all;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}
</style>
