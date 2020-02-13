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
    <h2>이달의 축제</h2>
    <q-carousel arrows animated swipeable autoplay infinite v-model="slideThr" height="600px">
      <q-carousel-slide v-for="(mainCard,index) in ThrCard" :key="index" :name="index">
        <div class="row justify-around">
          <div class="col-5" style="text-align:center;">
            <div class="text-h2">{{mainCard.title}}</div>
            <q-separator spaced inset />
            <div class="text-subtitle1">{{mainCard.sub}}</div>
          </div>
          <q-img
            :src="mainCard.img"
            :ratio="16/9"
            spinner-color="primary"
            spinner-size="82px"
            class="col-5"
            align="left"
          />
        </div>
      </q-carousel-slide>
    </q-carousel>
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
          img: require("../assets/train.gif"),
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
      ThrCard: [
        {
          img:
            "https://support.visitkorea.or.kr/img/call?cmd=VIEW&id=ef4fe9a4-afa2-4bc6-97e2-cec199f22496",
          title: "오색별빛정원전 2020",
          sub:
            "10만여 평의 야외 정원 곳곳을 다채로운 조명과 빛을 이용하여 특별한 주제를 가지고 표현한 야간 조명 점등행사이다. 자연과 빛의 조화를 추구하며 국내 최초로 시도된 새로운 빛의 풍경인 ‘오색별빛정원전’은, 인공적인 조명 속에서도 한국 자연의 미(美)를 한껏 느낄 수 있어 많은 관람객들에게 사랑받고 있다. 매년 12월에서 3월 (동절기)사이 개최되는 '오색별빛정원전'은 수목원 내 전 정원을 밑그림 삼아 친환경 소재인 LED 전구를 사용하여 그려진 화려한 빛 축제의 장이 될 것이다."
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
      slideOne: 0,
      slideTwo: 0,
      slideThr: 0
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