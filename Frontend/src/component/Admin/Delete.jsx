import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import "../../../css/delete.css";

function Delete() {
  let id = useParams();
  let url = `http://localhost:9090/api/user/${id.id}/stores`;
  console.log();
  const [state, changeState] = useState([]);
  const [msd, updateMsg] = useState(" ");
  const [check, crossCheck] = useState("");

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

  const store = state.map((value, key) => {
    return (
      <option
        className="delForm__opt"
        key={value.storeId}
        value={value.storeId}
      >
        {" "}
        {value.title}
      </option>
    );
  });

  //cancel delete
  const cancelDelte = (event) => {
    event.preventDefault();
    document.getElementById("confirm").style.display = "none";
    document.getElementById("cancel").style.display = "none";
    crossCheck("");
  };

  //confirm delete
  const confirmDelte = (event) => {
    event.preventDefault();
    const id = document.getElementById("deleteid").value;
    axios
      .delete(`http://localhost:9090/api/stores/${id}`)
      .then((res) => {
        updateMsg("Deleted Successfully Done!");
        crossCheck("");
        document.getElementById("confirm").style.display = "none";
        document.getElementById("cancel").style.display = "none";
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const deleteFun = (event) => {
    event.preventDefault();
    const id = document.getElementById("deleteid").value;

    if (id) {
      crossCheck("Are You want to delete ?");
      document.getElementById("confirm").style.display = "block";
      document.getElementById("cancel").style.display = "block";
    }
  };

  return (
    <form className="delForm" onSubmit={deleteFun}>
      <select className="delForm__sel" name="Store Name" id="deleteid">
        {store}
      </select>
      <button className="delForm__btn" type="submit">
        Delete
      </button>

      <p className="delForm__warn">{check}</p>
      <div className="delForm__isbtn">
        <button
          className="delForm__btn1"
          style={{ display: "none" }}
          id="confirm"
          onClick={confirmDelte}
        >
          Confirm
        </button>
        <button
          className="delForm__btn2"
          style={{ display: "none" }}
          id="cancel"
          onClick={cancelDelte}
        >
          Cancel
        </button>
      </div>

      <span className="delForm__msg">{msd}</span>
    </form>
  );
}

export default Delete;
