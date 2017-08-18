package com.data2life.assignment.studentservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.data2life.assignment.studentservice.model.*;
public interface StudentRepository extends MongoRepository<Student, Integer>{

}
