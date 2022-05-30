import axios from "axios";


class UserService {
    getUserById(id) {
        return axios.get("http://localhost:8080/api/users/"  + id);
      }

    getUsers() {
      return axios.get("http://localhost:8080/api/users");
    }
    
    updateUser(user, id) {
      return axios.put("http://localhost:8080/api/users/" + id, user);
    }

    getCourses() {
      return axios.get('http://localhost:8080/api/courses');
    }

    saveCourse(course) {
      return axios.post('http://localhost:8080/api/courses', course);
    }
}

export default new UserService();