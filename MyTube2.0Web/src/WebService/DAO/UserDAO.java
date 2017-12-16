package WebService.DAO;

import WebService.BO.UserBO;
import WebService.JDBC.PostgreSQLJDBC;

public class UserDAO {

    private static PostgreSQLJDBC postrgres = new PostgreSQLJDBC();

    public int insertNewUser(UserBO userBo){
        return postrgres.insertNewUser(userBo);
    }
    
    public UserBO getUserById(int id){
		return postrgres.getUserById(id);
    }
}
