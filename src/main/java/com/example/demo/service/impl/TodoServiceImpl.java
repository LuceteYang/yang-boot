package com.example.demo.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.repository.TodoRepository;
import com.example.demo.domain.Todos;
import com.example.demo.service.TodoService;

import org.springframework.data.domain.Sort;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
    private TodoRepository todoService;
	
	public List<Todos> todoList(){
		Sort sort = new Sort(Sort.Direction.DESC, "_id");
		return todoService.findBydelete(false,sort);
	};
	
	public Todos writeTodo(String text){
		Todos newTodo = todoService.save(new Todos(text));
		return newTodo;
	};
	
	public Todos doneTodo(ObjectId _id){
		Todos newTodo = todoService.findBy_id(_id);
		
		newTodo.setDone(!newTodo.getDone());
		todoService.save(newTodo);
		return newTodo;
	};
	public Todos deleteTodo(ObjectId _id){
		Todos newTodo = todoService.findBy_id(_id);
		
		newTodo.setDone(!newTodo.getDone());
		todoService.save(newTodo);
		return newTodo;
	}
}
