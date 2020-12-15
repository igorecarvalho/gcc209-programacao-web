import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:7979",
  headers: {
    "Content-type": "application/json"
  }
});