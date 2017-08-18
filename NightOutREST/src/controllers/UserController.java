package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.UserDAO;
import entities.User;

@RestController
public class UserController {

	@Autowired
	UserDAO dao;
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String pingPong() {
		return "Pong";
	}
	
	@RequestMapping(path = "users", method = RequestMethod.GET)
	public List<User> index() {
		return dao.index();
	}
	
	@RequestMapping(path = "users/{id}", method = RequestMethod.GET)
	public User show(@PathVariable int id) {
		return dao.show(id);
	}
	
	@RequestMapping(path = "users", method = RequestMethod.POST)
	public User create(@RequestBody String json) {
		ObjectMapper mapper = new ObjectMapper();
		User u = null;
		try {
			u = mapper.readValue(json, User.class);
			return dao.create(u);
		} catch (Exception e) {
			e.printStackTrace();
			return u;
		}
	}
	
	@RequestMapping(path = "users/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable int id, @RequestBody String json) {
		ObjectMapper mapper = new ObjectMapper();
		User u = null;
		try {
			u = mapper.readValue(json, User.class);
			return dao.update(id, u);
		} catch (Exception e) {
			e.printStackTrace();
			return u;
		}
	}
	
	@RequestMapping(path = "users/{id}", method = RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {
		return dao.delete(id);
	}
	
}
