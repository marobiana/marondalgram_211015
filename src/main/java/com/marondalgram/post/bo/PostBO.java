package com.marondalgram.post.bo;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marondalgram.comment.bo.CommentBO;
import com.marondalgram.common.FileManagerService;
import com.marondalgram.like.bo.LikeBO;
import com.marondalgram.post.dao.PostDAO;
import com.marondalgram.post.model.Post;

@Service
public class PostBO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private FileManagerService fileManager;

	public List<Post> getPosts() {
		return postDAO.selectPosts();
	}
	
	public Post getPostByPostIdAndUserId(int postId, int userId) {
		return postDAO.selectPostByPostIdAndUserId(postId, userId);
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
		Post post = getPostByPostIdAndUserId(postId, userId);
		if (post == null) {
			logger.error("[delete post] 삭제할 게시물이 없습니다. postId:{}", postId);
			return;
		}
		
		// 이미지가 있으면 이미지 삭제
		if (post.getImagePath() != null) {
			try {
				fileManager.deleteFile(post.getImagePath());
			} catch (IOException e) {
				logger.error("[delete post] 이미지 삭제 실패, postId:{}, path:{}", postId, post.getImagePath());
			}
		}
		
		// 글 삭제 byPostIdUserId
		postDAO.deletePost(postId, userId);
		
		// 댓글들 삭제  byPostId
		commentBO.deleteCommentsByPostId(postId);
		
		// 좋아요들 삭제 byPostId
		likeBO.deleteLikeByPostId(postId);
	}
}






