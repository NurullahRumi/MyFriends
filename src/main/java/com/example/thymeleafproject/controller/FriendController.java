package com.example.thymeleafproject.controller;

import com.example.thymeleafproject.entity.MyFriend;
import com.example.thymeleafproject.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;


    @GetMapping({"/showFriends","/","/friends"})
    public ModelAndView showFriends(){
        ModelAndView mav = new ModelAndView("list-friends");
        List<MyFriend> friends =  friendRepository.findAll();
        mav.addObject("friends",friends);
        return mav;
    }
}
