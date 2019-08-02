package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.List;

public class Article {
	private String title;
	private int words;
	private String type;
	private List<String>  tags = new ArrayList<>();
	
	public Article() {
	}

	public Article(String title, int words, String type, List<String> tags) {
		this.title = title;
		this.words = words;
		this.type = type;
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
