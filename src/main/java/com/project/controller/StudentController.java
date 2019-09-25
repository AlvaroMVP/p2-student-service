package com.project.controller;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.repository.StudentRepository;
import com.project.service.StudentInterface;
import com.project.service.impl.StudentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1.0")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;
	
	/**
	 * . method to list students
	 */
	@GetMapping("/student")
	public Mono<ResponseEntity<Flux<Student>>> findAll() {
		return Mono
				.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(studentService.findAll()));
	}

	/**
	 * . method to search students by id
	 * @throws Exception 
	 */
	@GetMapping("/student/{idStudent}")
	public Mono<ResponseEntity<Student>> findById(@PathVariable String idStudent) throws Exception {
		boolean ok = false;
		if(ok == false) {
			throw new Exception("Cant load student");
		}
		return studentService.findById(idStudent)
				.map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
		
	}

	/**
	 * . method to search by document number
	 */
	@GetMapping("numberDocument/{numberDocument}")
	public Mono<ResponseEntity<Student>> findBynumberDocument(@PathVariable String numberDocument) {
		return studentService.findBynumberDocument(numberDocument)
				.map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 * . method to search by full name
	 */
	@GetMapping("fullName/{fullName}")
	public Mono<ResponseEntity<Student>> findFullName(@PathVariable String fullName) {
		return studentService.findByFullName(fullName)
				.map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 * . method to create
	 */
	@PostMapping
	public Mono<ResponseEntity<Map<String, Object>>> create(@Valid @RequestBody Mono<Student> studentMono) {
		Map<String, Object> reply = new HashMap<String, Object>();
		return studentMono.flatMap(student -> {
			if (student.getBirthdate() == null) {
				student.setBirthdate(new Date());
			}
			return studentService.save(student).map(p -> {
				reply.put("student", p);
				reply.put("message", "Student created successfully");
				reply.put("dateTime", new Date());
				return ResponseEntity.created(URI.create("/api/v1.0".concat(p.getIdStudent())))
						.contentType(MediaType.APPLICATION_JSON_UTF8).body(reply);
			});
		});
	}

	/**
	 * . method to update a student
	 */
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Student>> save(@RequestBody Student student, @PathVariable String id) {
		return studentService.findById(id).flatMap(s -> {
			s.setFullName(student.getFullName());
			s.setGender(student.getGender());
			s.setBirthdate(student.getBirthdate());
			s.setTypeDocument(student.getTypeDocument());
			s.setNumberDocument(student.getNumberDocument());

			return studentService.save(s);
		}).map(s -> ResponseEntity.created(URI.create("/api/v1.0".concat(s.getIdStudent())))
				.contentType(MediaType.APPLICATION_JSON_UTF8).body(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 * . method to delete a student by id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		studentService.delete(id).subscribe();
	}

	/**
	 * . method to search by dates
	 */
	@GetMapping("student/date/{birthdate}/{birthdate1}")
	public Flux<Student> findByBirthdateBetween(
			@PathVariable("birthdate") @DateTimeFormat(iso = ISO.DATE) Date birthdate,
			@PathVariable("birthdate1") @DateTimeFormat(iso = ISO.DATE) Date birthdate1) {
		return studentService.findByBirthdateBetween(birthdate, birthdate1);
	}

}
