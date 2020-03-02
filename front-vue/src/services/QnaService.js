import Api from "./Api";

class QnaService {
  // 사용자에게 필요
  getUserQnas(mem_no) {
    return Api.get(`/Qna/searchForMember/${mem_no}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }

  insertQna(qna) {
    return Api.post("/Qna/insert", qna)
      .then(res => {
        return res.data.data;
      })
      .catch(e => console.log(e));
  }

  delete(qna_no) {
    return Api.delete(`/Qna/delete/${qna_no}`)
      .then(res => {
        return res.data.data;
      })
      .catch(e => console.log(e));
  }

  update(qna) {
    return Api.put("/Qna/update", qna)
      .then(res => {
        return res.data.data;
      })
      .catch(e => console.log(e));
  }

  // 관리자에게 필요
  getAllQnas() {
    return Api.get("/Qna/searchAll")
      .then(res => {
        return res.data.data;
      })
      .catch(e => console.log(e));
  }

  answerTheQuestion(qna) {
    return Api.put("/Qna/answerTheQuestion", qna)
      .then(res => {})
      .catch(e => {
        console.log(e);
      });
  }
}

export default new QnaService();
