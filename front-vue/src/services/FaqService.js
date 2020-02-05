import Api from "./Api";

class faqService {
  selectAllFaqs() {
    let temp = Api.get("comment/search").then(result => {
      return result.data.data;
    });
    return temp;
  }
}

export default new faqService();
