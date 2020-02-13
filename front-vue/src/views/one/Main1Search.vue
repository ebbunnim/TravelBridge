<template>
  <div align="center">
    <div class="row justify-center">
      <q-input v-model="text" label="검색어" class="col-7">
        <template v-slot:append>
          <q-icon
            v-if="text !== ''"
            name="close"
            @click="text = ''"
            class="cursor-pointer"
          />
          <q-icon name="search" />
        </template>
      </q-input>
    </div>

    <div class="row justify-center" align="center">
      <q-btn color="primary" icon="check" label="OK" />
      <q-btn color="primary" icon="check" label="OK" />
      <q-btn color="primary" icon="check" label="OK" />
      <q-btn color="primary" icon="check" label="OK" />
      <q-btn color="primary" icon="check" label="OK" />
      <q-btn color="primary" icon="check" label="OK" />
      <q-btn color="primary" icon="check" label="OK" />
    </div>
    <q-separator spaced inset vertical dark />
    <div
      v-for="(tta, index) in this.titles"
      :key="index"
      class="row justify-center"
      v-bind:class="{}"
    >
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
        <template v-if="tt == 1">
          <q-card class="my-card1" flat bordered style="width:100%;">
            <q-img src="https://cdn.quasar.dev/img/parallax2.jpg" />
            <q-card-section>
              <div class="text-overline text-orange-9">Overline</div>
              <div class="text-h5 q-mt-sm q-mb-xs">Title</div>
              <div class="text-caption text-grey">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </div>
            </q-card-section>
          </q-card>
        </template>
        <template v-else-if="tt == 2">
          <q-card class="my-card1" flat bordered>
            <q-card-section horizontal style="width:100%;">
              <q-card-section class="q-pt-xs col-7">
                <div class="text-overline">Overline</div>
                <div class="text-h5 q-mt-sm q-mb-xs">Title</div>
                <div class="text-caption text-grey text-body-2">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna
                  aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing
                  elit, sed do eiusmod tempor incididunt ut labore et dolore
                  magna aliqua.Lorem ipsum dolor sit amet, consectetur
                  adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliquaLorem ipsum dolor sit amet, consectetur
                  adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur
                  adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua..
                </div>
              </q-card-section>

              <q-card-section class="col-5 flex flex-center">
                <q-scroll-area style="width:100%;height:100%;">
                  <q-timeline color="secondary">
                    <q-timeline-entry body="November, 2017" />

                    <q-timeline-entry
                      title="Event Title"
                      subtitle="February 22, 1986"
                      :body="body"
                    />

                    <q-timeline-entry
                      title="Event Title"
                      subtitle="February 22, 1986"
                      :body="body"
                    />

                    <q-timeline-entry body="November, 2017" />
                    <q-timeline-entry
                      title="Event Title"
                      subtitle="February 22, 1986"
                      :body="body"
                    />

                    <q-timeline-entry
                      title="Event Title"
                      subtitle="February 22, 1986"
                      :body="body"
                    />
                  </q-timeline>
                </q-scroll-area>
              </q-card-section>
            </q-card-section>
          </q-card>
        </template>
        <template v-else>
          <q-card-section horizontal>
            <q-card-section class="q-pt-xs">
              <div class="text-overline">Overline</div>
              <div class="text-h5 q-mt-sm q-mb-xs">Title</div>
              <div class="text-caption text-grey">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </div>
            </q-card-section>

            <q-card-section class="col-5 flex flex-center">
              <q-img
                class="rounded-borders"
                src="https://cdn.quasar.dev/img/parallax2.jpg"
              />
            </q-card-section>
          </q-card-section>
        </template>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      text: "",
      postList: [
        1,
        1,
        1,
        1,
        1,
        1,
        2,
        1,
        1,
        1,
        2,
        1,
        2,
        2,
        2,
        1,
        1,
        2,
        1,
        2,
        2,
        2,
        1,
        2,
        1,
        1,
        1,
        2,
        1
      ]
    };
  },
  computed: {
    titles: function() {
      var titles = [];
      var cnt = 0;
      var ti = [];

      for (var i of this.postList) {
        if (i == 1) cnt = cnt + 1;
        else if (i == 2) cnt = cnt + 2;

        if (cnt == 4) {
          ti.push(i);
          titles.push(ti);
          ti = [];
          cnt = 0;
        } else if (cnt > 4) {
          ti.push(3);
          titles.push(ti);
          ti = [];
          cnt = 2;
          ti.push(i);
        } else if (cnt < 4) {
          ti.push(i);
        }
      }

      return titles;
    }
  },
  methods: {
    fixPost: function(target, pos) {
      if (target[pos] == 2) return true;
      else return false;
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
@keyframes anima {
  from {
    -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=($opacity * 100))";
    filter: alpha(opacity=0);
    -moz-opacity: 0;
    -khtml-opacity: 0;
    opacity: 0;
  }
  to {
    -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=($opacity * 100))";
    filter: alpha(opacity=100);
    -moz-opacity: 1;
    -khtml-opacity: 1;
    opacity: 1;
  }
}

@-webkit-keyframes anima {
  from {
    -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=($opacity * 100))";
    filter: alpha(opacity=0);
    -moz-opacity: 0;
    -khtml-opacity: 0;
    opacity: 0;
  }
  to {
    -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=($opacity * 100))";
    filter: alpha(opacity=100);
    -moz-opacity: 1;
    -khtml-opacity: 1;
    opacity: 1;
  }
}
.custom-caption {
  text-align: center;
  padding: 12px;
  color: white;
  background-color: rgba(0, 0, 0, 0.3);
}

.pic {
  position: relative;
  overflow: hidden;
  display: inline-block;
  -webkit-animation: anima 2s;
  -moz-animation: anima 2s;
  -o-animation: anima 2s;
  -ms-animation: anima 2s;
  animation: anima 2s;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  -o-backface-visibility: hidden;
  -ms-backface-visibility: hidden;
  backface-visibility: hidden;
}

.pic-caption {
  cursor: default;
  position: absolute;
  width: 100%;
  height: 100%;
  background: rgba(44, 62, 80, 0.66);
  padding: 10px;
  text-align: center;
  -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=($opacity * 100))";
  filter: alpha(opacity=0);
  -moz-opacity: 0;
  -khtml-opacity: 0;
  opacity: 0;
}

.pic-title {
  font-size: 1.8em;
}

a,
a:hover,
.pic .pic-image,
.pic-caption,
.pic:hover .pic-caption,
.pic:hover img {
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -ms-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

.pic:hover .bottom-to-top {
  -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=($opacity * 100))";
  filter: alpha(opacity=100);
  -moz-opacity: 1;
  -khtml-opacity: 1;
  opacity: 1;
  -webkit-user-select: none;
  -moz-user-select: none;
  -o-user-select: none;
  -ms-user-select: none;
  user-select: none;
  -webkit-touch-callout: none;
  -moz-touch-callout: none;
  -o-touch-callout: none;
  -ms-touch-callout: none;
  -webkit-tap-highlight-color: transparent;
  -moz-tap-highlight-color: transparent;
  -o-tap-highlight-color: transparent;
  -ms-tap-highlight-color: transparent;
}

.bottom-to-top {
  top: 50%;
  left: 0;
}

.pic:hover .bottom-to-top {
  top: 0;
  left: 0;
}
</style>
