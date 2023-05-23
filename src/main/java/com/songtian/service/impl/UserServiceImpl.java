package com.songtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songtian.entity.Users;
import com.songtian.mapper.UserMapper;
import com.songtian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional  //spring中声明式事务管理的注解配置方式
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {


//    @Override
//    public Users getUserList(String uname, String upwd) {
//        return baseMapper.getUserList(uname,upwd);
//    }
    @Autowired
    UserMapper userMapper;

    @Override
    public Users login(String uname,String upwd){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();

        //封装查询条件
        queryWrapper.eq("uname",uname);
        queryWrapper.eq("upwd",upwd);

        Users users=userMapper.selectOne(queryWrapper);
        return users;
    }

}
