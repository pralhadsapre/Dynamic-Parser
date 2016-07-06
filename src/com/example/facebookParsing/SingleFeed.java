package com.example.facebookParsing;
import java.util.ArrayList;

import com.example.jsonMapping.*;

public class SingleFeed extends JSONObjectModel {
	private String id;
	private String message;
	private String description;
	private ArrayList<Comment> comments;
	private Creator creator;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}
}
