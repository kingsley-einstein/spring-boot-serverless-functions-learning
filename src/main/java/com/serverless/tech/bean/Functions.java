package com.serverless.tech.bean;

import java.util.UUID;
import java.util.function.Function;

import com.serverless.tech.model.Model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Functions {
 @Bean
 public Function<Model, Model> create() {
  return model -> new Model(model.getName(), UUID.randomUUID());
 }
}
