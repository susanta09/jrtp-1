package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<User,Integer> {
	@Modifying
	@Transactional
	@Query("update User set userAction=:userAction where userId=:userId")
	void updateActionById(Integer userId,String userAction);

}
