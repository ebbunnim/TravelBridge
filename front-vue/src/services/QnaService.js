import Api from "./Api";

class QnaService {
  // GET
  searchAll() {
    return Api.get("/Qna/searchAll");
  }
  // "member no에 따른 Qna 정보 조회하는 기능"
  searchForMember(mem_no) {
    return Api.get(`/Qna/searchForMember/${mem_no}`);
  }

  // POST
  insert(qna) {
    return Api.post("/Qna/insert");
  }

  // Delete
  delete(qna_no) {
    return Api.delete(`/Qna/delete/${qna_no}`);
  }

  // PUT
  update(qna) {
    return Api.put("/Qna/update");
  }

  answerTheQuestion(qna) {
    return Api.put("/Qna/answerTheQuestion");
  }
}
