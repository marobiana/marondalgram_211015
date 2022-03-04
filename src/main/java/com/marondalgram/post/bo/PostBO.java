package com.marondalgram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marondalgram.common.FileManagerService;
import com.marondalgram.post.dao.PostDAO;
import com.marondalgram.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private FileManagerService fileManager;

	public List<Post> getPosts() {
		return postDAO.selectPosts();
	}
	
	public void addPost(int userId, String userLoginId, String content, MultipartFile file) {
		String imagePath = null;
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		
		postDAO.insertPost(userId, content, imagePath);
	}
	
	public void deletePostByPostIdAndUserId(int postId, int userId) {
		// postId로 select Post
		
		// 이미지가 있으면 이미지 삭제
		
		// 글 삭제 byPostIdUserId
		
		// 댓글들 삭제  byPostId
		
		// 좋아요들 삭제 byPostId
	}
}






