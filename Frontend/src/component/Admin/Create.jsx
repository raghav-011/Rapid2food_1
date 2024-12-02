import React, { useEffect } from "react";
import axios from "axios";
import "../../../css/create.css";
import { useParams } from "react-router-dom";

function Create() {
  let id = useParams();
  const [catId, updatecatId] = React.useState([]);
  const [msg, changeMsg] = React.useState("");

  useEffect(() => {
    axios.get("http://localhost:9090/api/block/").then((res) => {
      // updatecatId(res.body.category.blockId);
      console.log(res.data);
      updatecatId(res.data);
    });
  }, []);

  const uniqueId = new Set();
  // const uniqueTitle = new Set();
  const collection = new Map();

  catId.map((value) => {
    collection.set(value.blockId, value.blockTitle);
  });

  let storecat = () => {
    const options = []; // create an empty array to hold the options
    for (let [key, value] of collection.entries()) {
      if (uniqueId.has(value) || value === null) {
        console.log(`Value '${value}' already exists in the Map.`);
      } else {
        options.push(
          <option key={key} value={key}>
            {value}
          </option>
        );
        uniqueId.add(value);
      }
    }
    return options; // return the array of options
  };

  const createStore = (event) => {
    event.preventDefault();
    const title = document.getElementById("form__title").value;
    const userId = document.getElementById("form__Id").value;
    const categoryId = document.getElementById("form__cat").value;
    axios
      .post(
        `http://localhost:9090/api/user/${userId}/category/${categoryId}/stores`,
        { title }
      )
      .then(() => {
        changeMsg("Hurrah! New Store added");
      })
      .catch(() => {
        changeMsg("CrossCheck Your UserId and BlockId");
      });
  };

  return (
    <>
      <form>
        <div className="divtitle">
          <label htmlFor="form__title">Enter Title</label>
          <input
            required
            type="text"
            id="form__title"
            placeholder="eg. oven express"
          />
        </div>

        <div className="pass">
          <label htmlFor="form__Id">Enter User ID</label>
          <input readOnly type="number" value={id.id} id="form__Id" />
        </div>

        <label htmlFor="form__Id">Select Category ID</label>
        <select name="CategoryId" id="form__cat">
          {storecat()}
        </select>
        <button
          onClick={createStore}
          className="createForm__submit"
          type="submit"
        >
          Submit
        </button>
      </form>
      <span className="notify">{msg}</span>
    </>
  );
}

export default Create;
