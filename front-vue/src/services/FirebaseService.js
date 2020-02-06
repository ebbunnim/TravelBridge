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
  signUpWithDefault(email, password) {
    console.log(email + " " + password);
    firebase
      .auth()
      .createUserWithEmailAndPassword(email, password)
      .catch(function(error) {
        console.error("[Normal SignUp Error]", error);
      });
  },
  loginWithDefault(email, password) {
    console.log(email + " " + password);
    firebase
      .auth()
      .signInWithEmailAndPassword(email, password)
      .then(function(result) {
        console.log(result);
        return result;
      })
      .catch(function(error) {
        console.error("[Normal Login Error]", error);
      });
    console.log("login ok");
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
  }
};
