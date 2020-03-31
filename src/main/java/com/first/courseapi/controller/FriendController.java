package com.first.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.first.courseapi.model.Friend;
import com.first.courseapi.service.FriendService;

@RestController

public class FriendController {
	@Autowired
	FriendService friendservice;

	@PostMapping("/postfriend")
	public ResponseEntity<String> createFriend(@RequestBody JsonNode jsonnode) {
		friendservice.addingFriend(jsonnode);
		return (ResponseEntity.ok("Added Successsfully"));
	}

	@GetMapping("/gender/{gender}")
	public List<Friend> genderMatching(@PathVariable("gender") String gender) {
		List<Friend> genderList = friendservice.genderSearching(gender);
		return genderList;
		// return friendservice.genderSearching(gender);
	}
	
	@GetMapping("/name/{name}")
	public int ageFinding(@PathVariable("name") String name) {
		return friendservice.calculatingAge(name);
		
	}
	
	
	
}
