package WebService.BO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserBO implements Serializable{
     @Id
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
