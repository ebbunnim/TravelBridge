import axios from "axios";

export default axios.create({
  baseURL: "http://i02a402.p.ssafy.io:8080",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  }
});
