package com.songtian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.songtian.entity.Users;

public interface UserService extends IService<Users> {
    /**
     * 查询新闻类别
     * @return  返回mapper查询到的结果数据
     */
//    Users getUserList(String uname, String upwd);

    Users login(String userName, String password);
}
