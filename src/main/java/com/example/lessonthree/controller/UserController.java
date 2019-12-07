package com.example.lessonthree.controller;

import com.example.lessonthree.jpa.UserJPA;
import com.example.lessonthree.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<user> list(){
        return userJPA.findAll();
    }

    /**
     * 添加
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public user save(user entity){
        return userJPA.save(entity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<user> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
