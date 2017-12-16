package WebService.BO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ContentBO implements Serializable{
    @Id
    int id;
    @Column(name = "title")
    String title;
    @Column(name = "description")
    String description;
    @Column(name = "user_id")
    String uploader;
    @Column(name = "server_id")
    int serverId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }
}
