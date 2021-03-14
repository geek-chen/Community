package com.majiang.community.mapper;
import com.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface QuestionMapper {
    @Select("select * from question where id = #{id}")
    Question getById(@Param(value = "id") Integer id);

    @Insert("insert into question (title, description, gmt_creat, gmt_modified, creator, tag) values (#{title}, #{description}, #{gmt_creat}, #{gmt_modified}, #{creator}, #{tag})")
    void creat(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(*) from question where creator = #{userId}")
    Integer countById(@Param(value = "userId") Integer userId);

    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmt_modified}, tag = #{tag} where id = #{id}")
    void update(Question question);



}

