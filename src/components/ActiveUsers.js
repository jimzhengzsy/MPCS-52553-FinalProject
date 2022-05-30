import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import UserService from "../services/UserService";

const ActiveUsers = () => {
    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [users, setUsers] = useState(null);
  
    useEffect(() => {
      const fetchData = async () => {
        setLoading(true);
        try {
          const response = await UserService.getUsers();
          setUsers(response.data);
        } catch (error) {
          console.log(error);
        }
        setLoading(false);
      };
      fetchData();
    }, []);
  
    
  
    return (
      <div className="container mx-auto my-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Active Users</h1>
        </div>
  
        <div className="flex shadow border-b">
          <table className="min-w-full">
            <thead className="bg-gray-50">
              <tr>
                <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                  First Name
                </th>
                <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                  Last Name
                </th>
                <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                  Status
                </th>
              </tr>
            </thead>
            {!loading && (
              <tbody className="bg-white">
                {users.filter(user => user.status==="active").map((user) => (
                  <tr>
                  <td className="text-left px-6 py-4 whitespace-nowrap">
                    <div className="text-sm text-gray-500">{user.firstName}</div>
                  </td>
                  <td className="text-left px-6 py-4 whitespace-nowrap">
                    <div className="text-sm text-gray-500">{user.lastName}</div>
                  </td>
                  <td className="text-left px-6 py-4 whitespace-nowrap">
                    <div className="text-sm text-gray-500">{user.status}</div>
                  </td>
                  </tr>
                ))}
              </tbody>
            )}
          </table>
        </div>
      </div>
    );
}

export default ActiveUsers;