package com.songtian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songtian.entity.Comments;
import com.songtian.entity.News;
import com.songtian.mapper.CommentsMapper;
import com.songtian.mapper.NewsMapper;
import com.songtian.service.CommentsService;
import com.songtian.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Override
    public List<Comments> getNewsCommentsByCnid(Integer cnid) {
        return baseMapper.getNewsCommentsByCnid(cnid);
    }

    @Override
    public int insertComments(Comments comments){
        return baseMapper.insertComments(comments);
    }

    @Override
    public int deleteComments(Integer cnid) {
        return baseMapper.deleteComments(cnid);
    }
}
