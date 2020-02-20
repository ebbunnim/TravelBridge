import Api from "./Api";
class PostService {
  GetSearchAllPost(PageNo, option, word) {
    // /Post/search / page / { btnCnt } / { searchOption } / { word }
    if (option == undefined) option = "empty";
    if (word == undefined) word = "empty";
    return Api.get(`/Post/search/page/${PageNo}/${option}/${word}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(exp => console.log("Err post Search All " + exp));
  }

  GetSearchPost(postNo) {
    return Api.get(`/Post/search/${postNo}`)
      .then(Response => {
        console.log("옴뇸뇸2");
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(exp => console.log("Err post search no ") + exp);
  }
  PostInsertPost(post) {
    return Api.post("/Post/inser", { post })
      .then(() => {
        alert("글쓰기 성공");
        return true;
      })
      .catch(exp => {
        alert("글쓰기 실패 " + exp);
        return false;
      });
  }
  GetSearchFollow(userno) {
    console.log("Asd");
    console.log(userno);
    return Api.get(`/Members/searchFollowingPeoplePost/${userno}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data.mem_followPost;
      })
      .catch(exp => console.log("Err get follower search" + exp));
  }
}

export default new PostService();
