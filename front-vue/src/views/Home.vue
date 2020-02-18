<template>
  <div>
    <q-carousel arrows animated swipeable autoplay infinite v-model="slideOne" height="750px">
      <q-carousel-slide
        v-for="(mainCard, index) in MainCard"
        :key="index"
        :name="index"
        :img-src="mainCard.img"
      >
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">{{ mainCard.title }}</div>
          <div class="text-subtitle1">{{ mainCard.sub }}</div>
        </div>
      </q-carousel-slide>
    </q-carousel>
    <q-separator />
    <div class="row justify-center">
      <div class="col-10" style="margin-bottom:3%;">
        <div style="text-align:center">
          <h4>트래블 카드</h4>
        </div>
        <q-separator />
        <div class="column justify-center" style="height:270px; margin-top:1%;">
          <div class="row justify-around">
            <div class="col-5" style="text-align:center;">
              <div class="text-h2">서비스 제목</div>
              <q-separator spaced inset />
              <div class="text-subtitle1">우리서비스는 이렇고저렇고우리서비스는 이렇고저렇고우리서비스는</div>
            </div>
            <q-img
              :src="this.getImgUrl('bg.jpg')"
              style="height: 250px"
              spinner-color="primary"
              spinner-size="82px"
              class="col-5"
              align="left"
            />
          </div>
        </div>
        <div class="column justify-center" style="height:270px; margin-top:1%;">
          <div class="row justify-around">
            <q-img
              :src="this.getImgUrl('bg.jpg')"
              style="height: 250px"
              spinner-color="primary"
              spinner-size="82px"
              class="col-5"
              align="left"
            />
            <div class="col-5" style="text-align:center;">
              <div class="text-h2">서비스 제목</div>
              <q-separator spaced inset />
              <div class="text-subtitle1">우리서비스는 이렇고저렇고우리서비스는 이렇고저렇고우리서비스는</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row justify-center">
      <div class="col-10" style="margin-top:1%; margin-bottom:7%;">
        <div style="text-align:center">
          <h4>트래블 서치</h4>
        </div>
        <q-separator />
        <div class="column justify-center" style="height:270px; margin-top:1%;">
          <div class="row justify-around">
            <q-img
              :src="this.getImgUrl('bg.jpg')"
              style="height: 250px"
              spinner-color="primary"
              spinner-size="82px"
              class="col-5"
              align="left"
            />
            <div class="col-5" style="text-align:center;">
              <div class="text-h2">서비스 제목</div>
              <q-separator spaced inset />
              <div class="text-subtitle1">우리서비스는 이렇고저렇고우리서비스는 이렇고저렇고우리서비스는</div>
            </div>
          </div>
        </div>
        <div class="column justify-center" style="height:270px; margin-top:1%;">
          <div class="row justify-around">
            <div class="col-5" style="text-align:center;">
              <div class="text-h2">서비스 제목</div>
              <q-separator spaced inset />
              <div class="text-subtitle1">우리서비스는 이렇고저렇고우리서비스는 이렇고저렇고우리서비스는</div>
            </div>
            <q-img
              :src="this.getImgUrl('bg.jpg')"
              style="height: 250px"
              spinner-color="primary"
              spinner-size="82px"
              class="col-5"
              align="left"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    getImgUrl(img) {
      return require("../assets/" + img);
    }
  },
  data() {
    return {
      MainCard: [
        {
          img: require("../assets/bg.jpg"),
          title: "이번엔 어디로 여행가지?",
          sub: "국내 축제와 핫플은 다모아놨다!"
        },
        {
          img: require("../assets/main.gif"),
          title: "다른 사람들은 여행을 어떻게 갈까?",
          sub: "여행 정보 공유 라고 쓰고 자랑이라고 말하지"
        },
        {
          img: require("../assets/train.gif"),
          title: "가자 내일로 그런데 어디로?",
          sub: "내일로 추천의 신!"
        }
      ],
      slideOne: 0
    };
  }
};
</script>
<style lang="scss">
$s1: "";
$s2: "";
$s3: "";
@for $i from 1 through 400 {
  $s1: $s1 +
    random(1000) *
    0.1vw +
    " " +
    random(1000) *
    0.1vh +
    " " +
    0 +
    " " +
    random(50) *
    -0.01rem +
    #fffafa;
  $s2: $s2 +
    random(1000) *
    0.1vw +
    " " +
    random(1000) *
    0.1vh +
    " " +
    0 +
    " " +
    random(50) *
    -0.01rem +
    #fffafa;
  $s3: $s3 +
    random(1000) *
    0.1vw +
    " " +
    random(1000) *
    0.1vh +
    " " +
    0 +
    " " +
    random(50) *
    -0.01rem +
    #fffafa;
  @if $i < 400 {
    $s1: $s1 + ",";
    $s2: $s2 + ",";
    $s3: $s3 + ",";
  }
}
.snow {
  border-radius: 50%;
  opacity: 0.8;
  position: absolute;
  top: -100vh;
  animation-name: fall;
  animation-timing-function: linear;
  animation-iteration-count: infinite;
}
.layer1 {
  width: 1.5rem;
  height: 1.5rem;
  filter: blur(1.5px);
  box-shadow: #{$s1};
  animation-duration: 6s;
}
.layer1.a {
  animation-delay: -3s;
}
.layer2 {
  width: 1.2rem;
  height: 1.2rem;
  filter: blur(3px);
  box-shadow: #{$s2};
  animation-duration: 8s;
}
.layer2.a {
  animation-delay: -4s;
}
.layer3 {
  width: 0.8rem;
  height: 0.8rem;
  filter: blur(6px);
  box-shadow: #{$s3};
  animation-duration: 10s;
}
.layer3.a {
  animation-delay: -5s;
}
@keyframes fall {
  100% {
    transform: translateY(200vh);
  }
}

/* 카드 */
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
