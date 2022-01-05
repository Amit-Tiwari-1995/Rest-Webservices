package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HelloWorldBean;

@RestController
public class HelloWorldController {

	List<HelloWorldBean> list = Arrays.asList(new HelloWorldBean("Amit", 26, "Software Engineer"),
			new HelloWorldBean("Chetan", 33, "Software Engineer"), new HelloWorldBean("Ansh", 17, "Student"),
			new HelloWorldBean("Yashwant", 38, "IT"));

	@GetMapping("/hello")
	public String helloWord() {
		return "Why so serious:/";

	}

	@GetMapping("/hello-bean")
	public HelloWorldBean helloWordBean() {
		return new HelloWorldBean("Amit", 26, "Software Engineer");

	}

	@GetMapping("/hello/{name}")
	public String helloWordPathVar(@PathVariable String name) {
		return "Hello! " + name;

	}

	@GetMapping("hello/list")
	public List<HelloWorldBean> getList() {
		return this.list;
	}

}
