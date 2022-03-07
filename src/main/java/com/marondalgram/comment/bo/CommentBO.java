package com.marondalgram.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.comment.dao.CommentDAO;
import com.marondalgram.comment.model.Comment;
import com.marondalgram.comment.model.CommentView;
import com.marondalgram.user.bo.UserBO;
import com.marondalgram.user.model.User;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private UserBO userBO;
	
	public void createComment(int userId, int postId, String content) {
		commentDAO.insertComment(userId, postId, content);
	}
	
	public List<Comment> getCommentListByPostId(int postId) {
		return commentDAO.selectCommentListByPostId(postId);
	}
	
	public List<CommentView> generateCommentViewListByPostId(int postId) {
		List<CommentView> resultList = new ArrayList<>();
		List<Comment> commentList = getCommentListByPostId(postId);
		
		for (Comment comment : commentList) {  // Comment -> CommentView
			CommentView commentView = new CommentView();
			
			// 댓글
			commentView.setComment(comment);
			
			// 댓글쓴이 
			User user = userBO.getUserById(comment.getUserId());
			commentView.setUser(user);
			
			resultList.add(commentView);
		}
		
		return resultList;
	}
	
	public void deleteCommentsByPostId(int postId) {
		commentDAO.deleteCommentsByPostId(postId);
	}
	
	public void deleteCommentByCommentIdAndUserId(int commentId, int userId) {
		commentDAO.deleteCommentByCommentIdAndUserId(commentId, userId);
	}
}






