package com.example.thymeleafproject.repository;

import com.example.thymeleafproject.entity.MyFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository  extends JpaRepository<MyFriend, Long> {
}
