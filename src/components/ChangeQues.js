import React, { useEffect,useState } from 'react'
import { useNavigate, useParams } from "react-router-dom";
import UserService from "../services/UserService";

const ChangeQues = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState({
    id: id,
    name: "",
    email: "",
    studentid:"", 
    pwd:"", 
    q1:"",
    a1:"",
    q2:"",
    a2:"",
    q3:"",
    a3:""
  });

  const changeQues = (e) => {
    e.preventDefault();
    console.log(user);
    UserService.updateUser(user, id)
      .then((response) => {
        navigate("/showProfile");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleChange = (e) => {
    const value = e.target.value;
    setUser({ ...user, [e.target.name]: value });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await UserService.getUserById(user.id);
        setUser(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Change Security Questions</h1>
        </div>

        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Question 1
          </label>
          <select value={user.q1} onChange={handleChange}>
            <option value="What's your best friend's name?">What's your best friend's name?</option>
            <option value="What's your mother's name?">What's your mother's name?</option>
            <option value="What's your father's name?">What's your father's name?</option>
          </select>
          <label className="block text-gray-600 text-sm font-normal">
            Answer
          </label>
          <input
            type="text"
            name="a1"
            value={user.a1}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>

        <div className="items-center justify-center h-14 w-full my-20">
        <label className="block text-gray-600 text-sm font-normal">
            Question 2
          </label>
          <select value={user.q2} onChange={handleChange}>
            <option value="What's your best friend's name?">What's your best friend's name?</option>
            <option value="What's your mother's name?">What's your mother's name?</option>
            <option value="What's your father's name?">What's your father's name?</option>
          </select>
          <label className="block text-gray-600 text-sm font-normal">
            Answer
          </label>
          <input
            type="text"
            name="a2"
            value={user.a2}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>

        <div className="items-center justify-center h-14 w-full my-20">
        <label className="block text-gray-600 text-sm font-normal">
            Question 3
          </label>
          <select value={user.q3} onChange={handleChange}>
            <option value="What's your best friend's name?">What's your best friend's name?</option>
            <option value="What's your mother's name?">What's your mother's name?</option>
            <option value="What's your father's name?">What's your father's name?</option>
          </select>
          <label className="block text-gray-600 text-sm font-normal">
            Answer
          </label> 
          <input
            type="text"
            name="a3"
            value={user.a3}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={changeQues}
            className="rounded text-white font-semibold bg-green-400 hover:bg-green-700 py-2 px-6">
            Save
          </button>
          <button
            onClick={() => navigate("/showProfile/${id}")}
            className="rounded text-white font-semibold bg-red-400 hover:bg-red-700 py-2 px-6">
            Cancel
          </button>
        </div>
      </div>
    </div>
  )
}

export default ChangeQues;