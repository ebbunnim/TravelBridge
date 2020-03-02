<template>
  <div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold" style="padding-top: 10%">
          유저 페이지
        </div>
      </div>
    </q-img>
    <div class=" row justify-center">
      <div class=" col-10">
     
        <q-card class="q-pa-xl q-ma-lg" flat bordered>
        <q-card-section align="center">
          <div class="text-h5 text-weight-bold">
            {{another.mem_id}}
          </div>
          <div class="q-mt-md">
            {{ another.mem_interest }}
          </div>
        </q-card-section>
        <q-card-section class="row justify-center">
          <div class="col-md-6" align="left">
            <q-btn
              flat
              no-wrap
              color="primary"
              icon="arrow_back"
              label="이전으로"
              @click="goBack()"
            />
          </div>
          <div class="col-md-6" align="right">
            <template
          v-if="this.user.mem_id != null || this.user.mem_id != undefined"
        >
          <template v-if="Check">
            <q-btn color="red" icon="check" label="팔로우 해제" @click="delF" />
          </template>
          <template v-else>
            <q-btn color="primary" icon="check" label="팔로우 하기" @click="addF" />
          </template>
        </template>
          </div>

        </q-card-section>
        <q-separator inset />

<q-tabs
  v-model="tab"
  class="text-teal"
>
  <q-tab name="info" icon="mail" label="정보" />
  <q-tab name="post" icon="alarm" label="게시글" />

</q-tabs>
<q-tab-panels v-model="tab" animated>
  <q-tab-panel name="info">
   <div class="row justify-center">
          <q-card-section class="col-xs-12 col-md-6">
            
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              이름 : <p >{{another.mem_name}}</p>
              <template v-if="another.mem_sex == 1">
              성별 :<p>여자</p>
              </template>
             <template v-else>
              성별 :<p>남자</p>
              </template>
              생일 : <p> {{another.mem_birth}}</p>

            </div>
          </q-card-section>
        </div>
  </q-tab-panel>
  <q-tab-panel name="post" style="height:900px">
   <template v-if="this.postList.length == 0"> </template>
            <template v-else>
              <template v-if="this.gogo">
              <div
                v-for="(tta, index) of this.postList"
                :key="index"
                class="row justify-center"
              >
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
                    <q-card
                      class="my-card1"
                      flat
                      bordered
                      style="width:100%;"
                      @click="move(tt.post_no)"
                    >
                      <template v-if="tt.post_filesList.length !== 0">
                        <q-img
                          :src="tt.post_filesList[0].files_url"
                          style="max-height: 160px;"
                        />
                      </template>
                      <template v-else>
                        <q-img
                          src="https://cdn.quasar.dev/img/parallax2.jpg"
                          style="max-height: 160px;"
                        />
                      </template>

                      <q-card-section>
                        <div class="text-overline text-orange-9 text-body-3">
                          {{ tt.post_category }}
                        </div>
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
                    <q-card
                      class="my-card1"
                      flat
                      bordered
                      style="width:100%;"
                      @click="move(tt.post_no)"
                    >
                      <q-card-section
                        horizontal
                        style="width:100%;height:100%;"
                      >
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
                            <div
                              class="text-overline text-orange-9 text-body-3"
                            >
                              {{ tt.post_category }}
                            </div>
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
                                  <q-timeline-entry
                                    v-for="(a, index) of tt.post_courseList"
                                    :key="index"
                                  >
                                    <template v-slot:title>{{
                                      a.course_title
                                    }}</template>
                                    <div class="text-body-4">
                                      {{ a.course_description }}
                                    </div>
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
  </q-tab-panel>
  
</q-tab-panels>
        
      </q-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data(){
return{
  tab : "info"
}
  },
  mounted() {
    this.$store.dispatch("user/getAnother", {
      userNo: this.$route.params.userNo
    });
    this.$store.dispatch("user/getFollowing", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getPostListMem",{
      no : this.$route.params.userNo
    })
  },
  computed: {
    another() {
      return this.$store.state.user.another;
    },
    user() {
      return this.$store.state.user.user;
    },
    Check() {
      console.log("asdasdasdsa");
      if (this.user.mem_id != null || this.user.mem_id != undefined) {
        for (let x in this.$store.state.user.following.mem_followList) {
          if (
            this.$store.state.user.following.mem_followList[x].mem_no ===
            this.another.mem_no
          ) {
            return true;
          }
        }
      }
      return false;
    }
    ,
    postList(){
      return this.$store.state.user.userPost;
    },
    gogo(){
      return this.$store.state.user.gogo;
    }
  },
  methods: {
     move: function(postNo) {
      this.$router.push("/page1/postdetail/" + postNo);
    },
    fixPost: function(target, pos) {
      if (target[pos].post_type == 1) return true;
      else return false;
    },
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    goBack: function() {
      this.$router.go(-1);
      return;
    },addF: function(){
      let x = {
        follower_no : this.$store.state.user.user.mem_no, following_no : this.another.mem_no
      }
        this.$store.dispatch("user/addF",{x})
    },
    delF: function(){
      this.$store.dispatch("user/delF",{r :this.$store.state.user.user.mem_no, ing:this.another.mem_no })
    }
  }
};
</script>

<style></style>
