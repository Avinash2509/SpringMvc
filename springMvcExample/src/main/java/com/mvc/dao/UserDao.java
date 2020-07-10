package com.mvc.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.User;
import com.mvc.modal.Usermodel;

@Repository
public class UserDao {
	@Autowired
	SessionFactory sessionfactory;

	public List<User> getupdateById(int id) {
		Session session = sessionfactory.openSession();
		// session.beginTransaction();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.eq("id", id));
		List<User> list = ctr.list();

		return list;

	}

	public boolean getSaveUpdateData(User user) {

		Session session = sessionfactory.openSession();

		org.hibernate.Transaction tr = session.beginTransaction();

		session.saveOrUpdate(user);

		tr.commit();
		return true;
	}

	public boolean getRegistration(User user) {

		Session session = sessionfactory.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		System.out.println(" user register sucessfully");

		return true;
	}

	public boolean getDeleteUser(int id) {
		Session session = sessionfactory.openSession();
		User user = new User();
		org.hibernate.Transaction tr = session.beginTransaction();
		user = session.get(User.class, id);
		session.delete(user);
		tr.commit();
		return true;
	}

	public boolean getAddUser(User user) {

		Session session = sessionfactory.openSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		session.save(user);
		System.out.println("added user data");
		trans.commit();

		return true;
	}

	public List<User> getAllUser() {
		Session session = sessionfactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		List<User> list = ctr.list();
		return list;
	}

	public User checklogin(User user) {
		System.out.println(1);

		Session session = sessionfactory.openSession();
		// Criteria criteria= session.createCriteria(User.class);
		System.out.println(2);
		// criteria.add(Restrictions.all);
		Query query = session.createQuery("select email,password from User where email=:email AND password=:password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		System.out.println(3);
		List<User> list = query.list();

		if (!list.isEmpty()) {
			return user;
		} else {
			return null;
		}

	}

}
