import axios from 'axios';
import authHeader from './auth-header';


const base_url= "http://localhost:8083/target" ;


class TaskService {

  getAll() {
    return axios.get("http://localhost:8083/target/show-tasks", { headers: authHeader() });
  }

  gettaskperProject(id) {
    return axios.get(base_url+`/tasks-per-project/${id}`, { headers: authHeader() }) ;
  }

  updatetaskStatus(id , status) {
    return axios.put(base_url+`/updatetaskstatus/${id}/${status}` , { headers: authHeader() }) ;
  }

  addTaskinProject( id , data) {
    return axios.post(base_url+`/add-task/${id}`, data , { headers: authHeader() } )
  }

  usernames () {
    return axios.get("http://localhost:8083/target/usernames" , { headers : authHeader()}  )
  }


  affectOwner (id , username) {
    return axios.post(base_url+`/affect-task/${id}/${username}` ,{ headers : authHeader()})
  }
}

export default new TaskService();
