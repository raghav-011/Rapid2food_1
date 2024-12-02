import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import "../../../css/upload.css";

function Update() {
  let id = useParams();
  let url = `http://localhost:9090/api/user/${id.id}/stores`;
  const [state, changeState] = useState([]);
  const [msd, updateMsg] = useState(" ");

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

  const store = state.map((value) => {
    return (
      <option
        className="uploadForm__opt"
        key={value.storeId}
        value={value.storeId}
      >
        {" "}
        {value.title}
      </option>
    );
  });

  const updateFun = (event) => {
    event.preventDefault();
    const id = document.getElementById("updateid").value;
    const fileInput = document.getElementById("img");
    if (fileInput.files && fileInput.files[0]) {
      const formData = new FormData();
      formData.append("image", fileInput.files[0]);
      axios
        .post(`http://localhost:9090/api/stores/image/upload/${id}`, formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((res) => {
          // console.log(res);
          updateMsg("Image Uploaded Successfully Done");
        })
        .catch((err) => {
          console.log(err);
        });
    }
  };

  return (
    <form className="uploadForm" onSubmit={updateFun}>
      <select className="uploadForm__sel" name="Store Name" id="updateid">
        {store}
      </select>

      <input
        className="uploadForm__file"
        type="file"
        id="img"
        name="img"
        accept="image/*"
      />
      <button className="uploadForm__btn" type="submit">
        Upload
      </button>
      <br />
      <span className="uploadForm__msg">{msd}</span>
    </form>
  );
}

export default Update;
