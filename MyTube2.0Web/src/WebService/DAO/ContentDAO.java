package WebService.DAO;

import java.util.List;

import WebService.BO.ContentBO;
import WebService.JDBC.ContentJDBC;

public class ContentDAO {
	
	ContentJDBC postgres = new ContentJDBC();
		
	public List<ContentBO> getListOfContents() {
		return postgres.getAllContents();
		
	}
	
	public ContentBO getContentByID(int id){
		return postgres.getContentd(id);
	}
}
