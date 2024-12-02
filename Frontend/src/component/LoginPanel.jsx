import "../../css/loginpanel.css";
import { FaUserCircle } from "react-icons/fa";
import axios from "axios";
import { useState } from "react";

function LoginPanel({ SwitchLtoR, changeAuth, isLogin }) {
  const [warnMess, changeWarn] = useState("");
  function checkAuth() {
    const userId = document.getElementById("loginname").value;
    const paswd = document.getElementById("loginpass").value;
    event.preventDefault();

    axios
      .get(`http://localhost:9090/api/users/${userId}`)
      .then((response) => {
        if (response.data.id == userId && response.data.password == paswd) {
          const data = {
            isAuth: true,
            username: response.data.name,
            userId: userId,
          };
          changeAuth(data);
        } else {
          changeWarn("Password is Incorrect");
        }
      })
      .catch((err) => {
        changeWarn("User Id is Incorrect");
      });
  }

  return (
    <>
      <div className="loginForm">
        <form onSubmit={checkAuth}>
          <label className="loginForm__icon">
            {" "}
            <FaUserCircle />{" "}
          </label>
          <div className="loginForm__loginName">
            <label htmlFor="loginname">User Id</label>
            <input
              required
              placeholder="Enter Username"
              type="text"
              id="loginname"
            />
          </div>
          <div className="loginForm__pass">
            <label htmlFor="loginpass">Password</label>
            <input
              required
              placeholder="Enter your Password"
              type="password"
              id="loginpass"
            />
          </div>
          <button className="loginForm__submit" type="submit">
            Submit
          </button>
          <div className="loginForm__dontacnt"></div>
        </form>
        <a onClick={SwitchLtoR} style={{ color: "green", cursor: "pointer" }}>
          Don't have an account{" "}
        </a>
        <br />
        <span style={{color:"white"}}>{warnMess}</span>
      </div>
    </>
  );
}

export default LoginPanel;
