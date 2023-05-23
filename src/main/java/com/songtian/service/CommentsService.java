package com.songtian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.songtian.entity.Comments;
import com.songtian.entity.Users;

import java.util.List;

public interface CommentsService extends IService<Comments> {

    List<Comments> getNewsCommentsByCnid(Integer cnid);

    int insertComments(Comments comments);

    int deleteComments(Integer cnid);
}