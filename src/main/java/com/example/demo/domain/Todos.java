package com.example.demo.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Todos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	@NotNull
	@Size(min = 2, message = "Enter atleast 2 characters")
	private String text;
	
	private Boolean done=false;
	
	private Boolean delete=false;
	
	private Date _created_at=new Date();

	
	public Todos() {// Make JPA Happy

	}

	public Todos(String text) {
		super();
		this.text = text;
	}
}
