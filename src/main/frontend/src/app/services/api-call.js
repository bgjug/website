import axios from "axios";

let baseUrl = null;
export default class ApiCall {

  static get(url, queryParams, contentType) {
    return this.requestHelper(url, 'GET', null, queryParams, contentType);
  }

  static post(url, data, contentType) {
    return this.requestHelper(url, 'POST', data, null , contentType);
  }

  static put(url, data, contentType) {
    return this.requestHelper(url, 'PUT', data, null, contentType);
  }

  static delete(url) {
    return this.requestHelper(url, 'DELETE', null, null, null);
  }

  static patch(url, data, contentType) {
    return this.requestHelper(url, 'PATCH', data, null, contentType);
  }

  static requestHelper(url, method, data, params, contentType) {
    return axios({
      url: url,
      method: method,
      baseURL: this.getRestUrl(),
      headers: this.getHeaders(contentType),
      data: data,
      params: params,
    })
  }

  static getRestUrl() {
    if (!baseUrl) {
      baseUrl = "http://localhost:8080";
    }

    return baseUrl;
  }

  static getHeaders(contentType) {
    let result = {
      'Content-Type': contentType || 'application/json'
    };
    //add token bearer if required after login
    if (sessionStorage.getItem("jwtToken")) {
      result['Authorization'] = sessionStorage.getItem("jwtToken");
    }
    //Authorization: Bearer eyJraWQiOiJCR0pVRyIsInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJkYW1AZGFtLmNvbSIsInVwbiI6ImRhbUBkYW0uY29tIiwiYXV0aF90aW1lIjoxNTY4MDMwNTg5LCJpc3MiOiJodHRwczpcL1wvanVnLmJnIiwiZ3JvdXBzIjpbImFkbWluIl0sImV4cCI6MTU2ODAzNDE4OSwiaWF0IjoxNTY4MDMwNTg5fQ.FHh9LlyTARrIABAR4qZ3HIJr1sZipLQuzRhBrjZHreZnNXHn0CC79vuNPNIjkBFhFszdsvxHJMK6iZzs_BFZDjdmnsYu1x_9yFjovxyAMev60lLeWkaGaOW7P-KAySvxzuODgK4PJ-WneaAn6LduZckKF-j5-Z-4eSkyKNDkgKPJFiMeX46ZMt33oQZ-ZQR96Fbuuq8A0Yl5rBFy01O6cSmj0F40pMHbCDvQPx5IjTPbwieD9gwkO0dnS_3LMEs0O6fSzrQMbLXO1KRTE_Jop6DzlrDr59vBTUHmoEe4ZRRtPKEKN6Kr3K2zfxN9MqlFm6eEU1znOLLflqdZII_-bw
    return result;
  }
}
