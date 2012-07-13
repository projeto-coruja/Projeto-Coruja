package control.DAO;

import login.Profile;

public class LoginDAO extends AbstractDao{
	
	public void createUser(Profile p){
		super.saveOrUpdate(p);
	}
	
}
