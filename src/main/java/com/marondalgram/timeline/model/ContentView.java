package com.marondalgram.timeline.model;

import java.util.List;

import com.marondalgram.comment.model.CommentView;
import com.marondalgram.post.model.Post;
import com.marondalgram.user.model.User;

// 타임라인 카드 하나
public class ContentView {    // ${content.post.imagePath}
	private Post post;
	private User user; // 글쓴이
	private List<CommentView> commentList;   // ${content.commentList.user.name}

	private int likeCount; // 좋아요의 개수
	private boolean filledLike; // 내가 좋아요를 눌렀는지의 여부

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CommentView> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentView> commentList) {
		this.commentList = commentList;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public boolean isFilledLike() {
		return filledLike;
	}

	public void setFilledLike(boolean filledLike) {
		this.filledLike = filledLike;
	}
	
}
