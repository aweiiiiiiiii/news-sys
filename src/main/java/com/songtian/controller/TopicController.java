package com.songtian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songtian.entity.Comments;
import com.songtian.entity.News;
import com.songtian.entity.Topic;
import com.songtian.service.NewsService;
import com.songtian.service.TopicService;
import com.songtian.vo.TopicQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @Autowired
    NewsService newsService;
   @RequestMapping("/list")
   public String topicList(Model model,TopicQueryVo topicQueryVo){
       //查询新闻类别
       List<Topic> topicList =topicService.getTopicList();
       //保存新闻类别
       model.addAttribute("topicList",topicList);

       IPage<Topic> page= new Page<>(topicQueryVo.getPageNo(), topicQueryVo.getPageSize());
       page=topicService.getTopicListByPage(page,topicQueryVo);
       model.addAttribute("page",page);
       return "topic/list";
   }


    //进入添加主题页面
    @RequestMapping("/add.html")
    public String topic(){
        return "topic/add";
    }
    //添加主题并提交
    @RequestMapping("/add")
    public String addTopic(Topic topic){
        topicService.insertTopic(topic);
        return "redirect:/news/manager/";
    }

    //进入添加主题页面
    @RequestMapping("/edit/{id}")
    public String modifyTopic(Model model,@PathVariable Integer id){

       //查询新闻类别
        Topic topicList =topicService.getTopicByTid(id);

        //保存新闻类别
        model.addAttribute("topic",topicList);
        return "topic/edit";
    }
    //修改主题并提交
    @RequestMapping("/edit")
    public String toModify(Topic topic){
        topicService.updateTopic(topic);
        return "redirect:/topic/list";
    }

    //删除主题并提交
    @RequestMapping("/deleteById/{tid}")
    public String toDelete(@PathVariable Integer tid){
       topicService.deleteTopic(tid);
        return "redirect:/topic/list/";
    }

}
