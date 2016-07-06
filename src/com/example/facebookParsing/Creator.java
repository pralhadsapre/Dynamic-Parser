package com.example.facebookParsing;
import com.example.jsonMapping.*;

public class Creator extends JSONObjectModel {
	private String id;
	private String category;
	private String name;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
