import Api from "./Api";

class RankService {
  TotalRank() {
    return Api.get("/Rank/national").then(response => {
      return response;
    });
  }
  AreaRank(area) {
    return Api.get(`/Rank/national/${area}`).then(response => {
      return response;
    });
  }
}

export default new RankService();
