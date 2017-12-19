package WebService.DAO;

import WebService.BO.UserBO;
import WebService.JDBC.UserJDBC;

public class UserDAO {

    private static UserJDBC postrgres = new UserJDBC();

    public int insertNewUser(UserBO userBo){
        return postrgres.insert(userBo);
    }
    
    public UserBO getUserById(int id){
		return postrgres.getById(id);
    }
}
