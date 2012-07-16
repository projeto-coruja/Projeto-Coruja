package control.DAO;

import java.util.List;

import login.Profile;
import login.User;

public class LoginDAO extends AbstractDao{
	
	public void saveProfile(Profile p){
		super.save(p);
	}
	
	public void saveUser(User u){
		super.save(u);
	}
	
	public void updateUser(User u){
		super.update(u);
	}
	
	public <T> List<User> findAllUsers(){
		return super.findAll(User.class);
	}
	
	public <T> List<Profile> findAllProfile(){
		return super.findAll(Profile.class);
	}
}
