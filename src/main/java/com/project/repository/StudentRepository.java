package com.project.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.project.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveMongoRepository<Student, String>{
  
  Mono<Student> findByFullName(String fullName);
	  
  Mono<Student> findBynumberDocument(String numberDocument);
	  
  Flux<Student> findByBirthdateBetween(Date birthdate,Date birthdate1);
}
