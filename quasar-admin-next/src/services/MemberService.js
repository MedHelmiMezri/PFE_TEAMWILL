import axios from 'axios';
import authHeader from './auth-header';


const base_url= "http://localhost:8083/target" ;


class MemberService {

  getAll() {
    return axios.get(base_url+"/all-users",{ headers: authHeader() });
  }

}


export default new MemberService();
