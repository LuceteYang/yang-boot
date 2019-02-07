package com.example.demo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.demo.domain.Todos;

public interface TodoService {
	List<Todos> todoList();
	
	Todos writeTodo(String text);
	
	Todos doneTodo(ObjectId id);
	
	Todos deleteTodo(ObjectId id);
}
