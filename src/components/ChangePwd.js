import React, { useEffect,useState } from 'react'
import { useNavigate, useParams } from "react-router-dom";
import UserService from "../services/UserService";

const ChangePwd = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState({
    id: id,
    name: "",
    email: "",
    studentid:"",
    pwd:"",
  });
  const [pwd,setPwd]=useState({
      current:"",
      new:"",
      confirm:"",
  })
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

  const handleChange = (e) => {
    const value = e.target.value;
    setPwd({ ...pwd, [e.target.name]: value });
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

  const changePwd = (e) => {
    e.preventDefault();
    console.log(user);
    UserService.updateUser(user, id)
      .then((response) => {
        navigate(`/showProfile/${id}`);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(pwd));
    setIsSubmit(true);
  };

  const validate = (values) => {
    const errors = {};
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
    if (!values.current) {
      errors.username = "Current password is required!";
    }
    if (!values.new) {
      errors.email = "New password is required!";
    } else if (!regex.test(values.email)) {
      errors.email = "This is not a valid email format!";
    }
    if (!values.confirm) {
      errors.password = "Comfirming password is required!";
    } else if (values.password.length < 4) {
      errors.password = "Password must be more than 4 characters";
    } else if (values.password.length > 10) {
      errors.password = "Password cannot exceed more than 10 characters";
    }
    return errors;
  };

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      {Object.keys(formErrors).length === 0 && isSubmit ? (
        <div className="ui message success">Signed in successfully</div>
      ) : (
        <pre></pre>
      )}
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Change Password</h1>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Current Password
          </label>
          <input
            type="text"
            name="current"
            value={pwd.current}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            New Password
          </label>
          <input
            type="text"
            name="new"
            value={pwd.new}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Confirm new Password
          </label> 
          <input
            type="text"
            name="confirm"
            value={pwd.confirm}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={handleSubmit}
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

export default ChangePwd;