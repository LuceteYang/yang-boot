package com.example.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value = "/hello-view")
	public ModelAndView hello(ModelMap model) {
		model.put("title", "Hello");
		model.put("body", "World!");
		return new ModelAndView("hello", model);
	}
}
