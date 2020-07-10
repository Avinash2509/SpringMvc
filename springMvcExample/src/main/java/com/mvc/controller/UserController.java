package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.User;
import com.mvc.modal.Usermodel;
import com.mvc.service.UserService;

@Controller
@ComponentScan("com.mvc")
public class UserController {
	@Autowired
	UserService userservice;

	@RequestMapping("updateuser")
	ModelAndView getupdateById(@RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		List<User> list = userservice.getupdateById(id);
		System.out.println(list);
		mv.addObject("userlist", list);
		mv.setViewName("update_user");

		return mv;

	}

	@RequestMapping("update")
	ModelAndView getSaveUpdateData(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView();

		if (userservice.getSaveUpdateData(user)) {

			List<User> list = userservice.getAllUser();

			System.out.println("show all user after adding");
			mv.setViewName("users");
			mv.addObject("lists", list);

		}

		else {

			mv.setViewName("update_user");
		}

		return mv;
	}

	@RequestMapping("/deleteUser")
	ModelAndView getDeleteUser(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		if (userservice.getDeleteUser(id)) {
			List<User> list = userservice.getAllUser();

			System.out.println("show all user");
			mv.setViewName("users");
			mv.addObject("lists", list);

		} else {
			List<User> list = userservice.getAllUser();

			System.out.println("show all user");
			mv.setViewName("users");
			mv.addObject("lists", list);
		}

		return mv;
	}

	@RequestMapping("/saveUser")
	ModelAndView getAddUser(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView();

		boolean check = userservice.getAddUser(user);
		if (check) {
			List<User> list = userservice.getAllUser();

			System.out.println("show all user after adding");
			mv.setViewName("users");
			mv.addObject("lists", list);
			return mv;

		} else {
			System.out.println("suser not added sucessfully");
			mv.setViewName("add_user");
		}
		return mv;
	}

	@RequestMapping(value = "/addUserPage")
	public ModelAndView addUserPage() {
		System.out.println("  Add USer Page");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add_user");
		return mv;
	}

	@RequestMapping("/usersjsp")
	public ModelAndView getAllUser(@ModelAttribute User user) {

		ModelAndView mv = new ModelAndView();
		List<User> list = userservice.getAllUser();

		System.out.println("show all user");
		mv.setViewName("users");
		mv.addObject("lists", list);
		return mv;

	}

	@RequestMapping("/login")
	public ModelAndView checkLogin(@ModelAttribute User user) {

		ModelAndView mv = new ModelAndView();
		if (userservice.checklogin(user)) {

			mv.setViewName("dashboard");
		} else {
			mv.addObject("msg", "id or password wrong ");
			System.out.println(" something is wrong ");
		}
		return mv;
	}

	@RequestMapping("/loginpage")
	public ModelAndView openLoginpage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		System.out.println("In the method of open Login page");
		return mv;
	}

	@RequestMapping("/registration")
	public String registerpage1() {
		System.out.println("I am in registerpage1");
		return "register";
	}

	@RequestMapping("/register")
	ModelAndView getRegistration(User user) {
		ModelAndView mv = new ModelAndView();

		if (userservice.getRegistration(user)) {
			mv.addObject("msg", "register sucessfully");
			mv.setViewName("login");

		} else {
			mv.setViewName("register");
		}

		return mv;
	}

}