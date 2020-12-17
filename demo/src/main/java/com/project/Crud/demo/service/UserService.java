package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.Crud.demo.exception.AlreadyExistException;
import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Users;
import com.project.Crud.demo.repository.UserRepository;
import com.project.Crud.demo.request.UserCreation;
import com.project.Crud.demo.response.UserResponse;

public class UserService {

	@Autowired
	UserRepository userrepo;

	public Optional<Users> findbyId(long id) {
		return userrepo.findById(id);
	}

	private Users isExists(Long id) {
		Users user = userrepo.findByUserId(id);
		if (user == null)
			throw new NotFoundException("No user found");
		return user;
	}

	@Transactional
	public String CreateUser(Long userid, UserCreation ucreation) {
		Users users = userrepo.findByFirstName(ucreation.getFrstname());
		if (users != null) {
			throw new AlreadyExistException(ucreation.getFrstname() + "already exists");
		}
		try {
			Users user = new Users();
			user.setFrstname(ucreation.getFrstname());
			user.setLstname(ucreation.getLstname());
			user.setEmail(ucreation.getEmail());
			user.setContact(ucreation.getContact());
			user.setAddress(ucreation.getAddress());
			userrepo.save(user);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "User Created";
	}

	@Transactional
	public String deleteUser(Long userid) {
		Users users = userrepo.findByUserId(userid);
		if (users == null) {
			throw new NotFoundException("User not Found to delete");
		}
		try {
			userrepo.delete(users);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "User deleted";
	}

	@Transactional
	public String updateUser(Long userid, UserCreation usercreation) {
		Users user = isExists(userid);
		try {
			user.setFrstname(usercreation.getFrstname());
			user.setLstname(usercreation.getLstname());
			user.setAddress(usercreation.getAddress());
			user.setEmail(usercreation.getEmail());
			user.setContact(usercreation.getContact());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		userrepo.save(user);
		return "User updated Successfully";
	}

	@Transactional
	public List<UserResponse> getAllUsers() {
		List<UserResponse> UserRes = new ArrayList<UserResponse>();
		List<Users> userList = userrepo.findAll();
		userList.stream().forEach(u -> {
			UserResponse Uresponse = new UserResponse();
			Uresponse.setFrstname(u.getFrstname());
			Uresponse.setLstname(u.getLstname());
			Uresponse.setAddress(u.getAddress());
			Uresponse.setContact(u.getContact());
			Uresponse.setEmail(u.getEmail());
			UserRes.add(Uresponse);
		});
		return UserRes;
	}

}
