package com.serverless.tech.custom;

@SuppressWarnings("serial")
public class CustomResponse<T> implements java.io.Serializable {
 private Integer statusCode;
 private T response;

 public CustomResponse() {}

 public CustomResponse(final Integer statusCode, final T response) {
  this.statusCode = statusCode;
  this.response = response;
 }

 public Integer getStatusCode() {
  return statusCode;
 }

 public T getResponse() {
  return response;
 }
}
