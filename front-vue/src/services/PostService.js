import Api from "./Api";
class PostService {
  GetSearchAllPost(PageNo, option, word) {
    if (option == undefined) option = "empty";
    if (word == undefined) word = "empty";
    return Api.get(`/Post/search/page/${PageNo}/${option}/${word}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(exp => console.log("Err post Search All " + exp));
  }

  GetSearchPost(postNo) {
    return Api.get(`/Post/search/${postNo}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(exp => console.log("Err post search no ") + exp);
  }
  PostInsertPost(post) {
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
    return Api.get(`/Members/searchFollowingPeoplePost/${userno}`)
      .then(Response => {
        return Response.data.data.mem_followPost;
      })
      .catch(exp => console.log("Err get follower search" + exp));
  }
  insertPostFile(file) {
    Api.post("/Files/insert", file)
      .then(Response => {})
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
        return true;
      })
      .catch(exp => console.log(exp));
    console.log(x);
  }
  getLikePost(no) {
    return Api.get(`/Members/searchMemberLikePost/${no}`).then(Response => {
      return Response.data.data;
    });
  }
  deleteLikePost(no) {
    return Api.delete(`/Likes/deletepost/${no}`).then(() => {
      return false;
    });
  }
  setPostLike(x) {
    return Api.post("/Likes/insert", x).then(() => {
      return true;
    });
  }
  getSearchLikePost(mem_no, post_no) {
    console.log(mem_no);
    return Api.get(`/Likes/postsearch/${mem_no}/${post_no}`).then(Response => {
      return Response.data.data;
    });
  }
  getPostListMem(no) {
    return Api.get(
      `/Post/searchMyPost/${no}
    `
    ).then(Response => {
      return Response.data.data;
    });
  }
}

export default new PostService();
