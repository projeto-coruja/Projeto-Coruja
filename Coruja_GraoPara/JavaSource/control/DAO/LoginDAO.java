package control.DAO;

import login.Profile;
import login.User;

public class LoginDAO extends AbstractDao{
	
	public void createProfile(Profile p){
		super.saveOrUpdate(p);
	}
	
	public void createUser(User u){
		super.saveOrUpdate(u);
	}
	
}
