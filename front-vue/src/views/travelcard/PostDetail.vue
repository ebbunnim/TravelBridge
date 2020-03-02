<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold"></div>
      </div>
    </q-img>

    <q-card class="q-pa-xl q-ma-lg" flat bordered>
      <q-card-section align="center">
        <div class="text-h5 text-weight-bold">{{ post.post_title }}</div>
        <q-chip
          size="md"
          rounded
          icon="directions"
          :label="post.post_city"
        ></q-chip>
        <q-chip
          class="q-my-lg"
          size="md"
          v-for="(tag, index) in tagToArray"
          :key="index"
          >{{ tag }}</q-chip
        >
      </q-card-section>

      <q-card-section class="row justify-between" style="text-align: left">
        <div class="col-md-4">
          <q-btn
            class="col-md-4"
            flat
            no-wrap
            color="primary"
            icon="arrow_back"
            label="목록으로"
            @click="goBack()"
          />
        </div>
        <div class= "col-me-3" style="text-align:center">
          
          <template v-if="typeof like !== 'object' || like === undefined ">
            <q-icon name="favorite" class="text-black" style="font-size: 4rem;" @click="thislike()"/>
          </template>
          <template v-else>
            <template v-if ="Object.keys(like).length === 0">
            <q-icon name="favorite" class="text-black" style="font-size: 4rem;" @click="thislike()"/>
            </template>
            <template v-else>
             <q-icon name="favorite" class="text-red" style="font-size: 4rem;" @click="unlike()"/>
            </template>
          </template>

        </div>
        <div class="col-md-4 offset-md-4 q-mt-sm" style="text-align: right">
          작성일시
          <b>{{ post.post_regtime }}</b> / 작성자
          <b @click="goUser(post.mem_no)">{{ post.post_writer }}</b> / HIT
          <b>{{ post.post_hits }}</b>
        </div>
      </q-card-section>

      <q-separator inset />
      <!--  -->
      <q-card-section class="row">
        <q-carousel
          class="col-md-6 col-xs-12 q-pa-sm"
          arrows
          animated
          swipeable
          :autoplay="2000"
          infinite
          v-model="slideOne"
          height="350px"
        >
          <q-carousel-slide
            v-for="(mainCard, index) in post.post_filesList"
            :key="index"
            :name="index"
            :img-src="mainCard.files_url"
          ></q-carousel-slide>
        </q-carousel>
        <div class="col-md-6 col-xs-12 q-pa-sm">
          <p v-html="post.post_content"></p>
        </div>
      </q-card-section>
      <q-card-section class="row justify-center" style="min-height:300px;">
       
          <div class="col-6">
            <p>댓글</p>
            <template v-if="post.post_cmtList != []">
              <q-list style="width:100%;">
                <q-item v-for="(cmt, index) of post.post_cmtList" :key="index">
                  <q-item-section>
                    <q-item-label overline>{{ cmt.cmt_writer }}</q-item-label>
                    <q-item-label>{{ cmt.cmt_content }}</q-item-label>
                  </q-item-section>

                  <q-item-section side top>
                    <q-item-label caption
                      >작성일 : {{ cmt.cmt_regtime }}</q-item-label
                    >
                  </q-item-section>
                </q-item>
              </q-list>
            </template>
            <div>
              댓글 쓰기
              <q-input outlined v-model="cmt">
                <template v-slot:append>
                  <q-icon
                    v-if="cmt !== ''"
                    name="close"
                    @click="cmt = ''"
                    class="cursor-pointer"
                  />
                  <q-icon name="add" @click="addCmt" />
                </template>
              </q-input>
            </div>
          </div>
        
        <div class="col-6" >
          <template v-if="post.post_type == 1">
            일정
            <q-scroll-area style="width:100%;height:100%;">
              <q-timeline color="secondary">
                <template v-if="post.post_courseList.length != 0">
                  <div>
                    <q-timeline-entry
                      v-for="(a, index) of post.post_courseList"
                      :key="index"
                    >
                      <template v-slot:title>{{ a.course_title }}</template>
                      <div class="text-body-4">{{ a.course_description }}</div>
                    
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
          </template>
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slideOne: 0,
      cmt: ""
    };
  },
  mounted() {
    if (this.$route.params != null) {
      this.$store.dispatch("post/searchInfoPost", {
        postNo: this.$route.params.postNo
      });
    }
    // 좋아요 변수
    this.$store.dispatch("post/getPostLike", {
      post_no: this.$route.params.postNo,
      mem_no: this.$store.state.user.user.mem_no
    });

  },
  computed: {
    post() {
      return this.$store.state.post.post;
    },
    tagToArray() {
      const arr = this.post.post_category.split(" ");
      return arr;
    },
    like() {
      return this.$store.state.post.likePost;
    }
  },
  methods: {
    addCmt() {
      let x = {
        cmt_content: this.cmt,
        cmt_writer: this.$store.state.user.user.mem_id,
        mem_no: this.$store.state.user.user.mem_no,
        post_no: this.post.post_no
      };
      this.$store.dispatch("post/addCmt", {
        x,
        postNo: this.$route.params.postNo
      });
    },
    getImgUrl(img) {
      return require("@/assets/" + img);
    },
    goBack: function() {
      this.$router.go(-1);
      return;
    },
    goUser: function(no) {
      this.$router.push(`/userpage/${no}`);
    },
    thislike: function(){
      let x = {
        like_type : 1,
        post_no : this.post.post_no,
        liker_mem_no : this.$store.state.user.user.mem_no,
      }
      
        this.$store.dispatch("post/setPostLike",{x})
    },
    unlike: function(){
        this.$store.dispatch("post/deleteLikePost",{no : this.like.like_no, post_no:this.post.post_no,mem_no : this.$store.state.user.user.mem_no})
    }
  }
};
</script>

<style></style>
