import Api from "./Api";

class PartyService {
  PartyList() {
    return Api.get("/Party").then(Response => {
      return Response;
    });
  }
  async PartyCreate() {
    return await Api.post("/Party")
      .then(() => {
        alert("파티 생성 성공");
        return true;
      })
      .catch(exp => {
        alert("파티 생성 실패 " + exp);
        return false;
      });
  }
  Party(no) {
    return Api.get(`/Party/${no}`).then(Response => {
      return Response;
    });
  }
  async Partyin() {
    return await Api.post("/PartyIn")
      .then(() => {
        alert("파티 참여 성공");
        return true;
      })
      .catch(exp => {
        alert("파티 참여 실패 " + exp);
        return false;
      });
  }
}

export default new PartyService();
