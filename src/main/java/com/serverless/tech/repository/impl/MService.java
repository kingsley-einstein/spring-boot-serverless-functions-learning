package com.serverless.tech.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.serverless.tech.model.Model;
import com.serverless.tech.repository.ModelRepository;

import org.springframework.stereotype.Component;

@Component
public class MService implements ModelRepository {
 private List<Model> models = new ArrayList<>();

 public Model create(Model m) throws Exception {
  try {
   Model model = m;
   boolean added = models.add(model);

   if(!added)
    throw new Exception("Could not add entry");

   return model;
  } catch (Exception ex) {
   throw new Exception(ex.getMessage());
  }
 }

 public List<Model> getAll() {
  return models;
 }

 public List<Model> getAllPaginated(Integer page, Integer limit) {
  return models.subList(
   (page - 1) * (limit + 1),
   page * limit
  );
 }

 public Optional<Model> getById(UUID id) {
  return models.stream()
   .filter(m -> m.getId().equals(id))
   .findAny();
 }

 public Optional<Model> findByIdAndUpdate(UUID id, Model m) {
  for (Model model: models)
   if (model.getId().equals(id)) {
    models.set(
     models.indexOf(model),
     m
    );
   }

  return models.stream() 
   .filter(model -> model.getId().equals(id))
   .findAny();
 }

 public Optional<Model> delete(Model m) {
  Model del = null;

  for (Model model: models)
   if (model.getId().equals(m.getId())) {
    models.remove(model);
    del = model;
   }

  return Optional.of(del);
 }
}
