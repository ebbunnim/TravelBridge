import Api from "./Api";
class PostService {
  GetSearchAllPost() {
    return Api.get("Post/searchAll")
      .then(Response => {
        return Response.data.data;
      })
      .catch(exp => console.log("Err post Search All " + exp));
  }

  GetSearchPartPost(listNo) {
    return Api.get(`Post/searchAll/moreAll/${listNo}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(exp => console.log("Err post Search All " + exp));
  }
  GetSearchPost(postNo) {
    return Api.get(`/Post/search/WithCmtAndFiles/${postNo}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(exp => console.log("Err post search no ") + exp);
  }
  PostInsertPost(post) {
    return Api.post("Post/inser", { post })
      .then(() => {
        alert("글쓰기 성공");
        return true;
      })
      .catch(exp => {
        alert("글쓰기 실패 " + exp);
        return false;
      });
  }
  //withcomandfiles 는 뭐냐
  //수정
  // 삭제
}

export default new PostService();
