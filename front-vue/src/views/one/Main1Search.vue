<template>
  <div align="center">
    <div class="row justify-center" style="margin:5% 0 0 0 ;">
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
      <div class="col-8 q-py-md row justify-center">
        <p style="padding: 16px 0 0 0;">추천 검색어 :</p>
        <q-btn color="rgba(0,0,0,0.47)" flat label="맛집" />
        <q-btn color="rgba(0,0,0,0.47)" flat label="너네집" />
        <q-btn color="rgba(0,0,0,0.47)" flat label="우리집" />
      </div>
    </div>

    <q-separator spaced inset vertical dark />
    <template v-if="this.postList.length == 0">
      <div>이쉽게도 계시물이 없네요</div>
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
                  <q-img src="https://cdn.quasar.dev/img/parallax2.jpg" />
                </template>

                <q-card-section>
                  <div class="text-overline text-orange-9 text-body-3">{{ tt.post_category }}</div>
                  <div class="text-b q-mt-sm q-mb-xs text-body-4">
                    <b>{{ tt.post_title }}</b>
                  </div>
                  <div class="text-caption text-grey text-body-1">{{ tt.post_content }}</div>
                </q-card-section>
              </q-card>
            </template>
            <template v-else-if="tt.post_type == 1">
              <q-card class="my-card1" flat bordered @click="move(tt.post_no)">
                <q-card-section horizontal style="width:100%;height:100%;">
                  <q-card-section class="q-pt-xs col-7">
                    <div class="text-overline text-orange-9 text-body-3">{{ tt.post_category }}</div>
                    <div class="q-mt-sm q-mb-xs">
                      <b>{{ tt.post_title }}</b>
                    </div>
                    <div class="text-caption text-grey text-body-2">{{ tt.post_content }}</div>
                  </q-card-section>

                  <q-card-section class="col-5 flex flex-center">
                    <q-scroll-area style="width:100%;height:100%;">
                      <q-timeline color="secondary">
                        <q-timeline-entry body="November, 2017" />

                        <q-timeline-entry title="Event Title" subtitle="February 22, 1986" />

                        <q-timeline-entry title="Event Title" subtitle="February 22, 1986" />

                        <q-timeline-entry body="November, 2017" />
                        <q-timeline-entry title="Event Title" subtitle="February 22, 1986" />

                        <q-timeline-entry title="Event Title" subtitle="February 22, 1986" />
                      </q-timeline>
                    </q-scroll-area>
                  </q-card-section>
                </q-card-section>
              </q-card>
            </template>
            <template v-else>
              <q-card-section horizontal>
                <q-card-section class="q-pt-xs">
                  <div class="text-overline text-orange-9 text-body-3">{{ tt.post_category }}</div>
                  <div class="text-h5 q-mt-sm q-mb-xs">Title</div>
                  <div class="text-caption text-grey">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                    do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  </div>
                </q-card-section>

                <q-card-section class="col-5 flex flex-center">
                  <q-img class="rounded-borders" src="https://cdn.quasar.dev/img/parallax2.jpg" />
                </q-card-section>
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
    fixPost: function(target, pos) {
      if (target[pos].post_type == 1) return true;
      else return false;
    },
    move: function(postNo) {
      this.$router.push("postdetail/" + postNo);
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
