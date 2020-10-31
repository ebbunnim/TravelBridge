import axios from "axios";

export default axios.create({
  //baseURL: "http://15.164.216.248:8080/TravelBridge-0.0.1-SNAPSHOT/",
  baseURL :"http://localhost:8082",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  }
});
