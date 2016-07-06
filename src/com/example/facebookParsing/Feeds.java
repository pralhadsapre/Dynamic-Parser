package com.example.facebookParsing;

import java.util.ArrayList;

import com.example.jsonMapping.*;
public class Feeds extends JSONObjectModel {

	private ArrayList<SingleFeed> feeds;

	public ArrayList<SingleFeed> getFeeds() {
		return feeds;
	}

	public void setFeeds(ArrayList<SingleFeed> feeds) {
		this.feeds = feeds;
	}
}
