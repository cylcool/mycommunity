package com.cyl.mycommunity.mapper;

import com.cyl.mycommunity.modul.Question;
import com.cyl.mycommunity.modul.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Questionmapper {
    @Insert("insert into question (title,description,creator,gmt_create,gmt_modified,tag,avatar_url) values(" +
            "#{title},#{description},#{creator},#{gmt_create},#{gmt_modified},#{tag},#{avatar_url})"
    )
    void insert(Question question);

    @Select("select * from question")
    List<Question> select();
}
