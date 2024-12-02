import { useState } from "react";
import "../../css/loginpanel.css";
import { FaUserCircle } from "react-icons/fa";
import axios from "axios";

function RegisterLogin() {
  const [isRegistered, changeIsRegistered] = useState("");

  function checkAuth() {
    event.preventDefault();
    axios
      .post("http://localhost:9090/api/users/", {
        name: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("loginpass").value,
        registrationNo: document.getElementById("userid").value,
      })
      .then((response) => {
        changeIsRegistered(
          "Registered Successfully UserId is " + response.data.id
        );
      })
      .catch((e) => {
        console.log(e);
      });
  }

  return (
    <>
      <div className="loginForm">
        <form onSubmit={checkAuth}>
          <label style={{ color: "pink", fontSize: "90px", marginTop: "15px" }}>
            {" "}
            <FaUserCircle />{" "}
          </label>
          <div className="loginForm__loginName">
            <label htmlFor="loginname">UserID</label>
            <input
              required
              placeholder="Enter Username"
              type="text"
              id="userid"
            />
          </div>
          <div className="loginForm__loginName">
            <label htmlFor="loginname">Username</label>
            <input
              required
              placeholder="Enter Username"
              type="text"
              id="username"
            />
          </div>
          <div className="loginForm__loginName">
            <label htmlFor="loginname">Email</label>
            <input required placeholder="Enter Email" type="text" id="email" />
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
        </form>
        <p className="isRegistered">{isRegistered}</p>
      </div>
    </>
  );
}

export default RegisterLogin;
