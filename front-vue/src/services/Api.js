import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8081",
  // baseURL: "http://52.78.219.249:8080/TravelBridge-0.0.1-SNAPSHOT/",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  }
});
