<template>
  <div>
    <div style="height: 65px; background: #f9f9f9"></div>
    <q-img :src="getImgUrl('cutbg.jpg')">
      <div style="width: 100%; height: 100%" class="text-center">
        <div class="text-h5 text-weight-bold absolute-center">About Service</div>
      </div>
    </q-img>
    <div class="row q-ma-lg q-px-xl items-center" v-for="(service, index) in serviceList" :key="index">
      <div class="col-4">
        <q-img :src="service.img"></q-img>
      </div>
      <div class="col-8">
        <div class="text-center text-weight-bold text-h3">{{ service.name }}</div>
        <div>{{ service.content }}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      serviceList: [
        {
          name: "TravelCard",
          content: `별 나는 나의 딴은 그리고 말 계십니다. 이 사람들의 벌써 봅니다. 하나에 써 별이 듯합니다. 이웃 새겨지는 아무 마리아 멀리 아직 있습니다. 쓸쓸함과 사람들의 까닭이요, 파란 멀듯이, 이름자 비둘기, 이름과, 보고, 있습니다. 어머니, 쓸쓸함과 계절이 많은 써 노새, 별을 까닭입니다. 별을 청춘이 아름다운 까닭입니다. \n 언덕 나는 마리아 까닭입니다. 나는 가을로 경, 이런 있습니다. 릴케 까닭이요, 나는 마디씩 별이 거외다. 별빛이 언덕 별 있습니다. 차 다 그리고 딴은 새겨지는 잠, 토끼, 봅니다. 그리워 사람들의 사랑과 아직 위에 오는 부끄러운 노새, 있습니다. 쉬이 별 지나고 불러 별 위에도 버리었습니다.`,
          img:
            "https://static.wixstatic.com/media/c6ba6c_aebcc81da4a34f17b880471dec4ed9cb~mv2.gif"
        },
        {
          name: "TravelPick",
          content: `별 나는 나의 딴은 그리고 말 계십니다. 이 사람들의 벌써 봅니다. 하나에 써 별이 듯합니다. 이웃 새겨지는 아무 마리아 멀리 아직 있습니다. 쓸쓸함과 사람들의 까닭이요, 파란 멀듯이, 이름자 비둘기, 이름과, 보고, 있습니다. 어머니, 쓸쓸함과 계절이 많은 써 노새, 별을 까닭입니다. 별을 청춘이 아름다운 까닭입니다. \n 언덕 나는 마리아 까닭입니다. 나는 가을로 경, 이런 있습니다. 릴케 까닭이요, 나는 마디씩 별이 거외다. 별빛이 언덕 별 있습니다. 차 다 그리고 딴은 새겨지는 잠, 토끼, 봅니다. 그리워 사람들의 사랑과 아직 위에 오는 부끄러운 노새, 있습니다. 쉬이 별 지나고 불러 별 위에도 버리었습니다.`,
          img:
            "https://static.wixstatic.com/media/c6ba6c_aebcc81da4a34f17b880471dec4ed9cb~mv2.gif"
        },
        {
          name: "TravelPlus+",
          content: `별 나는 나의 딴은 그리고 말 계십니다. 이 사람들의 벌써 봅니다. 하나에 써 별이 듯합니다. 이웃 새겨지는 아무 마리아 멀리 아직 있습니다. 쓸쓸함과 사람들의 까닭이요, 파란 멀듯이, 이름자 비둘기, 이름과, 보고, 있습니다. 어머니, 쓸쓸함과 계절이 많은 써 노새, 별을 까닭입니다. 별을 청춘이 아름다운 까닭입니다. \n 언덕 나는 마리아 까닭입니다. 나는 가을로 경, 이런 있습니다. 릴케 까닭이요, 나는 마디씩 별이 거외다. 별빛이 언덕 별 있습니다. 차 다 그리고 딴은 새겨지는 잠, 토끼, 봅니다. 그리워 사람들의 사랑과 아직 위에 오는 부끄러운 노새, 있습니다. 쉬이 별 지나고 불러 별 위에도 버리었습니다.`,
          img:
            "https://static.wixstatic.com/media/c6ba6c_377676e7db5c4b58ac33dfe0f985bfe0~mv2.gif"
        }
      ]
    };
  },
  methods: {
    getImgUrl(img) {
      return require("@/assets/" + img);
    }
  }
};
</script>

<style>
/*  */
</style>
