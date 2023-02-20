import http from "../http-common";

class ProjectDataService {
  getAll() {
    return http.get("http://localhost:8080/target/list-projects");
  }

  get(id) {
    return http.get(`http://localhost:8080/target/detail-porject/${id}`);
  }

  create(data) {
    return http.post("http://localhost:8080/target/add-project", data);
  }

  update(id, data) {
    return http.put(`/tutorials/${id}`, data);
  }

  delete(id) {
    return http.delete(`/tutorials/${id}`);
  }

  deleteAll() {
    return http.delete(`/tutorials`);
  }

  findByTitle(title) {
    return http.get(`/tutorials?title=${title}`);
  }
}

export default new ProjectDataService();
