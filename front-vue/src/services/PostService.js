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
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(exp => console.log("Err post search no ") + exp);
  }
  PostInsertPost(post) {
    console.log(post);
    return Api.post("/Post/insert", post)
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
  insertPostFile(file) {
    Api.post("/Files/insert", file)
      .then(Response => {
        console.log(Response);
      })
      .catch(exp => console.log(exp));
  }
  LastNo() {
    return Api.get("/Post/LastNo").then(Response => {
      return Response.data.data;
    });
  }
  async insertPlan(file) {
    let x = await Api.post("/Course", file)
      .then(Response => {
        console.log(Response);
        return true;
      })
      .catch(exp => console.log(exp));
    console.log(x);
  }
}

export default new PostService();
