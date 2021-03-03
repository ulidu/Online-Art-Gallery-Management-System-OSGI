package databaseservice;

import java.util.Map;

public interface CustomerDao {
	
	public boolean save(Map<String, String> data);
	public Map<String, String> findById(String customerId);

}
