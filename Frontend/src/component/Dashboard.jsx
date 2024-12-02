import { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import "../../css/Dashboard.css";

function Dashboard() {
  const [state, changeState] = useState([]);
  let param = useParams();

  // use Effect
  useEffect(() => {
    axios
      .get(`http://localhost:9090/api/category/${param.id}/stores`)
      .then((response) => {
        changeState(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  if (!state) return null;
  let blockTitle = "";
  const Info = state.map((key, value) => {
    blockTitle = key.category.blockTitle;
    return (
      <div key={value.storeId} className="dash__card">
        <div className="dash__card__imgs">
          <img
            src={`http://localhost:9090/api/post/image/${key.image}`}
            alt=""
            className="dash__card__imgsimg"
          />
        </div>
        <div className="dash__card__info">
          <p className="dash__card__infostorename">
            <span>Item Name:</span>
            {key.title}
          </p>
          <p className="dash__card__infocat">
            <span>Block Name:</span>
            {key.category.blockTitle}
          </p>
          <p className="dash__card__infocatloc">
            <span>Location:</span> {key.category.blockDesc}
          </p>
          <p className="dash__card__infouser">
            <span>Owner:</span> {key.user.name}
          </p>
        </div>
      </div>
    );
  });
  return (
    <>
      <h2 className="header">All Stores of {blockTitle}</h2>
      <div className="dash__Container">{Info}</div>
    </>
  );
}

export default Dashboard;
