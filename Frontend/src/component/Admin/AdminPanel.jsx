import "../../../css/adminpanel.css";
import { Link, Outlet } from "react-router-dom";
import Create from "./Create";

function AdminPanel({ userId }) {
  return (
    <>
      <div className="flex">
        <div className="leftcontainer">
          <ul className="leftcontainer__items">
            <Link to={`/admin/create/${userId}`}>
              {" "}
              <li className="leftcontainer__items__item">Create Store</li>
            </Link>
            <Link to={`/admin/stores/${userId}`}>
              <li className="leftcontainer__items__item">All Store</li>
            </Link>
            <Link to={`/admin/delete/${userId}`}>
              <li className="leftcontainer__items__item">Delete</li>
            </Link>
            <Link to={`/admin/upload/${userId}`}>
              <li className="leftcontainer__items__item">Image Upload</li>
            </Link>
          </ul>
        </div>
        <div className="rightcontainer">
          <Outlet className="rightcontainer__outlet">
            <Create userId="Enio" />
          </Outlet>
        </div>
      </div>
    </>
  );
}

export default AdminPanel;
