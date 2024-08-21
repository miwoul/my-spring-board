package org.kitri.myspringboard.sevice;

import org.kitri.myspringboard.domain.Comment;
import org.kitri.myspringboard.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
//    @Autowired
//    CommentMapper commentMapper;
    //public List<Board> findAll() {
    //        return boardMapper.findAll();
    //    }
    //public void save(Board board) {
    //        boardMapper.insert(board);
    //    }
//    public List<Comment> findCommentsByBoardId(long boardId) {
//        return commentMapper.findCommentsByBoardId(boardId);
//    }
//
//    public void commentcreate(Comment comment) {
//        commentMapper.insertComment(comment);
//    }
//@Autowired
//private CommentMapper commentMapper;
//
//    public List<Comment> findCommentsByBoardId(long boardId) {
//        return commentMapper.findCommentsByBoardId(boardId);
//    }
//
//    public void createComment(Comment comment) {
//        commentMapper.insertComment(comment);
//    }
@Autowired
private CommentMapper commentMapper;

    public List<Comment> findCommentsByBoardId(long boardId) {
        return commentMapper.findCommentsByBoardId(boardId);
    }

    public void commentCreate(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        commentMapper.insertComment(comment);
    }
    public void deleteComment(Long commentId) {
        commentMapper.deleteComment(commentId);
    }
    //public void delete(long id) {
    //        boardMapper.delete(id);
    //    }
//    public void commentUpdate(Comment comment) {
//    }

}
