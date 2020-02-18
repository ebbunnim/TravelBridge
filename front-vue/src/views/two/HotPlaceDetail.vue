<template>
  <div>
    <div class="q-ma-xl q-pa-xl">
      <q-card flat bordered>
        <q-card-section class="row">
          <div class="text-h4 q-mt-xl text-center col-12">{{ hp.hp_name }}</div>
          <div class="text-h6 q-my-md text-center col-12">
            <div>
              {{ hp.hp_detail_adr }}
              <a :href="hp.hp_homepage">
                <q-btn size="lg" flat>
                  <q-icon name="home"></q-icon>
                </q-btn>
              </a>
            </div>
          </div>
          <q-separator inset />
        </q-card-section>
        <div class="row justify-center">
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <q-img :src="getImgUrl(hp.hp_img)" basic :ratio="16 / 9" />
            </div>
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <div class="text-subtitle1">{{ hp.hp_holiday }}</div>
              <div class="text-subtitle1">{{ hp.hp_fee }}</div>
            </div>
            <div class="q-ma-lg">
              <div class="text-body1">{{ hp.hp_content }}</div>
            </div>
          </q-card-section>
          <q-separator inset />
          <q-card-section class="q-ma-md">{{ hp.hp_tag }}</q-card-section>
        </div>
      </q-card>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  // data() {
  //   return {
  //     hp: {
  //       // 확인 후 삭제
  //       hp_no: 1,
  //       city_no: 1,
  //       hp_name: "남산서울타워",
  //       hp_address: "서울 용산구",
  //       hp_detail_adr: "서울특별시 용산구 남산공원길 105",
  //       hp_content:
  //         "피어나기 생생하며, 뛰노는 그들은 이 보라. 오아이스도 내는 노년에게서 스며들어 말이다. 곳으로 가치를 가는 청춘에서만 그들의 없으면, 속잎나고, 가슴에 칼이다. 같은 광야에서 기쁘며, 행복스럽고 만천하의 것은 곳이 때문이다. 피고 가치를 인간에 크고 심장의 이것이야말로 힘있다. 그림자는 기관과 이것은 투명하되 착목한는 그들에게 청춘은 우리 것은 것이다. 봄날의 아름답고 청춘 이성은 이상의 생의 이상, 있는가? 끝에 구하지 뛰노는 피는 그림자는 위하여서. 인생에 열매를 설레는 않는 쓸쓸하랴? 돋고, 대한 그들은 행복스럽고 그들은 우리 영락과 이것을 인간이 듣는다. 인도하겠다는 현저하게 귀는 그러므로 어디 같이, 쓸쓸한 봄바람이다.",
  //       hp_tag:
  //         "#15_16한국관광100선 #17_18한국관광100선 #19_20한국관광100선 #가족여행 #경복궁 #고궁 #관광지 #교과서속여행 #당일치기여행 #서울 #서울근교여행 #수도권 #아이와함께 #역사 #역사유적지 #연인과함께 #전통역사문화체험 #친구와함께 #한국관광",
  //       hp_homepage: "http://www.seoultower.co.kr",
  //       hp_holiday: "연중무휴",
  //       hp_fee:
  //         "운행요금 : 대인왕복 9,500원 / 대인편도 7,000원 / 소인왕복 6,500원 / 소인편도 4,000원 ※ 30명 이상 단체의 경우 단체 할인 적용 ※ 소인 (36개월 ~ 초등학생) / 65세 이상은 소인요금 적용",
  //       hp_img: "/img/hotplace/seoultower.jpg"
  //     }
  //   };
  // },
  computed: {
    hp_no() {
      return this.$route.params.hp_no;
    },
    ...mapState({
      hp: state => state.hotplace.hp
    })
  },
  methods: {
    getImgUrl(img) {
      return require("../../../../back-spring/src/main/resources" + img);
    },
    getHotplace() {
      this.$store.dispatch("hotplace/searchByNo", 1);
    }
  },
  mounted() {
    this.getHotplace();
  }
};
</script>

<style></style>
