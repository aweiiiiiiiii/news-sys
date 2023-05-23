package com.songtian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songtian.entity.Comments;
import com.songtian.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentsMapper extends BaseMapper<Comments> {

   //查看评论
   @Select("select * from comments where cnid = #{cnid}")
   List<Comments> getNewsCommentsByCnid(@Param("cnid") Integer cnid);

   //发表评论
   @Insert("insert into comments(cid,cnid,ccontent,cdate,cip,cauthor) values (#{cid},#{cnid},#{ccontent},#{cdate},#{cip},#{cauthor})")
   public int insertComments(Comments comments);

   //删除评论
   @Delete("delete from comments where cnid=#{cnid}")
   public int deleteComments(Integer cnid);
}