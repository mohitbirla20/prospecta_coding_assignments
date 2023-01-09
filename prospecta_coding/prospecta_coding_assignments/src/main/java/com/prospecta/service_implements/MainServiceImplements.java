package com.prospecta.service_implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prospecta.beans.Entry;
import com.prospecta.data.JSON_Data;
import com.prospecta.dto.ResultDTO;
import com.prospecta.exception.EntryNotFoundException;
import com.prospecta.repository.EntryDao;
import com.prospecta.service.MainService;

@Service
public class MainServiceImplements implements MainService{

	@Autowired
	private RestTemplate reatTemplate;
	
	@Autowired
	private EntryDao entryDao;
	
	
	/* 
	   this method will return the title and description 
	   based on category.
	*/
	@Override
    public List<ResultDTO> getTitleAndDescByCategory(String category) throws EntryNotFoundException{
		
		String url = "https://api.publicapis.org/entries";
		
		JSON_Data data = reatTemplate.getForObject(url, JSON_Data.class);
		
		List<Entry> entries = data.getEntries();
		
		List<ResultDTO> resultList = entries.stream()
		                                    .filter(s -> s.getCategory().equals(category))
		                                    .map(s -> new ResultDTO(s.getApi(),s.getDescription()))
		                                    .toList();
		
		if(resultList.size() == 0)
			throw new EntryNotFoundException("for this category entry not found");
		
		return resultList;
	
	} 
	
	
    // this method add new entry in our data base.
	@Override
	public String saveNewEntry(Entry entry){
		
		String url = "https://api.publicapis.org/entries";
		
		JSON_Data data = reatTemplate.getForObject(url , JSON_Data.class);
		
		List<Entry> entries = data.getEntries();
		
		entries.add(entry);
		
		entryDao.saveAll(entries);
			    
        return "new entry saved";
		
	}
	
	
	// this method return random entries
	@Override
	public List<Entry> getRandomEntries() {
	
		String url = "https://api.publicapis.org/random";
		
		RestTemplate rest = new RestTemplate();
		
		JSON_Data result = rest.getForObject(url, JSON_Data.class);
		
		return result.getEntries();
	
	}
	
	
	//this method return health status
	@Override
	public String getHealthStatus() {
			
		String url = "https://api.publicapis.org/health";
		
		RestTemplate rest = new RestTemplate();
			
		String result = rest.getForObject(url, String.class);
			
		return  result;
		
	}
	
	
	
}
