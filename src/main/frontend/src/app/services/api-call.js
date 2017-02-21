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
      baseUrl = document.getElementById('rest-base-url').getAttribute('url');
    }

    return baseUrl;
  }

  static getHeaders(contentType) {
    let result = {
      'Content-Type': contentType || 'application/json'
    };


    return result;
  }
}
