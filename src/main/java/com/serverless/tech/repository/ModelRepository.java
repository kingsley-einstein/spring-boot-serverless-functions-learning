package com.serverless.tech.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.serverless.tech.model.Model;

public interface ModelRepository {
 public Model create(Model m) throws Exception;
 public List<Model> getAll();
 public List<Model> getAllPaginated(Integer page, Integer limit);
 public Optional<Model> getById(UUID id);
 public Optional<Model> findByIdAndUpdate(UUID id, Model m);
 public Optional<Model> delete(Model m);
}
