package com.example.jsonMapping;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONArrayParsed {

	private JSONArray array;
	private JSONObject config;

	public JSONArrayParsed(JSONArray array, JSONObject config) {
		this.array = array;
		this.config = config;
	}

	public JSONArray getArray() {
		return array;
	}

	public void setArray(JSONArray array) {
		this.array = array;
	}

	public JSONObject getConfig() {
		return config;
	}

	public void setConfig(JSONObject config) {
		this.config = config;
	}

}
