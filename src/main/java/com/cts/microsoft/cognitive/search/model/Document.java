package com.cts.microsoft.cognitive.search.model;

import java.io.Serializable;

public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String fileName;
	
	String contentType;
	
	String content;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
