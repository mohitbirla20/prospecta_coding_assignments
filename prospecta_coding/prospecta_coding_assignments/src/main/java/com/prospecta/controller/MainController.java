package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.beans.Entry;
import com.prospecta.dto.ResultDTO;
import com.prospecta.exception.EntryNotFoundException;
import com.prospecta.service.MainService;

@RestController
@RequestMapping("/prospecta")
public class MainController {

	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResultDTO>> getTitleAndDescByCategory(@PathVariable("category") String category)
			throws EntryNotFoundException{
		
		List<ResultDTO> resultList = mainService.getTitleAndDescByCategory(category);
		
		return new ResponseEntity<>(resultList,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addEntry")
	public ResponseEntity<String> addNewEntry(@RequestBody Entry entry){
		
		String result = mainService.saveNewEntry(entry);
		
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/randomEntries")
    public ResponseEntity<List<Entry>> getRandomEntries(){
		
		List<Entry> resultList = mainService.getRandomEntries();
		
		return new ResponseEntity<>(resultList,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getHealth")
	public ResponseEntity<String> getHealthStatus(){
		
		String result = mainService.getHealthStatus();
		
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	
}
