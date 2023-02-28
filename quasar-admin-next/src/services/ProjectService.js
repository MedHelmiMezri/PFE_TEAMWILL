import axios from "axios";

const ProjectService = {

  async createProject(requestData) {
    const response = await axios.post("http://localhost:8083/add-project", requestData);
    return response.data;
  } ,
  async readProjects() {
    const response = await axios.get("http://localhost:8083/list-projects");
    return response.data;
} }

export default ProjectService;
