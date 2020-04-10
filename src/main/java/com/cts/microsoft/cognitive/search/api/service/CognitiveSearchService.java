package com.cts.microsoft.cognitive.search.api.service;

import java.util.List;

import com.cts.microsoft.cognitive.search.exception.SearchException;
import com.cts.microsoft.cognitive.search.model.Document;

public interface CognitiveSearchService {

	List<Document> searchQuery(final String query)throws SearchException;
}
