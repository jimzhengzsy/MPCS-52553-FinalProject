import React, { useEffect, useState } from "react";
import { useNavigate ,useParams} from "react-router-dom";
import UserService from "../services/UserService";
import Sidebar from "./Sidebar";
import GridLayout from "react-grid-layout";

const layout = [
  { i: "content", x: 1, y: 0, w: 4, h: 1, static: true },
  { i: "sidebar", x: 0, y: 0, w: 1, h: 1, static: true }
];

const ShowProfile = () => {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    id:"",
    name: "",
    email: "",
    studentid:"",
    pwd:"",
  });
  const editProfile = (e, id) => {
    e.preventDefault();
    navigate(`/editProfile/${id}`);
  };
  const changePwd = (e, id) => {
    e.preventDefault();
    navigate(`/changePwd/${id}`);
  };

  const changeQues = (e,id) =>{
    e.preventDefault();
    navigate(`/changeQues/${id}`)
  }
  

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await UserService.getUserInfo(user.id);
        setUser(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  

  return (
    <GridLayout layout={layout} cols={5} width={1200}>
    <div key = "sidebar">
        <Sidebar />
    </div>
    <div key = "content">
    <div className="container mx-auto my-8">
      <div className="h-12">
        <button
          onClick={(e, id) => editProfile(e, user.id)}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold">
          Edit Profile
        </button>
      </div>
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Email 
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Student ID
              </th>
            </tr>
          </thead>
          <tbody className="bg-white">
            <td className="text-left px-6 py-4 whitespace-nowrap">
              <div className="text-sm text-gray-500">{user.name}</div>
            </td>
            <td className="text-left px-6 py-4 whitespace-nowrap">
              <div className="text-sm text-gray-500">{user.email}</div>
            </td>
            <td className="text-left px-6 py-4 whitespace-nowrap">
              <div className="text-sm text-gray-500">{user.studentid}</div>
            </td>
          </tbody>      
        </table>
      </div>
      <div className="h-12 space-x-4">
        <button
          onClick={(e, id) => changePwd(e, user.id)}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold">
          Change Password
        </button>
        <button
          onClick={(e, id) => changeQues(e, user.id)}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold">
          Change Security Questions
        </button>
      </div>
    </div>
    </div>
        </GridLayout>
  );
};

export default ShowProfile;
