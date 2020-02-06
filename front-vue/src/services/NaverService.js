const BASE_URL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
const CLIENT_ID = "&client_id=" + "_8CH4AlS9eXUFGHZ1bxe";
const redirectURI = "&redirect_uri=" + "http%3A%2F%2Flocalhost%3A8081%2Flogin";
const state = "&state=" + "hLiDdL2uhPtsftcU";

export default {
  loginWithNaver() {
    return BASE_URL + CLIENT_ID + redirectURI + state;
  }
};
