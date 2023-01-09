package com.prospecta.service;

import java.util.List;

import com.prospecta.beans.Entry;
import com.prospecta.dto.ResultDTO;
import com.prospecta.exception.EntryNotFoundException;

public interface MainService {
	
	public List<ResultDTO> getTitleAndDescByCategory(String category)throws EntryNotFoundException;

	public String saveNewEntry(Entry entry);
	
	public List<Entry> getRandomEntries();
	
	public String getHealthStatus();
	
}
