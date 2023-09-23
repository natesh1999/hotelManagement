package com.hotel.taj.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dao.UserDao;
import com.hotel.taj.hotelmanagement.dto.User;
import com.hotel.taj.hotelmanagement.exception.UserNotFound;


@Service
public class UserService {

	@Autowired
	private UserDao udao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User u) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(udao.saveUser(u));
		structure.setMessage("user has been saved");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User exuser = udao.findUser(id);
		if (exuser != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(exuser);
			structure.setMessage("user found success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}
		throw new UserNotFound("user could not be found");
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User deleteduser = udao.deleteUser(id);
		if(deleteduser!=null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(deleteduser);
			structure.setMessage("user has been deleted");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new UserNotFound("could not delete a user");
		
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User u, int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(udao.updateUser(u, id));
		structure.setMessage("user has been updated");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> login(String email, String password){
		User exuser = udao.findByEmail(email);
		
		if(exuser!=null) {
			String userpwd = exuser.getUserPassword();
			if(userpwd.equals(password)) {
				ResponseStructure<User> structure = new ResponseStructure<>();
				structure.setData(exuser);
				structure.setMessage("login success");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			}
			throw new UserNotFound("wrong password");
			
		}
		throw new UserNotFound("no user found with this email id");
	}
	

}
