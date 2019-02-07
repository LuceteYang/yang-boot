package com.example.demo.controller.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Todos;
import com.example.demo.service.impl.TodoServiceImpl;
import com.example.demo.support.exception.ResourceException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("api")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController {
	@Autowired
	TodoServiceImpl todoService;

	//	@CrossOrigin("*")	
	@GetMapping("/todos")
	public JSONObject todoList() {
		JSONObject json = new JSONObject();
		json.put("todos", todoService.todoList());
		return json;
	}

	@PostMapping("/todos")
	public Todos writeTodo(HttpServletRequest request, @Valid Todos todo, BindingResult result) {
		if (result.hasErrors()) {			
			String originalURL = request.getRequestURI();
			throw new ResourceException(originalURL, HttpStatus.BAD_REQUEST, result.getFieldError().getField());
		}
		return todoService.writeTodo(todo.getText());
	}  

	@PutMapping("/todos/{id}")
	public Todos doneTodo(@PathVariable ObjectId id) {
		return todoService.doneTodo(id);
	}

	@DeleteMapping("/todos/{id}")
	public Todos deleteTodo(@PathVariable ObjectId id) {
		return todoService.deleteTodo(id);
	}
}
