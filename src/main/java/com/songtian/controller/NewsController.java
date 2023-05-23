package com.songtian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songtian.entity.Comments;
import com.songtian.entity.News;
import com.songtian.entity.Topic;
import com.songtian.service.CommentsService;
import com.songtian.service.NewsService;
import com.songtian.service.TopicService;
import com.songtian.vo.NewsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    TopicService topicService;

    @Autowired
    CommentsService commentsService;

    @RequestMapping("/detail/{id}")
    public String newsdetail(Model model, @PathVariable Integer id){

        List<News> newsList1 = newsService.getNewsListByTopicId(1,6);
        List<News> newsList2 = newsService.getNewsListByTopicId(2,6);
        List<News> newsList3 = newsService.getNewsListByTopicId(5,6);

        //保存数据响应给前端,addAttribute向前台传数据，前端显示的内容
        model.addAttribute("newsList1",newsList1);
        model.addAttribute("newsList2",newsList2);
        model.addAttribute("newsList3",newsList3);

        News nid=newsService.getNewsDetailByNid(id);
        model.addAttribute("news",nid).addAttribute(nid);

        List<Comments> clist=commentsService.getNewsCommentsByCnid(id);
        model.addAttribute("commentsList",clist);

        return "news/detail";
    }



    //进入控制台
    @RequestMapping("/manager")
    public String manager(Model model, NewsQueryVo newsQueryVo){

        IPage<News> page=new Page<>(newsQueryVo.getPageNo(),newsQueryVo.getPageSize());
        page=newsService.getNewsListByPage(page,newsQueryVo);
        model.addAttribute("page",page);
        return "admin";
    }


    //进入修改新闻页面
    @RequestMapping("/edit/{id}")
    public String toEdit(Model model,@PathVariable Integer id){
        News nid=newsService.getNewsDetailByNid(id);
        model.addAttribute("news",nid).addAttribute(nid);

        List<Comments> clist=commentsService.getNewsCommentsByCnid(id);
        model.addAttribute("commentsList",clist);

        //查询新闻类别
        List<Topic> topicList =topicService.getTopicList();
        //保存新闻类别
        model.addAttribute("topicList",topicList);
        return "news/edit";
    }
    //修改新闻
    @RequestMapping("/edit")
    public String edit(News news){
        news.setNmodifyDate(new Date());
        newsService.updateNews(news);
        return "redirect:/news/manager/";
    }


    //进入增加新闻页面
    @GetMapping("add.html")
    public String add(Model model){
        //查询新闻类别
        List<Topic> topicList =topicService.getTopicList();
        //保存新闻类别
        model.addAttribute("topicList",topicList);
        return "news/add";
    }
    //进行增加新闻操作
    @PostMapping("/add")
    public String toAdd(MultipartFile file,News news) throws IOException {
        //上传图片
        String imgName=file.getOriginalFilename();
        String dirPath="C:\\Users\\aa\\OneDrive\\桌面\\news521\\news-sys1\\news-sys\\src\\main\\resources\\static\\images\\";
        File filePath=new File(dirPath,imgName);
        file.transferTo(filePath);//将路径下的图片存入磁盘
        String ImNage2= "/images/" + imgName;
        news.setNpicPath(ImNage2);


        news.setNcreateDate(new Date());
        newsService.insertNews(news);

        return "redirect:/news/manager/";
    }

    //删除新闻(需要先删除评论)
    @RequestMapping("deleteById/{id}")
    public String delete(@PathVariable("id") Integer id){
        commentsService.deleteComments(id);
        newsService.deleteNews(id);
        return "redirect:/news/manager/";
    }


}
