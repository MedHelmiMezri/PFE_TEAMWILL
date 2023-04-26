import axios from 'axios';
import authHeader from './auth-header';


const base_url= "http://localhost:8083/target" ;


class TaskService {
  getAll() {
    return axios.get("http://localhost:8083/target/show-tasks",{ headers: authHeader() });
  }




}

export default new TaskService();
