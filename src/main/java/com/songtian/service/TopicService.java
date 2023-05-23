package com.songtian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songtian.entity.Topic;
import com.songtian.vo.TopicQueryVo;

import java.util.List;

public interface TopicService extends IService<Topic> {

    //查询新闻类别
    List<Topic> getTopicList();

    //插入主题
    int insertTopic(Topic topic);

    //新闻类别分页
    IPage<Topic> getTopicListByPage(IPage<Topic> page,TopicQueryVo topicQueryVo);

    //主题修改
    int updateTopic(Topic topic);

    //主题删除
//    int deleteTopic(Integer tid);

    void deleteTopic(Integer tid);

    Topic getTopicByTid(Integer tid);
}
