package com.songtian.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songtian.entity.Topic;
import com.songtian.mapper.TopicMapper;
import com.songtian.service.TopicService;
import com.songtian.vo.TopicQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service  //告诉spring帮我们创建对象，是业务层组件
public class TopicServiceImpl extends ServiceImpl<TopicMapper,Topic> implements TopicService {


    @Override
    public List<Topic> getTopicList(){
        return baseMapper.getTopicList();
    }

    @Override
    public int insertTopic(Topic topic){
        return baseMapper.insertTopic(topic);
    }

    @Override
    public IPage<Topic> getTopicListByPage(IPage<Topic> page, TopicQueryVo topicQueryVo) {
        //调用mapper方法，使用NewsMapper的父接口类型的变量调用方法
        return baseMapper.getTopicListByPage(page,topicQueryVo);
    }

    @Override
    public int updateTopic(Topic topic){
        return baseMapper.updateTopic(topic);
    }

//    @Override
//    public int deleteTopic(Integer tid){
//        return baseMapper.deleteById(tid);
//    }

    @Override
    public void deleteTopic(Integer tid){
        this.removeById(tid);
    }

    @Override
    public Topic getTopicByTid(Integer tid) {
        return baseMapper.getTopicByTid(tid);
    }
}
