package org.kitri.myspringboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.kitri.myspringboard.domain.Users;

@Mapper
public interface UsersMapper {
    @Insert("INSERT INTO users (username, password, enabled) VALUES (#{username}, #{password}, #{enabled})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(Users users);

    @Insert("INSERT INTO authorities (user_id, authority) VALUES (#{userId}, #{authority})")
    void insertAuthority(Long userId, String authority);
}
