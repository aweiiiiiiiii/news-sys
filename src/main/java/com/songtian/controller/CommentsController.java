package com.songtian.controller;

import com.songtian.entity.Comments;
import com.songtian.service.CommentsService;
import com.songtian.service.NewsService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    //添加评论
    @RequestMapping("/comments/add")
    public String addcomments( Comments comments) {

        comments.setCdate(new Date());
        int i=commentsService.insertComments(comments);
        return "redirect:/news/detail/"+comments.getCnid();

    }

}
