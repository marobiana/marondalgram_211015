package com.marondalgram.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		return "Hello world";
	}
	
	@RequestMapping("/quiz_jsp_test")
	public String quizJspTest() {
		return "test/quiz_test";
	}
}
