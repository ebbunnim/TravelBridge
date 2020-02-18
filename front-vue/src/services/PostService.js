import Api from "./Api";
class PostService {
  GetSearchAllPost(PageNo) {
    return Api.get(`Post/search/pageAll/${PageNo}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(exp => console.log("Err post Search All " + exp));
  }

  GetSearchPost(postNo) {
    return Api.get(`/Post/search/${postNo}`)
      .then(Response => {
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
        console.log(Response.data.data.mem_followPost);
        return Response.data.data.mem_followPost;
      })
      .catch(exp => console.log("Err get follower search" + exp));
  }
}

export default new PostService();
