package com.cts.microsoft.cognitive.search.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microsoft.cognitive.search.api.service.CognitiveSearchService;
import com.cts.microsoft.cognitive.search.model.Document;

@RestController
@RequestMapping("/api/search")
public class CognitiveSearchController {
	
	protected Logger logger = Logger.getLogger(CognitiveSearchController.class.getName());
	
	@Autowired
	private CognitiveSearchService service;
	 
    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Document>> search(@RequestParam("text") String searchText) {
    	List<Document> docs = new ArrayList<>();
        try {        		
        	docs = service.searchQuery(searchText);        	
        } catch (Exception e) {
            logger.info("Server exception " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(docs);
        }
        return ResponseEntity.ok().body(docs);
    }
        
}
