package com.majiang.community.mapper;

import com.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("select * from user where token = #{token}")
     User selectByToken(@Param("token") String token);

    @Insert("insert into user(name, account_id, token, gmt_creat, gmt_modified, avatar_url) values(#{name}, #{accountId}, #{token}, #{gmtCreat}, #{gmtModified}, #{avatar_url})")
   void insert(User user);

    @Select("select * from user where id = #{id} ")
    User  findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);


    @Update("update user set token = #{token}, name = #{name}, gmt_modified = #{gmtModified}, avatar_url = #{avatar_url}")
    void updateUser(User user);

}
