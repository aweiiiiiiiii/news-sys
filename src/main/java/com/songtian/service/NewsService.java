package com.songtian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songtian.entity.Comments;
import com.songtian.entity.News;
import com.songtian.vo.NewsQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsService extends IService<News> {
    /**
     * 根据新闻类型查询新闻
     * @param topicId  新闻类型ID
     * @param number  查询的记录条数
     * @return  mapper（dao）层返回的数据
     */
    List<News> getNewsListByTopicId( int topicId,int number);


    /**
     *
     * @param page 分页
     * @param newsQueryVo 查询条件
     * @return 新闻记录的集合
     */
    IPage<News> getNewsListByPage(IPage<News> page, NewsQueryVo newsQueryVo);


    /**
     *根据nid查看新闻详情
     * @param nid
     * @param
     * @return
     */
    News getNewsDetailByNid(Integer nid);


    int insertNews(News news);

    int updateNews(News news);

    int deleteNews(Integer nid);
}
