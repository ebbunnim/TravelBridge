<template>
  <div align="center">
    <div class="row justify-center" style="margin:5% 0 0 0 ;">
      <h2>팔로워 피드</h2>
    </div>

    <q-separator spaced inset vertical dark />
    <div v-for="(tta, index) in postList" :key="index" class="row justify-center">
      <div
        v-for="(tt, index) in tta"
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
              <div class="text-caption text-grey text-body-1">{{ tt.post_content }}</div>
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
                  <div class="text-caption text-grey text-body-1">{{ tt.post_content }}</div>
                </q-card-section>
              </div>
              <q-card-section class="col-5 flex flex-center">
                <q-scroll-area style="width:100%;height:100%;">
                  <q-timeline color="secondary">
                    <template v-if="tt.post_courseList.length !== 0">
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
          <q-card-section horizontal>
            <q-card-section class="q-pt-xs">
              <div class="text-overline text-orange-9 text-body-3">우리의 다른 서비스를 이용해보시는건 어때요?</div>
            </q-card-section>

            <q-card-section class="col-5 flex flex-center">
              <q-img class="rounded-borders" src="https://cdn.quasar.dev/img/parallax2.jpg" />
            </q-card-section>
          </q-card-section>
        </template>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    console.log(this.$store.state);
    this.$store.dispatch("post/searchAllFollower", {
      userno: this.$store.state.user.user.mem_no
    });
  },
  computed: {
    postList() {
      return this.$store.state.post.postList;
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
    moveView: function(page) {
      this.$router.push(page);
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
