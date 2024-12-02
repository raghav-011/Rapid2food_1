import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import App from "./component/App";
import Dashboard from "./component/Dashboard";
import Block from "./component/Block";
import Delete from "./component/Admin/Delete";
import Update from "./component/Admin/update";
import Create from "./component/Admin/create";
import OwnerDashboard from "./component/Owner/Dashboard";

ReactDOM.createRoot(document.getElementById("root")).render(
  <Router>
    <Routes>
      <Route path="/admin" element={<App />}>
        <Route path="create/:id" element={<Create />}></Route>
        <Route path="stores/:id" element={<Block />}></Route>
        <Route path="delete/:id" element={<Delete />}></Route>
        <Route path="upload/:id" element={<Update />}></Route>
      </Route>
      <Route path="/admin/:id" element={<Dashboard />}></Route>
      <Route path="/owner" element={<OwnerDashboard />}></Route>
    </Routes>
  </Router>
);
