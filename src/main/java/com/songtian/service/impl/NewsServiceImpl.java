package com.songtian.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songtian.entity.Comments;
import com.songtian.entity.News;
import com.songtian.mapper.NewsMapper;
import com.songtian.service.NewsService;
import com.songtian.vo.NewsQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional  //spring中声明式事务管理的注解配置方式
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {


    @Override
    public List<News> getNewsListByTopicId(int topicId, int number) {
        //调用mapper方法，使用NewsMapper的父接口类型的变量调用方法
        return baseMapper.getNewsListByTopicId(topicId,number);
    }

    @Override
    public IPage<News> getNewsListByPage(IPage<News> page, NewsQueryVo newsQueryVo) {
        //调用mapper方法，使用NewsMapper的父接口类型的变量调用方法
        return baseMapper.getNewsListByPage(page,newsQueryVo);
    }

    @Override
    public News getNewsDetailByNid(Integer nid) {
        return baseMapper.getNewsDetailByNid(nid);
    }

    @Override
    public int insertNews(News news){
        return baseMapper.insertNews(news);
    }

    @Override
    public int updateNews(News news){
        return baseMapper.updateNews(news);
    }

    @Override
    public int deleteNews(Integer nid){
        return baseMapper.deleteNews(nid);
    }
}
