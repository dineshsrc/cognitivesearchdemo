package com.cts.microsoft.cognitive.search.api.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microsoft.cognitive.search.exception.SearchException;
import com.cts.microsoft.cognitive.search.model.Document;

@Service
public class CognitivieSearchServiceImpl implements CognitiveSearchService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${search.index.url}")
	private String indexUrl;
	
	@Value("${api.version}")
	private String apiVersion;
	
	@Value("${api.key}")
	private String apiKey;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CognitivieSearchServiceImpl.class);

	@Override
	public List<Document> searchQuery(String query) throws SearchException {
		List<Document> docs = new ArrayList<>();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("api-key", apiKey);
		final HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(indexUrl + "search=" + query + "&api-version=" + apiVersion, HttpMethod.GET, entity, String.class);
		try {
			String responseBody = response.getBody();			
			JSONObject object = new JSONObject(responseBody);
			JSONArray array = object.getJSONArray("value");
			for (int i = 0; i < array.length(); i++) {
				Document doc = new Document();
				JSONObject obj = array.getJSONObject(i);
				doc.setFileName(obj.getString("metadata_storage_name"));
				doc.setContentType(obj.getString("metadata_storage_content_type"));
				doc.setContent(obj.getString("content"));
				docs.add(doc);
			}
		} catch (JSONException e) {
			LOGGER.error("Exception thrown while parsing the response", e);
			throw new SearchException(e.getMessage());
		}
		return docs;
	}

}
