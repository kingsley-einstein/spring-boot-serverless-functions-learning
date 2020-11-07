package com.serverless.tech.model;

import java.util.UUID;

@SuppressWarnings("serial")
public class Model implements java.io.Serializable {
 private String name;
 private UUID id;

 public Model() {}

 public Model(String name, UUID id) {
  this.name = name;
  this.id = id;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }

 public UUID getId() {
  return id;
 }
}
