import "../../css/navbar.css";

function Navbar({ username, isLogin }) {
  let topRight;
  if (username != null) {
    topRight = username;
  } else {
    topRight = "Admin Login";
  }

  return (
    <div className="navbar">
      <img
        className="navbar__brandName"
        src="../../Public/Image/logo.png"
        alt=""
      />
      <button onClick={isLogin} id="btn" className="navbar__login">
        {topRight}
      </button>
    </div>
  );
}

export default Navbar;
