package com.lzc.mbgenerator.mapper;

import com.lzc.basicssm.entity.RoleUser;
import com.lzc.basicssm.entity.RoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int countByExample(RoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int deleteByExample(RoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int insert(RoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int insertSelective(RoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    List<RoleUser> selectByExample(RoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    RoleUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int updateByExampleSelective(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int updateByExample(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int updateByPrimaryKeySelective(RoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbggenerated Thu Aug 02 13:49:42 CST 2018
     */
    int updateByPrimaryKey(RoleUser record);
}