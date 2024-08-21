package org.kitri.myspringboard.mapper;

import org.apache.ibatis.annotations.*;
import org.kitri.myspringboard.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM Board")
    List<Board> findAll();

    @Select("SELECT * FROM Board WHERE id = #{id}")
    Board findById(Long id);

    @Insert("INSERT INTO Board(title, content, writer) VALUES (#{title}, #{content}, #{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("UPDATE Board SET title=#{title}, content=#{content}, writer=#{writer} WHERE id=#{id}")
    void update(Board board);

    @Delete("DELETE FROM Board WHERE id=#{id}")
    void delete(Long id);
}
