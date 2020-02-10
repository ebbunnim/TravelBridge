import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";

// Setup Firebase
// Do change to your own firebase configuration

const firebaseConfig = {
  apiKey: "AIzaSyCt4FnHbNGTAovXs3x6r2ezOXd6mhHFxBw",
  authDomain: "sub1-f38ef.firebaseapp.com",
  databaseURL: "https://sub1front.firebaseio.com",
  projectId: "sub1-f38ef",
  storageBucket: "sub1-f38ef.appspot.com"
};
firebase.initializeApp(firebaseConfig);

export default {
  async signUpWithDefault(email, password) {
    console.log(email + " " + password);
    return await firebase
      .auth()
      .createUserWithEmailAndPassword(email, password)
      .then(function(result) {
        console.log(result);
        return true;
      })
      .catch(function(error) {
        console.error("[Normal SignUp Error]", error);
        return false;
      });
  },
  async loginWithDefault(email, password) {
    console.log(email + " " + password);
    return await firebase
      .auth()
      .signInWithEmailAndPassword(email, password)
      .then(function(result) {
        console.log(result.user);
        return true;
      })
      .catch(function(error) {
        console.error("[Normal Login Error]", error);
        return false;
      });
  },
  loginWithGoogle() {
    let provider = new firebase.auth.GoogleAuthProvider();
    return firebase
      .auth()
      .signInWithPopup(provider)
      .then(function(result) {
        // let accessToken = result.credential.accessToken;
        //var user = result.user;
        return result;
      })
      .catch(function(error) {
        console.error("[Google Login Error]", error);
      });
  },
  loginWithGitHub() {
    var provider = new firebase.auth.GithubAuthProvider();
    return firebase
      .auth()
      .signInWithPopup(provider)
      .then(function(result) {
        // let accessToken = result.credential.accessToken;
        // var user = result.user;
        return result;
      })
      .catch(function(error) {
        console.error("[GitHub Login Error]", error);
      });
  },
  resetPw(email) {
    if (email.includes("@naver.com")) {
      alert("네이버에서 비밀번호를  찾아주세요.");
      return;
    } else if (email.includes("@google.com")) {
      alert("구글에서 비밀번호를 찾아주세요.");
      return;
    } else if (email.includes("@github.com")) {
      alert("깃허브에서 비밀번호를 찾아주세요.");
      return;
    }
    firebase
      .auth()
      .sendPasswordResetEmail(email)
      .then(function() {
        alert("가입한 이메일로 비밀번호 재설정 메일을 발송 하였습니다.");
      })
      .catch(function(error) {
        // An error happened.
        alert("등록되지 않은 회원입니다." + error);
      });
  }
};
