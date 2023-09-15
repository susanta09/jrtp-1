package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.User;
@Service
public interface UserService {
	public Boolean saveUser(User user);
	public List<User> getAllUser();
	public User getById(Integer id);
	public Boolean updateUser(User user);
	public Boolean updateAction(Integer id,String action);
	public Boolean deleteById(Integer id);
}
