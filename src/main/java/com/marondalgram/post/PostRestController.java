package com.marondalgram.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marondalgram.post.bo.PostBO;
import com.marondalgram.post.model.Post;

@RequestMapping("/post")
@RestController
public class PostRestController {
	@Autowired
	private PostBO postBO;
	
	@RequestMapping("/post_list")
	public List<Post> postList() {
		return postBO.getPosts();
	}
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("content") String content,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String userLoginId = (String) session.getAttribute("userLoginId");
		if (userId == null) {
			result.put("result", "error");
			result.put("errorMessage", "로그인을 해주세요.");
			return result;
		}
		
		postBO.addPost(userId, userLoginId, content, file);
		
		result.put("result", "success");
		return result;
	}
}
