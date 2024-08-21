package org.kitri.myspringboard.mapper;

import org.apache.ibatis.annotations.*;
import org.kitri.myspringboard.domain.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comment WHERE board_id = #{boardId}")
    List<Comment> findCommentsByBoardId(Long boardId);

    @Insert("INSERT INTO comment (content, username, board_id, created_at) VALUES (#{content}, #{username}, #{boardId}, NOW())")
    void insertComment(Comment comment);

    @Delete("DELETE FROM comment WHERE id = #{id}")
    void deleteComment(Long id);
//@Select("SELECT * FROM comment WHERE board_id = #{boardId}")
//List<Comment> findCommentsByBoardId(Long boardId);
//
//    @Insert("INSERT INTO comment (content, username, board_id, created_at) " +
//            "VALUES (#{content}, #{username}, #{boardId}, NOW())")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    void insertComment(Comment comment);
}
