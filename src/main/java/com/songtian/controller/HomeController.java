 package com.songtian.controller;

 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songtian.entity.News;
import com.songtian.entity.Topic;
import com.songtian.service.NewsService;
import com.songtian.service.TopicService;
import com.songtian.service.UserService;
import com.songtian.vo.NewsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//Controller调用service，service调用mapper
@Controller
public class HomeController {

    //接受请求，调用service代码，响应请求
    @Autowired
    NewsService newsService;

    @Autowired
    TopicService topicService;

    @Autowired
    UserService userService;


    @RequestMapping(value = {"/","/index.html","home.html"}) //请求映射
    public String index(Model model,NewsQueryVo newsQueryVo){
//        System.out.println("===========");
        //调用service的方法
        //根据类型查询新闻
        List<News> newsList1 = newsService.getNewsListByTopicId(1,6);
        List<News> newsList2 = newsService.getNewsListByTopicId(2,6);
        List<News> newsList3 = newsService.getNewsListByTopicId(5,6);


        //保存数据响应给前端
        model.addAttribute("newsList1",newsList1);
        model.addAttribute("newsList2",newsList2);
        model.addAttribute("newsList3",newsList3);

        //查询新闻类别
        List<Topic> topicList =topicService.getTopicList();

        //保存新闻类别
        model.addAttribute("topicList",topicList);

        //创建分页查询对象，帮助分页查询信息
        //设置页码和分页的数量
        IPage<News> page= new Page<>(newsQueryVo.getPageNo(), newsQueryVo.getPageSize());

        page=newsService.getNewsListByPage(page,newsQueryVo);

        model.addAttribute("page",page);

        //设置分页信息参数
        model.addAttribute("newVo",newsQueryVo);

        return "index.html";  //返回视图名称
    }

//    @RequestMapping(value = "/users/login")
//    public String login(@RequestParam("userName") String uname, @RequestParam("password") String upwd, HttpServletRequest request)  {
//        Users loginUser = userService.login(uname,upwd);
//        request.getSession().setAttribute("loginUser",loginUser);
//        return "redirect:/";
//    }
//
//
//    @RequestMapping(value = "/users/logout")
//    public String logout(HttpServletRequest request)  {
//        HttpSession session = request.getSession();
//        session.invalidate();
//        return "redirect:/";
//    }



}
