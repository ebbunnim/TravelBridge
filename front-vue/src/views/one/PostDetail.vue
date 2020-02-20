<template>
  <div>
    <div class="q-pa-xl">
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

          <div class="col-md-4 offset-md-4 q-mt-sm" style="text-align: right">
            작성일시
            <b>{{ post.post_regtime }}</b> / 작성자
            <b>{{ post.post_writer }}</b> / HIT
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
        <q-card-section class="row">
          <template class="col-12" v-if="post.post_plan_start != null"
            >플랜</template
          >
          <div>
            <p>댓글</p>
          </div>
        </q-card-section>

        <!--  -->
      </q-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slideOne: 0
    };
  },
  mounted() {
    if (this.$route.params != null) {
      this.$store.dispatch("post/searchInfoPost", {
        postNo: this.$route.params.postNo
      });
    }
  },
  computed: {
    post() {
      return this.$store.state.post.post;
    },
    tagToArray() {
      const arr = this.post.post_category.split(" ");
      return arr;
    }
  },
  methods: {
    goBack: function() {
      this.$router.go(-1);
      return;
    }
  }
};
</script>

<style></style>
