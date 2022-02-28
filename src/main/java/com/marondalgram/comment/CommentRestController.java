package com.marondalgram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondalgram.comment.bo.CommentBO;

@RequestMapping("/comment")
@RestController
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO;

	@PostMapping("/create")
	public Map<String, Object> createComment(
			@RequestParam("postId") int postId,
			@RequestParam("content") String content) {
		
		commentBO.createComment(postId, postId, content);
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
}
