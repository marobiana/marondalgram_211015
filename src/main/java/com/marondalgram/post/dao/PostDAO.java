package com.marondalgram.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondalgram.post.model.Post;

@Repository
public interface PostDAO {
	public List<Post> selectPosts();
	
	public Post selectPostByPostIdAndUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	public void insertPost(
			@Param("userId") int userId, 
			@Param("content") String content, 
			@Param("imagePath") String imagePath);
	
	public void deletePost(
			@Param("postId") int postId, 
			@Param("userId") int userId);
}
