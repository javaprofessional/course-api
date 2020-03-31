package com.first.courseapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.first.courseapi.model.TopicJava;

@RestController
public class TestController {

	// Printing one value
	@PostMapping("/poststring")
	public ResponseEntity<String> testString(@RequestBody JsonNode a) {

		JsonNode nodeName = a.get("country");
		String name = nodeName.asText();
		return ResponseEntity.ok(name);
	}

	// printing json as is
	@PostMapping("/postnode")
	public ResponseEntity<JsonNode> testNode(@RequestBody JsonNode a) {
		return ResponseEntity.ok(a);

	}

	// printing your object as is
	@PostMapping("/postcustomobject")
	public ResponseEntity<TopicJava> testCustomObject(@RequestBody TopicJava a) {
		a.setName("Durga");
		a.setId("12345");
		a.setBithplace("bithplace");

		return ResponseEntity.ok(a);

	}

}
