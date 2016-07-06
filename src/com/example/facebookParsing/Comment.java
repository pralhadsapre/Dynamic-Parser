package com.example.facebookParsing;
import com.example.jsonMapping.*;

public class Comment extends JSONObjectModel {
	private String name;
	private String message;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
