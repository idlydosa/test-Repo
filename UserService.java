package com.org.user.service;

import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.user.beans.AddressDTO;
import com.org.user.beans.RoleDTO;
import com.org.user.beans.UserDTO;

@Service("userservice")
public class UserService {

	static HashMap<Integer, UserDTO> UserIdMap = new HashMap<>();

	public UserDTO addUser(UserDTO user) {
		user.setId(getMaxId() + 1);
		UserIdMap.put(user.getId(), user);
		System.out.println("User" + user.toString());
		
		return user;
	}

	public static int getMaxId() {
		int max = 0;
		for (int id : UserIdMap.keySet()) {
			if (max <= id)
				max = id;
		}
		return max;
	}
	
	public UserDTO updateUser(UserDTO user)
	{
		if(user.getId()<=0)
			return null;
		UserIdMap.put(user.getId(), user);
		return user;

	}

	public ArrayList<UserDTO> getUsers()
	{
		int size = UserIdMap.size();
		ArrayList<UserDTO> users;
		if(size==0){
			users = new ArrayList<UserDTO>();
		}else{		
			users = new ArrayList<UserDTO>(UserIdMap.values());
		}
		return users;
	}
	
	public UserDTO getUser(int id)
	{
		
		UserDTO dto= (UserDTO)UserIdMap.get(id);
		System.out.println(dto.toString());
		return dto;
		
		
	}
}
