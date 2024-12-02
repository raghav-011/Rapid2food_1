import { useState, useEffect } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import "../../css/block.css";

function Block() {
  const [state, changeState] = useState([]);
  let id = useParams();
  let url;
  if (id.id) url = `http://localhost:9090/api/user/${id.id}/stores`;
  else url = "http://localhost:9090/api/stores";
  // use Effect
  useEffect(() => {
    axios
      .get(url)
      .then((response) => {
        changeState(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  // looping here

  const card = state.map((key) => {
    return (
      <Link key={key.storeId} to={`/admin/${key.category.blockId}`}>
        <div className="card">
          <div className="card__imgs">
            <img
              src={`http://localhost:9090/api/post/image/${key.image}`}
              alt=""
              className="card__imgsimg"
            />
          </div>
          <div className="card__info">
            <p className="card__infostorename">
              <span>Item Name:</span>
              {key.title}
            </p>
            <p className="card__infocat">
              <span>Block Name:</span>
              {key.category.blockTitle}
            </p>
            <p className="card__infocatloc">
              <span>Location:</span> {key.category.blockDesc}
            </p>
            <p className="card__infouser">
              <span>Owner:</span> {key.user.name}
            </p>
          </div>
        </div>
      </Link>
    );
  });

  return <div className="container">{card}</div>;
}

export default Block;
