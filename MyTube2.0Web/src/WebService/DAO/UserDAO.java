package WebService.DAO;

import java.util.List;

import WebService.BO.UserBO;
import WebService.JDBC.UserJDBC;

public class UserDAO {

    private static UserJDBC postgres = new UserJDBC();

    public int insertNewUser(UserBO userBo){
        return postgres.insert(userBo);
    }
    
    public UserBO getUserById(int id){
		return postgres.getById(id);
    }

	public List<UserBO> getAllUsers() {
		return postgres.getAll();
	}

	public List<UserBO> getUsersByName(String name) {
		return postgres.getUsersByName(name);
	}
}
