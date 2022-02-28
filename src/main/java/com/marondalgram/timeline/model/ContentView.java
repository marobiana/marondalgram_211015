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
//	private List<Like> likeList;

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
}
