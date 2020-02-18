import Api from "./Api";

class UserService {
  async signUp(user) {
    console.log("hello");
    return await Api.post("/Members/insert", user)
      .then(() => {
        alert("회원가입 성공");
        return true;
      })
      .catch(exp => {
        alert("회원가입 실패 " + exp);
        return false;
      });
  }

  LogIn(email) {
    console.log(email);
    return Api.post("/Members/login", {
      mem_email: email
    }).then(response => {
      return response.data.data;
    });
  }

  updateUser(user) {
    console.log("수정시작");
    console.log(user);
    return Api.put("/Members/update", user)
      .then(res => {
        console.log("updateservice.js:", res.data.data);
        return res.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  followerUser(userNo) {
    console.log("팔로워");
    return Api.get(`/Members/searchFollowMePeople/${userNo}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  followingUser(userNo) {
    console.log("팔로잉");
    return Api.get(`/Members/searchMyFollowPeople/${userNo}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  likePost(userNo) {
    return Api.get(`/Members/searchMemberLikePost/${userNo}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  likeHot(userNo) {
    return Api.get(`/Members/searchMemberLikeHotPlace/${userNo}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  likeFesta(userNo) {
    return Api.get(`/Members/searchMemberLikeFestival/${userNo}`)
      .then(Response => {
        console.log(Response.data.data);
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  anotherUser(userNo) {
    return Api.get(`Members/search/${userNo}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(e => console.log(e));
  }
}

export default new UserService();
