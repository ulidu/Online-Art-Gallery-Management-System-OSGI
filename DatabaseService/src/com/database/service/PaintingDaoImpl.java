package com.database.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PaintingDaoImpl implements PaintingDao{
	

	private static Map<String, Map<String, String>> dataList = new HashMap<>();

	@Override
	public boolean save(Map<String, String> data) {
		
		String paintingID = data.get("paintingId");
		
		try {
			
			dataList.put(paintingID, new HashMap<String, String>(data));
			return true;
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
		
		return false;
		
	}

	@Override
	public Map<String, String> findById(String paintingID) {
		
		Map<String, String> data = new HashMap<>();
		
		try {
			
			data = dataList.get(paintingID);
			if(Objects.isNull(data)){
				
				return null;
				
			}
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
		
		return data;
		
	}

}
