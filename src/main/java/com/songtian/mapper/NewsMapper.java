package com.songtian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.songtian.entity.Comments;
import com.songtian.entity.News;
import com.songtian.vo.NewsQueryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface NewsMapper extends BaseMapper<News> {

    /**
     * 根据新闻类型查询新闻
     * @param topicId  新闻类型ID
     * @param number  查询的记录条数
     * @return  根据新闻类型ID查询到的新闻记录的集合
     */

    @Select("select * from news where ntid = #{topicId} ORDER BY ncreateDate desc limit #{number}") //根据创建日期查询ntip(第几页）到number（第几页）的所有数据
    List<News> getNewsListByTopicId(@Param("topicId") int topicId,@Param("number") int number);

    /**
     *
     * @param page 分页
     * @param newsQueryVo 查询条件
     * @return 新闻记录的集合
     */
    IPage<News> getNewsListByPage(@Param("page") IPage<News> page, @Param("news")NewsQueryVo newsQueryVo);


    /**
     *根据nid查看新闻详情
     * @param nid
     * @param
     * @return
     */
    @Select("select * from news where nid = #{nid}")
    News getNewsDetailByNid(@Param("nid") Integer nid);

    //增加新闻
    @Insert("insert into news(nid,ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) values (#{nid},#{ntid},#{ntitle},#{nauthor},#{ncreateDate},#{npicPath},#{ncontent},#{nmodifyDate},#{nsummary})")
    public int insertNews(News news);

    //修改新闻
    @Update("update news set ntid=#{ntid},ntitle=#{ntitle},nauthor=#{nauthor},ncreateDate=#{ncreateDate},nmodifyDate=#{nmodifyDate},npicPath=#{npicPath},ncontent=#{ncontent},nsummary=#{nsummary} where nid=#{nid}")
    public int updateNews(News news);

    //删除新闻
    @Delete("delete from news where nid=#{nid}")
    public int deleteNews(Integer nid);
}
