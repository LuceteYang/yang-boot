package com.example.demo.repository;

import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.domain.Todos;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;

public interface TodoRepository extends MongoRepository<Todos, String> {
	Todos findBy_id(ObjectId _id);
	
	@Query(value="{ delete : ?0}", fields="{ _id : 1, done : 1, text : 1 }")
	List<Todos> findBydelete(boolean delete,Sort sort);
		
	
	
}
