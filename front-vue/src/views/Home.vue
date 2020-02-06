<template>
  <div>
    <q-carousel arrows animated swipeable autoplay infinite v-model="slideOne" height="600px">
      <q-carousel-slide
        v-for="(mainCard,index) in MainCard"
        :key="index"
        :name="index"
        :img-src="mainCard.img"
      >
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">{{mainCard.title}}</div>
          <div class="text-subtitle1">{{mainCard.sub}}</div>
        </div>
      </q-carousel-slide>
    </q-carousel>
    <h2>hello</h2>

    <q-carousel
      v-model="slideTwo"
      transition-prev="slide-right"
      transition-next="slide-left"
      swipeable
      animated
      control-color="primary"
      navigation
      padding
      arrows
      autoplay
      infinite
      height="400px"
      class="bg-white text-black shadow-1 rounded-borders no-shadow"
    >
      <q-carousel-slide
        v-for="(subCard,index) in SubCard"
        :key="index"
        :name="index"
        class="column no-wrap"
      >
        <div class="row fit justify-start items-center q-gutter-xs q-col-gutter no-wrap">
          <q-img
            v-for="(subContent,index) in subCard"
            :key="index"
            class="col-4 full-height pic"
            :src="subContent.img"
          >
            <span class="pic-caption bottom-to-top">
              <h1 class="pic-title">{{subContent.title}}</h1>
              <p>{{subContent.sub}}</p>
            </span>
          </q-img>
        </div>
      </q-carousel-slide>
    </q-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      MainCard: [
        {
          img: require("../assets/bg.jpg"),
          title: "First stop",
          sub: "Mountains"
        },
        {
          img: require("../assets/main.gif"),
          title: "second stop",
          sub: "Mountains"
        },
        {
          img: "https://cdn.quasar.dev/img/donuts.png",
          title: "thrid stop",
          sub: "Mountains"
        }
      ],
      SubCard: [
        [
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          }
        ],
        [
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          }
        ],
        [
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          },
          {
            img: "https://cdn.quasar.dev/img/donuts.png",
            title: "thrid stop",
            sub: "Mountains"
          }
        ]
      ],
      slideOne: 0,
      slideTwo: 0
    };
  }
};
</script>
<style >
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