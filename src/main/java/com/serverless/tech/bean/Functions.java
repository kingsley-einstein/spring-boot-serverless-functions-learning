package com.serverless.tech.bean;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

import com.serverless.tech.custom.CustomResponse;
import com.serverless.tech.model.Model;
import com.serverless.tech.repository.impl.MService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Functions {
 @Autowired
 private MService service;

 @Bean
 public Function<Model, CustomResponse<?>> create() {
  return model -> {
   try {
    return new CustomResponse<Model>(
     201, service.create(
      new Model(model.getName(), UUID.randomUUID())
     )
    );
   } catch (Exception ex) {
    return new CustomResponse<String>(500, ex.getMessage());
   }
  };
 }

 @Bean
 public Supplier<CustomResponse<List<Model>>> getAll() {
  return () -> new CustomResponse<List<Model>>(200, service.getAll());
 }

 @Bean
 public Function<Map<String, Integer>, CustomResponse<List<Model>>> getAllPaginated() {
  return map -> new CustomResponse<List<Model>>(
   200,
   service.getAllPaginated(map.get("page"), map.get("limit"))
  );
 }

 @Bean
 public Function<Map<String, UUID>, CustomResponse<?>> getById() {
  return map -> {
   try {
    Model model = service.getById(map.get("id"))
     .orElseThrow(() -> new Exception("Not Found"));

    return new CustomResponse<Model>(200, model);
   } catch (Exception ex) {
    return new CustomResponse<String>(500, ex.getMessage());
   }
  };
 } 
}
