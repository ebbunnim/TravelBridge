<template>
  <div class="text-center">
    <div>
      <div style="height: 65px; background: #f9f9f9"></div>
      <q-img :src="getImgUrl('cutbg.jpg')">
        <div style="width: 100%; height: 100%" class="text-center">
          <div class="text-h5 text-weight-bold absolute-center">My Page</div>
          <!-- <div class="text-h5 text-weight-bold" style="padding-top: 10%">
            My Page
          </div>-->
        </div>
      </q-img>
    </div>

    <div class="q-pa-lg">
      <div>
        <q-tabs
          dense
          v-model="tab"
          class="text-grey q-ma-lg"
          active-color="primary"
          indicator-color="primary"
          narrow-indicator
          align="center"
        >
          <q-tab name="activity" label="팔로우" />
          <q-tab name="info" label="개인정보" />
          <q-tab name="etc" label="내 활동" />
          <q-tab name="post" label="내 포스트" />
        </q-tabs>

        <q-tab-panels v-model="tab" animated>
          <!-- 첫번째 패널 -->
          <q-tab-panel name="activity">
            <!-- 패널 내 다른 tabs -->
            <q-tabs
              dense
              v-model="followTab"
              class="text-black"
              active-color="grey"
              indicator-color="grey"
              narrow-indicator
            >
              <q-tab name="follower" label="팔로워">
                
                <template v-if="follower.length != 0">{{
                  follower.mem_followMe.length
                  }}
                </template>
                <template v-else>0</template>
              </q-tab>
              <q-tab name="following" label="팔로잉">
                
                <template v-if="following.length != 0">{{
                  following.mem_followList.length
                  }}
                </template>
                <template v-else>0</template>
              </q-tab>
            </q-tabs>

            <q-tab-panels v-model="followTab" animated>
              <q-tab-panel name="follower" class="row justify-center">
                <q-list class="col-md-2 col-xs-10">
                  <template v-if="follower.length != 0">
                  <q-item
                    v-for="(mem, index) in follower.mem_followMe"
                    :key="index"
                    class="q-my-sm"
                    clickable
                    @click="movefollowing(mem.mem_no)"
                  >
                    <q-item-section side>
                      <q-icon name="person"  />
                    </q-item-section>

                    <q-item-section>
                      <q-item-label>{{ mem.mem_id }}</q-item-label>
                      <q-item-label caption lines="1">
                        {{
                        mem.mem_email
                        }}
                      </q-item-label>
                    </q-item-section>
                  </q-item>
                  </template>
                </q-list>
              </q-tab-panel>
              <q-tab-panel name="following" class="row justify-center">
                <q-list class="col-md-2 col-xs-10">
                  <template v-if="following.length != 0">
                  <q-item
                    v-for="(mem, index) in following.mem_followList"
                    :key="index"
                    class="q-my-sm"
                    clickable
                     @click="movefollowing(mem.mem_no, user.mem_no)"
                  >
                    <q-item-section side>
                      <q-icon
                        name="person_outline"
                       
                      />
                    </q-item-section>
                    <q-item-section>
                      <q-item-label>{{ mem.mem_id }}</q-item-label>
                      <q-item-label caption lines="1">
                        {{
                        mem.mem_email
                        }}
                      </q-item-label>
                    </q-item-section>
                  </q-item>
                  </template>
                </q-list>
              </q-tab-panel>
            </q-tab-panels>
          </q-tab-panel>

          <!-- 두번째 패널 -->
          <q-tab-panel name="info" style="font-size:20px">
            <div class="q-pa-md row justify-center q-gutter-md">
              <!-- 첫번째 카드 -->
              <q-card flat bordered class="my-card col-xs-12 col-md-9">
                <q-card-section>
                  <div class="text-h6">계정정보</div>
                </q-card-section>
                <q-separator inset />
                <q-card-section>
                  <div class="text-body2 text-left">이메일</div>
                  <q-input
                    v-model="user.mem_email"
                    type="text"
                    class="text-h6"
                    readonly
                    dense
                    borderless
                  />
                </q-card-section>
                <q-card-section>
                  <div class="text-subtitle2 text-left">
                    <span>이메일 수신 여부</span>
                    <q-btn
                      class="q-ml-lg"
                      round
                      flat
                      size="sm"
                      color="primary"
                      icon="edit"
                      v-if="!onEditReceive"
                      @click="onEditReceive = !onEditReceive"
                    />
                    <q-btn
                      class="q-ml-lg"
                      round
                      flat
                      size="sm"
                      color="info"
                      icon="edit"
                      v-if="onEditReceive"
                      @click="
                        onEditReceive = !onEditReceive;
                        updateUser();
                      "
                    />
                  </div>
                  <q-input
                    v-model="user.mem_receive_email"
                    type="text"
                    class="text-h6"
                    readonly
                    dense
                    borderless
                    v-show="!onEditReceive"
                  />
                  <div v-show="onEditReceive" align="left " class="row justify-center">
                    <q-radio v-model="user.mem_receive_email" val="true" label="Email 수신에 동의합니다" />
                    <q-radio
                      v-model="user.mem_receive_email"
                      val="false"
                      label="Email 수신에 동의하지 않습니다 "
                    />
                  </div>
                </q-card-section>
                <q-card-section class="row">
                  <div class="col-md-6 col-xs-12">
                    <div class="text-subtitle2 text-left">최종 로그인</div>
                    <q-input
                      v-model="user.mem_lastlogin"
                      type="text"
                      class="text-subtitle1"
                      readonly
                      dense
                      borderless
                    />
                  </div>
                  <div class="col-md-6 col-xs-12">
                    <div class="text-subtitle2 text-left">가입일시</div>
                    <q-input
                      v-model="user.mem_regtime"
                      type="text"
                      class="text-subtitle1"
                      readonly
                      dense
                      borderless
                    />
                  </div>
                </q-card-section>
                <q-card-section>
                  <!-- 기능 아직 구현 안 됨 -->
                  <!-- <div class="text-h4 text-left">회원탈퇴</div> -->
                </q-card-section>
              </q-card>
              <!-- 두번째 카드 -->
              <q-card flat bordered class="my-card col-xs-12 col-md-9">
                <q-card-section>
                  <div class="text-h6">회원정보</div>
                  <div class="text-right">
                    <q-btn
                      flat
                      class="q-ml-lg"
                      label="수정하기"
                      color="primary"
                      icon="edit"
                      v-if="readOnly"
                      @click="readOnly = !readOnly"
                    />
                    <q-btn
                      outline
                      class="q-ml-lg"
                      label="수정완료"
                      color="primary"
                      icon="edit"
                      v-if="!readOnly"
                      @click="
                        readOnly = !readOnly;
                        updateUser();
                      "
                    />
                  </div>
                </q-card-section>
                <q-separator inset />
                <q-card-section class="row">
                  <div class="col-6">
                    <div class="text-body2 text-left">이름</div>
                    <q-input
                      v-model="user.mem_name"
                      type="text"
                      class="text-h6 q-pr-lg"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                      dense
                      borderless
                    />
                  </div>
                  <div class="col-6">
                    <div class="text-body2 text-left">닉네임</div>
                    <q-input
                      v-model="user.mem_id"
                      type="text"
                      class="text-h6 q-pr-lg"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                      dense
                      borderless
                    />
                  </div>
                </q-card-section>

                <q-card-section class="row">
                  <div class="col-6">
                    <div class="text-body2 text-left">연락처</div>
                    <q-input
                      v-model="user.mem_phone"
                      type="text"
                      class="text-h6 q-mr-md q-pr-lg"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                      dense
                      borderless
                    />
                  </div>
                  <div class="col-6">
                    <div class="text-body2 text-left">생년월일</div>
                    <q-input
                      dense
                      borderless
                      v-model="user.mem_birth"
                      placeholder="YYYY/MM/DD"
                      mask="date"
                      class="text-h6 q-pr-lg"
                      :rules="['date']"
                      v-bind="{ readonly: readOnly, outlined: !readOnly }"
                    >
                      <template v-slot:append>
                        <q-icon name="event" class="cursor-pointer" v-if="!readOnly">
                          <q-popup-proxy
                            ref="qDateProxy"
                            transition-show="scale"
                            transition-hide="scale"
                          >
                            <q-date
                              minimal
                              v-model="user.mem_birth"
                              @input="() => $refs.qDateProxy.hide()"
                            />
                          </q-popup-proxy>
                        </q-icon>
                      </template>
                    </q-input>
                  </div>
                </q-card-section>
              </q-card>
              <!-- 세번째 카드 -->
              <q-card flat bordered class="my-card col-xs-12 col-md-9">
                <q-card-section>
                  <div class="text-h6">관심분야</div>
                  <div class="text-right">
                    <q-btn
                      flat
                      class="q-ml-lg"
                      label="수정하기"
                      color="primary"
                      icon="edit"
                      v-if="!onInterestEdit"
                      @click="onInterestEdit = !onInterestEdit"
                    />
                    <q-btn
                      outline
                      class="q-ml-lg"
                      label="수정완료"
                      color="primary"
                      icon="edit"
                      v-if="onInterestEdit"
                      @click="
                        onInterestEdit = !onInterestEdit;
                        updateUser();
                      "
                    />
                  </div>
                </q-card-section>
                <q-separator inset />
                <q-card-section>
                  <!-- <q-input
                    v-model="user.mem_interest"
                    type="text"
                    class="col-"
                    style="text-align:left; margin-left:10px"
                    readonly
                  />-->

                  <div class="row" style="display: inline" v-for="(item, idx) in thema" :key="idx">
                    <q-btn
                      v-bind="{ disabled: !onInterestEdit }"
                      color="grey"
                      unelevated
                      class="q-mb-sm q-mt-md q-px-xs"
                      size="md"
                      v-if="item.state"
                      @click="
                        item.state = !item.state;
                        onToggle();
                      "
                    >#{{ item.name }}</q-btn>
                    <q-btn
                      v-bind="{ disabled: !onInterestEdit }"
                      color="grey"
                      size="md"
                      class="q-mb-sm q-mt-md q-px-xs"
                      v-if="!item.state"
                      bordered
                      flat
                      @click="
                        item.state = !item.state;
                        onToggle();
                      "
                    >#{{ item.name }}</q-btn>
                  </div>
                </q-card-section>
              </q-card>
            </div>
          </q-tab-panel>
          <!-- 세번재 패널 -->
          <q-tab-panel name="etc">
            <q-tabs
              dense
              v-model="likeTab"
              class="text-black"
              active-color="grey"
              indicator-color="grey"
              narrow-indicator
              align="center"
            >
              <q-tab name="post" label="좋아요 포스트"></q-tab>
              <q-tab name="hot" label="좋아요 핫플"></q-tab>
              <q-tab name="festa" label="좋아요 축제"></q-tab>
            </q-tabs>

            <q-tab-panels v-model="likeTab">
              <q-tab-panel name="post" class="row justify-center">
                <q-list bordered class="col-md-8 col-xs-10 q-ma-lg q-pa-md">
                  <q-item
                    v-for="(post, index) in likePost.mem_likePost"
                    :key="index"
                    class="q-my-sm"
                    clickable
                  >
                    <q-item-section @click="movePost(post.post_no)">
                      <q-item-label>{{ post.post_title }}</q-item-label>
                      <q-item-label caption lines="1">
                        {{
                        post.post_category
                        }}
                      </q-item-label>
                    </q-item-section>
                  </q-item>
                </q-list>
              </q-tab-panel>

              <q-tab-panel name="hot" class="row justify-center">
                <q-list bordered class="col-md-8 col-xs-10 q-ma-lg q-pa-md">
                  <q-item
                    v-for="(hot, index) in likeHot.mem_likeHotPlace"
                    :key="index"
                    class="q-my-sm"
                    clickable
                  >
                    <q-item-section @click="moveHot(hot.hp_no)">
                      <q-item-label>{{ hot.hp_name }}</q-item-label>
                      <q-item-label caption lines="1">
                        {{
                        hot.hp_tag
                        }}
                      </q-item-label>
                    </q-item-section>
                  </q-item>
                </q-list>
              </q-tab-panel>

              <q-tab-panel name="festa" class="row justify-center">
                <q-list bordered class="col-md-8 col-xs-10 q-ma-lg q-pa-md">
                  <q-item
                    v-for="(festa, index) in likeFesta.mem_likeFestival"
                    :key="index"
                    class="q-my-sm"
                    clickable
                  >
                    <q-item-section @click="moveFesta(festa.fval_no)">
                      <q-item-label>{{ festa.fval_name }}</q-item-label>
                      <q-item-label caption lines="1">
                        {{
                        festa.fval_tag
                        }}
                      </q-item-label>
                    </q-item-section>
                  </q-item>
                </q-list>
              </q-tab-panel>
            </q-tab-panels>
          </q-tab-panel>
          
          <q-tab-panel name="post" style="height:900px">
            <template v-if="this.postList.length == 0"></template>
            <template v-else>
              <template v-if="this.gogo">
                <div v-for="(tta, index) of this.postList" :key="index" class="row justify-center">
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
                          <q-img :src="tt.post_filesList[0].files_url" style="max-height: 160px;" />
                        </template>
                        <template v-else>
                          <q-img
                            src="https://cdn.quasar.dev/img/parallax2.jpg"
                            style="max-height: 160px;"
                          />
                        </template>

                        <q-card-section>
                          <div
                            class="text-overline text-orange-9 text-body-3"
                          >{{ tt.post_category }}</div>
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
                              <div
                                class="text-overline text-orange-9 text-body-3"
                              >{{ tt.post_category }}</div>
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
                                      <template v-slot:title>
                                        {{
                                        a.course_title
                                        }}
                                      </template>
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
          </q-tab-panel>
        </q-tab-panels>
        <!-- card end -->
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import UserService from "@/services/UserService.js";
export default {
  data() {
    return {
      currentChoices: "",
      thema: {
        food: { state: false, name: "맛집" },
        family: { state: false, name: "가족" },
        date: { state: false, name: "데이트" },
        shopping: { state: false, name: "쇼핑" },
        culture: { state: false, name: "문화" },
        indoor: { state: false, name: "실내" },
        healing: { state: false, name: "힐링" },
        tradition: { state: false, name: "전통" }
      },
      onEditReceive: false,
      readOnly: true,
      onInterestEdit: false,
      submitted: false,
      tab: "info",
      followTab: "follower",
      likeTab: "post"
    };
  },
  computed: {
    emailForLoginAfterUpdate() {
      return this.user.mem_email;
    },
    ...mapState({
      user: state => state.user.user // 현재 접속자
    }),
    follower() {
      return this.$store.state.user.follower;
    },
    following() {
      return this.$store.state.user.following;
    },
    likePost() {
      return this.$store.state.user.likePost;
    },
    likeHot() {
      return this.$store.state.user.likeHot;
    },
    likeFesta() {
      return this.$store.state.user.likeFesta;
    },
    postList() {
      return this.$store.state.user.userPost;
    },
    gogo() {
      return this.$store.state.user.gogo;
    }
  },
  methods: {
    fixPost: function(target, pos) {
      if (target[pos].post_type == 1) return true;
      else return false;
    },
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    onToggle() {
      this.currentChoices = "";
      const themaChoice = this.thema;
      for (let key in themaChoice) {
        if (themaChoice[key].state === true) {
          this.currentChoices += themaChoice[key].name + " ";
        }
      }
      
      this.user.mem_interest = this.currentChoices;
      
    },
    move: function(postNo) {
      this.$router.push("/page1/postdetail/" + postNo);
    },
    updateUser() {
      UserService.updateUser(this.user).then(res => {
      });
    },
    getPastInterest() {
      const pastChoice = this.user.mem_interest;
      if (pastChoice !== "undefined") {
        const tempInterest = pastChoice.split(" ");
        for (let key in tempInterest) {
          for (let themaKey in this.thema) {
            if (this.thema[themaKey].name === tempInterest[key]) {
              this.thema[themaKey].state = true;
            }
          }
        }
      }
    },
    movefollowing(target) {
      this.$router.push(`/userpage/${target}`);
    },
    movefollower(target) {
      this.$router.push(`/userpage/${target}`);
    },
    moveHot(no) {
      this.$router.push(`/hotplace/${no}`);
    },
    movePost(no) {
      this.$router.push(`/page1/postdetail/${no}`);
    },
    moveFesta(no) {
      this.$router.push(`/festival/${no}`);
    }
  },
  mounted() {
    this.getPastInterest();
    this.$store.dispatch("user/getFollower", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getFollowing", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getLikePost", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getLikeHot", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getLikeFesta", {
      userNo: this.$store.state.user.user.mem_no
    });
    this.$store.dispatch("user/getPostListMem", {
      no: this.$store.state.user.user.mem_no
    });
  }
};
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  max-width: 450px
</style>
