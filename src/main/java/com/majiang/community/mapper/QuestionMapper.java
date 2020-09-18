package com.majiang.community.mapper;
import com.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionMapper {
    @Insert("insert into question (title, description, gmt_creat, gmt_modified, creator, tag) values (#{title}, #{description}, #{gmt_creat}, #{gmt_modified}, #{creator}, #{tag})")
    void creat(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

}
