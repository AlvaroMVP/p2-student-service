package com.project.service;

import com.project.model.Student;
import java.util.Date;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentInterface {

  public Flux<Student> findAll();
    
  public Flux<Student> findByDate(String birthdate);
	  
  public Flux<Student> findByBirthdateBetween(Date birthdate, Date birthdate1);
	  
  public Mono<Student> findByFullName(String fullName);
	   
  public Mono<Student> findBynumberDocument(String numberDocument);
	   
  public Mono<Student> findById(String idStudent);
	  
  public Mono<Student> save(Student student);
	  
  public Mono<Void> delete(String idStudent);

}
