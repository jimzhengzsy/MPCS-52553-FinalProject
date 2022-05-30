import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Navbar from "./components/Navbar";
import ShowProfile from "./components/ShowProfile";
import EditProfile from "./components/EditProfile";
import ChangePwd from "./components/ChangePwd";
import ChangeQues from "./components/ChangeQues";
import ShowStatus from "./components/ShowStatus";
import AdminCourse from "./components/AdminCourse";
import ActiveUsers from "./components/ActiveUsers";
import InactiveUsers from "./components/InactiveUsers";
import ChangeStatus from "./components/ChangeStatus";
import Sidebar from "./components/AdminCourse";
import Forget from "./components/Forget";
import Login from "./components/Login";
import Signup from "./components/Signup";
import Dashboards from "./components/Dashboards";


function App() {
  return (
    <>
      <BrowserRouter>
        
        <Routes>
          

          <Route path="/login" element={ <Login />} />
          
          <Route path="/signup" element = {<Signup />} />
          
          <Route path="/forget" element = {<Forget />} />
          
          <Route path="/dashboards" element = {<Dashboards />} />
          <Route index element={<ShowProfile />} />
          <Route path="/" element={<ShowProfile />}></Route>
          <Route path="/showProfile" element={<ShowProfile />} />
          <Route path="/editProfile/:id" element={<EditProfile />} />
          <Route path="/changePwd/:id" element={<ChangePwd />} />
          <Route path="/changeQues/:id" element={<ChangeQues />} />
          <Route path="/setting" element={<ShowStatus />} />
          <Route path="/ActiveUsers" element={<ActiveUsers />} />
          <Route path="/InactiveUsers" element={<InactiveUsers />} />
          <Route path="/ChangeStatus/:id" element={<ChangeStatus />} />
          <Route path="/course" element={<AdminCourse />} />

        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
