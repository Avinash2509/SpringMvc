package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dao.UserDao;
import com.mvc.entity.User;
import com.mvc.modal.Usermodel;

@Service
public class UserService {
	@Autowired
	UserDao userdao;

	public List<User> getupdateById(int id) {

		List<User> list = userdao.getupdateById(id);
		return list;
	}

	public boolean getSaveUpdateData(User user) {

		userdao.getSaveUpdateData(user);
		return true;
	}

	public boolean getRegistration(User user) {

		userdao.getRegistration(user);

		return true;
	}

	public boolean getDeleteUser(int id) {
		// ModelAndView mv=new ModelAndView();

		return userdao.getDeleteUser(id);
	}

	public boolean getAddUser(User user) {
		ModelAndView mv = new ModelAndView();

		boolean check = userdao.getAddUser(user);

		return true;
	}

	public List<User> getAllUser() {
		List<User> list = userdao.getAllUser();

		return list;
	}

	public boolean checklogin(User user) {

		User user2 = userdao.checklogin(user);

		if (user2 != null) {
			return true;
		} else {
			return false;
		}

	}

}