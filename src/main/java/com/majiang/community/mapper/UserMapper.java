package com.majiang.community.mapper;

import com.majiang.community.model.User;
import com.majiang.community.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Tue Mar 16 21:21:06 CST 2021
     */
    int updateByPrimaryKey(User record);
}