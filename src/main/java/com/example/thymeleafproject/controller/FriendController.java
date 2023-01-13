package com.example.thymeleafproject.controller;

import com.example.thymeleafproject.entity.MyFriend;
import com.example.thymeleafproject.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/addFriendForm")
    public ModelAndView addFriendForm(){
        ModelAndView mav = new ModelAndView("add-friend-form");
        MyFriend newFriend = new MyFriend();
        mav.addObject("friend",newFriend);
        return mav;
    }

    @PostMapping("/saveFriend")
    public String saveFriend(@ModelAttribute MyFriend friend){
        friendRepository.save(friend);
        return "redirect:/friends";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateFrom(@RequestParam Long friendId){
        ModelAndView mav = new ModelAndView("add-friend-form");
        MyFriend thisFriend = friendRepository.findById(friendId).get();
        mav.addObject("friend",thisFriend);
        return mav;
    }

    @GetMapping("/deleteFriend")
    public String deleteFriend(@RequestParam Long friendId){
        friendRepository.deleteById(friendId);
        return "redirect:/friends";
    }


}
