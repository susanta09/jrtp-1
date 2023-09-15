package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Override
	public Boolean saveUser(User user)
	{
		Integer userId=user.getUserId();
		if(userId==null)
		{
			user.setUserAction("y");
		}
		userRepo.save(user);
		if(userId==null)
		{
			//save user
			return true;
		}else
		{
			//update
			return false;
		}
	
	}
	@Override
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	@Override
	public User getById(Integer id)
	{
		Optional<User> user = userRepo.findById(id);
		if(user!=null)
		{
			return user.get();
		}
		else {
			return null;
		}	
	}
	@Override
	public Boolean updateUser(User user)
	{
		Boolean b=userRepo.existsById(user.getUserId());
		if (b) {
			userRepo.save(user);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Boolean updateAction(Integer id,String action)
	{
		try {
			userRepo.updateActionById(id, action);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Boolean deleteById(Integer id) {
		Boolean b=userRepo.existsById(id);
		if(b)
		{
			userRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	

}
