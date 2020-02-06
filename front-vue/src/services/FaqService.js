import Api from "./Api";

class FaqService {
  selectAllFaqs() {
    return Api.get("/Faq/search/all")
  }
}

export default new FaqService();
