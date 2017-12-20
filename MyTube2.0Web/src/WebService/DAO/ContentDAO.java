package WebService.DAO;

import java.util.List;

import javax.ws.rs.core.Response;

import WebService.BO.ContentBO;
import WebService.JDBC.ContentJDBC;

public class ContentDAO {
	
	ContentJDBC postgres = new ContentJDBC();
		
	public List<ContentBO> getListOfContents() {
		return postgres.getAll();	
	}
	
	public ContentBO getContentByID(int id){
		return postgres.getByID(id);
	}

	public int insertNewCotent(ContentBO contentBO) {
		return postgres.insert(contentBO);
	}

	public List<ContentBO> getContentByUserID(int userID) {
		return postgres.getByUserID(userID);
	}

	public int deleteByID(int contentID) {
		return postgres.deleteByID(contentID);
	}
}
