<template>
  <div class="q-pa-none">
    <div class="q-col-gutter-lg items-start">
      <div class="col-12">
        <q-img :src="getImgUrl('bg.jpg')" style="width: 100%">
          <div class="absolute-center text-center" style="width: 100%">
            <p class="text-h4 q-pt-lg">
              <b>트래블브릿지</b>는 여행 관련 서비스를 제공하는 종합
              플랫폼입니다
            </p>
            <p class="text-body1">
              여행 계획과 후기를 공유하는 커뮤니티에서 여행지 정보 제공
              서비스까지
            </p>
          </div>
        </q-img>
      </div>
      <!-- 주요 서비스 소개 -->
      <div class="row" style="height: 350px; background: #f9f9f9">
        <div class="col text-left q-ma-lg q-pl-lg">
          <div class="">
            <p class="text-h4 q-pt-lg">트래블 카드</p>
            <p class="text-body1 q-ma-none">
              (임시)해외에서 전국 방방곡곡까지, 핫플에서 지역 축제까지 여행지
              정보를 검색해보세요.
            </p>
            <p class="text-body1 q-ma-none">
              당신의 트래블메이트를 찾을 수도 있습니다.
            </p>
          </div>
        </div>
      </div>

      <div class="row" style="height: 350px">
        <div class="col text-right q-ma-lg q-pr-lg">
          <div>
            <p class="text-h4 q-pt-lg">트래블 픽</p>
            <p class="text-body1 q-ma-none">
              당신의 트래블 픽을 선택해보세요. 테마별, 랜덤 추천서비스를
              제공합니다.
            </p>
            <p class="text-body1 q-ma-none">
              이번엔 어디로 떠날지 트래블브릿지와 함께 결정해보세요.
            </p>
          </div>
        </div>
      </div>
      <div class="row" style="height: 350px; background: #f9f9f9">
        <div class="col text-left q-ma-lg q-pl-lg">
          <div class="">
            <p class="text-h4 q-pt-lg">트래블 인포(가칭)</p>
            <p class="text-body1 q-ma-none">
              해외에서 전국 방방곡곡까지, 핫플에서 지역 축제까지 여행지 정보를
              검색해보세요.
            </p>
          </div>
        </div>
      </div>

      <div class="row" style="height: 350px">
        <div class="col text-right q-ma-lg q-pr-lg">
          <div>
            <p class="text-h4 q-pt-lg">임시제목</p>
            <p class="text-body1 q-ma-none"></p>
          </div>
        </div>
      </div>
      <!-- 마지막 시연 화면 -->
      <div class="row" style="height: 700px; background: #f9f9f9">
        <div class="col text-center q-ma-lg q-pl-lg">
          <div class="">
            <q-btn large color="primary" class="text-h6">둘러보기</q-btn>
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
  }
};
</script>

<style>
/*  */
</style>
