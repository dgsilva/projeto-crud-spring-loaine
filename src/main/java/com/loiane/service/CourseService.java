package com.loiane.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.loiane.exception.RecordNotFoundException;
import com.loiane.model.Course;
import com.loiane.repository.CourseRepository;
@Validated
@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	public List<Course> list() {
		return courseRepository.findAll();
	}
	
	public Course findById(@PathVariable @NotNull @Positive Long id) {
		return courseRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id));
	}
	
	public Course create(@Valid Course course) {
		return courseRepository.save(course);
	}
	
	public Course update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {
		return courseRepository.findById(id).map(recordFound -> {
			recordFound.setName(course.getName());
			recordFound.setCategory(course.getCategory());
			return courseRepository.save(recordFound);
		}).orElseThrow(()-> new RecordNotFoundException(id));
	}
	
	public void delete(@PathVariable @NotNull @Positive Long id) {
		courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
	}
	
}