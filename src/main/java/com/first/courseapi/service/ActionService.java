package com.first.courseapi.service;

import org.springframework.stereotype.Service;

@Service
public class ActionService {
  
	public String doneAction() {
		return "Action taken at the service";
	}

}
