package com.cyl.mycommunity.mapper;

import com.cyl.mycommunity.modul.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface usermapper {
    @Insert("insert into user_info (name,account_id,token,gmt_create,gmt_modified,Avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);

    @Select("select * from user_info")
    List<User> select();

    @Select("select id from user_info where token=#{token}")
    Integer findByToken(String token);

    @Select("select * from user_info where id=#{id}")
    User selectByCreator(Integer id);
}
