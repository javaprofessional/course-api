package com.first.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.first.courseapi.service.ActionService;
import com.first.courseapi.service.ServiceAdd;

@RestController
@RequestMapping("/durga")
public class sampleController {
	@Autowired
	ActionService as;

	@Autowired
	ServiceAdd sadd;

	//using PathVariable
	@GetMapping("/add/{number}/{age}")
	public int add(@PathVariable("number") int number, @PathVariable("age") int age) {

		return sadd.addition(number, age);
	}

	// using queryparam
	@GetMapping("/addition")
	public int addition(@RequestParam int a,@RequestParam int b) {
		return a+b;
	}

	@GetMapping("/service")
	public String demo() {
		return as.doneAction();
	}

	@GetMapping("/weathertoday")
	public String trial() {
		return "rainy";
	}

	@PostMapping("/firstpost")
	public ResponseEntity<String> sports(@RequestBody JsonNode a) {
		JsonNode place = a.get("place");
		String takenplace = place.asText();
		return (ResponseEntity.ok(takenplace));
	}

}
