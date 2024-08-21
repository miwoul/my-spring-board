package org.kitri.myspringboard.sevice;

import org.kitri.myspringboard.domain.Board;
import org.kitri.myspringboard.domain.Comment;
import org.kitri.myspringboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;
    @Autowired
    CommentService commentService;
    public List<Board> findAll() {
        return boardMapper.findAll();
    }
    public Board findById(long id) {
        Board board = boardMapper.findById(id);
        if (board != null) {
            List<Comment> comments = commentService.findCommentsByBoardId(board.getId());
            board.setComments(comments);
        }
        return board;
    }


    public void save(Board board) {
        boardMapper.insert(board);
    }
    public void update(Board board) {
        boardMapper.update(board);
    }
    public void delete(long id) {
        boardMapper.delete(id);
    }
}
