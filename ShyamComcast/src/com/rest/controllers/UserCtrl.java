package com.rest.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rest.persistance.SqliteUtils;
import com.rest.singletons.Storeroom;
import com.rest.vo.User;

@Controller
public class UserCtrl {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getUser() {
		return new ModelAndView("Login", "user", "get");
	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser() {
		return new ModelAndView("Login", "user", "delete");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userForm") User user) {
		user.setDateRegistered(new Date());
		Storeroom.getStoreroom().addUser(user);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		model.put("users", Storeroom.getStoreroom().getUsers());
		return new ModelAndView("homepage", "model", model);
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register", "userForm", new User());
	}

	@RequestMapping("/homepage")
	public ModelAndView homepage() {
		return new ModelAndView("homepage");
	}

//	@PostConstruct
//	public void initDB() {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			conn = SqliteUtils.getInstance().getConn();
//			stmt = conn.createStatement();
//			// CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT,
//			// USERNAME TEXT NOT NULL, EMAILADDRESS TEXT NOT NULL, DATE TEXT NOT
//			// NULL)
//			String sql = "CREATE TABLE USERS "
//					+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
//					+ " USERNAME TEXT NOT NULL, "
//					+ " EMAILADDRESS TEXT NOT NULL, " + " DATE TEXT NOT NULL)";
//			stmt.executeUpdate(sql);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//	}
//
//	@PreDestroy
//	public void save() {
//	}
}
