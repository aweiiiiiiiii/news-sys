package com.songtian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.songtian.entity.Topic;
import com.songtian.vo.TopicQueryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TopicMapper extends BaseMapper<Topic> {

    //查询新闻类别
    List<Topic> getTopicList();

    //添加主题
    @Insert("insert into topic(tid,tname) values (#{tid},#{tname})")
    public int insertTopic(Topic topic);

    //新闻类别分页

    IPage<Topic> getTopicListByPage(@Param("page") IPage<Topic> page, @Param("topic") TopicQueryVo topicQueryVo);

    //主题修改
    @Update("update topic set tname=#{tname} where tid=#{tid} ")
    public int updateTopic(Topic topic);

    //根据tid删除主题
    @Delete("detele from topic where tid=#{tid}")
    public int deleteTopic(Integer tid);

    @Select("select * from topic where tid=#{tid}")
    Topic getTopicByTid(Integer tid);

}
