package WebService.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name = "server")

public class ServerBO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4483641237909797884L;
	@Id
    int id;
    @Column(name = "port")
    int port;
    @Column(name = "host")
    String host;
    @Column(name = "on")
    Boolean on;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    public Boolean getOn(){
    	return on;
    }
    
    public void setOn(Boolean on){
    	this.on=on;
    }
}
