<template>
  <div>
    <div class="q-ma-xl q-pa-xl">
      <q-card flat bordered>
        <q-card-section class="row">
          <div class="text-h6 q-my-sm text-center col-12">
            {{ fval.fval_start_day }} ~ {{ fval.fval_end_day }}
          </div>
          <div class="text-h4 q-my-sm text-center col-12">
            {{ fval.fval_name }}
          </div>
          <div class="text-h6 q-my-sm text-center col-12">
            <div>
              {{ fval.fval_detail_adr }}
              <a :href="fval.fval_homepage">
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
              <q-img :src="getImgUrl(fval.fval_img)" basic :ratio="16 / 9" />
            </div>
          </q-card-section>
          <q-card-section class="col-xs-12 col-md-6">
            <div class="q-ma-md">
              <div class="text-subtitle1">{{ fval.fval_holiday }}</div>
              <div class="text-subtitle1">{{ fval.fval_fee }}</div>
            </div>
            <div class="q-ma-lg">
              <div class="text-body1">{{ fval.fval_content }}</div>
            </div>
          </q-card-section>
          <q-card-section class="q-ma-md">{{ fval.fval_tag }}</q-card-section>
        </div>
      </q-card>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  data() {
    return {
      fval: {
        // 확인 후 삭제
        fval_no: 1,
        city_no: 15,
        fval_name: "경주 벚꽃축제 2019",
        fval_address: "경북 경주시",
        fval_detail_adr: "경상북도 경주시 첨성로 140-25",
        fval_content:
          "천년고도 경주에서 <2019경주벚꽃축제>가 4월 3일부터 4월 7일까지 첨성대를 비롯한 경주동부사적지대 일원에서 펼쳐진다.\n벚꽃과 문화예술이 한데 어우러지는 페스티벌을 통해 경주를 찾아온 관광객들에게 즐거움을 선사한다.\n대릉원, 황리단길 등 2019~2020년 한국관광 100선에 이름을 올린 경주의 대표관광명소와 탐스럽게 핀 벚꽃이 함께하는 절경 속으로 관광객들을 초대한다.\n\n[행사내용]\n봄을 알리는 소리, 벚꽃음악회\n⦁ 벚꽃이 흐드러지게 핀 경주의 사적지를 따라 열리는 벚꽃버스킹페스티벌\n⦁ 어린이부터 어른까지 모두 즐길 수 있는 벚꽃운동회 운영\n⦁ 경주에서만 즐길 수 있는 벚꽃야행 등 다채로운 체험프로그램 운영\n\n[부대행사]\n⦁ 체험행사\n- 벚꽃 페이스 페인팅, 벚꽃야행, 화전놀이, 벚꽃샤워 및 축제기념사진 인화, SNS참여이벤트 등\n\n[프로그램]\n⦁ 벚꽃음악회\n- 일시 : 4.5(금) 19:00부터\n- 장소 : 보문수상공연장\n⦁ 벚꽃버스킹 페스티벌\n- 일시 : 4.3(수) ~ 7(일) 13:00부터\n- 장소 : 첨성대, 대릉원돌담길, 교촌한옥마을, 월정교, 황리단길\n⦁ 벚꽃운동회\n- 일시 : 4.6(토) 11:00부터\n- 장소 : 첨성대 옆 잔디밭\n\n[참가안내]\n⦁ 벚꽃버스킹 페스티벌\n- 문의 : (재)경주문화재단 문화사업팀 054- 748 - 7721",
        fval_tag:
          "#가볼만한축제 #가족여행 #경상권 #경주벚꽃축제 #관광지 #기차여행 #꽃여행 #나들이 #데이트코스 #봄꽃#아이와함께 #연인과함께 #이색체험 #체험학습 #친구와함께 #힐링",
        fval_start_day: "2019-04-03",
        fval_end_day: "2019-04-07",
        fval_homepage: "http://www.cherryblossomfestival.kr",
        fval_fee: "무료",
        fval_img: "/img/festival/keongju.jpg",
        fval_host: "(주)한국국제전시",
        fval_theme: "#데이트 #힐링",
        fval_ended: 1,
        fval_del_check: 0
      }
    };
  },
  computed: {
    fval_no() {
      return this.$route.params.fval_no;
    },
    ...mapState({
      fval: state => state.festival.fval
    })
  },
  methods: {
    getImgUrl(img) {
      return require("../../../../back-spring/src/main/resources" + img);
    },
    getFestival() {
      this.$store.dispatch("festival/searchByNo", {
        no: this.$route.params.fval_no
      });
    }
  }
};
</script>

<style></style>
