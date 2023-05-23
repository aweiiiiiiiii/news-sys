package com.songtian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songtian.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<Users> {
    /**
     * 查询新闻类别
     * @return  返回mapper查询到的结果数据
     */
    @Select("select * from news_users where uname = #{uname} and upwd= #{upwd}") //根据创建日期查询ntip(第几页）到number（第几页）的所有数据
    Users getUserList(@Param("uname") String uname, @Param("upwd") String upwd);
}
