import React from "react";
import Navbar from "./Navbar";
import Block from "./Block";
import LoginPanel from "./LoginPanel";
import RegisterLogin from "./RegisterLogin";
import AdminPanel from "../component/Admin/AdminPanel";

function App() {
  const [isclick, changeclick] = React.useState(false);
  const [isLogged, changeLogin] = React.useState(false);
  const [switchLtoR, changeLtoR] = React.useState(false);
  const [isAuth, changeAuth] = React.useState({
    isAuth: false,
    username: null,
    userId: null,
  });
  let com;

  // Switch Login to Register panel
  function SwitchLtoR() {
    changeLogin(!isLogged);
    changeLtoR(!switchLtoR);
    changeclick(true);
  }

  // Check login
  function isLogin() {
    if (isclick === true) {
      changeLtoR(false);
      changeLogin(false);
      changeclick(false);
    } else changeLogin(!isLogged);
  }

  if (!isAuth.username) {
    com = <Block />;
  } else {
    com = <AdminPanel userId={isAuth.userId} />;
  }

  // return the component
  return (
    <>
      {isLogged && isAuth.username === null && (
        <LoginPanel
          SwitchLtoR={SwitchLtoR}
          changeAuth={changeAuth}
          isLogin={isLogin}
        />
      )}
      {switchLtoR && <RegisterLogin />}
      <Navbar username={isAuth.username} isLogin={isLogin} />
      {com}
    </>
  );
}

export default App;
