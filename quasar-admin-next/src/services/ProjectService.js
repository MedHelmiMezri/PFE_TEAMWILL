import axios from 'axios';
import authHeader from './auth-header';


const base_url= "http://localhost:8083/target" ;


class ProjectService {

  getAll() {
    return axios.get(base_url+"/show-projects",{ headers: authHeader() });
  }

  create(data) {
    return axios.post(base_url+"/add-project", data ,{ headers: authHeader() });
  }

  get(id) {
    return axios.get(base_url+`/detail-project/${id}`,{ headers: authHeader() });
  }

  delete(id) {
    return axios.delete(base_url+`/delete-project/${id}` , {headers : authHeader()});
  }

}


export default new ProjectService();
