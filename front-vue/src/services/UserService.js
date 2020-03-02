import Api from "./Api";

class UserService {
  async signUp(user) {
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
    return Api.post("/Members/login", {
      mem_email: email
    }).then(response => {
      return response.data.data
    }).catch(error =>{
      if (error.response.status === 404) {
        return {status:false,email:email}
      } 
    });
  }

  updateUser(user) {
    return Api.put("/Members/update", user)
      .then(res => {
        return res.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  followerUser(userNo) {
    return Api.get(`/Members/searchFollowMePeople/${userNo}`).then(Response => {
      return Response.data.data;
    });
  }

  // no에 따른 Member가 좋아하는 핫플레이스 List를 조회하는 기능
  getLikedHotplaces(mem_no) {
    return Api.get(`/Members/searchMemberLikeHotPlace/${mem_no}`)
      .then(res => {
        return res.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  followingUser(userNo) {
    return Api.get(`/Members/searchMyFollowPeople/${userNo}`).then(Response => {
      return Response.data.data;
    });
  }

  // no에 따른 Member가 좋아하는 축제 List를 조회하는 기능
  getLikedFestivals(mem_no) {
    return Api.get(`/Members/searchMemberLikeFestival/${mem_no}`)
      .then(res => {
        return res.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  likePost(userNo) {
    return Api.get(`/Members/searchMemberLikePost/${userNo}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  likeHot(userNo) {
    return Api.get(`/Members/searchMemberLikeHotPlace/${userNo}`)
      .then(Response => {
        return Response.data.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
  likeFesta(userNo) {
    return Api.get(`/Members/searchMemberLikeFestival/${userNo}`)
      .then(Response => {
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
  addF(target){
    return Api.post(`/Follow/insert`,target).then(Response =>{
      return Response.data.data;
    })
  }
  delF(r,ing){
    return Api.delete(`/Follow/delete/${r}/${ing}`)
  }

  addCmt(cmt){
    return Api.post('/Comment',cmt)
  }
}

export default new UserService();
